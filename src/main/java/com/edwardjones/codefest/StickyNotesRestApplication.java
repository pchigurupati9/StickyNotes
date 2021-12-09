package com.edwardjones.codefest;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages = { "com.edwardjones.codefest" })
public class StickyNotesRestApplication {

	public static void main(String[] args) throws Exception {
//		addMongoDBCertificateAuthority();
		SpringApplication.run(StickyNotesRestApplication.class, args);
	}

	// use a newer java version instead
//	// for if this Java doesn't have the CA in the trust store
//	private static void addMongoDBCertificateAuthority() throws Exception {
//		// https://docs.atlas.mongodb.com/reference/faq/security/#tls-change-hard-code
//		String CA_FILE = "isrgrootx1.pem";
//		File file = ResourceUtils.getFile("classpath:" + CA_FILE);
//		FileInputStream fis = new FileInputStream(file);
//		X509Certificate ca = (X509Certificate) CertificateFactory.getInstance("X.509")
//				.generateCertificate(new BufferedInputStream(fis));
//
//		KeyStore ks = KeyStore.getInstance(KeyStore.getDefaultType());
//		ks.load(null, null);
//		ks.setCertificateEntry(Integer.toString(1), ca);
//
//		TrustManagerFactory tmf = TrustManagerFactory.getInstance(TrustManagerFactory.getDefaultAlgorithm());
//		tmf.init(ks);
//
//		SSLContext context = SSLContext.getInstance("TLS");
//		context.init(null, tmf.getTrustManagers(), null);
//	}

}
