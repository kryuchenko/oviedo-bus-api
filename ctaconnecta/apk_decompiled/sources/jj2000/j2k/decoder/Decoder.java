package jj2000.j2k.decoder;

import colorspace.ColorSpace;
import colorspace.ColorSpaceException;
import com.google.firebase.perf.network.FirebasePerfUrlConnection;
import com.google.firebase.sessions.settings.RemoteSettings;
import icc.ICCProfiler;
import java.awt.Color;
import java.awt.Cursor;
import java.awt.Dimension;
import java.awt.Frame;
import java.awt.Image;
import java.awt.Insets;
import java.awt.event.MouseMotionListener;
import java.io.EOFException;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.lang.reflect.Array;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.util.Enumeration;
import java.util.Vector;
import jj2000.disp.BlkImgDataSrcImageProducer;
import jj2000.disp.ExitHandler;
import jj2000.disp.ImgKeyListener;
import jj2000.disp.ImgMouseListener;
import jj2000.disp.ImgScrollPane;
import jj2000.disp.TitleUpdater;
import jj2000.j2k.codestream.HeaderInfo;
import jj2000.j2k.codestream.reader.BitstreamReaderAgent;
import jj2000.j2k.codestream.reader.HeaderDecoder;
import jj2000.j2k.entropy.decoder.EntropyDecoder;
import jj2000.j2k.fileformat.reader.FileFormatReader;
import jj2000.j2k.image.BlkImgDataSrc;
import jj2000.j2k.image.ImgDataConverter;
import jj2000.j2k.image.invcomptransf.InvCompTransf;
import jj2000.j2k.image.output.ImgWriter;
import jj2000.j2k.image.output.ImgWriterPGM;
import jj2000.j2k.image.output.ImgWriterPGX;
import jj2000.j2k.image.output.ImgWriterPPM;
import jj2000.j2k.io.BEBufferedRandomAccessFile;
import jj2000.j2k.io.RandomAccessIO;
import jj2000.j2k.quantization.dequantizer.Dequantizer;
import jj2000.j2k.roi.ROIDeScaler;
import jj2000.j2k.util.FacilityManager;
import jj2000.j2k.util.ISRandomAccessIO;
import jj2000.j2k.util.MsgLogger;
import jj2000.j2k.util.ParameterList;
import jj2000.j2k.util.StringFormatException;
import jj2000.j2k.wavelet.synthesis.InverseWT;
import kotlinx.coroutines.DebugKt;
import org.jmrtd.PassportService;

/* loaded from: classes5.dex */
public class Decoder implements Runnable {
    private ColorSpace csMap;
    private ParameterList defpl;
    private int exitCode;
    private HeaderInfo hi;
    private boolean isChildProcess;
    private ImgScrollPane isp;
    private ParameterList pl;
    TitleUpdater title;
    private Frame win;
    private static final char[] vprfxs = {BitstreamReaderAgent.OPT_PREFIX, 'C', 'R', 'Q', 'M', 'H', 'I'};
    private static final String[][] pinfo = {new String[]{"u", "[on|off]", "Prints usage information. If specified all other arguments (except 'v') are ignored", DebugKt.DEBUG_PROPERTY_VALUE_OFF}, new String[]{"v", "[on|off]", "Prints version and copyright information", DebugKt.DEBUG_PROPERTY_VALUE_OFF}, new String[]{"verbose", "[on|off]", "Prints information about the decoded codestream", DebugKt.DEBUG_PROPERTY_VALUE_ON}, new String[]{"pfile", "<filename>", "Loads the arguments from the specified file. Arguments that are specified on the command line override the ones from the file.\nThe arguments file is a simple text file with one argument per line of the following form:\n  <argument name>=<argument value>\nIf the argument is of boolean type (i.e. its presence turns a feature on), then the 'on' value turns it on, while the 'off' value turns it off. The argument name does not include the '-' or '+' character. Long lines can be broken into several lines by terminating them with '\\'. Lines starting with '#' are considered as comments. This option is not recursive: any 'pfile' argument appearing in the file is ignored.", null}, new String[]{"res", "<resolution level index>", "The resolution level at which to reconstruct the image  (0 means the lowest available resolution whereas the maximum resolution level corresponds to the original image resolution). If the given index is greater than the number of available resolution levels of the compressed image, the image is reconstructed at its highest resolution (among all tile-components). Note that this option affects only the inverse wavelet transform and not the number  of bytes read by the codestream parser: this number of bytes depends only on options '-nbytes' or '-rate'.", null}, new String[]{"i", "<filename or url>", "The file containing the JPEG 2000 compressed data. This can be either a JPEG 2000 codestream or a JP2 file containing a JPEG 2000 codestream. In the latter case the first codestream in the file will be decoded. If an URL is specified (e.g., http://...) the data will be downloaded and cached in memory before decoding. This is intended for easy use in applets, but it is not a very efficient way of decoding network served data.", null}, new String[]{"o", "<filename>", "This is the name of the file to which the decompressed image is written. If no output filename is given, the image is displayed on the screen. Output file format is PGX by default. If the extension is '.pgm' then a PGM file is written as output, however this is only permitted if the component bitdepth does not exceed 8. If the extension is '.ppm' then a PPM file is written, however this is only permitted if there are 3 components and none of them has a bitdepth of more than 8. If there is more than 1 component, suffices '-1', '-2', '-3', ... are added to the file name, just before the extension, except for PPM files where all three components are written to the same file.", null}, new String[]{"rate", "<decoding rate in bpp>", "Specifies the decoding rate in bits per pixel (bpp) where the number of pixels is related to the image's original size (Note: this number is not affected by the '-res' option). If it is equalto -1, the whole codestream is decoded. The codestream is either parsed (default) or truncated depending the command line option '-parsing'. To specify the decoding rate in bytes, use '-nbytes' options instead.", "-1"}, new String[]{"nbytes", "<decoding rate in bytes>", "Specifies the decoding rate in bytes. The codestream is either parsed (default) or truncated depending the command line option '-parsing'. To specify the decoding rate in bits per pixel, use '-rate' options instead.", "-1"}, new String[]{"parsing", null, "Enable or not the parsing mode when decoding rate is specified ('-nbytes' or '-rate' options). If it is false, the codestream is decoded as if it were truncated to the given rate. If it is true, the decoder creates, truncates and decodes a virtual layer progressive codestream with the same truncation points in each code-block.", DebugKt.DEBUG_PROPERTY_VALUE_ON}, new String[]{"ncb_quit", "<max number of code blocks>", "Use the ncb and lbody quit conditions. If state information is found for more code blocks than is indicated with this option, the decoder will decode using only information found before that point. Using this otion implies that the 'rate' or 'nbyte' parameter is used to indicate the lbody parameter which is the number of packet body bytes the decoder will decode.", "-1"}, new String[]{"l_quit", "<max number of layers>", "Specifies the maximum number of layers to decode for any code-block", "-1"}, new String[]{"m_quit", "<max number of bit planes>", "Specifies the maximum number of bit planes to decode for any code-block", "-1"}, new String[]{"poc_quit", null, "Specifies the whether the decoder should only decode code-blocks included in the first progression order.", DebugKt.DEBUG_PROPERTY_VALUE_OFF}, new String[]{"one_tp", null, "Specifies whether the decoder should only decode the first tile part of each tile.", DebugKt.DEBUG_PROPERTY_VALUE_OFF}, new String[]{"comp_transf", null, "Specifies whether the component transform indicated in the codestream should be used.", DebugKt.DEBUG_PROPERTY_VALUE_ON}, new String[]{"debug", null, "Print debugging messages when an error is encountered.", DebugKt.DEBUG_PROPERTY_VALUE_OFF}, new String[]{"cdstr_info", null, "Display information about the codestream. This information is: \n- Marker segments value in main and tile-part headers,\n- Tile-part length and position within the code-stream.", DebugKt.DEBUG_PROPERTY_VALUE_OFF}, new String[]{"nocolorspace", null, "Ignore any colorspace information in the image.", DebugKt.DEBUG_PROPERTY_VALUE_OFF}, new String[]{"colorspace_debug", null, "Print debugging messages when an error is encountered in the colorspace module.", DebugKt.DEBUG_PROPERTY_VALUE_OFF}};

