package com.example.demo.restClient;

import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import com.example.demo.model.ViaCepDTO;

@Component
public class RestViaCep {

	public ViaCepDTO getViaCEP(String cep) {
		String url = "https://viacep.com.br/ws/" + cep + "/json/";
		RestTemplate restT = new RestTemplate();
		ViaCepDTO enderecoRetornado = restT.getForObject(url, ViaCepDTO.class);
		return enderecoRetornado;
	}

}
