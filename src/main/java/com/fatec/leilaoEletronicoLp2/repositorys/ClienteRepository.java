package com.fatec.leilaoEletronicoLp2.repositorys;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.fatec.leilaoEletronicoLp2.models.Cliente;

@Repository
public interface ClienteRepository extends JpaRepository<Cliente, Integer>{
	Cliente findBycliCpf(String cpf);
	
	Long deleteBycliCpf(String cpf);
}
