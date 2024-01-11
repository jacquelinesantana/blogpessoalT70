package com.generation.blogpessoal.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.generation.blogpessoal.model.Postagem;
import com.generation.blogpessoal.repository.PostagemRepository;
//controller vai controlar quem vai acessar, qual a rota, e quais os métodos e como os métodos vão responder ao front ou ao insomnia
@RestController
@RequestMapping("/postagens") // endereço para acessar essa controller
@CrossOrigin(origins = "*", allowedHeaders="*")//informa toda e qualquer origem pode acessar essa rota
public class PostagemController {

	//injeção de dependencias
	@Autowired
	private PostagemRepository postagemRepository;
	
	//acessado verbo get
	@GetMapping
	public ResponseEntity<List<Postagem>> getAll(){
		//respostas no formato http
		
		return ResponseEntity.ok(postagemRepository.findAll()) ;
		//find all == select * from nomedatabela
		//codigo de retorno -- corpo de retorno
		
		
	}
	
	@GetMapping("/exemplo")
	public ResponseEntity<String> exemplo(){
		String ola = "Olá mundo";
		return ResponseEntity.noContent().build();
		//nesse exemplo utilizamos o build pq não vamos retornar nada no corpo da requisição
		//o .noContent vai retornar outro código de status no insomnia
		//cada status serve para indicar alguma coisa veja a documentação noContent = não contem o dado ou informação solicitada
	}
	
}
