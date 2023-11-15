package com.fatec.leilaoEletronicoLp2.repositorys;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.fatec.leilaoEletronicoLp2.models.DispositivoInformatica;
import com.fatec.leilaoEletronicoLp2.models.Veiculos;

@Repository
public interface DispositivosInformaticaRepository extends JpaRepository<DispositivoInformatica, Integer>{
	
	
	@Query(value = "SELECT di.* FROM Dispositivos_Informatica di WHERE di.leilao = ?1", nativeQuery = true)
	List<DispositivoInformatica> findDiByLeilao(Integer idLeilao);

}
