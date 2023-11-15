package com.fatec.leilaoEletronicoLp2.repositorys;


import com.fatec.leilaoEletronicoLp2.models.ClienteDispositivoInformatica;
import com.fatec.leilaoEletronicoLp2.models.Veiculos;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface VeiculosRepository extends JpaRepository <Veiculos, Integer> {

	@Query(value = "SELECT vei.* FROM Veiculos vei WHERE vei.leilao = ?1", nativeQuery = true	)
	List<Veiculos> findVeiculosByLeilao(Integer idLeilao);
}

