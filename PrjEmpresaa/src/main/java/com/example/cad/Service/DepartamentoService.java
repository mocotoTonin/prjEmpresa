package com.example.cad.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.cad.entity.Departamento;
import com.example.cad.repository.DepartamentoRepository;
import com.example.cad.repository.FuncionarioRepository;

@Service
public class DepartamentoService {

	private final DepartamentoRepository departamentoRepository; 
	private final FuncionarioRepository funcionarioRepository;
	
	@Autowired
	public DepartamentoService (DepartamentoRepository departamentoRepository, FuncionarioRepository funcionarioRepository) {
		this.departamentoRepository = departamentoRepository;
		this.funcionarioRepository = funcionarioRepository;
	}
	
	public Departamento salvarDepartamento(Departamento departamento) {
		return departamentoRepository.save(departamento);
	}
	
	public Departamento buscarDepartamentoPorId(Long id)  {
		return departamentoRepository.findById(id).orElse(null);
	}
	
	public List<Departamento> buscarTodosDepartamento(){
		return departamentoRepository. findAll();

	}
}

