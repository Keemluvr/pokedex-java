package br.com.edu.ifsc.pokedex.models;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

@Entity
@Table(name="egg")
public class Egg implements Serializable{

	// Para manter a compatibilidade com as versões dessa classe 
	private static final long serialVersionUID = 1L; 
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO) //Cria automaticamente o id
	private long id;
	
	
	/** Nome do ovo
	 * */
	@Column(nullable = false)
	private String name;
	
	/** Cria uma tabela chamada egg_pokemon onde há uma lista de pokemons para 
	 *  um ovo
	 */
	@ManyToMany // Não é o lado dominante da relação
	@JoinTable(name = "pokemon_egg")
	@JoinColumn(name = "egg_id")
	private List<Pokemon> pokemon;

	
	// Getters and Setters
	
	public long getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public List<Pokemon> getPokemon() {
		return pokemon;
	}

	public void setPokemon(List<Pokemon> pokemon) {
		this.pokemon = pokemon;
	}
	
	
	
}
