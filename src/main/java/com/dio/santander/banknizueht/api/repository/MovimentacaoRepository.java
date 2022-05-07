package com.dio.santander.banknizueht.api.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.dio.santander.banknizueht.api.model.MovimentacaoModel;

public interface MovimentacaoRepository extends JpaRepository<MovimentacaoModel, Integer>{

}
