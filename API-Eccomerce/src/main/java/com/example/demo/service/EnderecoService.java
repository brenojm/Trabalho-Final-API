package com.example.demo.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.exception.EnderecoExistenteException;
import com.example.demo.exception.EnderecoInexistenteException;
import com.example.demo.model.Endereco;
import com.example.demo.model.EnderecoDTO;
import com.example.demo.model.ViaCepDTO;
import com.example.demo.repository.EnderecoRepository;
import com.example.demo.restClient.RestViaCep;

@Service
public class EnderecoService {
	

	@Autowired
	EnderecoRepository repositorio;
	
	@Autowired	
	RestViaCep restViaCep;
	
	public List<Endereco> listarTudo(){
		return repositorio.findAll();
	}
	
	public Endereco listarPorId(Integer id) throws EnderecoInexistenteException{
		Optional<Endereco> optional = repositorio.findById(id);		
		if (optional.isEmpty()) {
			throw new EnderecoInexistenteException("Endereco inexistente");
		}
		return optional.get();
	}
	
	public Endereco create(EnderecoDTO enderecoDto) throws EnderecoExistenteException {
		ViaCepDTO enderecoNovo = restViaCep.getViaCEP(enderecoDto.getCep());
		Endereco endereco = new Endereco();
		endereco.setRua(enderecoNovo.getLogradouro());
		endereco.setCidade(enderecoNovo.getLocalidade());
		endereco.setCep(enderecoNovo.getCep());
		endereco.setBairro(enderecoNovo.getBairro());
		endereco.setNumCasa(enderecoDto.getNumCasa());
		endereco.setComplemento(enderecoDto.getComplemento());
		endereco.setEstado(enderecoNovo.getUf());
		//verificarEnderecoExiste(endereco);
		return repositorio.save(endereco);
	}
	
	/* void verificarEnderecoExiste(Endereco endereco) throws EnderecoExistenteException {
		Optional<Endereco> optional = repositorio.findByCep(endereco.getCep());
		if (optional.isPresent()) {
			throw new EnderecoExistenteException("Esse Endereco ja existe");
		}	
	}*/
	
    public Endereco update(Endereco endereco, Integer id) {
    	endereco.setId(id);
    	return repositorio.save(endereco);
    }
    public void delete(Integer id) throws EnderecoInexistenteException {
    	Optional<Endereco> optional = repositorio.findById(id);
    	if (optional.isEmpty()) {
			throw new EnderecoInexistenteException("Endereco não existe");
		}
		repositorio.deleteById(id);
    	
    	
    }
	

}