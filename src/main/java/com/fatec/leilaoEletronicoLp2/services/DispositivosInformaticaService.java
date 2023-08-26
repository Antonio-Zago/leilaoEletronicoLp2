package com.fatec.leilaoEletronicoLp2.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fatec.leilaoEletronicoLp2.models.DispositivoInformatica;
import com.fatec.leilaoEletronicoLp2.repositorys.DispositivosInformaticaRepository;

@Service
public class DispositivosInformaticaService {
	
	@Autowired
	private DispositivosInformaticaRepository dispositivosInformaticaRepository;
	
	public List<DispositivoInformatica> getAll(){
		return dispositivosInformaticaRepository.findAll();
	}
	
	public DispositivoInformatica save(DispositivoInformatica dispositivoInformatica) {
		return dispositivosInformaticaRepository.save(dispositivoInformatica);
	}

}
