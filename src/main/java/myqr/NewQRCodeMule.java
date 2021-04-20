package myqr;

import java.io.IOException;

import org.springframework.web.util.UriComponentsBuilder;

import com.google.zxing.WriterException;


class NewQRCodeMule {
    //private static final Logger logger = LoggerFactory.getLogger(QRCodeService.class);

    public static  String createUpiQrCode(String payeeAddress, String payeeName, String trxNo, String amount, String purpose, String trxRef) throws IOException, WriterException {
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
        GenerateQRCodeURL.QRCodeService();
        GenerateQRCodeURL.createQRCode(qrCode, "D:/UPIs/Dev1.png");
		return qrCode;
	
    }
  
	/*public static void main(String[] args) throws WriterException, IOException {
		// TODO Auto-generated method stub
		createUpiQrCode("9179922334@upi", "DEV BHAGAT", null, null, null, null);

	}*/
}