    public Decoder(ParameterList parameterList, ImgScrollPane imgScrollPane) {
        this.csMap = null;
        this.title = null;
        this.isChildProcess = false;
        this.win = null;
        this.pl = parameterList;
        this.defpl = parameterList.getDefaultParameterList();
        this.isp = imgScrollPane;
    }

    public Decoder(ParameterList parameterList) {
        this(parameterList, null);
    }

    public int getExitCode() {
        return this.exitCode;
    }

    public static String[][] getParameterInfo() {
        return pinfo;
    }

    /* JADX WARN: Code restructure failed: missing block: B:200:0x0603, code lost:
    
        if (r6.isOriginalSigned(2) == false) goto L204;
     */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:507:0x0dcf  */
    /* JADX WARN: Removed duplicated region for block: B:508:0x0dd4  */
    /* JADX WARN: Removed duplicated region for block: B:512:0x0de0  */
    /* JADX WARN: Removed duplicated region for block: B:513:0x0df7  */
    /* JADX WARN: Removed duplicated region for block: B:516:0x0e09  */
    /* JADX WARN: Removed duplicated region for block: B:517:0x0e0d  */
    /* JADX WARN: Removed duplicated region for block: B:522:0x0e1a  */
    /* JADX WARN: Removed duplicated region for block: B:523:0x0e22  */
    /* JADX WARN: Removed duplicated region for block: B:526:0x0e33  */
    /* JADX WARN: Removed duplicated region for block: B:527:0x0e37  */
    /* JADX WARN: Removed duplicated region for block: B:532:0x0e51  */
    /* JADX WARN: Removed duplicated region for block: B:642:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Type inference failed for: r37v0, types: [jj2000.j2k.decoder.Decoder] */
    /* JADX WARN: Type inference failed for: r3v111, types: [java.lang.StringBuilder] */
    /* JADX WARN: Type inference failed for: r8v58, types: [java.lang.Object, jj2000.j2k.image.BlkImgDataSrc] */
    @Override // java.lang.Runnable
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void run() {
        int i;
        boolean z;
        String str;
        String strSubstring;
        boolean z2;
        RandomAccessIO bEBufferedRandomAccessFile;
        String str2;
        String str3;
        RandomAccessIO randomAccessIO;
        FileFormatReader fileFormatReader;
        InvCompTransf invCompTransf;
        DecoderSpecs decoderSpecs;
        InvCompTransf invCompTransf2;
        int i2;
        char c;
        InvCompTransf invCompTransf3;
        String str4;
        String str5;
        String str6;
        ImgWriter[] imgWriterArr;
        DecoderSpecs decoderSpecs2;
        ImgWriter[] imgWriterArr2;
        ImgWriter[] imgWriterArr3;
        String[] strArr;
        String str7;
        int iCheckImage;
        String str8 = "debug";
        String str9 = DebugKt.DEBUG_PROPERTY_VALUE_ON;
        String str10 = "Cannot get data from connection to ";
        String str11 = "Malformed URL for input file ";
        try {
            try {
                try {
                    try {
                        try {
                            if (this.pl.getBooleanParameter("v")) {
                                printVersionAndCopyright();
                            }
                            if (this.pl.getParameter("u").equals(DebugKt.DEBUG_PROPERTY_VALUE_ON)) {
                                printUsage();
                                return;
                            }
                            boolean booleanParameter = this.pl.getBooleanParameter("verbose");
                            try {
                                this.pl.checkList(vprfxs, ParameterList.toNameArray(pinfo));
                                String parameter = this.pl.getParameter("i");
                                if (parameter == null) {
                                    error("Input file ('-i' option) has not been specified", 1);
                                    return;
                                }
                                String parameter2 = this.pl.getParameter("o");
                                if (parameter2 == null) {
                                    str = "Cannot open input file ";
                                    z = booleanParameter;
                                    strSubstring = "";
                                    parameter2 = strSubstring;
                                    z2 = true;
                                } else {
                                    z = booleanParameter;
                                    str = "Cannot open input file ";
                                    if (parameter2.lastIndexOf(46) != -1) {
                                        strSubstring = parameter2.substring(parameter2.lastIndexOf(46), parameter2.length());
                                        parameter2 = parameter2.substring(0, parameter2.lastIndexOf(46));
                                    } else {
                                        strSubstring = ".pgx";
                                    }
                                    z2 = false;
                                }
                                boolean z3 = z2;
                                String str12 = parameter2;
                                if (parameter.indexOf(RemoteSettings.FORWARD_SLASH_STRING) < 1 || parameter.charAt(parameter.indexOf(RemoteSettings.FORWARD_SLASH_STRING) - 1) != ':') {
                                    try {
                                        bEBufferedRandomAccessFile = new BEBufferedRandomAccessFile(parameter, "r");
                                    } catch (IOException e) {
                                        StringBuilder sb = new StringBuilder(str);
                                        sb.append(e.getMessage() != null ? ":\n" + e.getMessage() : "");
                                        error(sb.toString(), 4);
                                        if (this.pl.getParameter("debug").equals(DebugKt.DEBUG_PROPERTY_VALUE_ON)) {
                                            e.printStackTrace();
                                            return;
                                        } else {
                                            error("Use '-debug' option for more details", 2);
                                            return;
                                        }
                                    }
                                } else {
                                    try {
                                        try {
                                            URLConnection uRLConnection = (URLConnection) FirebasePerfUrlConnection.instrument(new URL(parameter).openConnection());
                                            uRLConnection.connect();
                                            int contentLength = uRLConnection.getContentLength();
                                            try {
                                                InputStream inputStream = uRLConnection.getInputStream();
                                                bEBufferedRandomAccessFile = contentLength != -1 ? new ISRandomAccessIO(inputStream, contentLength, 1, contentLength) : new ISRandomAccessIO(inputStream);
                                                try {
                                                    bEBufferedRandomAccessFile.read();
                                                    bEBufferedRandomAccessFile.seek(0);
                                                } catch (IOException e2) {
                                                    error("Cannot get input data from " + parameter + " Invalid URL?", 4);
                                                    if (this.pl.getParameter("debug").equals(DebugKt.DEBUG_PROPERTY_VALUE_ON)) {
                                                        e2.printStackTrace();
                                                        return;
                                                    } else {
                                                        error("Use '-debug' option for more details", 2);
                                                        return;
                                                    }
                                                }
                                            } catch (IOException e3) {
                                                StringBuilder sb2 = new StringBuilder("Cannot get data from connection to ");
                                                sb2.append(parameter);
                                                sb2.append(e3.getMessage() != null ? ":\n" + e3.getMessage() : "");
                                                error(sb2.toString(), 4);
                                                if (this.pl.getParameter("debug").equals(DebugKt.DEBUG_PROPERTY_VALUE_ON)) {
                                                    e3.printStackTrace();
                                                    return;
                                                } else {
                                                    error("Use '-debug' option for more details", 2);
                                                    return;
                                                }
                                            }
                                        } catch (IOException e4) {
                                            StringBuilder sb3 = new StringBuilder("Cannot open connection to ");
                                            sb3.append(parameter);
                                            sb3.append(e4.getMessage() != null ? ":\n" + e4.getMessage() : "");
                                            error(sb3.toString(), 4);
                                            if (this.pl.getParameter("debug").equals(DebugKt.DEBUG_PROPERTY_VALUE_ON)) {
                                                e4.printStackTrace();
                                                return;
                                            } else {
                                                error("Use '-debug' option for more details", 2);
                                                return;
                                            }
                                        }
                                    } catch (MalformedURLException e5) {
                                        error("Malformed URL for input file " + parameter, 4);
                                        if (this.pl.getParameter("debug").equals(DebugKt.DEBUG_PROPERTY_VALUE_ON)) {
                                            e5.printStackTrace();
                                            return;
                                        } else {
                                            error("Use '-debug' option for more details", 2);
                                            return;
                                        }
                                    }
                                }
                                FileFormatReader fileFormatReader2 = new FileFormatReader(bEBufferedRandomAccessFile);
                                fileFormatReader2.readFileFormat();
                                if (fileFormatReader2.JP2FFUsed) {
                                    bEBufferedRandomAccessFile.seek(fileFormatReader2.getFirstCodeStreamPos());
                                }
                                this.hi = new HeaderInfo();
                                try {
                                    HeaderDecoder headerDecoder = new HeaderDecoder(bEBufferedRandomAccessFile, this.pl, this.hi);
                                    int numComps = headerDecoder.getNumComps();
                                    int numTiles = this.hi.siz.getNumTiles();
                                    DecoderSpecs decoderSpecs3 = headerDecoder.getDecoderSpecs();
                                    if (z) {
                                        randomAccessIO = bEBufferedRandomAccessFile;
                                        try {
                                            try {
                                                StringBuilder sb4 = new StringBuilder();
                                                sb4.append(numComps);
                                                str2 = "Use '-debug' option for more details";
                                                try {
                                                    sb4.append(" component(s) in codestream, ");
                                                    sb4.append(numTiles);
                                                    sb4.append(" tile(s)\n");
                                                    String str13 = sb4.toString() + "Image dimension: ";
                                                    int i3 = 0;
                                                    while (i3 < numComps) {
                                                        str3 = str9;
                                                        try {
                                                            try {
                                                                str13 = str13 + this.hi.siz.getCompImgWidth(i3) + "x" + this.hi.siz.getCompImgHeight(i3) + " ";
                                                                i3++;
                                                                str9 = str3;
                                                            } catch (IllegalArgumentException e6) {
                                                                e = e6;
                                                                str10 = str3;
                                                                error(e.getMessage(), 2);
                                                                if (this.pl.getParameter(str8).equals(str10)) {
                                                                }
                                                            }
                                                        } catch (Error e7) {
                                                            e = e7;
                                                            str11 = str2;
                                                            str10 = str3;
                                                            if (e.getMessage() == null) {
                                                                error(e.getMessage(), 2);
                                                            } else {
                                                                error("An error has occurred during decoding.", 2);
                                                            }
                                                            if (this.pl.getParameter(str8).equals(str10)) {
                                                                error(str11, 2);
                                                                return;
                                                            } else {
                                                                e.printStackTrace();
                                                                return;
                                                            }
                                                        } catch (RuntimeException e8) {
                                                            e = e8;
                                                            str11 = str2;
                                                            str10 = str3;
                                                            if (e.getMessage() == null) {
                                                                i = 2;
                                                                error("An uncaught runtime exception has occurred:\n" + e.getMessage(), 2);
                                                            } else {
                                                                i = 2;
                                                                error("An uncaught runtime exception has occurred.", 2);
                                                            }
                                                            if (this.pl.getParameter(str8).equals(str10)) {
                                                                error(str11, i);
                                                                return;
                                                            } else {
                                                                e.printStackTrace();
                                                                return;
                                                            }
                                                        } catch (Throwable th) {
                                                            th = th;
                                                            str11 = str2;
                                                            str10 = str3;
                                                            error("An uncaught exception has occurred.", 2);
                                                            if (this.pl.getParameter(str8).equals(str10)) {
                                                                error(str11, 2);
                                                                return;
                                                            } else {
                                                                th.printStackTrace();
                                                                return;
                                                            }
                                                        }
                                                    }
                                                    str3 = str9;
                                                    if (numTiles != 1) {
                                                        str13 = str13 + "\nNom. Tile dim. (in canvas): " + this.hi.siz.xtsiz + "x" + this.hi.siz.ytsiz;
                                                    }
                                                    FacilityManager.getMsgLogger().printmsg(1, str13);
                                                } catch (Error e9) {
                                                    e = e9;
                                                    str3 = DebugKt.DEBUG_PROPERTY_VALUE_ON;
                                                    str11 = str2;
                                                    str10 = str3;
                                                    if (e.getMessage() == null) {
                                                    }
                                                    if (this.pl.getParameter(str8).equals(str10)) {
                                                    }
                                                } catch (RuntimeException e10) {
                                                    e = e10;
                                                    str3 = DebugKt.DEBUG_PROPERTY_VALUE_ON;
                                                    str11 = str2;
                                                    str10 = str3;
                                                    if (e.getMessage() == null) {
                                                    }
                                                    if (this.pl.getParameter(str8).equals(str10)) {
                                                    }
                                                } catch (Throwable th2) {
                                                    th = th2;
                                                    str3 = DebugKt.DEBUG_PROPERTY_VALUE_ON;
                                                    str11 = str2;
                                                    str10 = str3;
                                                    error("An uncaught exception has occurred.", 2);
                                                    if (this.pl.getParameter(str8).equals(str10)) {
                                                    }
                                                }
                                            } catch (IllegalArgumentException e11) {
                                                e = e11;
                                                str3 = DebugKt.DEBUG_PROPERTY_VALUE_ON;
                                                str10 = str3;
                                                error(e.getMessage(), 2);
                                                if (this.pl.getParameter(str8).equals(str10)) {
                                                    e.printStackTrace();
                                                    return;
                                                }
                                                return;
                                            }
                                        } catch (Error e12) {
                                            e = e12;
                                            str2 = "Use '-debug' option for more details";
                                        } catch (RuntimeException e13) {
                                            e = e13;
                                            str2 = "Use '-debug' option for more details";
                                        } catch (Throwable th3) {
                                            th = th3;
                                            str2 = "Use '-debug' option for more details";
                                        }
                                    } else {
                                        str2 = "Use '-debug' option for more details";
                                        str3 = DebugKt.DEBUG_PROPERTY_VALUE_ON;
                                        randomAccessIO = bEBufferedRandomAccessFile;
                                    }
                                    if (this.pl.getBooleanParameter("cdstr_info")) {
                                        FacilityManager.getMsgLogger().printmsg(1, "Main header:\n" + this.hi.toStringMainHeader());
                                    }
                                    int[] iArr = new int[numComps];
                                    for (int i4 = 0; i4 < numComps; i4++) {
                                        iArr[i4] = headerDecoder.getOriginalBitDepth(i4);
                                    }
                                    try {
                                        ParameterList parameterList = this.pl;
                                        BitstreamReaderAgent bitstreamReaderAgentCreateInstance = BitstreamReaderAgent.createInstance(randomAccessIO, headerDecoder, parameterList, decoderSpecs3, parameterList.getBooleanParameter("cdstr_info"), this.hi);
                                        RandomAccessIO randomAccessIO2 = randomAccessIO;
                                        try {
                                            try {
                                                try {
                                                    try {
                                                        InverseWT inverseWTCreateInstance = InverseWT.createInstance(headerDecoder.createDequantizer(headerDecoder.createROIDeScaler(headerDecoder.createEntropyDecoder(bitstreamReaderAgentCreateInstance, this.pl), this.pl, decoderSpecs3), iArr, decoderSpecs3), decoderSpecs3);
                                                        int imgRes = bitstreamReaderAgentCreateInstance.getImgRes();
                                                        inverseWTCreateInstance.setImgResLevel(imgRes);
                                                        try {
                                                            try {
                                                                InvCompTransf invCompTransf4 = new InvCompTransf(new ImgDataConverter(inverseWTCreateInstance, 0), decoderSpecs3, iArr, this.pl);
                                                                if (fileFormatReader2.JP2FFUsed && this.pl.getParameter("nocolorspace").equals(DebugKt.DEBUG_PROPERTY_VALUE_OFF)) {
                                                                    try {
                                                                        ColorSpace colorSpace = new ColorSpace(randomAccessIO2, headerDecoder, this.pl);
                                                                        this.csMap = colorSpace;
                                                                        BlkImgDataSrc blkImgDataSrcCreateChannelDefinitionMapper = headerDecoder.createChannelDefinitionMapper(invCompTransf4, colorSpace);
                                                                        BlkImgDataSrc blkImgDataSrcCreateResampler = headerDecoder.createResampler(blkImgDataSrcCreateChannelDefinitionMapper, this.csMap);
                                                                        BlkImgDataSrc blkImgDataSrcCreatePalettizedColorSpaceMapper = headerDecoder.createPalettizedColorSpaceMapper(blkImgDataSrcCreateResampler, this.csMap);
                                                                        ?? CreateColorSpaceMapper = headerDecoder.createColorSpaceMapper(blkImgDataSrcCreatePalettizedColorSpaceMapper, this.csMap);
                                                                        invCompTransf = invCompTransf4;
                                                                        if (this.csMap.debugging()) {
                                                                            MsgLogger msgLogger = FacilityManager.getMsgLogger();
                                                                            fileFormatReader = fileFormatReader2;
                                                                            StringBuilder sb5 = new StringBuilder();
                                                                            sb5.append("");
                                                                            decoderSpecs = decoderSpecs3;
                                                                            sb5.append(this.csMap);
                                                                            msgLogger.printmsg(3, sb5.toString());
                                                                            FacilityManager.getMsgLogger().printmsg(3, "" + blkImgDataSrcCreateChannelDefinitionMapper);
                                                                            FacilityManager.getMsgLogger().printmsg(3, "" + blkImgDataSrcCreateResampler);
                                                                            FacilityManager.getMsgLogger().printmsg(3, "" + blkImgDataSrcCreatePalettizedColorSpaceMapper);
                                                                            FacilityManager.getMsgLogger().printmsg(3, "" + CreateColorSpaceMapper);
                                                                            invCompTransf2 = CreateColorSpaceMapper;
                                                                        } else {
                                                                            fileFormatReader = fileFormatReader2;
                                                                            decoderSpecs = decoderSpecs3;
                                                                            invCompTransf2 = CreateColorSpaceMapper;
                                                                        }
                                                                    } catch (ColorSpaceException e14) {
                                                                        StringBuilder sb6 = new StringBuilder();
                                                                        sb6.append("error processing jp2 colorspace information");
                                                                        sb6.append(e14.getMessage() != null ? ": " + e14.getMessage() : "    ");
                                                                        error(sb6.toString(), 1, e14);
                                                                        return;
                                                                    } catch (IllegalArgumentException e15) {
                                                                        StringBuilder sb7 = new StringBuilder();
                                                                        sb7.append("Could not instantiate ICC profiler");
                                                                        sb7.append(e15.getMessage() != null ? ":\n" + e15.getMessage() : "");
                                                                        error(sb7.toString(), 1, e15);
                                                                        return;
                                                                    }
                                                                } else {
                                                                    fileFormatReader = fileFormatReader2;
                                                                    invCompTransf = invCompTransf4;
                                                                    decoderSpecs = decoderSpecs3;
                                                                    invCompTransf2 = invCompTransf;
                                                                }
                                                                InvCompTransf invCompTransf5 = invCompTransf2 == null ? invCompTransf : invCompTransf2;
                                                                int numComps2 = invCompTransf5.getNumComps();
                                                                String[] strArr2 = null;
                                                                if (z3) {
                                                                    String str14 = "JJ2000: " + new File(parameter).getName() + " " + invCompTransf5.getImgWidth() + "x" + invCompTransf5.getImgHeight();
                                                                    if (this.isp == null) {
                                                                        Frame frame = new Frame(str14 + " @ (0,0) : 1");
                                                                        this.win = frame;
                                                                        frame.setBackground(Color.white);
                                                                        this.win.addWindowListener(new ExitHandler(this));
                                                                        ImgScrollPane imgScrollPane = new ImgScrollPane(0);
                                                                        this.isp = imgScrollPane;
                                                                        this.win.add(imgScrollPane, "Center");
                                                                        this.isp.addKeyListener(new ImgKeyListener(this.isp, this));
                                                                        this.win.addKeyListener(new ImgKeyListener(this.isp, this));
                                                                    } else {
                                                                        this.win = null;
                                                                    }
                                                                    Frame frame2 = this.win;
                                                                    if (frame2 != null) {
                                                                        frame2.addNotify();
                                                                        Insets insets = this.win.getInsets();
                                                                        Dimension dimension = new Dimension((((invCompTransf5.getImgWidth() + r9) - 1) / invCompTransf5.getCompSubsX(0)) + insets.left + insets.right, (((invCompTransf5.getImgHeight() + r13) - 1) / invCompTransf5.getCompSubsY(0)) + insets.top + insets.bottom);
                                                                        Dimension screenSize = this.win.getToolkit().getScreenSize();
                                                                        if (dimension.width > (screenSize.width * 8) / 10.0f) {
                                                                            dimension.width = (int) ((screenSize.width * 8) / 10.0f);
                                                                        }
                                                                        if (dimension.height > (screenSize.height * 8) / 10.0f) {
                                                                            dimension.height = (int) ((screenSize.height * 8) / 10.0f);
                                                                        }
                                                                        this.win.setSize(dimension);
                                                                        this.win.validate();
                                                                        this.win.setVisible(true);
                                                                        this.title = new TitleUpdater(this.isp, this.win, str14);
                                                                        new Thread(this.title).start();
                                                                    } else {
                                                                        this.title = null;
                                                                    }
                                                                    invCompTransf3 = invCompTransf5;
                                                                    imgWriterArr3 = null;
                                                                    str4 = "debug";
                                                                    decoderSpecs2 = decoderSpecs;
                                                                    str5 = str2;
                                                                    str6 = str3;
                                                                } else {
                                                                    if (this.csMap != null) {
                                                                        if (strSubstring.equalsIgnoreCase(".PPM") && (numComps2 != 3 || invCompTransf5.getNomRangeBits(0) > 8 || invCompTransf5.getNomRangeBits(1) > 8 || invCompTransf5.getNomRangeBits(2) > 8 || this.csMap.isOutputSigned(0) || this.csMap.isOutputSigned(1) || this.csMap.isOutputSigned(2))) {
                                                                            error("Specified PPM output file but compressed image is not of the correct format for PPM or limited decoded components to less than 3.", 1);
                                                                            return;
                                                                        }
                                                                    } else if (strSubstring.equalsIgnoreCase(".PPM")) {
                                                                        if (numComps2 != 3 || invCompTransf5.getNomRangeBits(0) > 8) {
                                                                            i2 = 1;
                                                                        } else {
                                                                            i2 = 1;
                                                                            if (invCompTransf5.getNomRangeBits(1) <= 8 && invCompTransf5.getNomRangeBits(2) <= 8 && !headerDecoder.isOriginalSigned(0)) {
                                                                                if (!headerDecoder.isOriginalSigned(1)) {
                                                                                }
                                                                                i2 = 1;
                                                                            }
                                                                        }
                                                                        error("Specified PPM output file but compressed image is not of the correct format for PPM or limited decoded components to less than 3.", i2);
                                                                        return;
                                                                    }
                                                                    strArr2 = new String[numComps2];
                                                                    int i5 = 0;
                                                                    while (i5 < numComps2) {
                                                                        strArr2[i5] = "";
                                                                        i5++;
                                                                    }
                                                                    if (numComps2 <= 1 || strSubstring.equalsIgnoreCase(".PPM")) {
                                                                        c = 0;
                                                                        strArr2[0] = str12 + strSubstring;
                                                                    } else {
                                                                        if (strSubstring.equalsIgnoreCase(".PGM")) {
                                                                            for (int i6 = 0; i6 < numComps2; i6++) {
                                                                                ColorSpace colorSpace2 = this.csMap;
                                                                                if (colorSpace2 != null) {
                                                                                    if (colorSpace2.isOutputSigned(i6)) {
                                                                                        error("Specified PGM output file but compressed image is not of the correct format for PGM.", 1);
                                                                                        return;
                                                                                    }
                                                                                } else if (headerDecoder.isOriginalSigned(i6)) {
                                                                                    error("Specified PGM output file but compressed image is not of the correct format for PGM.", 1);
                                                                                    return;
                                                                                }
                                                                            }
                                                                        }
                                                                        i5 = 0;
                                                                        while (i5 < numComps2) {
                                                                            StringBuilder sb8 = new StringBuilder();
                                                                            String str15 = str12;
                                                                            sb8.append(str15);
                                                                            sb8.append("-");
                                                                            int i7 = i5 + 1;
                                                                            sb8.append(i7);
                                                                            sb8.append(strSubstring);
                                                                            strArr2[i5] = sb8.toString();
                                                                            i5 = i7;
                                                                            str12 = str15;
                                                                        }
                                                                        c = 0;
                                                                    }
                                                                    if (strSubstring.equalsIgnoreCase(".PPM")) {
                                                                        imgWriterArr = new ImgWriter[1];
                                                                        try {
                                                                            InvCompTransf invCompTransf6 = invCompTransf5;
                                                                            invCompTransf3 = invCompTransf6;
                                                                            imgWriterArr[c] = new ImgWriterPPM(strArr2[c], invCompTransf6, 0, 1, 2);
                                                                            str4 = "debug";
                                                                            str5 = str2;
                                                                            str6 = str3;
                                                                        } catch (IOException e16) {
                                                                            StringBuilder sb9 = new StringBuilder();
                                                                            sb9.append("Cannot write PPM header or open output file");
                                                                            sb9.append(i5);
                                                                            sb9.append(e16.getMessage() != null ? ":\n" + e16.getMessage() : "");
                                                                            error(sb9.toString(), 2);
                                                                            str8 = "debug";
                                                                            str10 = str3;
                                                                            try {
                                                                                if (this.pl.getParameter(str8).equals(str10)) {
                                                                                    e16.printStackTrace();
                                                                                    return;
                                                                                } else {
                                                                                    error(str2, 2);
                                                                                    return;
                                                                                }
                                                                            } catch (Error e17) {
                                                                                e = e17;
                                                                                str11 = str2;
                                                                                if (e.getMessage() == null) {
                                                                                }
                                                                                if (this.pl.getParameter(str8).equals(str10)) {
                                                                                }
                                                                            } catch (RuntimeException e18) {
                                                                                e = e18;
                                                                                str11 = str2;
                                                                                if (e.getMessage() == null) {
                                                                                }
                                                                                if (this.pl.getParameter(str8).equals(str10)) {
                                                                                }
                                                                            } catch (Throwable th4) {
                                                                                th = th4;
                                                                                str11 = str2;
                                                                                error("An uncaught exception has occurred.", 2);
                                                                                if (this.pl.getParameter(str8).equals(str10)) {
                                                                                }
                                                                            }
                                                                        }
                                                                    } else {
                                                                        invCompTransf3 = invCompTransf5;
                                                                        str4 = "debug";
                                                                        str5 = str2;
                                                                        str6 = str3;
                                                                        imgWriterArr = new ImgWriter[numComps2];
                                                                    }
                                                                    if (this.csMap == null) {
                                                                        decoderSpecs2 = decoderSpecs;
                                                                        if (imgWriterArr.length == 3 && invCompTransf3.getNomRangeBits(0) <= 8) {
                                                                            imgWriterArr2 = imgWriterArr;
                                                                            if (invCompTransf3.getNomRangeBits(1) <= 8 && invCompTransf3.getNomRangeBits(2) <= 8 && !headerDecoder.isOriginalSigned(0) && !headerDecoder.isOriginalSigned(1) && !headerDecoder.isOriginalSigned(2) && decoderSpecs2.cts.isCompTransfUsed()) {
                                                                                warning("JJ2000 is quicker with one PPM output file than with 3 PGM/PGX output files when a component transformation is applied.");
                                                                            }
                                                                        }
                                                                        imgWriterArr3 = imgWriterArr2;
                                                                    } else if (imgWriterArr.length != 3 || invCompTransf3.getNomRangeBits(0) > 8 || invCompTransf3.getNomRangeBits(1) > 8 || invCompTransf3.getNomRangeBits(2) > 8 || this.csMap.isOutputSigned(0) || this.csMap.isOutputSigned(1) || this.csMap.isOutputSigned(2)) {
                                                                        decoderSpecs2 = decoderSpecs;
                                                                    } else {
                                                                        decoderSpecs2 = decoderSpecs;
                                                                        if (decoderSpecs2.cts.isCompTransfUsed()) {
                                                                            warning("JJ2000 is quicker with one PPM output file than with 3 PGM/PGX output files when a component transformation is applied.");
                                                                        }
                                                                    }
                                                                    imgWriterArr2 = imgWriterArr;
                                                                    imgWriterArr3 = imgWriterArr2;
                                                                }
                                                                int min = decoderSpecs2.dls.getMin();
                                                                if (z) {
                                                                    if (min != imgRes) {
                                                                        MsgLogger msgLogger2 = FacilityManager.getMsgLogger();
                                                                        strArr = strArr2;
                                                                        StringBuilder sb10 = new StringBuilder();
                                                                        str7 = "";
                                                                        sb10.append("Reconstructing resolution ");
                                                                        sb10.append(imgRes);
                                                                        sb10.append(" on ");
                                                                        sb10.append(min);
                                                                        sb10.append(" (");
                                                                        sb10.append(bitstreamReaderAgentCreateInstance.getImgWidth(imgRes));
                                                                        sb10.append("x");
                                                                        sb10.append(bitstreamReaderAgentCreateInstance.getImgHeight(imgRes));
                                                                        sb10.append(")");
                                                                        msgLogger2.println(sb10.toString(), 8, 8);
                                                                    } else {
                                                                        strArr = strArr2;
                                                                        str7 = "";
                                                                    }
                                                                    if (this.pl.getFloatParameter("rate") != -1.0f) {
                                                                        FacilityManager.getMsgLogger().println("Target rate = " + bitstreamReaderAgentCreateInstance.getTargetRate() + " bpp (" + bitstreamReaderAgentCreateInstance.getTargetNbytes() + " bytes)", 8, 8);
                                                                    }
                                                                } else {
                                                                    strArr = strArr2;
                                                                    str7 = "";
                                                                }
                                                                if (z3) {
                                                                    Thread.currentThread().setPriority(2);
                                                                    Image imageCreateImage = BlkImgDataSrcImageProducer.createImage(invCompTransf3, this.isp);
                                                                    this.isp.setCursor(Cursor.getPredefinedCursor(3));
                                                                    Frame frame3 = this.win;
                                                                    if (frame3 != null) {
                                                                        frame3.setCursor(Cursor.getPredefinedCursor(3));
                                                                    }
                                                                    this.isp.setImage(imageCreateImage);
                                                                    this.isp.setCursor(Cursor.getPredefinedCursor(0));
                                                                    Frame frame4 = this.win;
                                                                    if (frame4 != null) {
                                                                        frame4.setCursor(Cursor.getPredefinedCursor(0));
                                                                    }
                                                                    if (this.win != null) {
                                                                        do {
                                                                            iCheckImage = this.isp.checkImage(imageCreateImage, null);
                                                                            if ((iCheckImage & 64) != 0) {
                                                                                FacilityManager.getMsgLogger().printmsg(3, "An unknown error occurred while producing the image");
                                                                                return;
                                                                            }
                                                                            if ((iCheckImage & 128) != 0) {
                                                                                FacilityManager.getMsgLogger().printmsg(3, "Image production was aborted for some unknown reason");
                                                                            } else if ((iCheckImage & 32) != 0) {
                                                                                MouseMotionListener imgMouseListener = new ImgMouseListener(this.isp);
                                                                                this.isp.addMouseListener(imgMouseListener);
                                                                                this.isp.addMouseMotionListener(imgMouseListener);
                                                                            } else {
                                                                                try {
                                                                                    Thread.currentThread();
                                                                                    Thread.sleep(100L);
                                                                                } catch (InterruptedException unused) {
                                                                                }
                                                                            }
                                                                        } while ((iCheckImage & PassportService.DEFAULT_MAX_BLOCKSIZE) == 0);
                                                                    }
                                                                } else {
                                                                    for (int i8 = 0; i8 < imgWriterArr3.length; i8++) {
                                                                        if (strSubstring.equalsIgnoreCase(".PGM")) {
                                                                            try {
                                                                                imgWriterArr3[i8] = new ImgWriterPGM(strArr[i8], invCompTransf3, i8);
                                                                            } catch (IOException e19) {
                                                                                StringBuilder sb11 = new StringBuilder();
                                                                                sb11.append("Cannot write PGM header or open output file for component ");
                                                                                sb11.append(i8);
                                                                                sb11.append(e19.getMessage() != null ? ":\n" + e19.getMessage() : str7);
                                                                                error(sb11.toString(), 2);
                                                                                if (this.pl.getParameter(str4).equals(str6)) {
                                                                                    e19.printStackTrace();
                                                                                    return;
                                                                                } else {
                                                                                    error(str5, 2);
                                                                                    return;
                                                                                }
                                                                            }
                                                                        } else if (strSubstring.equalsIgnoreCase(".PGX")) {
                                                                            try {
                                                                                if (this.csMap != null) {
                                                                                    imgWriterArr3[i8] = new ImgWriterPGX(strArr[i8], invCompTransf3, i8, this.csMap.isOutputSigned(i8));
                                                                                } else {
                                                                                    imgWriterArr3[i8] = new ImgWriterPGX(strArr[i8], invCompTransf3, i8, headerDecoder.isOriginalSigned(i8));
                                                                                }
                                                                            } catch (IOException e20) {
                                                                                StringBuilder sb12 = new StringBuilder();
                                                                                sb12.append("Cannot write PGX header or open output file for component ");
                                                                                sb12.append(i8);
                                                                                sb12.append(e20.getMessage() != null ? ":\n" + e20.getMessage() : str7);
                                                                                error(sb12.toString(), 2);
                                                                                if (this.pl.getParameter(str4).equals(str6)) {
                                                                                    e20.printStackTrace();
                                                                                    return;
                                                                                } else {
                                                                                    error(str5, 2);
                                                                                    return;
                                                                                }
                                                                            }
                                                                        }
                                                                        try {
                                                                            imgWriterArr3[i8].writeAll();
                                                                            try {
                                                                                imgWriterArr3[i8].close();
                                                                            } catch (IOException e21) {
                                                                                StringBuilder sb13 = new StringBuilder();
                                                                                sb13.append("I/O error while closing output file (data may be corrupted");
                                                                                sb13.append(e21.getMessage() != null ? ":\n" + e21.getMessage() : str7);
                                                                                error(sb13.toString(), 2);
                                                                                if (this.pl.getParameter(str4).equals(str6)) {
                                                                                    e21.printStackTrace();
                                                                                    return;
                                                                                } else {
                                                                                    error(str5, 2);
                                                                                    return;
                                                                                }
                                                                            }
                                                                        } catch (IOException e22) {
                                                                            StringBuilder sb14 = new StringBuilder();
                                                                            sb14.append("I/O error while writing output file");
                                                                            sb14.append(e22.getMessage() != null ? ":\n" + e22.getMessage() : str7);
                                                                            error(sb14.toString(), 2);
                                                                            if (this.pl.getParameter(str4).equals(str6)) {
                                                                                e22.printStackTrace();
                                                                                return;
                                                                            } else {
                                                                                error(str5, 2);
                                                                                return;
                                                                            }
                                                                        }
                                                                    }
                                                                }
                                                                if (z) {
                                                                    float actualRate = bitstreamReaderAgentCreateInstance.getActualRate();
                                                                    int actualNbytes = bitstreamReaderAgentCreateInstance.getActualNbytes();
                                                                    FileFormatReader fileFormatReader3 = fileFormatReader;
                                                                    if (fileFormatReader3.JP2FFUsed) {
                                                                        int i9 = (int) ((actualNbytes * 8.0f) / actualRate);
                                                                        actualNbytes += fileFormatReader3.getFirstCodeStreamPos();
                                                                        actualRate = (actualNbytes * 8.0f) / i9;
                                                                    }
                                                                    if (this.pl.getIntParameter("ncb_quit") == -1) {
                                                                        FacilityManager.getMsgLogger().println("Actual bitrate = " + actualRate + " bpp (i.e. " + actualNbytes + " bytes)", 8, 8);
                                                                    } else {
                                                                        FacilityManager.getMsgLogger().println("Number of packet body bytes read = " + actualNbytes, 8, 8);
                                                                    }
                                                                    FacilityManager.getMsgLogger().flush();
                                                                }
                                                            } catch (IllegalArgumentException e23) {
                                                                e = e23;
                                                                str8 = "debug";
                                                                str10 = str3;
                                                                error(e.getMessage(), 2);
                                                                if (this.pl.getParameter(str8).equals(str10)) {
                                                                }
                                                            }
                                                        } catch (Error e24) {
                                                            e = e24;
                                                            str8 = "debug";
                                                            str11 = str2;
                                                            str10 = str3;
                                                            if (e.getMessage() == null) {
                                                            }
                                                            if (this.pl.getParameter(str8).equals(str10)) {
                                                            }
                                                        } catch (RuntimeException e25) {
                                                            e = e25;
                                                            str8 = "debug";
                                                            str11 = str2;
                                                            str10 = str3;
                                                            if (e.getMessage() == null) {
                                                            }
                                                            if (this.pl.getParameter(str8).equals(str10)) {
                                                            }
                                                        } catch (Throwable th5) {
                                                            th = th5;
                                                            str8 = "debug";
                                                            str11 = str2;
                                                            str10 = str3;
                                                            error("An uncaught exception has occurred.", 2);
                                                            if (this.pl.getParameter(str8).equals(str10)) {
                                                            }
                                                        }
                                                    } catch (IllegalArgumentException e26) {
                                                        String str16 = str2;
                                                        String str17 = str3;
                                                        StringBuilder sb15 = new StringBuilder();
                                                        sb15.append("Cannot instantiate inverse wavelet transform");
                                                        sb15.append(e26.getMessage() != null ? ":\n" + e26.getMessage() : "");
                                                        error(sb15.toString(), 2);
                                                        if (this.pl.getParameter("debug").equals(str17)) {
                                                            e26.printStackTrace();
                                                        } else {
                                                            error(str16, 2);
                                                        }
                                                    }
                                                } catch (IllegalArgumentException e27) {
                                                    String str18 = str2;
                                                    String str19 = str3;
                                                    StringBuilder sb16 = new StringBuilder();
                                                    sb16.append("Cannot instantiate dequantizer");
                                                    sb16.append(e27.getMessage() != null ? ":\n" + e27.getMessage() : "");
                                                    error(sb16.toString(), 2);
                                                    if (this.pl.getParameter("debug").equals(str19)) {
                                                        e27.printStackTrace();
                                                    } else {
                                                        error(str18, 2);
                                                    }
                                                }
                                            } catch (IllegalArgumentException e28) {
                                                String str20 = str2;
                                                String str21 = str3;
                                                StringBuilder sb17 = new StringBuilder();
                                                sb17.append("Cannot instantiate roi de-scaler.");
                                                sb17.append(e28.getMessage() != null ? ":\n" + e28.getMessage() : "");
                                                error(sb17.toString(), 2);
                                                if (this.pl.getParameter("debug").equals(str21)) {
                                                    e28.printStackTrace();
                                                } else {
                                                    error(str20, 2);
                                                }
                                            }
                                        } catch (IllegalArgumentException e29) {
                                            String str22 = str2;
                                            String str23 = str3;
                                            StringBuilder sb18 = new StringBuilder();
                                            sb18.append("Cannot instantiate entropy decoder");
                                            sb18.append(e29.getMessage() != null ? ":\n" + e29.getMessage() : "");
                                            error(sb18.toString(), 2);
                                            if (this.pl.getParameter("debug").equals(str23)) {
                                                e29.printStackTrace();
                                            } else {
                                                error(str22, 2);
                                            }
                                        }
                                    } catch (IOException e30) {
                                        String str24 = str2;
                                        String str25 = str3;
                                        StringBuilder sb19 = new StringBuilder();
                                        sb19.append("Error while reading bit stream header or parsing packets");
                                        sb19.append(e30.getMessage() != null ? ":\n" + e30.getMessage() : "");
                                        error(sb19.toString(), 4);
                                        if (this.pl.getParameter("debug").equals(str25)) {
                                            e30.printStackTrace();
                                        } else {
                                            error(str24, 2);
                                        }
                                    } catch (IllegalArgumentException e31) {
                                        String str26 = str2;
                                        String str27 = str3;
                                        StringBuilder sb20 = new StringBuilder();
                                        sb20.append("Cannot instantiate bit stream reader");
                                        sb20.append(e31.getMessage() != null ? ":\n" + e31.getMessage() : "");
                                        error(sb20.toString(), 2);
                                        if (this.pl.getParameter("debug").equals(str27)) {
                                            e31.printStackTrace();
                                        } else {
                                            error(str26, 2);
                                        }
                                    }
                                } catch (EOFException e32) {
                                    error("Codestream too short or bad header, unable to decode.", 2);
                                    if (this.pl.getParameter("debug").equals(DebugKt.DEBUG_PROPERTY_VALUE_ON)) {
                                        e32.printStackTrace();
                                    } else {
                                        error("Use '-debug' option for more details", 2);
                                    }
                                }
                            } catch (IllegalArgumentException e33) {
                                error(e33.getMessage(), 2);
                                if (this.pl.getParameter("debug").equals(DebugKt.DEBUG_PROPERTY_VALUE_ON)) {
                                    e33.printStackTrace();
                                } else {
                                    error("Use '-debug' option for more details", 2);
                                }
                            }
                        } catch (IllegalArgumentException e34) {
                            e = e34;
                        }
                    } catch (IllegalArgumentException e35) {
                        e = e35;
                        str10 = DebugKt.DEBUG_PROPERTY_VALUE_ON;
                    }
                } catch (Error e36) {
                    e = e36;
                    str11 = "Use '-debug' option for more details";
                    str10 = DebugKt.DEBUG_PROPERTY_VALUE_ON;
                } catch (RuntimeException e37) {
                    e = e37;
                    str11 = "Use '-debug' option for more details";
                    str10 = DebugKt.DEBUG_PROPERTY_VALUE_ON;
                } catch (Throwable th6) {
                    th = th6;
                    str11 = "Use '-debug' option for more details";
                    str10 = DebugKt.DEBUG_PROPERTY_VALUE_ON;
                }
            } catch (NumberFormatException e38) {
                error("An error occurred while parsing the arguments:\n" + e38.getMessage(), 1);
                if (this.pl.getParameter("debug").equals(DebugKt.DEBUG_PROPERTY_VALUE_ON)) {
                    e38.printStackTrace();
                } else {
                    error("Use '-debug' option for more details", 2);
                }
            } catch (StringFormatException e39) {
                error("An error occurred while parsing the arguments:\n" + e39.getMessage(), 1);
                if (this.pl.getParameter("debug").equals(DebugKt.DEBUG_PROPERTY_VALUE_ON)) {
                    e39.printStackTrace();
                } else {
                    error("Use '-debug' option for more details", 2);
                }
            }
        } catch (Error e40) {
            e = e40;
        } catch (RuntimeException e41) {
            e = e41;
        } catch (Throwable th7) {
            th = th7;
        }
    }

