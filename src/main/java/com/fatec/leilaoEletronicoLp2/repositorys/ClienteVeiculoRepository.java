package com.fatec.leilaoEletronicoLp2.repositorys;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.fatec.leilaoEletronicoLp2.models.ClienteDispositivoInformatica;
import com.fatec.leilaoEletronicoLp2.models.ClienteVeiculos;
import com.fatec.leilaoEletronicoLp2.models.DispositivoInformatica;
import com.fatec.leilaoEletronicoLp2.models.Veiculos;

@Repository
public interface ClienteVeiculoRepository extends JpaRepository<ClienteVeiculos, Integer> {
	
	List<ClienteVeiculos> findByveiculo(Veiculos veiculos);
	
	@Query("SELECT cdi FROM ClienteVeiculos cdi WHERE cdi.cliveiValorLance = (SELECT MAX(cdi2.cliveiValorLance) FROM ClienteVeiculos cdi2)")
	ClienteVeiculos findClienteWithHighestLance();

	List<ClienteVeiculos> findBycliveiIdOrderByCliveiIdAsc(Integer id);


}
