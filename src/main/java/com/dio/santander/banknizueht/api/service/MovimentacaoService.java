package com.dio.santander.banknizueht.api.service;

import java.time.LocalDateTime;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dio.santander.banknizueht.api.dto.NovaMovimentacao;
import com.dio.santander.banknizueht.api.model.CorrentistaModel;
import com.dio.santander.banknizueht.api.model.MovimentacaoModel;
import com.dio.santander.banknizueht.api.model.MovimentacaoTipo;
import com.dio.santander.banknizueht.api.repository.CorrentistaRepository;
import com.dio.santander.banknizueht.api.repository.MovimentacaoRepository;

@Service
public class MovimentacaoService {

	@Autowired
	private MovimentacaoRepository repository;
	
	@Autowired
	private CorrentistaRepository correntistaRepository;
	
	public void save(NovaMovimentacao novaMovimentacao) {
		
		MovimentacaoModel movimentacaoModel = new MovimentacaoModel();
		Double valor = novaMovimentacao.getTipo()==MovimentacaoTipo.RECEITA ? novaMovimentacao.getValor() : novaMovimentacao.getValor() * -1;
		
		movimentacaoModel.setDataHora(LocalDateTime.now());
		movimentacaoModel.setDescricao(novaMovimentacao.getDescricao());
		movimentacaoModel.setIdConta(novaMovimentacao.getIdConta());
		movimentacaoModel.setTipo(novaMovimentacao.getTipo());
		movimentacaoModel.setValor(valor);
		
		CorrentistaModel correntistaModel = correntistaRepository.findById(novaMovimentacao.getIdConta()).orElse(null);
		if(correntistaModel != null) {
			
			correntistaModel.getConta().setSaldo(correntistaModel.getConta().getSaldo() + valor);
			correntistaRepository.save(correntistaModel);
		}
		
		repository.save(movimentacaoModel);
		
	}
}
