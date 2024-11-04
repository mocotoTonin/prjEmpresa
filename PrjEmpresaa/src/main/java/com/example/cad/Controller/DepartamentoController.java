package com.example.cad.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.cad.Service.DepartamentoService;
import com.example.cad.entity.Departamento;

@RestController
@RequestMapping ("/Departamento")
public class DepartamentoController{

	private final DepartamentoService departamentoService;

	@Autowired
	public DepartamentoController (DepartamentoService departamentoService) {
		this. departamentoService = departamentoService;
	}

	@PostMapping("/criar")
	public ResponseEntity<Departamento> criarDepartamento(@RequestBody Departamento departamento) {
		Departamento departamentoSalvo = departamentoService. salvarDepartamento(departamento);
		if(departamentoSalvo != null) {
			return ResponseEntity.ok(departamentoSalvo);
	}else {
	return ResponseEntity.badRequest().build();
	}
}
	@GetMapping ("/{id}")
	public Departamento buscarPorID(@PathVariable Long id) {
		return departamentoService.buscarDepartamentoPorId(id);
	}
	
	@GetMapping public List<Departamento> buscarTodos (){
		return departamentoService. buscarTodosDepartamento();
	}
}
