package com.usto.re.ushort.services;

import java.time.Instant;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import com.usto.re.ushort.entities.AccessCount;
import com.usto.re.ushort.entities.AccessCountKey;
import com.usto.re.ushort.entities.TinyUrl;
import com.usto.re.ushort.exceptions.CodeCollisionException;
import com.usto.re.ushort.interfaces.UrlInterface;
import com.usto.re.ushort.repositories.AccessCountRepository;
import com.usto.re.ushort.repositories.TinyUrlRepository;
import com.usto.re.ushort.utils.Base62;
import com.usto.re.ushort.utils.HashUtils;

@Service
public class UrlBase62Service implements UrlInterface {
	
	private final TinyUrlRepository tinyUrlRepository;
	
	private final AccessCountRepository accessCountRepository;
	
	@Value("${app.encoded-length}")
	public int encodedLenght;
	
	public UrlBase62Service(TinyUrlRepository tinyUrlRepository, AccessCountRepository accessCountRepository) {
		this.tinyUrlRepository = tinyUrlRepository;
		this.accessCountRepository = accessCountRepository;
	}

	@Override
	public TinyUrl createURL(String originalUrl) throws Exception {
		var code = generateCode(originalUrl);
		this.availabelCode(code);
		
		return this.save(new TinyUrl(code, originalUrl, Instant.now()));
	}

	@Override
	public String getURL(String code) throws Exception {
		TinyUrl tinyUrl = this.findByCode(code);
		this.countAccess(code);
		return tinyUrl.getOriginalURL();
	}

	public String generateCode(String originalUrl) {
		String salt = HashUtils.generateUUID();
		String hash = HashUtils.generateHashMurmur3_128(originalUrl, salt);
		String base62Hash = Base62.encode(hash.getBytes());
		
		return base62Hash.substring(0, encodedLenght);
	}
	
	public TinyUrl findByCode(String code) throws Exception {
		Optional<TinyUrl> tinyUrlOp = this.tinyUrlRepository.findById(code);
		
		if(tinyUrlOp.isPresent()) {
			return tinyUrlOp.get();
		}
		
		throw new RuntimeException("não existe esse código");
	}
	
	public void availabelCode(String code) throws Exception{
		Optional<TinyUrl> tinyUrlOp = this.tinyUrlRepository.findById(code);
		if(tinyUrlOp.isPresent()) {
			throw new CodeCollisionException("fail to generate short url code.");
		}
	}
	
	private TinyUrl save(TinyUrl tinyUrl) {
		return tinyUrlRepository.save(tinyUrl);
	}
	
	private void countAccess(String code) {
		AccessCountKey accessCountKey = new AccessCountKey(HashUtils.generateUUID(), Instant.now());
		AccessCount accessCount = new AccessCount(accessCountKey, code);
		this.accessCountRepository.save(accessCount);
	}
}
