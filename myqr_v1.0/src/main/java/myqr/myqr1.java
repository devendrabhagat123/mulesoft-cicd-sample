package myqr;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import com.google.zxing.BarcodeFormat;
import com.google.zxing.EncodeHintType;
import com.google.zxing.MultiFormatWriter;
import com.google.zxing.NotFoundException;
import com.google.zxing.WriterException;
import com.google.zxing.client.j2se.MatrixToImageWriter;
import com.google.zxing.common.BitMatrix;
import com.google.zxing.qrcode.decoder.ErrorCorrectionLevel;

public class myqr1 {
	// Function to create the QR code
	 @SuppressWarnings("deprecation")
	public static String createQR(String data, String path,
	                             String charset,Map hashMap,
	                             int height, int width)
	     throws WriterException, IOException
	 { 
		/* Map<EncodeHintType, ErrorCorrectionLevel> hashMap
         = new HashMap<EncodeHintType,
                       ErrorCorrectionLevel>();

     hashMap.put(EncodeHintType.ERROR_CORRECTION,
                 ErrorCorrectionLevel.L);*/

	     BitMatrix matrix = new MultiFormatWriter().encode(
	         new String(data.getBytes(charset), charset),
	         BarcodeFormat.QR_CODE, width, height);

	     MatrixToImageWriter.writeToFile(
	         matrix,
	         path.substring(path.lastIndexOf('.') + 1),
	         new File(path));
		return (path)  ;
	 }
	 

}
