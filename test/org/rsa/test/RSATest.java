package org.rsa.test;

import java.math.BigInteger;

import org.film.util.RSAUtil;
import org.junit.Test;

public class RSATest {
	@Test
	public void test() throws Exception {
		String result = "59bfeeb7146a4002c03f8dedb41cccade1a3a21006e838b72afeaa6ff35ede92bb097713bee1f5bb7b88745d3f43c372551982eb504400958f41ce6f84bd251b8faa6063491ea875379489d7157e6bbe14d0c77020b5bf44e5307962891ef7e9afb61985c3e52f89b25af15f4d51d92934c19716f85182388e263333c6d726d7";
		byte[] en_result = new BigInteger(result, 16).toByteArray();
		System.out.println("转成byte[]" + new String(en_result));
		byte[] de_result = RSAUtil.decrypt(RSAUtil.getKeyPair().getPrivate(),
				en_result);
		StringBuilder sb = new StringBuilder(new String(de_result));
		System.out.println(sb.reverse().toString());
	}
}
