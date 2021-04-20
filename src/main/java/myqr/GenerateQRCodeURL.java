package myqr;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Paths;
import java.util.EnumSet;
import java.util.*;

import com.google.zxing.*;
import com.google.zxing.DecodeHintType;
import com.google.zxing.EncodeHintType;
import com.google.zxing.MultiFormatWriter;
import com.google.zxing.WriterException;
import com.google.zxing.client.j2se.MatrixToImageWriter;
import com.google.zxing.common.BitMatrix;
import com.google.zxing.qrcode.decoder.ErrorCorrectionLevel;

class GenerateQRCodeURL {
    //private static final Logger logger = LoggerFactory.getLogger(QRCodeService.class);

    private final static Map hintMap = new HashMap<>();
    private final static String charset = StandardCharsets.UTF_8.name(); // or "ISO-8859-1"
    private final static int size = 350;

    public static  void QRCodeService() {
        hintMap.put(EncodeHintType.ERROR_CORRECTION, ErrorCorrectionLevel.L);
        hintMap.put(EncodeHintType.CHARACTER_SET, StandardCharsets.UTF_8);
        hintMap.put(EncodeHintType.MARGIN, 1);

        hintMap.put(DecodeHintType.CHARACTER_SET, StandardCharsets.UTF_8);
        hintMap.put(DecodeHintType.PURE_BARCODE, Boolean.TRUE);
        hintMap.put(DecodeHintType.POSSIBLE_FORMATS, EnumSet.allOf(BarcodeFormat.class));
    }

    public static  void createQRCode(String qrCodeData, String filePath) throws WriterException, IOException {
        BitMatrix matrix = new MultiFormatWriter().encode(qrCodeData, BarcodeFormat.QR_CODE, size, size, hintMap);
        MatrixToImageWriter.writeToPath(matrix, "png", Paths.get(filePath));
    }
    
    
    
}