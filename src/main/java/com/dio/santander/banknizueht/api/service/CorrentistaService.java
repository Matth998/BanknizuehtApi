package com.dio.santander.banknizueht.api.service;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dio.santander.banknizueht.api.dto.NovoCorrentista;
import com.dio.santander.banknizueht.api.model.ContaModel;
import com.dio.santander.banknizueht.api.model.CorrentistaModel;
import com.dio.santander.banknizueht.api.repository.CorrentistaRepository;

@Service
public class CorrentistaService {

	@Autowired
	private CorrentistaRepository repository;
	
	public void save(NovoCorrentista novoCorrentista) {
		
		CorrentistaModel correntistaModel = new CorrentistaModel();
		correntistaModel.setCpf(novoCorrentista.getCpf());
		correntistaModel.setNome(novoCorrentista.getNome());
	
		ContaModel contaModel = new ContaModel();
		contaModel.setSaldo(0.0);
		contaModel.setNumero(new Date().getTime());
		
		correntistaModel.setConta(contaModel);
		repository.save(correntistaModel);
	}
	
}
