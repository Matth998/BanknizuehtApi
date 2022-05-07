package com.dio.santander.banknizueht.api.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.dio.santander.banknizueht.api.dto.NovaMovimentacao;
import com.dio.santander.banknizueht.api.model.MovimentacaoModel;
import com.dio.santander.banknizueht.api.repository.MovimentacaoRepository;
import com.dio.santander.banknizueht.api.service.MovimentacaoService;

@RestController
@RequestMapping("/movimentacoes")
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class MovimentacaoController {

	@Autowired
	private MovimentacaoRepository repository;
	
	@Autowired
	private MovimentacaoService service;
	
	@GetMapping
	public List<MovimentacaoModel> findAll(){
		
		return repository.findAll();
		
	}
	
	@PostMapping
	public void post(@RequestBody NovaMovimentacao movimentacao) {
		
		service.save(movimentacao);
		
	}
	
}
