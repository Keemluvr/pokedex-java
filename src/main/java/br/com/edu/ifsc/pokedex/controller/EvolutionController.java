package br.com.edu.ifsc.pokedex.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.edu.ifsc.pokedex.models.Evolution;
import br.com.edu.ifsc.pokedex.repository.EvolutionRepository;

/** Classe que vai receber as requisições http
 * 
 * @Author	Keila Fernandes
 */
@RestController
@RequestMapping(value="/api") //URI padrão para a API  
public class EvolutionController {
	
	/** Ponto de injeção
	 * para poder utilizar aos métodos para se conectar 
	 * ao banco de dados.
	 */
	@Autowired
	EvolutionRepository evolutionRepository;
	
	/** Lista todas evoluções salvas no banco de dados
	 * em formato JSON.
	 */
	@CrossOrigin
	@GetMapping("/evolution")
	public List<Evolution> listEvolutions() {
		return evolutionRepository.findAll();
	}
	
	/** Lista a evolução específicada pelo id que está salvo 
	 * no banco de dados, em formato JSON.
	 */
	@CrossOrigin
	@GetMapping("/evolution/{id:[0-9]+}")
	public Evolution listEvolution(@PathVariable(value="id") long id) {
		return evolutionRepository.findById(id);
	}
	
	/** Vai receber através do corpo da requisição a evolução
	 * e vai ser salvo no banco de dados.
	 */
	@PostMapping("/evolution")
	public Evolution saveEvolution(@RequestBody Evolution evolution) {
		return evolutionRepository.save(evolution);
	}
	
	/** Irá deletar uma evolução em uma determinada posição
	 * conhecida como id.
	 * Irá receber como parâmetro o id a ser deletado
	 * em formato JSON, no corpo da requisição.
	 */
	@DeleteMapping("/evolution/{id}")
	public void deleteEvolution(@PathVariable(value="id") long id) {
		evolutionRepository.deleteById(id);
	}
	
}