    private void error(String str, int i) {
        this.exitCode = i;
        FacilityManager.getMsgLogger().printmsg(3, str);
    }

    private void error(String str, int i, Throwable th) {
        this.exitCode = i;
        FacilityManager.getMsgLogger().printmsg(3, str);
        if (this.pl.getParameter("debug").equals(DebugKt.DEBUG_PROPERTY_VALUE_ON)) {
            th.printStackTrace();
        } else {
            error("Use '-debug' option for more details", 2);
        }
    }

    public String[] getCOMInfo() {
        HeaderInfo headerInfo = this.hi;
        if (headerInfo == null) {
            return null;
        }
        int numCOM = headerInfo.getNumCOM();
        Enumeration enumerationElements = this.hi.f5com.elements();
        String[] strArr = new String[numCOM];
        for (int i = 0; i < numCOM; i++) {
            strArr[i] = enumerationElements.nextElement().toString();
        }
        return strArr;
    }

    public static String[][] getAllParameters() {
        Vector vector = new Vector();
        String[][] parameterInfo = BitstreamReaderAgent.getParameterInfo();
        if (parameterInfo != null) {
            for (int length = parameterInfo.length - 1; length >= 0; length--) {
                vector.addElement(parameterInfo[length]);
            }
        }
        String[][] parameterInfo2 = EntropyDecoder.getParameterInfo();
        if (parameterInfo2 != null) {
            for (int length2 = parameterInfo2.length - 1; length2 >= 0; length2--) {
                vector.addElement(parameterInfo2[length2]);
            }
        }
        String[][] parameterInfo3 = ROIDeScaler.getParameterInfo();
        if (parameterInfo3 != null) {
            for (int length3 = parameterInfo3.length - 1; length3 >= 0; length3--) {
                vector.addElement(parameterInfo3[length3]);
            }
        }
        String[][] parameterInfo4 = Dequantizer.getParameterInfo();
        if (parameterInfo4 != null) {
            for (int length4 = parameterInfo4.length - 1; length4 >= 0; length4--) {
                vector.addElement(parameterInfo4[length4]);
            }
        }
        String[][] parameterInfo5 = InvCompTransf.getParameterInfo();
        if (parameterInfo5 != null) {
            for (int length5 = parameterInfo5.length - 1; length5 >= 0; length5--) {
                vector.addElement(parameterInfo5[length5]);
            }
        }
        String[][] parameterInfo6 = HeaderDecoder.getParameterInfo();
        if (parameterInfo6 != null) {
            for (int length6 = parameterInfo6.length - 1; length6 >= 0; length6--) {
                vector.addElement(parameterInfo6[length6]);
            }
        }
        String[][] parameterInfo7 = ICCProfiler.getParameterInfo();
        if (parameterInfo7 != null) {
            for (int length7 = parameterInfo7.length - 1; length7 >= 0; length7--) {
                vector.addElement(parameterInfo7[length7]);
            }
        }
        String[][] parameterInfo8 = getParameterInfo();
        if (parameterInfo8 != null) {
            for (int length8 = parameterInfo8.length - 1; length8 >= 0; length8--) {
                vector.addElement(parameterInfo8[length8]);
            }
        }
        String[][] strArr = (String[][]) Array.newInstance((Class<?>) String.class, vector.size(), 4);
        if (strArr != null) {
            for (int length9 = strArr.length - 1; length9 >= 0; length9--) {
                strArr[length9] = (String[]) vector.elementAt(length9);
            }
        }
        return strArr;
    }

