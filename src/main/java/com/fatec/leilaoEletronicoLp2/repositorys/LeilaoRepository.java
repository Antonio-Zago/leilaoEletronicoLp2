package com.fatec.leilaoEletronicoLp2.repositorys;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.fatec.leilaoEletronicoLp2.models.Leilao;

import java.util.List;

@Repository
public interface LeilaoRepository extends JpaRepository<Leilao, Integer>{

    List<Leilao> findByLanceInicialBetween(Double valorMinimo, Double valorMaximo);

    List<Leilao> findByValorTotalBetween(Double valorMinimo, Double valorMaximo);

    List<Leilao> findByNomeDoProdutoContendo(String palavraChave);

    List<Leilao> findByTipoDeProduto(String tipoDeProduto);
	
}
