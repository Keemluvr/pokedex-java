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

import br.com.edu.ifsc.pokedex.models.Egg;
import br.com.edu.ifsc.pokedex.repository.EggRepository;

/* Classe que vai receber as requisições http
 * 
 * @Author	Keila Fernandes
 * @Author	Cesar Henrique
 */

@RestController
@RequestMapping(value="/api") //URI padrão para a API  
public class EggController {
	
	/* Ponto de injeção
	 * Para poder utilizar aos métodos para se conectar 
	 * ao banco de dados.
	 */
	@Autowired
	EggRepository eggRepository;
	
	
	/* Lista todos os ovos salvos no banco de dados
	 * em formato JSON.
	 */
	@GetMapping("/egg")
	public List<Egg> listEggs() {
		return eggRepository.findAll();
	}
	
	
	/* Lista o ovo específico pelo id que está salvo 
	 * no banco de dados, em formato JSON,.
	 */
	@GetMapping("/egg/{id}")
	public Egg listEgg(@PathVariable(value="id") long id) {
		return eggRepository.findById(id);
	}
	
	
	/* Vai receber através do corpo da requisição o ovo
	 * e vai ser salvo no banco de dados.
	 */
	@PostMapping("/egg")
	public Egg saveEgg(@RequestBody Egg egg) {
		return eggRepository.save(egg);
	}
	
	
	/* Irá deletar um ovo em uma determinada posição
	 * conhecida como id.
	 * Irá receber como parâmetro o id a ser deletado
	 * em formato JSON, no corpo da requisição.
	 */
	@DeleteMapping("/egg")
	public void deleteEgg(@RequestBody Egg egg) {
		eggRepository.delete(egg);
	}
	
	
	/* Irá atualizar as informações de um ovo através das
	 * informações recebidas do RequestBody em formato JSON.
	 */
	@PutMapping("/egg")
	public Egg updateEgg(@RequestBody Egg egg) {
		return eggRepository.save(egg);
	}
	

}
