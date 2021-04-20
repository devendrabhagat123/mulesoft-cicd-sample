package myqr;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Paths;
import java.util.EnumSet;
import java.util.HashMap;
import java.util.Map;
import com.google.zxing.DecodeHintType;
import com.google.zxing.EncodeHintType;
import com.google.zxing.MultiFormatWriter;
import com.google.zxing.WriterException;
import com.google.zxing.client.j2se.MatrixToImageWriter;
import com.google.zxing.common.BitMatrix;
import com.google.zxing.qrcode.decoder.ErrorCorrectionLevel;
import org.springframework.web.util.UriComponentsBuilder;
import com.google.zxing.BarcodeFormat;

public class NewQRCodeMule1 {
	final static Map hintMap = new HashMap<>();
    final String charset = StandardCharsets.UTF_8.name(); // or "ISO-8859-1"
    final static int size = 350;

	 public static  void createQRCode(String qrCodeData, String filePath) throws WriterException, IOException {
	        BitMatrix matrix = new MultiFormatWriter().encode(qrCodeData, BarcodeFormat.QR_CODE, size, size, hintMap);
	        MatrixToImageWriter.writeToPath(matrix, "png", Paths.get(filePath));
	    }
	private static void QRCodeService() {    
	  hintMap.put(EncodeHintType.ERROR_CORRECTION, ErrorCorrectionLevel.L);
      hintMap.put(EncodeHintType.CHARACTER_SET, StandardCharsets.UTF_8);
      hintMap.put(EncodeHintType.MARGIN, 1);
      hintMap.put(DecodeHintType.CHARACTER_SET, StandardCharsets.UTF_8);
      hintMap.put(DecodeHintType.PURE_BARCODE, Boolean.TRUE);
      hintMap.put(DecodeHintType.POSSIBLE_FORMATS, EnumSet.allOf(BarcodeFormat.class));		
	}
	public static  String createUpiQrCode(String payeeAddress, String payeeName, String trxNo, String amount, String purpose, String trxRef, String path) throws  WriterException, IOException {
        final String qrCode = UriComponentsBuilder.fromUriString("upi://pay")
                .queryParam("pa", payeeAddress) 
                .queryParam("pn", payeeName)
                .queryParam("tn", trxNo)
                .queryParam("tr", trxRef)
                .queryParam("am", amount)
                .queryParam("cu", "INR")
                .queryParam("purpose", purpose)
                .build().encode().toUriString();
      //  logger.info("UPI QR Code = " + qrCode);
        QRCodeService();
        createQRCode(qrCode, path);
		return qrCode;	
    }	  
	/*public static void main(String[] args) throws WriterException, IOException {
		// TODO Auto-generated method stub
		System.out.println(createUpiQrCode("9179922334@upi", "DEV BHAGAT", null, null, null, null));
	}*/
}
