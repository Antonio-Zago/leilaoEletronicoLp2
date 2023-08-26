package com.fatec.leilaoEletronicoLp2.controllers;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fatec.leilaoEletronicoLp2.models.DispositivoInformatica;
import com.fatec.leilaoEletronicoLp2.services.DispositivosInformaticaService;

@RestController
@RequestMapping("/api/dispositivosinformatica")
@CrossOrigin(origins="*")
public class DispositivosInformaticaController {
	
	@Autowired
	private DispositivosInformaticaService dispositivosInformaticaService;
	
	@GetMapping
	public List<DispositivoInformatica> getAll() {

		return dispositivosInformaticaService.getAll();
	}
	
	@PostMapping
	public DispositivoInformatica save(@RequestBody DispositivoInformatica dispositivoInformatica) {
		
		
		return dispositivosInformaticaService.save(dispositivoInformatica);
	}
	
}
