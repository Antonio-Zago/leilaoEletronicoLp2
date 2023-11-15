package com.fatec.leilaoEletronicoLp2.repositorys;

import java.util.List;
import java.util.Optional;

import com.fatec.leilaoEletronicoLp2.models.ClienteVeiculos;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.fatec.leilaoEletronicoLp2.models.ClienteDispositivoInformatica;
import com.fatec.leilaoEletronicoLp2.models.DispositivoInformatica;

@Repository
public interface ClienteDispositivoInformaticaRepository extends JpaRepository<ClienteDispositivoInformatica, Integer>{

	List<ClienteDispositivoInformatica> findBydispositivoInformatica(DispositivoInformatica dispositivoInformatica);

	List<ClienteDispositivoInformatica> findByclidiIdOrderByClidiIdAsc(Integer id);
	
	@Query("SELECT cdi FROM ClienteDispositivoInformatica cdi WHERE cdi.clidiValorLance = (SELECT MAX(cdi2.clidiValorLance) FROM ClienteDispositivoInformatica cdi2)")
	ClienteDispositivoInformatica findClienteWithHighestLance();



}
