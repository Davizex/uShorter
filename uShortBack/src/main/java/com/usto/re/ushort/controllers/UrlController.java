package com.usto.re.ushort.controllers;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.view.RedirectView;

import com.usto.re.ushort.dto.CreateTinyUrl;
import com.usto.re.ushort.dto.TinyUrlDTO;
import com.usto.re.ushort.entities.TinyUrl;
import com.usto.re.ushort.interfaces.UrlInterface;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.ws.rs.core.MediaType;

@RestController
public class UrlController {

	private final UrlInterface service;

	public UrlController(UrlInterface service) {
		this.service = service;
	}

	@PostMapping(path = "/create", consumes = MediaType.APPLICATION_JSON, produces = MediaType.APPLICATION_JSON)
	public ResponseEntity<TinyUrlDTO> create(@RequestBody CreateTinyUrl create, HttpServletRequest request) throws Exception {
		TinyUrl tinyUrl = service.createURL(create.getOriginalURL());
		
		return new ResponseEntity<TinyUrlDTO>(new TinyUrlDTO(tinyUrl), HttpStatus.CREATED);
	}

	@GetMapping("/{code}")
	public RedirectView getUrl(@PathVariable final String code) throws Exception {
		var originalUrl = service.getURL(code);
		RedirectView redirectView = new RedirectView(originalUrl);
		return redirectView;
	}
}
