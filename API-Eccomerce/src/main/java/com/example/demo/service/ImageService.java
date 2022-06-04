package com.example.demo.service;

import java.io.IOException;
import java.net.URI;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.example.demo.model.Image;
import com.example.demo.model.Produto;
import com.example.demo.repository.ImageRepository;

@Service
public class ImageService {
	
	@Autowired
	ImageRepository repository;
	
	
	@Transactional
	public Image create(Produto produto, MultipartFile file) throws IOException {
		Image image = new Image();
		image.setMimeType(file.getContentType());
		image.setName(file.getName());
		image.setData(file.getBytes());
		image.setProduto(produto);
		return repository.save(image);
	}
	
	public String createUrl(Integer id) {
		URI uri = ServletUriComponentsBuilder.fromCurrentContextPath().path("/produto/{id}/image").buildAndExpand(id).toUri();
		return uri.toString();
	}
	
	@Transactional
	public Image getImage(Integer id) {
		Optional<Image> optional = repository.findByProdutoId(id);
		if(optional.isEmpty()) {
			return null;
			//to-do tratar erro
		}
		
		return optional.get();
	}
}
