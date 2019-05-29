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

import br.com.edu.ifsc.pokedex.models.Item;
import br.com.edu.ifsc.pokedex.repository.ItemRepository;

/** Classe que vai receber as requisições http
 * 
 * @Author	Keila Fernandes
 * @Author	Cesar Henrique
 */

@RestController
@RequestMapping(value="/api") //URI padrão para a API  
public class ItemController {

	/** Ponto de injeção
	 * Para poder utilizar aos métodos para se conectar 
	 * ao banco de dados.
	 */
	@Autowired
	ItemRepository itemRepository;
	
	
	/** Lista todos os itens salvos no banco de dados
	 * em formato JSON.
	 */
	@GetMapping("/item")
	public List<Item> listItems() {
		return itemRepository.findAll();
	}
	
	
	/** Lista o item específico pelo id que está salvo 
	 * no banco de dados, em formato JSON.
	 */
	@GetMapping("/item/{id}")
	public Item listItem(@PathVariable(value="id") long id) {
		return itemRepository.findById(id);
	}
	
	
	/** Vai receber através do corpo da requisição o item
	 * e vai ser salvo no banco de dados.
	 */
	@PostMapping("/item")
	public Item saveItem(@RequestBody Item item) {
		return itemRepository.save(item);
	}
	
	
	/** Irá deletar um item em uma determinada posição
	 * conhecida como id.
	 * Irá receber como parâmetro o id a ser deletado
	 * em formato JSON, no corpo da requisição.
	 */
	@DeleteMapping("/item/{id}")
	public void deleteItem(@PathVariable(value="id") long id) {
		itemRepository.deleteById(id);
	}
	
	
	/** Irá atualizar as informações de um ovo através das
	 * informações recebidas do RequestBody em formato JSON.
	 */
	@PutMapping("/item")
	public Item updateItem(@RequestBody Item item) {
		return itemRepository.save(item);
	}
	
	
}
