package com.usto.re.ushort.utils;

import java.math.BigInteger;

public class Base62 {
	private static final String BASE62 = "0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz";
	private static final BigInteger BASE = BigInteger.valueOf(62);

	// Encode a byte array to a Base62 string
	public static String encode(byte[] input) {
		BigInteger value = new BigInteger(1, input);
		StringBuilder result = new StringBuilder();
		while (value.compareTo(BigInteger.ZERO) > 0) {
			BigInteger[] divMod = value.divideAndRemainder(BASE);
			result.insert(0, BASE62.charAt(divMod[1].intValue()));
			value = divMod[0];
		}
		return result.toString();
	}

	// Decode a Base62 string to a byte array
	public static byte[] decode(String input) {
		BigInteger value = BigInteger.ZERO;
		for (int i = 0; i < input.length(); i++) {
			value = value.multiply(BASE).add(BigInteger.valueOf(BASE62.indexOf(input.charAt(i))));
		}
		return value.toByteArray();
	}

}
