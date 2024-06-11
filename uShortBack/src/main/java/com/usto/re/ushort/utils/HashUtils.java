package com.usto.re.ushort.utils;

import java.nio.charset.Charset;
import java.util.UUID;

import com.google.common.hash.Hashing;

public class HashUtils {
	
	public static String generateHashMurmur3_128(String origin, String salt){
		String input = origin + salt;
		return Hashing.murmur3_128().hashString(input, Charset.defaultCharset()).toString();
	}

	public static String generateUUID() {
 		return UUID.randomUUID().toString();
	}
}
	