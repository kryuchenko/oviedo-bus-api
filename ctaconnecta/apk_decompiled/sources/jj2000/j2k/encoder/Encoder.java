package jj2000.j2k.encoder;

import java.io.IOException;
import java.lang.reflect.Array;
import java.util.StringTokenizer;
import java.util.Vector;
import jj2000.j2k.codestream.writer.HeaderEncoder;
import jj2000.j2k.codestream.writer.PktEncoder;
import jj2000.j2k.entropy.encoder.EntropyCoder;
import jj2000.j2k.entropy.encoder.PostCompRateAllocator;
import jj2000.j2k.entropy.encoder.StdEntropyCoder;
import jj2000.j2k.image.forwcomptransf.ForwCompTransf;
import jj2000.j2k.image.input.ImgReader;
import jj2000.j2k.image.input.ImgReaderPGM;
import jj2000.j2k.image.input.ImgReaderPGX;
import jj2000.j2k.image.input.ImgReaderPPM;
import jj2000.j2k.quantization.quantizer.Quantizer;
import jj2000.j2k.roi.encoder.ROIScaler;
import jj2000.j2k.util.FacilityManager;
import jj2000.j2k.util.MsgLogger;
import jj2000.j2k.util.ParameterList;
import jj2000.j2k.util.StringFormatException;
import jj2000.j2k.wavelet.analysis.AnWTFilter;
import jj2000.j2k.wavelet.analysis.ForwardWT;
import kotlinx.coroutines.DebugKt;

/* loaded from: classes5.dex */
public class Encoder implements Runnable {
    private ParameterList defpl;
    private int exitCode;
    private ParameterList pl;
    public static final char[] vprfxs = {'M', AnWTFilter.OPT_PREFIX, ForwardWT.OPT_PREFIX, 'Q', 'R', 'H', 'C', PostCompRateAllocator.OPT_PREFIX, PktEncoder.OPT_PREFIX};
    private static final String[][] pinfo = {new String[]{"debug", null, "Print debugging messages when an error is encountered.", DebugKt.DEBUG_PROPERTY_VALUE_OFF}, new String[]{"disable_jp2_extension", "[on|off]", "JJ2000 automatically adds .jp2 extension when using 'file_format'option. This option disables it when on.", DebugKt.DEBUG_PROPERTY_VALUE_OFF}, new String[]{"file_format", "[on|off]", "Puts the JPEG 2000 codestream in a JP2 file format wrapper.", DebugKt.DEBUG_PROPERTY_VALUE_OFF}, new String[]{"pph_tile", "[on|off]", "Packs the packet headers in the tile headers.", DebugKt.DEBUG_PROPERTY_VALUE_OFF}, new String[]{"pph_main", "[on|off]", "Packs the packet headers in the main header.", DebugKt.DEBUG_PROPERTY_VALUE_OFF}, new String[]{"pfile", "<filename of arguments file>", "Loads the arguments from the specified file. Arguments that are specified on the command line override the ones from the file.\nThe arguments file is a simple text file with one argument per line of the following form:\n  <argument name>=<argument value>\nIf the argument is of boolean type (i.e. its presence turns a feature on), then the 'on' value turns it on, while the 'off' value turns it off. The argument name does not include the '-' or '+' character. Long lines can be broken into several lines by terminating them with ''. Lines starting with '#' are considered as comments. This option is not recursive: any 'pfile' argument appearing in the file is ignored.", null}, new String[]{"tile_parts", "<packets per tile-part>", "This option specifies the maximum number of packets to have in one tile-part. 0 means include all packets in first tile-part of each tile", StdEntropyCoder.DEF_THREADS_NUM}, new String[]{"tiles", "<nominal tile width> <nominal tile height>", "This option specifies the maximum tile dimensions to use. If both dimensions are 0 then no tiling is used.", "0 0"}, new String[]{"ref", "<x> <y>", "Sets the origin of the image in the canvas system. It sets the coordinate of the top-left corner of the image reference grid, with respect to the canvas origin", "0 0"}, new String[]{"tref", "<x> <y>", "Sets the origin of the tile partitioning on the reference grid, with respect to the canvas origin. The value of 'x' ('y') specified can not be larger than the 'x' one specified in the ref option.", "0 0"}, new String[]{"rate", "<output bitrate in bpp>", "This is the output bitrate of the codestream in bits per pixel. When equal to -1, no image information (beside quantization effects) is discarded during compression.\nNote: In the case where '-file_format' option is used, the resulting file may have a larger bitrate.", "-1"}, new String[]{"lossless", "[on|off]", "Specifies a lossless compression for the encoder. This options is equivalent to use reversible quantization ('-Qtype reversible') and 5x3 wavelet filters pair ('-Ffilters w5x3'). Note that this option cannot be used with '-rate'. When this option is off, the quantization type and the filters pair is defined by '-Qtype' and '-Ffilters' respectively.", DebugKt.DEBUG_PROPERTY_VALUE_OFF}, new String[]{"i", "<image file> [,<image file> [,<image file> ... ]]", "Mandatory argument. This option specifies the name of the input image files. If several image files are provided, they have to be separated by commas in the command line. Supported formats are PGM (raw), PPM (raw) and PGX, which is a simple extension of the PGM file format for single component data supporting arbitrary bitdepths. If the extension is '.pgm', PGM-raw file format is assumed, if the extension is '.ppm', PPM-raw file format is assumed, otherwise PGX file format is assumed. PGM and PPM files are assumed to be 8 bits deep. A multi-component image can be specified by either specifying several PPM and/or PGX files, or by specifying one PPM file.", null}, new String[]{"o", "<file name>", "Mandatory argument. This option specifies the name of the output file to which the codestream will be written.", null}, new String[]{"verbose", null, "Prints information about the obtained bit stream.", DebugKt.DEBUG_PROPERTY_VALUE_ON}, new String[]{"v", "[on|off]", "Prints version and copyright information.", DebugKt.DEBUG_PROPERTY_VALUE_OFF}, new String[]{"u", "[on|off]", "Prints usage information. If specified all other arguments (except 'v') are ignored", DebugKt.DEBUG_PROPERTY_VALUE_OFF}};

    public Encoder(ParameterList parameterList) {
        this.pl = parameterList;
        this.defpl = parameterList.getDefaultParameterList();
    }

    public int getExitCode() {
        return this.exitCode;
    }

