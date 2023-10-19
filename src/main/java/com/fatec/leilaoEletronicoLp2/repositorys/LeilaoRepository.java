package com.fatec.leilaoEletronicoLp2.repositorys;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.fatec.leilaoEletronicoLp2.models.Leilao;

@Repository
public interface LeilaoRepository extends JpaRepository<Leilao, Integer>{
	
}
