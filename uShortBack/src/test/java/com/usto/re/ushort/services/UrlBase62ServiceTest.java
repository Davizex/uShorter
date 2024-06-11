package com.usto.re.ushort.services;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.when;

import java.time.Instant;
import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.test.util.ReflectionTestUtils;

import com.usto.re.ushort.entities.TinyUrl;
import com.usto.re.ushort.exceptions.CodeCollisionException;
import com.usto.re.ushort.repositories.TinyUrlRepository;

@ExtendWith(MockitoExtension.class)
class UrlBase62ServiceTest {

	@Mock
	private TinyUrlRepository tinyUrlRepository;

	@InjectMocks
	private UrlBase62Service service;

	@Test
	void testGenerateSameAddres() {
		ReflectionTestUtils.setField(service, "encodedLenght", 8);

		var code1 = service.generateCode("https://ustore.com.br/");
		var code2 = service.generateCode("https://ustore.com.br/");

		assertNotEquals(code1, code2);
	}

	@Test
	public void testFindByCode() throws Exception {
		String code = "code";

		TinyUrl tinyUrl = new TinyUrl(code, "https://ustore.com.br/", Instant.now());

		when(tinyUrlRepository.findById(code)).thenReturn(Optional.of(tinyUrl));

		TinyUrl result = service.findByCode(code);
		assertEquals(tinyUrl, result);
	}

	@Test
	public void testNotFindByCode() throws Exception {
		String code = "code";

		when(tinyUrlRepository.findById(code)).thenReturn(Optional.empty());
		assertThrows(RuntimeException.class, () -> service.findByCode(code));
	}
	
	@Test
	public void testAvailabelCode() throws Exception {
		String code = "code";

		when(tinyUrlRepository.findById(code)).thenReturn(Optional.empty());

		assertDoesNotThrow(() -> service.availabelCode(code));
	}

	@Test
	public void testUnavailabelCode() throws Exception {
		String code = "code";
		TinyUrl tinyUrl = new TinyUrl(code, "https://ustore.com.br/", Instant.now());

		when(tinyUrlRepository.findById(code)).thenReturn(Optional.of(tinyUrl));
		assertThrows(CodeCollisionException.class, () -> service.availabelCode(code));
	}
	
}
