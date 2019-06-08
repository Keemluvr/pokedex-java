package br.com.edu.ifsc.pokedex.controller;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.edu.ifsc.pokedex.models.Type;
import br.com.edu.ifsc.pokedex.repository.TypeRepository;

/** Classe que vai receber as requisições http
 * 
 * @Author	Keila Fernandes
 */
@RestController
@RequestMapping(value="/api") //URI padrão para a API  
public class TypeController {

	/** Ponto de injeção
	 * Para poder utilizar aos métodos para se conectar 
	 * ao banco de dados.
	 */
	@Autowired
	TypeRepository typeRepository;
	
	
	/** Lista todos os os tipos salvos no banco de dados
	 * em formato JSON.
	 * 
	 * @see Type
	 * @see TypeRepository
	 */
	@GetMapping("/type")
	public List<Type> listTypes() {
		
		return typeRepository.findAll();
	}
	
	/**
	 * Lista o tipo específico pelo id que está salvo no banco de dados, em
	 * formato JSON.
	 * 
	 * @see Type
	 * @see TypeRepository
	 */
	@GetMapping("/type/{id:[0-9]+}")
	public Type listTypeId(@PathVariable(value = "id") long id) {
		return typeRepository.findById(id);
	}
	
	/**
	 * Lista um type específico pelo nome que está salvo no banco de dados, em
	 * formato JSON.
	 * 
	 * @see Type
	 * @see TypeRepository
	 */
	@GetMapping("/type/{name:[a-zA-Z]+}")
	public Type listTypeName(@PathVariable(value = "name") String name) {
		return typeRepository.findByName(name.toLowerCase());
	}
	
	/**
	 * Vai receber através do corpo da requisição o tipo e vai ser salvo no banco
	 * de dados.
	 * 
	 * @see Type
	 * @see TypeRepository
	 */
	@PostMapping("/type")
	public Type saveType(@RequestBody Type type) {
		return typeRepository.save(type);
	}
	
	/**
	 * Irá deletar um tipo em uma determinada posição conhecida como id. Irá
	 * receber como parâmetro o id do tipo a ser deletado, no corpo da
	 * requisição.
	 */
	@DeleteMapping("/type/{id}")
	public void deleteType(@PathVariable(value = "id") long id) {
		typeRepository.deleteById(id);
	}

	/**
	 * Irá atualizar as informações de um tipo através das informações recebidas
	 * do RequestBody em formato JSON.
	 */
	@PutMapping("/type")
	public Type updateType(@RequestBody Type type) {
		return typeRepository.save(type);
	}
}
