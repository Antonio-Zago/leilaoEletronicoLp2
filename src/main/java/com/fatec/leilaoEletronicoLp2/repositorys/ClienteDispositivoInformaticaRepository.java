package com.fatec.leilaoEletronicoLp2.repositorys;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.fatec.leilaoEletronicoLp2.models.ClienteDispositivoInformatica;
import com.fatec.leilaoEletronicoLp2.models.DispositivoInformatica;

@Repository
public interface ClienteDispositivoInformaticaRepository extends JpaRepository<ClienteDispositivoInformatica, Integer>{
	
	List<ClienteDispositivoInformatica> findBydispositivoInformatica(DispositivoInformatica dispositivoInformatica);

}