    /* JADX WARN: Code restructure failed: missing block: B:166:0x0397, code lost:
    
        r31 = r3;
        r19 = r15;
        r3 = r2.size();
        r8 = new jj2000.j2k.image.input.ImgReader[r3];
        r2.copyInto(r8);
        r2.removeAllElements();
        r2 = new boolean[r13];
     */
    /* JADX WARN: Code restructure failed: missing block: B:167:0x03a9, code lost:
    
        if (r19 != false) goto L175;
     */
    /* JADX WARN: Code restructure failed: missing block: B:169:0x03ac, code lost:
    
        if (r13 != 1) goto L171;
     */
    /* JADX WARN: Code restructure failed: missing block: B:171:0x03af, code lost:
    
        r12 = new int[r13];
        r15 = 0;
     */
    /* JADX WARN: Code restructure failed: missing block: B:172:0x03b2, code lost:
    
        if (r15 >= r13) goto L471;
     */
    /* JADX WARN: Code restructure failed: missing block: B:173:0x03b4, code lost:
    
        r34 = r2;
        r16 = r15;
        r34[r16] = r8[r15].isOrigSigned(0);
        r15 = r16 + 1;
        r2 = r34;
     */
    /* JADX WARN: Code restructure failed: missing block: B:174:0x03c6, code lost:
    
        r34 = r2;
        r2 = new jj2000.j2k.image.ImgDataJoiner(r8, r12);
     */
    /* JADX WARN: Code restructure failed: missing block: B:175:0x03ce, code lost:
    
        r34 = r2;
        r18 = 0;
        r2 = r8[0];
        r12 = 0;
     */
    /* JADX WARN: Code restructure failed: missing block: B:176:0x03d5, code lost:
    
        if (r12 >= r13) goto L474;
     */
    /* JADX WARN: Code restructure failed: missing block: B:177:0x03d7, code lost:
    
        r34[r12] = r8[r18].isOrigSigned(r12);
        r12 = r12 + 1;
        r18 = 0;
     */
    /* JADX WARN: Code restructure failed: missing block: B:178:0x03e4, code lost:
    
        r33 = r2;
        r2 = new java.io.StreamTokenizer(new java.io.StringReader(r46.pl.getParameter("tiles")));
        r2.eolIsSignificant(false);
        r2.nextToken();
     */
    /* JADX WARN: Code restructure failed: missing block: B:179:0x0400, code lost:
    
        if (r2.ttype == (-2)) goto L182;
     */
    /* JADX WARN: Code restructure failed: missing block: B:180:0x0402, code lost:
    
        error("An error occurred while parsing the tiles option: " + r46.pl.getParameter("tiles"), 2);
     */
    /* JADX WARN: Code restructure failed: missing block: B:183:0x0421, code lost:
    
        r7 = (int) r2.nval;
        r2.nextToken();
     */
    /* JADX WARN: Code restructure failed: missing block: B:184:0x042c, code lost:
    
        if (r2.ttype == (-2)) goto L186;
     */
    /* JADX WARN: Code restructure failed: missing block: B:185:0x042e, code lost:
    
        error("An error occurred while parsing the tiles option: " + r46.pl.getParameter("tiles"), 2);
     */
    /* JADX WARN: Code restructure failed: missing block: B:186:0x044b, code lost:
    
        r2 = (int) r2.nval;
        r4 = new java.util.StringTokenizer(r46.pl.getParameter("ref"));
     */
    /* JADX WARN: Code restructure failed: missing block: B:187:0x045b, code lost:
    
        r7 = java.lang.Integer.parseInt(r4.nextToken());
        r4 = java.lang.Integer.parseInt(r4.nextToken());
     */
    /* JADX WARN: Code restructure failed: missing block: B:188:0x046b, code lost:
    
        if (r7 < 0) goto L344;
     */
    /* JADX WARN: Code restructure failed: missing block: B:189:0x046d, code lost:
    
        if (r4 < 0) goto L344;
     */
    /* JADX WARN: Code restructure failed: missing block: B:192:0x0477, code lost:
    
        r8 = new java.util.StringTokenizer(r46.pl.getParameter("tref"));
     */
    /* JADX WARN: Code restructure failed: missing block: B:193:0x0480, code lost:
    
        r2 = java.lang.Integer.parseInt(r8.nextToken());
        r8 = java.lang.Integer.parseInt(r8.nextToken());
     */
    /* JADX WARN: Code restructure failed: missing block: B:194:0x0490, code lost:
    
        if (r2 < 0) goto L330;
     */
    /* JADX WARN: Code restructure failed: missing block: B:195:0x0492, code lost:
    
        if (r8 < 0) goto L330;
     */
    /* JADX WARN: Code restructure failed: missing block: B:196:0x0494, code lost:
    
        if (r2 > r7) goto L330;
     */
    /* JADX WARN: Code restructure failed: missing block: B:197:0x0496, code lost:
    
        if (r8 > r4) goto L330;
     */
    /* JADX WARN: Code restructure failed: missing block: B:198:0x0498, code lost:
    
        r35 = new jj2000.j2k.image.Tiler(r33, r7, r4, r2, r8, r7, r2);
     */
    /* JADX WARN: Code restructure failed: missing block: B:200:0x04ab, code lost:
    
        r7 = r35.getNumTiles();
        r8 = new jj2000.j2k.encoder.EncoderSpecs(r7, r13, r33, r46.pl);
     */
    /* JADX WARN: Code restructure failed: missing block: B:201:0x04b6, code lost:
    
        if (r19 == false) goto L419;
     */
    /* JADX WARN: Code restructure failed: missing block: B:203:0x04c0, code lost:
    
        if (r46.pl.getParameter("Mct") == null) goto L419;
     */
    /* JADX WARN: Code restructure failed: missing block: B:205:0x04ce, code lost:
    
        if (r46.pl.getParameter("Mct").equals(kotlinx.coroutines.DebugKt.DEBUG_PROPERTY_VALUE_OFF) == false) goto L419;
     */
    /* JADX WARN: Code restructure failed: missing block: B:206:0x04d0, code lost:
    
        jj2000.j2k.util.FacilityManager.getMsgLogger().printmsg(2, "Input image is RGB and no color transform has been specified. Compression performance and image quality might be greatly degraded. Use the 'Mct' option to specify a color transform");
     */
    /* JADX WARN: Code restructure failed: missing block: B:209:0x04e4, code lost:
    
        r10 = jj2000.j2k.wavelet.analysis.ForwardWT.createInstance(new jj2000.j2k.image.ImgDataConverter(new jj2000.j2k.image.forwcomptransf.ForwCompTransf(r35, r8)), r46.pl, r8);
     */
    /* JADX WARN: Code restructure failed: missing block: B:211:0x04ee, code lost:
    
        r35 = jj2000.j2k.roi.encoder.ROIScaler.createInstance(jj2000.j2k.quantization.quantizer.Quantizer.createInstance(r10, r8), r46.pl, r8);
     */
    /* JADX WARN: Code restructure failed: missing block: B:212:0x04f4, code lost:
    
        r2 = jj2000.j2k.entropy.encoder.EntropyCoder.createInstance(r35, r46.pl, r8.cblks, r8.pss, r8.bms, r8.mqrs, r8.rts, r8.css, r8.sss, r8.lcs, r8.tts);
     */
    /* JADX WARN: Code restructure failed: missing block: B:213:0x0522, code lost:
    
        r12 = new jj2000.j2k.codestream.writer.FileCodestreamWriter(r0, Integer.MAX_VALUE);
     */
    /* JADX WARN: Code restructure failed: missing block: B:214:0x052a, code lost:
    
        r39 = jj2000.j2k.entropy.encoder.PostCompRateAllocator.createInstance(r2, r46.pl, r9, r12, r8);
     */
    /* JADX WARN: Code restructure failed: missing block: B:215:0x0530, code lost:
    
        r32 = new jj2000.j2k.codestream.writer.HeaderEncoder(r33, r34, r10, r35, r8, r35, r39, r46.pl);
        r39.setHeaderEncoder(r32);
        r32.encodeMainHeader();
        r39.initialize();
        r32.reset();
        r32.encodeMainHeader();
        r12.commitBitstreamHeader(r32);
     */
    /* JADX WARN: Code restructure failed: missing block: B:216:0x055c, code lost:
    
        if (r10 == false) goto L220;
     */
    /* JADX WARN: Code restructure failed: missing block: B:217:0x055e, code lost:
    
        r30 = 8.0f;
     */
    /* JADX WARN: Code restructure failed: missing block: B:218:0x056a, code lost:
    
        if (r46.pl.getFloatParameter("rate") == (-1.0f)) goto L221;
     */
    /* JADX WARN: Code restructure failed: missing block: B:219:0x056c, code lost:
    
        jj2000.j2k.util.FacilityManager.getMsgLogger().println("Target bitrate = " + r9 + " bpp (i.e. " + ((int) (((r9 * r33.getImgWidth()) * r33.getImgHeight()) / 8.0f)) + " bytes)", 4, 6);
     */
    /* JADX WARN: Code restructure failed: missing block: B:220:0x05a4, code lost:
    
        r30 = 8.0f;
     */
    /* JADX WARN: Code restructure failed: missing block: B:221:0x05a6, code lost:
    
        r39.runAndWrite();
        r12.close();
        r2 = r12.getLength();
     */
    /* JADX WARN: Code restructure failed: missing block: B:222:0x05b0, code lost:
    
        if (r11 > 0) goto L432;
     */
    /* JADX WARN: Code restructure failed: missing block: B:223:0x05b2, code lost:
    
        if (r23 != false) goto L432;
     */
    /* JADX WARN: Code restructure failed: missing block: B:224:0x05b4, code lost:
    
        if (r22 == false) goto L226;
     */
    /* JADX WARN: Code restructure failed: missing block: B:226:0x05b7, code lost:
    
        r19 = r0;
     */
    /* JADX WARN: Code restructure failed: missing block: B:227:0x05b9, code lost:
    
        r24 = r2;
     */
    /* JADX WARN: Code restructure failed: missing block: B:228:0x05bc, code lost:
    
        r19 = r0;
        r2 = r2 + new jj2000.j2k.util.CodestreamManipulator(r19, r7, r11, r22, r23, r24, r25).doCodestreamManipulation();
     */
    /* JADX WARN: Code restructure failed: missing block: B:229:0x05cc, code lost:
    
        if (r11 <= 0) goto L231;
     */
    /* JADX WARN: Code restructure failed: missing block: B:230:0x05ce, code lost:
    
        jj2000.j2k.util.FacilityManager.getMsgLogger().println("Created tile-parts containing at most " + r11 + " packets per tile.", 4, 6);
     */
    /* JADX WARN: Code restructure failed: missing block: B:231:0x05ec, code lost:
    
        if (r23 == false) goto L233;
     */
    /* JADX WARN: Code restructure failed: missing block: B:232:0x05ee, code lost:
    
        jj2000.j2k.util.FacilityManager.getMsgLogger().println("Moved packet headers to tile headers", 4, 6);
     */
    /* JADX WARN: Code restructure failed: missing block: B:233:0x05f8, code lost:
    
        if (r22 == false) goto L227;
     */
    /* JADX WARN: Code restructure failed: missing block: B:234:0x05fa, code lost:
    
        jj2000.j2k.util.FacilityManager.getMsgLogger().println("Moved packet headers to main header", 4, 6);
     */
    /* JADX WARN: Code restructure failed: missing block: B:236:0x0605, code lost:
    
        if (r27 == false) goto L244;
     */
    /* JADX WARN: Code restructure failed: missing block: B:237:0x0607, code lost:
    
        r0 = r33.getNumComps();
        r2 = new int[r0];
        r7 = 0;
     */
    /* JADX WARN: Code restructure failed: missing block: B:238:0x060e, code lost:
    
        if (r7 >= r0) goto L473;
     */
    /* JADX WARN: Code restructure failed: missing block: B:239:0x0610, code lost:
    
        r2[r7] = r33.getNomRangeBits(r7);
        r7 = r7 + 1;
     */
    /* JADX WARN: Code restructure failed: missing block: B:241:0x062e, code lost:
    
        r24 = r24 + new jj2000.j2k.fileformat.writer.FileFormatWriter(r19, r33.getImgHeight(), r33.getImgWidth(), r0, r2, r24).writeFileFormat();
     */
    /* JADX WARN: Code restructure failed: missing block: B:243:0x0638, code lost:
    
        throw new java.lang.Error("Error while writing JP2 file format");
     */
    /* JADX WARN: Code restructure failed: missing block: B:244:0x0639, code lost:
    
        r0 = r24;
     */
    /* JADX WARN: Code restructure failed: missing block: B:245:0x063b, code lost:
    
        if (r10 == false) goto L253;
     */
    /* JADX WARN: Code restructure failed: missing block: B:246:0x063d, code lost:
    
        jj2000.j2k.util.FacilityManager.getMsgLogger().println("Achieved bitrate = " + ((r0 * r30) / (r33.getImgWidth() * r33.getImgHeight())) + " bpp (i.e. " + r0 + " bytes)", 4, 6);
     */
    /* JADX WARN: Code restructure failed: missing block: B:247:0x067a, code lost:
    
        if (r46.pl.getParameter("Rroi") == null) goto L252;
     */
    /* JADX WARN: Code restructure failed: missing block: B:248:0x067c, code lost:
    
        if (r27 != false) goto L252;
     */
    /* JADX WARN: Code restructure failed: missing block: B:250:0x0686, code lost:
    
        if (r46.pl.getIntParameter(r31) != 0) goto L252;
     */
    /* JADX WARN: Code restructure failed: missing block: B:251:0x0688, code lost:
    
        r0 = r12.getOffLastROIPkt();
        jj2000.j2k.util.FacilityManager.getMsgLogger().printmsg(1, "The Region Of Interest is encoded in the first " + r0 + " bytes of the codestream (i.e " + ((r0 * r30) / (r33.getImgWidth() * r33.getImgHeight())) + " bpp)");
     */
    /* JADX WARN: Code restructure failed: missing block: B:252:0x06c1, code lost:
    
        jj2000.j2k.util.FacilityManager.getMsgLogger().flush();
     */
    /* JADX WARN: Code restructure failed: missing block: B:253:0x06c8, code lost:
    
        r0 = 0;
     */
    /* JADX WARN: Code restructure failed: missing block: B:254:0x06c9, code lost:
    
        if (r0 >= r3) goto L472;
     */
    /* JADX WARN: Code restructure failed: missing block: B:255:0x06cb, code lost:
    
        r8[r0].close();
        r0 = r0 + 1;
     */
    /* JADX WARN: Code restructure failed: missing block: B:256:0x06d3, code lost:
    
        r0 = move-exception;
     */
    /* JADX WARN: Code restructure failed: missing block: B:257:0x06d4, code lost:
    
        r2 = new java.lang.StringBuilder();
        r2.append("Error while creating tileparts or packed packet headers");
     */
    /* JADX WARN: Code restructure failed: missing block: B:258:0x06e2, code lost:
    
        if (r0.getMessage() != null) goto L259;
     */
    /* JADX WARN: Code restructure failed: missing block: B:259:0x06e4, code lost:
    
        r28 = ":\n" + r0.getMessage();
     */
    /* JADX WARN: Code restructure failed: missing block: B:260:0x06f7, code lost:
    
        r2.append(r28);
        error(r2.toString(), 2);
     */
    /* JADX WARN: Code restructure failed: missing block: B:263:0x0710, code lost:
    
        if (r46.pl.getParameter("debug").equals(kotlinx.coroutines.DebugKt.DEBUG_PROPERTY_VALUE_ON) != false) goto L264;
     */
    /* JADX WARN: Code restructure failed: missing block: B:264:0x0712, code lost:
    
        r0.printStackTrace();
     */
    /* JADX WARN: Code restructure failed: missing block: B:265:0x0717, code lost:
    
        error("Use '-debug' option for more details", 2);
     */
    /* JADX WARN: Code restructure failed: missing block: B:266:0x071d, code lost:
    
        r0 = move-exception;
     */
    /* JADX WARN: Code restructure failed: missing block: B:267:0x071e, code lost:
    
        r2 = new java.lang.StringBuilder();
        r2.append("Could not instantiate rate allocator");
     */
    /* JADX WARN: Code restructure failed: missing block: B:268:0x072e, code lost:
    
        if (r0.getMessage() != null) goto L269;
     */
    /* JADX WARN: Code restructure failed: missing block: B:269:0x0730, code lost:
    
        r28 = ":\n" + r0.getMessage();
     */
    /* JADX WARN: Code restructure failed: missing block: B:270:0x0743, code lost:
    
        r2.append(r28);
        error(r2.toString(), 2);
     */
    /* JADX WARN: Code restructure failed: missing block: B:271:0x075a, code lost:
    
        if (r46.pl.getParameter("debug").equals(kotlinx.coroutines.DebugKt.DEBUG_PROPERTY_VALUE_ON) != false) goto L272;
     */
    /* JADX WARN: Code restructure failed: missing block: B:272:0x075c, code lost:
    
        r0.printStackTrace();
     */
    /* JADX WARN: Code restructure failed: missing block: B:273:0x0761, code lost:
    
        error("Use '-debug' option for more details", 2);
     */
    /* JADX WARN: Code restructure failed: missing block: B:274:0x0767, code lost:
    
        r0 = move-exception;
     */
    /* JADX WARN: Code restructure failed: missing block: B:275:0x0768, code lost:
    
        r2 = new java.lang.StringBuilder();
        r2.append("Could not open output file");
     */
    /* JADX WARN: Code restructure failed: missing block: B:276:0x0778, code lost:
    
        if (r0.getMessage() != null) goto L277;
     */
    /* JADX WARN: Code restructure failed: missing block: B:277:0x077a, code lost:
    
        r28 = ":\n" + r0.getMessage();
     */
    /* JADX WARN: Code restructure failed: missing block: B:278:0x078d, code lost:
    
        r2.append(r28);
        error(r2.toString(), 2);
     */
    /* JADX WARN: Code restructure failed: missing block: B:279:0x07a4, code lost:
    
        if (r46.pl.getParameter("debug").equals(kotlinx.coroutines.DebugKt.DEBUG_PROPERTY_VALUE_ON) != false) goto L280;
     */
    /* JADX WARN: Code restructure failed: missing block: B:280:0x07a6, code lost:
    
        r0.printStackTrace();
     */
    /* JADX WARN: Code restructure failed: missing block: B:281:0x07ab, code lost:
    
        error("Use '-debug' option for more details", 2);
     */
    /* JADX WARN: Code restructure failed: missing block: B:282:0x07b1, code lost:
    
        r0 = move-exception;
     */
    /* JADX WARN: Code restructure failed: missing block: B:283:0x07b2, code lost:
    
        r2 = new java.lang.StringBuilder();
        r2.append("Could not instantiate entropy coder");
     */
    /* JADX WARN: Code restructure failed: missing block: B:284:0x07c2, code lost:
    
        if (r0.getMessage() != null) goto L285;
     */
    /* JADX WARN: Code restructure failed: missing block: B:285:0x07c4, code lost:
    
        r28 = ":\n" + r0.getMessage();
     */
    /* JADX WARN: Code restructure failed: missing block: B:286:0x07d7, code lost:
    
        r2.append(r28);
        error(r2.toString(), 2);
     */
    /* JADX WARN: Code restructure failed: missing block: B:287:0x07ee, code lost:
    
        if (r46.pl.getParameter("debug").equals(kotlinx.coroutines.DebugKt.DEBUG_PROPERTY_VALUE_ON) != false) goto L288;
     */
    /* JADX WARN: Code restructure failed: missing block: B:288:0x07f0, code lost:
    
        r0.printStackTrace();
     */
    /* JADX WARN: Code restructure failed: missing block: B:289:0x07f5, code lost:
    
        error("Use '-debug' option for more details", 2);
     */
    /* JADX WARN: Code restructure failed: missing block: B:290:0x07fb, code lost:
    
        r0 = move-exception;
     */
    /* JADX WARN: Code restructure failed: missing block: B:291:0x07fc, code lost:
    
        r2 = new java.lang.StringBuilder();
        r2.append("Could not instantiate ROI scaler");
     */
    /* JADX WARN: Code restructure failed: missing block: B:292:0x080c, code lost:
    
        if (r0.getMessage() != null) goto L293;
     */
    /* JADX WARN: Code restructure failed: missing block: B:293:0x080e, code lost:
    
        r28 = ":\n" + r0.getMessage();
     */
    /* JADX WARN: Code restructure failed: missing block: B:294:0x0821, code lost:
    
        r2.append(r28);
        error(r2.toString(), 2);
     */
    /* JADX WARN: Code restructure failed: missing block: B:295:0x0838, code lost:
    
        if (r46.pl.getParameter("debug").equals(kotlinx.coroutines.DebugKt.DEBUG_PROPERTY_VALUE_ON) != false) goto L296;
     */
    /* JADX WARN: Code restructure failed: missing block: B:296:0x083a, code lost:
    
        r0.printStackTrace();
     */
    /* JADX WARN: Code restructure failed: missing block: B:297:0x083f, code lost:
    
        error("Use '-debug' option for more details", 2);
     */
    /* JADX WARN: Code restructure failed: missing block: B:298:0x0845, code lost:
    
        r0 = move-exception;
     */
    /* JADX WARN: Code restructure failed: missing block: B:299:0x0846, code lost:
    
        r2 = new java.lang.StringBuilder();
        r2.append("Could not instantiate quantizer");
     */
    /* JADX WARN: Code restructure failed: missing block: B:300:0x0856, code lost:
    
        if (r0.getMessage() != null) goto L301;
     */
    /* JADX WARN: Code restructure failed: missing block: B:301:0x0858, code lost:
    
        r28 = ":\n" + r0.getMessage();
     */
    /* JADX WARN: Code restructure failed: missing block: B:302:0x086b, code lost:
    
        r2.append(r28);
        error(r2.toString(), 2);
     */
    /* JADX WARN: Code restructure failed: missing block: B:303:0x0882, code lost:
    
        if (r46.pl.getParameter("debug").equals(kotlinx.coroutines.DebugKt.DEBUG_PROPERTY_VALUE_ON) != false) goto L304;
     */
    /* JADX WARN: Code restructure failed: missing block: B:304:0x0884, code lost:
    
        r0.printStackTrace();
     */
    /* JADX WARN: Code restructure failed: missing block: B:305:0x0889, code lost:
    
        error("Use '-debug' option for more details", 2);
     */
    /* JADX WARN: Code restructure failed: missing block: B:306:0x088f, code lost:
    
        r0 = move-exception;
     */
    /* JADX WARN: Code restructure failed: missing block: B:307:0x0890, code lost:
    
        r2 = new java.lang.StringBuilder();
        r2.append("Could not instantiate wavelet transform");
     */
    /* JADX WARN: Code restructure failed: missing block: B:308:0x08a0, code lost:
    
        if (r0.getMessage() != null) goto L309;
     */
    /* JADX WARN: Code restructure failed: missing block: B:309:0x08a2, code lost:
    
        r28 = ":\n" + r0.getMessage();
     */
    /* JADX WARN: Code restructure failed: missing block: B:310:0x08b5, code lost:
    
        r2.append(r28);
        error(r2.toString(), 2);
     */
    /* JADX WARN: Code restructure failed: missing block: B:311:0x08cc, code lost:
    
        if (r46.pl.getParameter("debug").equals(kotlinx.coroutines.DebugKt.DEBUG_PROPERTY_VALUE_ON) != false) goto L312;
     */
    /* JADX WARN: Code restructure failed: missing block: B:312:0x08ce, code lost:
    
        r0.printStackTrace();
     */
    /* JADX WARN: Code restructure failed: missing block: B:313:0x08d3, code lost:
    
        error("Use '-debug' option for more details", 2);
     */
    /* JADX WARN: Code restructure failed: missing block: B:314:0x08d9, code lost:
    
        r0 = move-exception;
     */
    /* JADX WARN: Code restructure failed: missing block: B:315:0x08da, code lost:
    
        r2 = new java.lang.StringBuilder();
        r2.append("Could not instantiate forward component transformation");
     */
    /* JADX WARN: Code restructure failed: missing block: B:316:0x08ea, code lost:
    
        if (r0.getMessage() != null) goto L317;
     */
    /* JADX WARN: Code restructure failed: missing block: B:317:0x08ec, code lost:
    
        r28 = ":\n" + r0.getMessage();
     */
    /* JADX WARN: Code restructure failed: missing block: B:318:0x08ff, code lost:
    
        r2.append(r28);
        error(r2.toString(), 2);
     */
    /* JADX WARN: Code restructure failed: missing block: B:319:0x0916, code lost:
    
        if (r46.pl.getParameter("debug").equals(kotlinx.coroutines.DebugKt.DEBUG_PROPERTY_VALUE_ON) != false) goto L320;
     */
    /* JADX WARN: Code restructure failed: missing block: B:320:0x0918, code lost:
    
        r0.printStackTrace();
     */
    /* JADX WARN: Code restructure failed: missing block: B:321:0x091d, code lost:
    
        error("Use '-debug' option for more details", 2);
     */
    /* JADX WARN: Code restructure failed: missing block: B:322:0x0923, code lost:
    
        r0 = move-exception;
     */
    /* JADX WARN: Code restructure failed: missing block: B:323:0x0924, code lost:
    
        r2 = new java.lang.StringBuilder();
        r2.append("Could not tile image");
     */
    /* JADX WARN: Code restructure failed: missing block: B:324:0x0934, code lost:
    
        if (r0.getMessage() != null) goto L325;
     */
    /* JADX WARN: Code restructure failed: missing block: B:325:0x0936, code lost:
    
        r28 = ":\n" + r0.getMessage();
     */
    /* JADX WARN: Code restructure failed: missing block: B:326:0x0949, code lost:
    
        r2.append(r28);
        error(r2.toString(), 2);
     */
    /* JADX WARN: Code restructure failed: missing block: B:327:0x0960, code lost:
    
        if (r46.pl.getParameter("debug").equals(kotlinx.coroutines.DebugKt.DEBUG_PROPERTY_VALUE_ON) != false) goto L328;
     */
    /* JADX WARN: Code restructure failed: missing block: B:328:0x0962, code lost:
    
        r0.printStackTrace();
     */
    /* JADX WARN: Code restructure failed: missing block: B:329:0x0967, code lost:
    
        error("Use '-debug' option for more details", 2);
     */
    /* JADX WARN: Code restructure failed: missing block: B:331:0x0976, code lost:
    
        throw new java.lang.IllegalArgumentException("Invalid value in 'tref' option ");
     */
    /* JADX WARN: Code restructure failed: missing block: B:333:0x0980, code lost:
    
        throw new java.lang.IllegalArgumentException("Invalid number type in 'tref' option");
     */
    /* JADX WARN: Code restructure failed: missing block: B:335:0x098a, code lost:
    
        throw new java.lang.IllegalArgumentException("Error while parsing 'tref' option");
     */
    /* JADX WARN: Code restructure failed: missing block: B:336:0x098b, code lost:
    
        r0 = th;
     */
    /* JADX WARN: Code restructure failed: missing block: B:337:0x098c, code lost:
    
        r12 = kotlinx.coroutines.DebugKt.DEBUG_PROPERTY_VALUE_ON;
     */
    /* JADX WARN: Code restructure failed: missing block: B:338:0x0990, code lost:
    
        r0 = e;
     */
    /* JADX WARN: Code restructure failed: missing block: B:339:0x0991, code lost:
    
        r12 = kotlinx.coroutines.DebugKt.DEBUG_PROPERTY_VALUE_ON;
     */
    /* JADX WARN: Code restructure failed: missing block: B:340:0x0995, code lost:
    
        r0 = e;
     */
    /* JADX WARN: Code restructure failed: missing block: B:341:0x0996, code lost:
    
        r12 = kotlinx.coroutines.DebugKt.DEBUG_PROPERTY_VALUE_ON;
     */
    /* JADX WARN: Code restructure failed: missing block: B:342:0x099a, code lost:
    
        r0 = e;
     */
    /* JADX WARN: Code restructure failed: missing block: B:343:0x099b, code lost:
    
        r12 = kotlinx.coroutines.DebugKt.DEBUG_PROPERTY_VALUE_ON;
     */
    /* JADX WARN: Code restructure failed: missing block: B:345:0x09a6, code lost:
    
        throw new java.lang.IllegalArgumentException("Invalid value in 'ref' option ");
     */
    /* JADX WARN: Code restructure failed: missing block: B:347:0x09ae, code lost:
    
        throw new java.lang.IllegalArgumentException("Invalid number type in 'ref' option");
     */
    /* JADX WARN: Code restructure failed: missing block: B:349:0x09b6, code lost:
    
        throw new java.lang.IllegalArgumentException("Error while parsing 'ref' option");
     */
    /* JADX WARN: Code restructure failed: missing block: B:383:0x0a84, code lost:
    
        error("An unchecked exception has occurred: " + r0.getMessage(), 2);
     */
    /* JADX WARN: Code restructure failed: missing block: B:384:0x0aa4, code lost:
    
        if (r46.pl.getParameter("debug").equals(r12) != false) goto L385;
     */
    /* JADX WARN: Code restructure failed: missing block: B:385:0x0aa6, code lost:
    
        r0.printStackTrace();
     */
    /* JADX WARN: Code restructure failed: missing block: B:386:0x0aab, code lost:
    
        error("Use '-debug' option for more details", 2);
     */
    /* JADX WARN: Code restructure failed: missing block: B:389:0x0ab3, code lost:
    
        error("An uncaught runtime exception has occurred: " + r0.getMessage(), 2);
     */
    /* JADX WARN: Code restructure failed: missing block: B:390:0x0ad2, code lost:
    
        if (r46.pl.getParameter("debug").equals(r12) != false) goto L391;
     */
    /* JADX WARN: Code restructure failed: missing block: B:391:0x0ad4, code lost:
    
        r0.printStackTrace();
     */
    /* JADX WARN: Code restructure failed: missing block: B:392:0x0ad8, code lost:
    
        error("Use '-debug' option for more details", 2);
     */
    /* JADX WARN: Code restructure failed: missing block: B:395:0x0adf, code lost:
    
        error("An uncaught error has occurred: " + r0.getMessage(), 2);
     */
    /* JADX WARN: Code restructure failed: missing block: B:396:0x0afe, code lost:
    
        if (r46.pl.getParameter("debug").equals(r12) != false) goto L397;
     */
    /* JADX WARN: Code restructure failed: missing block: B:397:0x0b00, code lost:
    
        r0.printStackTrace();
     */
    /* JADX WARN: Code restructure failed: missing block: B:398:0x0b04, code lost:
    
        error("Use '-debug' option for more details", 2);
     */
    /* JADX WARN: Code restructure failed: missing block: B:401:0x0b0b, code lost:
    
        error(r0.getMessage(), 2);
     */
    /* JADX WARN: Code restructure failed: missing block: B:402:0x0b1c, code lost:
    
        if (r46.pl.getParameter("debug").equals(r12) != false) goto L403;
     */
    /* JADX WARN: Code restructure failed: missing block: B:403:0x0b1e, code lost:
    
        r0.printStackTrace();
     */
    /* JADX WARN: Code restructure failed: missing block: B:404:0x0b21, code lost:
    
        return;
     */
    /* JADX WARN: Code restructure failed: missing block: B:478:?, code lost:
    
        return;
     */
    /* JADX WARN: Code restructure failed: missing block: B:479:?, code lost:
    
        return;
     */
    /* JADX WARN: Code restructure failed: missing block: B:480:?, code lost:
    
        return;
     */
    /* JADX WARN: Code restructure failed: missing block: B:481:?, code lost:
    
        return;
     */
    /* JADX WARN: Code restructure failed: missing block: B:482:?, code lost:
    
        return;
     */
    /* JADX WARN: Code restructure failed: missing block: B:483:?, code lost:
    
        return;
     */
    /* JADX WARN: Code restructure failed: missing block: B:484:?, code lost:
    
        return;
     */
    /* JADX WARN: Code restructure failed: missing block: B:485:?, code lost:
    
        return;
     */
    /* JADX WARN: Code restructure failed: missing block: B:486:?, code lost:
    
        return;
     */
    /* JADX WARN: Code restructure failed: missing block: B:487:?, code lost:
    
        return;
     */
    /* JADX WARN: Code restructure failed: missing block: B:488:?, code lost:
    
        return;
     */
    /* JADX WARN: Code restructure failed: missing block: B:489:?, code lost:
    
        return;
     */
    /* JADX WARN: Code restructure failed: missing block: B:490:?, code lost:
    
        return;
     */
    /* JADX WARN: Code restructure failed: missing block: B:491:?, code lost:
    
        return;
     */
    /* JADX WARN: Code restructure failed: missing block: B:492:?, code lost:
    
        return;
     */
    /* JADX WARN: Code restructure failed: missing block: B:493:?, code lost:
    
        return;
     */
    /* JADX WARN: Code restructure failed: missing block: B:494:?, code lost:
    
        return;
     */
    /* JADX WARN: Code restructure failed: missing block: B:495:?, code lost:
    
        return;
     */
    /* JADX WARN: Code restructure failed: missing block: B:496:?, code lost:
    
        return;
     */
    /* JADX WARN: Code restructure failed: missing block: B:504:?, code lost:
    
        return;
     */
    /* JADX WARN: Code restructure failed: missing block: B:505:?, code lost:
    
        return;
     */
    /* JADX WARN: Code restructure failed: missing block: B:506:?, code lost:
    
        return;
     */
    /* JADX WARN: Code restructure failed: missing block: B:507:?, code lost:
    
        return;
     */
    /* JADX WARN: Code restructure failed: missing block: B:508:?, code lost:
    
        return;
     */
    /* JADX WARN: Code restructure failed: missing block: B:509:?, code lost:
    
        return;
     */
    /* JADX WARN: Code restructure failed: missing block: B:510:?, code lost:
    
        return;
     */
    /* JADX WARN: Code restructure failed: missing block: B:511:?, code lost:
    
        return;
     */
    /* JADX WARN: Code restructure failed: missing block: B:516:?, code lost:
    
        return;
     */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:102:0x0222  */
    /* JADX WARN: Removed duplicated region for block: B:138:0x02d9 A[Catch: all -> 0x0a16, RuntimeException -> 0x0a1a, Error -> 0x0a1f, IllegalArgumentException -> 0x0a24, LOOP:1: B:138:0x02d9->B:457:0x02d9, LOOP_START, TRY_LEAVE, TryCatch #28 {Error -> 0x0a1f, IllegalArgumentException -> 0x0a24, RuntimeException -> 0x0a1a, all -> 0x0a16, blocks: (B:3:0x0017, B:5:0x0021, B:6:0x0024, B:8:0x0032, B:10:0x0036, B:11:0x003e, B:13:0x0046, B:15:0x004c, B:17:0x0054, B:19:0x005a, B:22:0x0070, B:24:0x0078, B:26:0x0088, B:31:0x0094, B:33:0x009b, B:36:0x00b5, B:38:0x00bd, B:40:0x00c7, B:41:0x00e2, B:43:0x00ea, B:45:0x00f1, B:48:0x0107, B:50:0x0113, B:52:0x011d, B:54:0x0129, B:58:0x013c, B:60:0x014c, B:62:0x0158, B:63:0x015f, B:65:0x016b, B:70:0x017b, B:71:0x0181, B:73:0x018b, B:75:0x0193, B:78:0x01a4, B:79:0x01ab, B:80:0x01ac, B:82:0x01b4, B:84:0x01bb, B:88:0x01ca, B:90:0x01d2, B:92:0x01de, B:93:0x01e5, B:95:0x01f1, B:98:0x01ff, B:103:0x0224, B:108:0x0236, B:110:0x023a, B:112:0x0240, B:136:0x02d5, B:138:0x02d9, B:140:0x02df, B:127:0x029b, B:129:0x029f, B:131:0x02a5, B:159:0x0371, B:161:0x0375, B:163:0x037b, B:165:0x0396, B:153:0x034c, B:155:0x0350, B:157:0x0356, B:166:0x0397, B:171:0x03af, B:173:0x03b4, B:174:0x03c6, B:178:0x03e4, B:180:0x0402, B:175:0x03ce, B:177:0x03d7), top: B:448:0x0017 }] */
    /* JADX WARN: Removed duplicated region for block: B:452:0x0397 A[EDGE_INSN: B:452:0x0397->B:166:0x0397 BREAK  A[LOOP:0: B:100:0x021c->B:142:0x02fa], SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:455:0x02fa A[SYNTHETIC] */
    /* JADX WARN: Type inference failed for: r12v0 */
    /* JADX WARN: Type inference failed for: r12v1, types: [java.lang.Object] */
    /* JADX WARN: Type inference failed for: r12v2, types: [java.lang.Object] */
    /* JADX WARN: Type inference failed for: r12v27 */
    /* JADX WARN: Type inference failed for: r12v28 */
    /* JADX WARN: Type inference failed for: r12v29 */
    /* JADX WARN: Type inference failed for: r12v3, types: [java.lang.Object] */
    /* JADX WARN: Type inference failed for: r12v30 */
    /* JADX WARN: Type inference failed for: r12v4, types: [java.lang.Object] */
    /* JADX WARN: Type inference failed for: r12v5 */
    /* JADX WARN: Type inference failed for: r12v6 */
    /* JADX WARN: Type inference failed for: r12v7 */
    /* JADX WARN: Type inference failed for: r12v8 */
    /* JADX WARN: Type inference failed for: r12v80 */
    /* JADX WARN: Type inference failed for: r12v81 */
    /* JADX WARN: Type inference failed for: r12v82 */
    /* JADX WARN: Type inference failed for: r15v3, types: [jj2000.j2k.image.input.ImgReader] */
    /* JADX WARN: Type inference failed for: r2v133, types: [jj2000.j2k.image.input.ImgReader] */
    /* JADX WARN: Type inference failed for: r2v14, types: [java.lang.String] */
    /* JADX WARN: Type inference failed for: r2v146, types: [jj2000.j2k.image.ImgDataJoiner] */
    /* JADX WARN: Type inference failed for: r2v147, types: [jj2000.j2k.image.input.ImgReader] */
    /* JADX WARN: Type inference failed for: r2v18, types: [java.lang.String] */
    /* JADX WARN: Type inference failed for: r2v4, types: [java.lang.String] */
    /* JADX WARN: Type inference failed for: r2v46, types: [java.util.Vector] */
    /* JADX WARN: Type inference failed for: r2v48 */
    /* JADX WARN: Type inference failed for: r2v49 */
    /* JADX WARN: Type inference failed for: r2v9, types: [java.lang.String] */
    /* JADX WARN: Type inference failed for: r8v4, types: [java.lang.Object[], jj2000.j2k.image.BlkImgDataSrc[], jj2000.j2k.image.input.ImgReader[]] */
    @Override // java.lang.Runnable
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void run() {
        boolean z;
        boolean z2;
        boolean z3;
        boolean z4;
        boolean z5;
        boolean z6;
        boolean z7;
        int iCountTokens;
        int i;
        int i2;
        int i3;
        String strSubstring;
        String strSubstring2;
        String str = "tile_parts";
        ?? r12 = 2;
        ?? r122 = 2;
        ?? r123 = 2;
        ?? r124 = 2;
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
                    if (this.pl.getParameter("i") == null) {
                        error("Mandatory input file is missing (-i option)", 2);
                        return;
                    }
                    if (this.pl.getParameter("o") == null) {
                        error("Mandatory output file is missing (-o option)", 2);
                        return;
                    }
                    String parameter = this.pl.getParameter("o");
                    if (this.pl.getParameter("file_format").equals(DebugKt.DEBUG_PROPERTY_VALUE_ON)) {
                        if (this.pl.getParameter("rate") != null && this.pl.getFloatParameter("rate") != this.defpl.getFloatParameter("rate")) {
                            warning("Specified bit-rate applies only on the codestream but not on the whole file.");
                        }
                        z = true;
                    } else {
                        z = false;
                    }
                    if (z) {
                        if (parameter.lastIndexOf(46) != -1) {
                            strSubstring2 = parameter.substring(parameter.lastIndexOf(46), parameter.length());
                            strSubstring = parameter.substring(0, parameter.lastIndexOf(46));
                        } else {
                            strSubstring = parameter;
                            strSubstring2 = null;
                        }
                        if ((strSubstring2 == null || !strSubstring2.equalsIgnoreCase(".jp2")) && !this.pl.getBooleanParameter("disable_jp2_extension")) {
                            FacilityManager.getMsgLogger().printmsg(1, "JPEG 2000 file names end with .jp2 extension when using the file format of part 1. This extension is automatically added by JJ2000. Use '-disable_jp2_extension' to disable it.");
                            parameter = strSubstring + ".jp2";
                        }
                    }
                    if (this.pl.getParameter("tiles") == null) {
                        error("No tiles option specified", 2);
                        return;
                    }
                    if (this.pl.getParameter("pph_tile").equals(DebugKt.DEBUG_PROPERTY_VALUE_ON)) {
                        if (this.pl.getParameter("Psop").equals(DebugKt.DEBUG_PROPERTY_VALUE_OFF)) {
                            this.pl.put("Psop", DebugKt.DEBUG_PROPERTY_VALUE_ON);
                            z2 = true;
                        } else {
                            z2 = false;
                        }
                        if (this.pl.getParameter("Peph").equals(DebugKt.DEBUG_PROPERTY_VALUE_OFF)) {
                            this.pl.put("Peph", DebugKt.DEBUG_PROPERTY_VALUE_ON);
                            z3 = true;
                        } else {
                            z3 = false;
                        }
                        z4 = true;
                    } else {
                        z2 = false;
                        z3 = false;
                        z4 = false;
                    }
                    boolean z8 = z;
                    if (this.pl.getParameter("pph_main").equals(DebugKt.DEBUG_PROPERTY_VALUE_ON)) {
                        if (this.pl.getParameter("Psop").equals(DebugKt.DEBUG_PROPERTY_VALUE_OFF)) {
                            this.pl.put("Psop", DebugKt.DEBUG_PROPERTY_VALUE_ON);
                            z2 = true;
                        }
                        if (this.pl.getParameter("Peph").equals(DebugKt.DEBUG_PROPERTY_VALUE_OFF)) {
                            this.pl.put("Peph", DebugKt.DEBUG_PROPERTY_VALUE_ON);
                            z3 = true;
                        }
                        z5 = true;
                    } else {
                        z5 = false;
                    }
                    if (z4 && z5) {
                        error("Can't have packed packet headers in both main and tile headers", 2);
                    }
                    if (this.pl.getBooleanParameter("lossless") && this.pl.getParameter("rate") != null && this.pl.getFloatParameter("rate") != this.defpl.getFloatParameter("rate")) {
                        throw new IllegalArgumentException("Cannot use '-rate' and '-lossless' option at  the same time.");
                    }
                    if (this.pl.getParameter("rate") == null) {
                        error("Target bitrate not specified", 2);
                        return;
                    }
                    try {
                        float floatParameter = this.pl.getFloatParameter("rate");
                        if (floatParameter == -1.0f) {
                            floatParameter = Float.MAX_VALUE;
                        }
                        try {
                            int intParameter = this.pl.getIntParameter("tile_parts");
                            if (intParameter != 0) {
                                if (this.pl.getParameter("Psop").equals(DebugKt.DEBUG_PROPERTY_VALUE_OFF)) {
                                    this.pl.put("Psop", DebugKt.DEBUG_PROPERTY_VALUE_ON);
                                    z2 = true;
                                }
                                if (this.pl.getParameter("Peph").equals(DebugKt.DEBUG_PROPERTY_VALUE_OFF)) {
                                    this.pl.put("Peph", DebugKt.DEBUG_PROPERTY_VALUE_ON);
                                    z6 = z2;
                                    z7 = true;
                                }
                                StringTokenizer stringTokenizer = new StringTokenizer(this.pl.getParameter("i"), ",");
                                ?? vector = new Vector();
                                iCountTokens = stringTokenizer.countTokens();
                                i = 0;
                                int i4 = 0;
                                boolean z9 = false;
                                while (true) {
                                    String str2 = "";
                                    if (i < iCountTokens) {
                                        break;
                                    }
                                    i2 = i;
                                    String strNextToken = stringTokenizer.nextToken();
                                    i3 = iCountTokens;
                                    try {
                                        try {
                                            if (vector.size() < i4) {
                                                error("With PPM input format only 1 input file can be specified", 2);
                                                if (this.exitCode != 0) {
                                                    while (vector.size() > 0) {
                                                        try {
                                                            ((ImgReader) vector.elementAt(vector.size() - 1)).close();
                                                            vector.removeElementAt(vector.size() - 1);
                                                        } catch (Exception unused) {
                                                        }
                                                    }
                                                    return;
                                                }
                                                return;
                                            }
                                            boolean z10 = z9;
                                            String str3 = str;
                                            String strSubstring3 = strNextToken.lastIndexOf(46) != -1 ? strNextToken.substring(strNextToken.lastIndexOf(46), strNextToken.length()) : null;
                                            if (".PGM".equalsIgnoreCase(strSubstring3)) {
                                                vector.addElement(new ImgReaderPGM(strNextToken));
                                            } else if (!".PPM".equalsIgnoreCase(strSubstring3)) {
                                                vector.addElement(new ImgReaderPGX(strNextToken));
                                            } else {
                                                if (i4 > 0) {
                                                    error("With PPM input format only 1 input file can be specified", 2);
                                                    if (this.exitCode != 0) {
                                                        while (vector.size() > 0) {
                                                            try {
                                                                ((ImgReader) vector.elementAt(vector.size() - 1)).close();
                                                                vector.removeElementAt(vector.size() - 1);
                                                            } catch (Exception unused2) {
                                                            }
                                                        }
                                                        return;
                                                    }
                                                    return;
                                                }
                                                vector.addElement(new ImgReaderPPM(strNextToken));
                                                i4 += 3;
                                                z9 = true;
                                                if (this.exitCode == 0) {
                                                    while (vector.size() > 0) {
                                                        try {
                                                            ((ImgReader) vector.elementAt(vector.size() - 1)).close();
                                                            vector.removeElementAt(vector.size() - 1);
                                                        } catch (Exception unused3) {
                                                        }
                                                    }
                                                }
                                                i = i2 + 1;
                                                iCountTokens = i3;
                                                str = str3;
                                            }
                                            i4++;
                                            z9 = z10;
                                            if (this.exitCode == 0) {
                                            }
                                            i = i2 + 1;
                                            iCountTokens = i3;
                                            str = str3;
                                        } catch (IOException e) {
                                            StringBuilder sb = new StringBuilder();
                                            sb.append("Could not open or read from file ");
                                            sb.append(strNextToken);
                                            if (e.getMessage() != null) {
                                                str2 = ":\n" + e.getMessage();
                                            }
                                            sb.append(str2);
                                            error(sb.toString(), 3);
                                            if (this.pl.getParameter("debug").equals(DebugKt.DEBUG_PROPERTY_VALUE_ON)) {
                                                e.printStackTrace();
                                            } else {
                                                error("Use '-debug' option for more details", 2);
                                            }
                                            if (this.exitCode != 0) {
                                                while (vector.size() > 0) {
                                                    try {
                                                        ((ImgReader) vector.elementAt(vector.size() - 1)).close();
                                                        vector.removeElementAt(vector.size() - 1);
                                                    } catch (Exception unused4) {
                                                    }
                                                }
                                                return;
                                            }
                                            return;
                                        }
                                    } catch (Throwable th) {
                                        if (this.exitCode != 0) {
                                            while (vector.size() > 0) {
                                                try {
                                                    ((ImgReader) vector.elementAt(vector.size() - 1)).close();
                                                    vector.removeElementAt(vector.size() - 1);
                                                } catch (Exception unused5) {
                                                }
                                            }
                                        }
                                        throw th;
                                    }
                                }
                            }
                            z6 = z2;
                            z7 = z3;
                            StringTokenizer stringTokenizer2 = new StringTokenizer(this.pl.getParameter("i"), ",");
                            ?? vector2 = new Vector();
                            iCountTokens = stringTokenizer2.countTokens();
                            i = 0;
                            int i42 = 0;
                            boolean z92 = false;
                            while (true) {
                                String str22 = "";
                                if (i < iCountTokens) {
                                }
                                i = i2 + 1;
                                iCountTokens = i3;
                                str = str3;
                            }
                        } catch (NumberFormatException e2) {
                            error("Invalid value in 'tile_parts' option: " + this.pl.getParameter("tile_parts"), 2);
                            if (this.pl.getParameter("debug").equals(DebugKt.DEBUG_PROPERTY_VALUE_ON)) {
                                e2.printStackTrace();
                            } else {
                                error("Use '-debug' option for more details", 2);
                            }
                        }
                    } catch (NumberFormatException e3) {
                        error("Invalid value in 'rate' option: " + this.pl.getParameter("rate"), 2);
                        if (this.pl.getParameter("debug").equals(DebugKt.DEBUG_PROPERTY_VALUE_ON)) {
                            e3.printStackTrace();
                        } else {
                            error("Use '-debug' option for more details", 2);
                        }
                    }
                } catch (NumberFormatException e4) {
                    error("An error occurred while parsing the arguments:\n" + e4.getMessage(), 1);
                    if (this.pl.getParameter("debug").equals(DebugKt.DEBUG_PROPERTY_VALUE_ON)) {
                        e4.printStackTrace();
                    } else {
                        error("Use '-debug' option for more details", 2);
                    }
                } catch (StringFormatException e5) {
                    error("An error occurred while parsing the arguments:\n" + e5.getMessage(), 1);
                    if (this.pl.getParameter("debug").equals(DebugKt.DEBUG_PROPERTY_VALUE_ON)) {
                        e5.printStackTrace();
                    } else {
                        error("Use '-debug' option for more details", 2);
                    }
                }
            } catch (Error e6) {
                e = e6;
                r122 = DebugKt.DEBUG_PROPERTY_VALUE_ON;
            } catch (IllegalArgumentException e7) {
                e = e7;
                r123 = DebugKt.DEBUG_PROPERTY_VALUE_ON;
            } catch (RuntimeException e8) {
                e = e8;
                r124 = DebugKt.DEBUG_PROPERTY_VALUE_ON;
            } catch (Throwable th2) {
                th = th2;
                r12 = DebugKt.DEBUG_PROPERTY_VALUE_ON;
            }
        } catch (Error e9) {
            e = e9;
        } catch (IllegalArgumentException e10) {
            e = e10;
        } catch (RuntimeException e11) {
            e = e11;
        } catch (Throwable th3) {
            th = th3;
        }
    }

    public static String[][] getParameterInfo() {
        return pinfo;
    }

    public static String[][] getAllParameters() {
        Vector vector = new Vector();
        String[][] parameterInfo = getParameterInfo();
        if (parameterInfo != null) {
            for (int length = parameterInfo.length - 1; length >= 0; length--) {
                vector.addElement(parameterInfo[length]);
            }
        }
        String[][] parameterInfo2 = ForwCompTransf.getParameterInfo();
        if (parameterInfo2 != null) {
            for (int length2 = parameterInfo2.length - 1; length2 >= 0; length2--) {
                vector.addElement(parameterInfo2[length2]);
            }
        }
        String[][] parameterInfo3 = AnWTFilter.getParameterInfo();
        if (parameterInfo3 != null) {
            for (int length3 = parameterInfo3.length - 1; length3 >= 0; length3--) {
                vector.addElement(parameterInfo3[length3]);
            }
        }
        String[][] parameterInfo4 = ForwardWT.getParameterInfo();
        if (parameterInfo4 != null) {
            for (int length4 = parameterInfo4.length - 1; length4 >= 0; length4--) {
                vector.addElement(parameterInfo4[length4]);
            }
        }
        String[][] parameterInfo5 = Quantizer.getParameterInfo();
        if (parameterInfo5 != null) {
            for (int length5 = parameterInfo5.length - 1; length5 >= 0; length5--) {
                vector.addElement(parameterInfo5[length5]);
            }
        }
        String[][] parameterInfo6 = ROIScaler.getParameterInfo();
        if (parameterInfo6 != null) {
            for (int length6 = parameterInfo6.length - 1; length6 >= 0; length6--) {
                vector.addElement(parameterInfo6[length6]);
            }
        }
        String[][] parameterInfo7 = EntropyCoder.getParameterInfo();
        if (parameterInfo7 != null) {
            for (int length7 = parameterInfo7.length - 1; length7 >= 0; length7--) {
                vector.addElement(parameterInfo7[length7]);
            }
        }
        String[][] parameterInfo8 = HeaderEncoder.getParameterInfo();
        if (parameterInfo8 != null) {
            for (int length8 = parameterInfo8.length - 1; length8 >= 0; length8--) {
                vector.addElement(parameterInfo8[length8]);
            }
        }
        String[][] parameterInfo9 = PostCompRateAllocator.getParameterInfo();
        if (parameterInfo9 != null) {
            for (int length9 = parameterInfo9.length - 1; length9 >= 0; length9--) {
                vector.addElement(parameterInfo9[length9]);
            }
        }
        String[][] parameterInfo10 = PktEncoder.getParameterInfo();
        if (parameterInfo10 != null) {
            for (int length10 = parameterInfo10.length - 1; length10 >= 0; length10--) {
                vector.addElement(parameterInfo10[length10]);
            }
        }
        String[][] strArr = (String[][]) Array.newInstance((Class<?>) String.class, vector.size(), 4);
        if (strArr != null) {
            for (int length11 = strArr.length - 1; length11 >= 0; length11--) {
                strArr[length11] = (String[]) vector.elementAt(length11);
            }
        }
        return strArr;
    }

    private void error(String str, int i) {
        this.exitCode = i;
        FacilityManager.getMsgLogger().printmsg(3, str);
    }

    private void warning(String str) {
        FacilityManager.getMsgLogger().printmsg(2, str);
    }

    private void printVersionAndCopyright() {
        FacilityManager.getMsgLogger().println("JJ2000's JPEG 2000 Encoder\n", 2, 4);
        FacilityManager.getMsgLogger().println("Version: 5.1\n", 2, 4);
        FacilityManager.getMsgLogger().println("Copyright:\n\nThis software module was originally developed by Raphaël Grosbois and Diego Santa Cruz (Swiss Federal Institute of Technology-EPFL); Joel Askelöf (Ericsson Radio Systems AB); and Bertrand Berthelot, David Bouchard, Félix Henry, Gerard Mozelle and Patrice Onno (Canon Research Centre France S.A) in the course of development of the JPEG 2000 standard as specified by ISO/IEC 15444 (JPEG 2000 Standard). This software module is an implementation of a part of the JPEG 2000 Standard. Swiss Federal Institute of Technology-EPFL, Ericsson Radio Systems AB and Canon Research Centre France S.A (collectively JJ2000 Partners) agree not to assert against ISO/IEC and users of the JPEG 2000 Standard (Users) any of their rights under the copyright, not including other intellectual property rights, for this software module with respect to the usage by ISO/IEC and Users of this software module or modifications thereof for use in hardware or software products claiming conformance to the JPEG 2000 Standard. Those intending to use this software module in hardware or software products are advised that their use may infringe existing patents. The original developers of this software module, JJ2000 Partners and ISO/IEC assume no liability for use of this software module or modifications thereof. No license or right to this software module is granted for non JPEG 2000 Standard conforming products. JJ2000 Partners have full right to use this software module for his/her own purpose, assign or donate this software module to any third party and to inhibit third parties from using this software module for non JPEG 2000 Standard conforming products. This copyright notice must be included in all copies or derivative works of this software module.\n\nCopyright (c) 1999/2000 JJ2000 Partners.\n", 2, 4);
        FacilityManager.getMsgLogger().println("Send bug reports to: jj2000-bugs@ltssg3.epfl.ch\n", 2, 4);
    }

    private void printUsage() {
        MsgLogger msgLogger = FacilityManager.getMsgLogger();
        msgLogger.println("Usage:", 0, 0);
        msgLogger.println("JJ2KEncoder args...\n", 10, 12);
        msgLogger.println("The exit code of the encoder is non-zero if an error occurs.\n", 2, 4);
        msgLogger.println("Note: Many encoder modules accept tile-component specific parameters. These parameters must be provided according to the pattern:\n \"[<tile-component idx>] <param>\" (repeated as many time as needed). ", 2, 4);
        msgLogger.println("\n<tile-component idx> respect the following policy according to the degree of priority: \n  (1) t<idx> c<idx> : Tile-component specification.\n  (2) t<idx> : Tile specification.\n  (3) c<idx> : Component specification\n  (4) <void> : Default specification.\n\nWhere the priorities of the specifications are:\n(1) > (2) > (3) > (4), ('>' means \"overrides\")\n", 2, 4);
        msgLogger.println("  <idx>: ',' separates indexes, '-' separates bounds of indexes list. (ex: 0,2-4 means indexes 0,2,3 and  4).\n", 2, 4);
        msgLogger.println("The following arguments are recognized:", 2, 4);
        printParamInfo(msgLogger, getAllParameters());
        FacilityManager.getMsgLogger().println("\n\n", 0, 0);
        FacilityManager.getMsgLogger().println("Send bug reports to: jj2000-bugs@ltssg3.epfl.ch\n", 2, 4);
    }

    private void printParamInfo(MsgLogger msgLogger, String[][] strArr) {
        if (strArr == null) {
            return;
        }
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
}