    private void warning(String str) {
        FacilityManager.getMsgLogger().printmsg(2, str);
    }

    private void printVersionAndCopyright() {
        FacilityManager.getMsgLogger().println("JJ2000's JPEG 2000 Decoder\n", 2, 4);
        FacilityManager.getMsgLogger().println("Version: 5.1\n", 2, 4);
        FacilityManager.getMsgLogger().println("Copyright:\n\nThis software module was originally developed by Raphaël Grosbois and Diego Santa Cruz (Swiss Federal Institute of Technology-EPFL); Joel Askelöf (Ericsson Radio Systems AB); and Bertrand Berthelot, David Bouchard, Félix Henry, Gerard Mozelle and Patrice Onno (Canon Research Centre France S.A) in the course of development of the JPEG 2000 standard as specified by ISO/IEC 15444 (JPEG 2000 Standard). This software module is an implementation of a part of the JPEG 2000 Standard. Swiss Federal Institute of Technology-EPFL, Ericsson Radio Systems AB and Canon Research Centre France S.A (collectively JJ2000 Partners) agree not to assert against ISO/IEC and users of the JPEG 2000 Standard (Users) any of their rights under the copyright, not including other intellectual property rights, for this software module with respect to the usage by ISO/IEC and Users of this software module or modifications thereof for use in hardware or software products claiming conformance to the JPEG 2000 Standard. Those intending to use this software module in hardware or software products are advised that their use may infringe existing patents. The original developers of this software module, JJ2000 Partners and ISO/IEC assume no liability for use of this software module or modifications thereof. No license or right to this software module is granted for non JPEG 2000 Standard conforming products. JJ2000 Partners have full right to use this software module for his/her own purpose, assign or donate this software module to any third party and to inhibit third parties from using this software module for non JPEG 2000 Standard conforming products. This copyright notice must be included in all copies or derivative works of this software module.\n\nCopyright (c) 1999/2000 JJ2000 Partners.\n", 2, 4);
        FacilityManager.getMsgLogger().println("Send bug reports to: jj2000-bugs@ltssg3.epfl.ch\n", 2, 4);
    }

