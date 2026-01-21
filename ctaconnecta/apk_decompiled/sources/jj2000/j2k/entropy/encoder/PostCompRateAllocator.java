package jj2000.j2k.entropy.encoder;

import java.io.IOException;
import java.io.StreamTokenizer;
import java.io.StringReader;
import jj2000.j2k.codestream.writer.CodestreamWriter;
import jj2000.j2k.codestream.writer.HeaderEncoder;
import jj2000.j2k.encoder.EncoderSpecs;
import jj2000.j2k.entropy.ProgressionSpec;
import jj2000.j2k.image.ImgDataAdapter;
import jj2000.j2k.util.ParameterList;

/* loaded from: classes5.dex */
public abstract class PostCompRateAllocator extends ImgDataAdapter {
    public static final char OPT_PREFIX = 'A';
    private static final String[][] pinfo = {new String[]{"Aptype", "[<tile idx>] res|layer|res-pos|pos-comp|comp-pos [res_start comp_start layer_end res_end comp_end prog] [[res_start comp_start ly_end res_end comp_end prog] ...] [[<tile-component idx>] ...]", "Specifies which type of progression should be used when generating the codestream. The 'res' value generates a resolution progressive codestream with the number of layers specified by 'Alayers' option. The 'layer' value generates a layer progressive codestream with multiple layers. In any case the rate-allocation algorithm optimizes for best quality in each layer. The quality measure is mean squared error (MSE) or a weighted version of it (WMSE). If no progression type is specified or imposed by other modules, the default value is 'layer'.\nIt is also possible to describe progression order changes. In this case, 'res_start' is the index (from 0) of the first resolution level, 'comp_start' is the index (from 0) of the first component, 'ly_end' is the index (from 0) of the first layer not included, 'res_end' is the index (from 0) of the first resolution level not included, 'comp_end' is index (from 0) of the first component not included and 'prog' is the progression type to be used for the rest of the tile/image. Several progression order changes can be specified, one after the other.", null}, new String[]{"Alayers", "[<rate> [+<layers>] [<rate [+<layers>] [...]] | sl]", "Explicitly specifies the codestream layer formation parameters. The <rate> parameter specifies the bitrate to which the first layer should be optimized. The <layers> parameter, if present, specifies the number of extra layers that should be added for scalability. These extra layers are not optimized. Any extra <rate> and <layers> parameters add more layers, in the same way. An additional layer is always added at the end, which is optimized to the overall target bitrate of the bit stream. Any layers (optimized or not) whose target bitrate is higher that the overall target bitrate are silently ignored. The bitrates of the extra layers that are added through the <layers> parameter are approximately log-spaced between the other target bitrates. If several <rate> [+<layers>] constructs appear the <rate> parameters must appear in increasing order. The rate allocation algorithm ensures that all coded layers have a minimal reasonable size, if not these layers are silently ignored.\nIf the 'sl' (i.e. 'single layer') argument is specified, the generated codestream will only contain one layer (with a bit rate specified thanks to the '-rate' or 'nbytes' options).", "0.015 +20 2.0 +10"}};
    CodestreamWriter bsWriter;
    protected EncoderSpecs encSpec;
    HeaderEncoder headEnc;
    protected int numLayers;
    protected CodedCBlkDataSrcEnc src;

    public abstract void initialize() throws IOException;

    public abstract void runAndWrite() throws IOException;

    public PostCompRateAllocator(CodedCBlkDataSrcEnc codedCBlkDataSrcEnc, int i, CodestreamWriter codestreamWriter, EncoderSpecs encoderSpecs) {
        super(codedCBlkDataSrcEnc);
        this.src = codedCBlkDataSrcEnc;
        this.encSpec = encoderSpecs;
        this.numLayers = i;
        this.bsWriter = codestreamWriter;
    }

    public void setHeaderEncoder(HeaderEncoder headerEncoder) {
        this.headEnc = headerEncoder;
    }

    public int getNumLayers() {
        return this.numLayers;
    }

    public static String[][] getParameterInfo() {
        return pinfo;
    }

    public static PostCompRateAllocator createInstance(CodedCBlkDataSrcEnc codedCBlkDataSrcEnc, ParameterList parameterList, float f, CodestreamWriter codestreamWriter, EncoderSpecs encoderSpecs) throws IOException {
        parameterList.checkList(OPT_PREFIX, ParameterList.toNameArray(pinfo));
        LayersInfo alayers = parseAlayers(parameterList.getParameter("Alayers"), f);
        encoderSpecs.pocs = new ProgressionSpec(encoderSpecs.nTiles, encoderSpecs.nComp, alayers.getTotNumLayers(), encoderSpecs.dls, (byte) 2, parameterList);
        return new EBCOTRateAllocator(codedCBlkDataSrcEnc, alayers, codestreamWriter, encoderSpecs, parameterList);
    }

    private static LayersInfo parseAlayers(String str, float f) throws IOException {
        LayersInfo layersInfo = new LayersInfo(f);
        StreamTokenizer streamTokenizer = new StreamTokenizer(new StringReader(str));
        streamTokenizer.eolIsSignificant(false);
        try {
            streamTokenizer.nextToken();
            float f2 = 0.0f;
            boolean z = false;
            boolean z2 = false;
            while (streamTokenizer.ttype != -1) {
                int i = streamTokenizer.ttype;
                if (i == -3) {
                    try {
                        streamTokenizer.nextToken();
                        if (streamTokenizer.ttype != -1) {
                            throw new IllegalArgumentException("'sl' argument of '-Alayers' option must be used alone.");
                        }
                    } catch (IOException unused) {
                        throw new Error("An IOException has occurred where it should never occur");
                    }
                } else if (i != -2) {
                    if (i != 43) {
                        throw new IllegalArgumentException("Error parsing 'Alayers' option");
                    }
                    if (!z2 || z) {
                        throw new IllegalArgumentException("Layer parameter without previous rate parameter in 'Alayers' option");
                    }
                    z = true;
                } else if (z) {
                    try {
                        layersInfo.addOptPoint(f2, (int) streamTokenizer.nval);
                        z = false;
                        z2 = false;
                    } catch (IllegalArgumentException e) {
                        throw new IllegalArgumentException("Error in 'Alayers' option: " + e.getMessage());
                    }
                } else {
                    if (z2) {
                        try {
                            layersInfo.addOptPoint(f2, 0);
                        } catch (IllegalArgumentException e2) {
                            throw new IllegalArgumentException("Error in 'Alayers' option: " + e2.getMessage());
                        }
                    }
                    f2 = (float) streamTokenizer.nval;
                    z2 = true;
                }
                try {
                    streamTokenizer.nextToken();
                } catch (IOException unused2) {
                    throw new Error("An IOException has occurred where it should never occur");
                }
            }
            if (z) {
                throw new IllegalArgumentException("Error parsing 'Alayers' option");
            }
            if (!z2) {
                return layersInfo;
            }
            try {
                layersInfo.addOptPoint(f2, 0);
                return layersInfo;
            } catch (IllegalArgumentException e3) {
                throw new IllegalArgumentException("Error in 'Alayers' option: " + e3.getMessage());
            }
        } catch (IOException unused3) {
            throw new Error("An IOException has occurred where it should never occur");
        }
    }
}
