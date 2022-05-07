package com.dio.santander.banknizueht.api.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.dio.santander.banknizueht.api.dto.NovoCorrentista;
import com.dio.santander.banknizueht.api.model.CorrentistaModel;
import com.dio.santander.banknizueht.api.repository.CorrentistaRepository;
import com.dio.santander.banknizueht.api.service.CorrentistaService;

@RestController
@RequestMapping("/correntistas")
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class CorrentistaController {
	
	@Autowired
	private CorrentistaRepository repository;
	
	@Autowired
	private CorrentistaService service;

	@GetMapping
	public List<CorrentistaModel> findAll(){
		
		return repository.findAll();
		
	}
	
	@PostMapping
	public void post(@RequestBody NovoCorrentista novoCorrentista) {
		
		service.save(novoCorrentista);
		
	}
	
}
