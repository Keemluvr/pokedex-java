package br.com.edu.ifsc.pokedex.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.edu.ifsc.pokedex.models.Pokemon;
import br.com.edu.ifsc.pokedex.repository.PokemonRepository;

/* Classe que vai receber as requisições http
 * 
 * @Author	Keila Fernandes
 * @Author	Cesar Henrique
 */

@RestController
@RequestMapping(value="/api") //URI padrão para a API  
public class PokemonController {

	/* Ponto de injeção
	 * Para poder utilizar aos métodos para se conectar 
	 * ao banco de dados.
	 */
	@Autowired
	PokemonRepository pokemonRepository;
	
	/* Lista todos os pokemons salvos no banco de dados
	 * em formato JSON.
	 */
	@GetMapping("/pokemon")
	public List<Pokemon> listPokemons() {
		return pokemonRepository.findAll();
	}
	
	/* Lista o pokemon específico pelo id que está salvo 
	 * no banco de dados, em formato JSON,.
	 */
	@GetMapping("/pokemon/{id}")
	public Pokemon listPokemon(@PathVariable(value="id") long id) {
		return pokemonRepository.findById(id);
	}
	
	/* Vai receber através do corpo da requisição o pokemon
	 * e vai ser salvo no banco de dados.
	 */
	@PostMapping("/pokemon")
	public Pokemon savePokemon(@RequestBody Pokemon pokemon) {
		return pokemonRepository.save(pokemon);
		
	}
	
}
