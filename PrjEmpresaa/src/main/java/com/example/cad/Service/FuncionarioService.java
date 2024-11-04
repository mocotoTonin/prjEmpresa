package com.example.cad.Service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.cad.entity.Departamento;
import com.example.cad.entity.Funcionario;
import com.example.cad.repository.DepartamentoRepository;
import com.example.cad.repository.FuncionarioRepository;

@Service
public class FuncionarioService {
	
	private final FuncionarioRepository funcionarioRepository;
	private final DepartamentoRepository departamentoRepository;
	
	@Autowired
	public FuncionarioService (FuncionarioRepository funcionarioRepository, DepartamentoRepository departamentoRepository) {
		this.departamentoRepository = departamentoRepository;
		this.funcionarioRepository = funcionarioRepository;
	}
	
	public Funcionario salvarFuncionario (Funcionario funcionario) {
		if(funcionario.getDepartamento() != null && funcionario.getDepartamento().getDepCodigo() !=null) {
			Optional<Departamento> departamento = departamentoRepository.findById(funcionario.getDepartamento().getDepCodigo());
			if(departamento.isPresent()) {
				funcionario.setDepartamento(departamento.get());
				return funcionarioRepository.save(funcionario);
			}else {
			throw new RuntimeException("funcionario nao encontrado") ;
		 }
	}else {
			throw new RuntimeException("ID do funcionario é obrigatório");
	}
	}
	public Funcionario buscarFuncionarioPorId(Long id) {
		return funcionarioRepository.findById(id).orElse(null);
	}
	
	public List<Funcionario> buscarTodosFuncionario(){
		return funcionarioRepository. findAll();
	}
	
	public void excluirFuncionario (Long id) {
	funcionarioRepository.deleteById(id);
	}
}
