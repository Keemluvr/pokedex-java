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

import br.com.edu.ifsc.pokedex.models.Stat;
import br.com.edu.ifsc.pokedex.repository.StatRepository;

/** Classe que vai receber as requisições http
 * 
 * @Author	Keila Fernandes
 * @Author	Cesar Henrique
 */
@RestController
@RequestMapping(value="/api") //URI padrão para a API  
public class StatController {
	
	/** Ponto de injeção
	 * Para poder utilizar aos métodos para se conectar 
	 * ao banco de dados.
	 */
	@Autowired
	StatRepository statRepository;
	
	
	/** Lista todos os stats salvos no banco de dados
	 * em formato JSON.
	 */
	@GetMapping("/stat")
	public List<Stat> listStats() {
		return statRepository.findAll();
	}
	
	
	/** Lista o stat específicado pelo id que está salvo 
	 * no banco de dados, em formato JSON.
	 */
	@GetMapping("/stat/{id}")
	public Stat listStat(@PathVariable(value="id") long id) {
		return statRepository.findById(id);
	}
	
	
	/** Vai receber através do corpo da requisição o stat
	 * e vai ser salvo no banco de dados.
	 */
	@PostMapping("/stat")
	public Stat saveStat(@RequestBody Stat stat) {
		return statRepository.save(stat);
	}
	
	
	/** Irá deletar um stat em uma determinada posição
	 * conhecida como id.
	 * Irá receber como parâmetro o id a ser deletado
	 * em formato JSON, no corpo da requisição.
	 */
	@DeleteMapping("/stat/{id}")
	public void deleteStat(@PathVariable(value="id") long id) {
		statRepository.deleteById(id);
	}
	
	
	/** Irá atualizar as informações de uma nature através das
	 * informações recebidas do RequestBody em formato JSON.
	 */
	@PutMapping("/stat/{id}")
	public Stat updateNature(@RequestBody Stat newStat, @PathVariable(value="id") long id) {
		return statRepository.save(newStat);
	}
}