    private void printUsage() {
        MsgLogger msgLogger = FacilityManager.getMsgLogger();
        msgLogger.println("Usage:", 0, 0);
        msgLogger.println("JJ2KDecoder args...\n", 10, 12);
        msgLogger.println("The exit code of the decoder is non-zero if an error occurs.", 2, 4);
        msgLogger.println("The following arguments are recongnized:\n", 2, 4);
        printParamInfo(msgLogger, getAllParameters());
        FacilityManager.getMsgLogger().println("\n\n", 0, 0);
        FacilityManager.getMsgLogger().println("Send bug reports to: jj2000-bugs@ltssg3.epfl.ch\n", 2, 4);
    }

    private void printParamInfo(MsgLogger msgLogger, String[][] strArr) {
        for (int i = 0; i < strArr.length; i++) {
            String parameter = this.defpl.getParameter(strArr[i][0]);
            if (parameter != null) {
                StringBuilder sb = new StringBuilder("-");
                sb.append(strArr[i][0]);
                sb.append(strArr[i][1] != null ? " " + strArr[i][1] + " " : " ");
                sb.append("(default = ");
                sb.append(parameter);
                sb.append(")");
                msgLogger.println(sb.toString(), 4, 8);
            } else {
                StringBuilder sb2 = new StringBuilder("-");
                sb2.append(strArr[i][0]);
                sb2.append(strArr[i][1] != null ? " " + strArr[i][1] : "");
                msgLogger.println(sb2.toString(), 4, 8);
            }
            String str = strArr[i][2];
            if (str != null) {
                msgLogger.println(str, 6, 6);
            }
        }
    }

    public void exit() {
        if (this.isChildProcess) {
            Frame frame = this.win;
            if (frame != null) {
                frame.dispose();
            }
            TitleUpdater titleUpdater = this.title;
            if (titleUpdater != null) {
                titleUpdater.done = true;
                return;
            }
            return;
        }
        System.exit(0);
    }

    public void setChildProcess(boolean z) {
        this.isChildProcess = z;
    }
}
