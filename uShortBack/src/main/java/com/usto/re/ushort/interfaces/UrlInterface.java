package com.usto.re.ushort.interfaces;

import com.usto.re.ushort.entities.TinyUrl;

public interface UrlInterface {

	default public TinyUrl createURL(String originalUrl) throws Exception {
		throw new Exception("needed to be implement");
	}
	
	default public String getURL(String code) throws Exception  {
		throw new Exception("needed to be implement");
	}
}
