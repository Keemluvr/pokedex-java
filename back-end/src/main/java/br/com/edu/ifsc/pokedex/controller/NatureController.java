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

import br.com.edu.ifsc.pokedex.models.Nature;
import br.com.edu.ifsc.pokedex.repository.NatureRepository;

/** Classe que vai receber as requisições http
 * 
 * @Author	Keila Fernandes
 * @Author	Cesar Henrique
 */
@RestController
@RequestMapping(value="/api") //URI padrão para a API  
public class NatureController {
	
	/** Ponto de injeção
	 * Para poder utilizar aos métodos para se conectar 
	 * ao banco de dados.
	 */
	@Autowired
	NatureRepository natureRepository;
	
	
	/** Lista todos as naturezas salvas no banco de dados
	 * em formato JSON.
	 */
	@GetMapping("/nature")
	public List<Nature> listNatures() {
		return natureRepository.findAll();
	}
	
	
	/** Lista a natureza específicada pelo id que está salvo 
	 * no banco de dados, em formato JSON.
	 */
	@GetMapping("/nature/{id:[0-9]+}")
	public Nature listNature(@PathVariable(value="id") long id) {
		return natureRepository.findById(id);
	}
	
	
	/**
	 * Lista a natureza específica pelo nome que está salvo no banco de dados, em
	 * formato JSON,.
	 */
	@GetMapping("/nature/{name:[A-Za-z]+}")
	public Nature listNatureName(@PathVariable(value = "name") String name) {
		return natureRepository.findByName(name.toLowerCase());
	}
	
	
	/** Vai receber através do corpo da requisição a natureza
	 * e vai ser salvo no banco de dados.
	 */
	@PostMapping("/nature")
	public Nature saveNature(@RequestBody Nature nature) {
		return natureRepository.save(nature);
	}
	
	
	/** Irá deletar uma natureza em uma determinada posição
	 * conhecida como id.
	 * Irá receber como parâmetro o id a ser deletado
	 * em formato JSON, no corpo da requisição.
	 */
	@DeleteMapping("/nature/{id}")
	public void deleteNature(@PathVariable(value="id") long id) {
		natureRepository.deleteById(id);
	}
	
	
	/** Irá atualizar as informações de uma nature através das
	 * informações recebidas do RequestBody em formato JSON.
	 */
	@PutMapping("/nature")
	public Nature updateNature(@RequestBody Nature nature) {
		return natureRepository.save(nature);
	}
}
