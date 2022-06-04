package com.example.demo.controller;

import java.io.IOException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.example.demo.exception.CategoriaInexistenteException;
import com.example.demo.exception.ProdutoExistenteException;
import com.example.demo.exception.ProdutoInexistenteException;
import com.example.demo.model.Image;
import com.example.demo.model.Produto;
import com.example.demo.model.ProdutoDTO;
import com.example.demo.service.ImageService;
import com.example.demo.service.ProdutoService;

@RestController
@RequestMapping("/produto")
public class ProdutoController {

	@Autowired
	ProdutoService service;
	
	@Autowired
	ImageService serviceImage;

	@GetMapping
	public ResponseEntity<List<Produto>> getAll() {
		HttpHeaders headers = new HttpHeaders();
		headers.add("Lista de Produtos", "Segue todos os produtos cadastrados");
		return new ResponseEntity<List<Produto>>(service.listarTudo(), headers, HttpStatus.ACCEPTED);
	}

	@GetMapping("/{numero}")
	public ResponseEntity<ProdutoDTO> getOne(@PathVariable Integer numero) throws ProdutoInexistenteException {
		return new ResponseEntity<ProdutoDTO>(service.listarProduto(numero), HttpStatus.OK);
	}
	
	@GetMapping("/{id}/image")
	public ResponseEntity<byte[]> getImage(@PathVariable Integer id){
		Image image = serviceImage.getImage(id);
		HttpHeaders headers = new HttpHeaders();
		headers.add("content-type", image.getMimeType());
		headers.add("content-length", String.valueOf(image.getData().length));
		return new ResponseEntity<>(image.getData(),headers, HttpStatus.OK);
		
	}

	@PostMapping
	public ResponseEntity<Produto> insert(@RequestPart Produto produto,@RequestParam MultipartFile file) throws ProdutoExistenteException, CategoriaInexistenteException, IOException {
		service.inserir(produto, file);
		return new ResponseEntity<>(produto, HttpStatus.CREATED);
	}

	@PutMapping("/{numero}")
	public ResponseEntity<Produto> update(@RequestBody Produto produto, @PathVariable Integer numero)
			throws ProdutoInexistenteException, ProdutoExistenteException {
		return new ResponseEntity<Produto>(service.atualizar(produto, numero), HttpStatus.OK);
	}

	@DeleteMapping("/{numero}")
	public ResponseEntity<?> delete(@PathVariable Integer numero) throws ProdutoInexistenteException {
		service.deletar(numero);
		return new ResponseEntity<>(HttpStatus.OK);
	}

}