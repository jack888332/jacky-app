package demo.security;

import java.security.*;
import java.security.Provider.Service;

// Java Cryptography Architecture (JCA)
public class EncodingCase {
	public static void main(String[] args) {
		try {
			MessageDigest md = MessageDigest.getInstance("SHA-256");
			Provider p6r = md.getProvider();
			System.out.println(p6r.getName());

			for (Provider p6r1 : Security.getProviders()) {
				System.out.println("-----" + p6r1.getName() + "-----");
				for (Service s5e : p6r1.getServices()) {
					System.out.println("=======================");
					System.out.println(s5e.getType());
					System.out.println(s5e.getAlgorithm());
					System.out.println(s5e.getClassName());
				}
			}

		} catch (NoSuchAlgorithmException e) {
			e.printStackTrace();
		}
	}
}
