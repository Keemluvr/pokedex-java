package br.com.edu.ifsc.pokedex.models;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonManagedReference;

/** Classe que vai modelar o ovo do pokémon.
 * Cada Pokémon é atribuído a um ou mais grupos de ovos, e somente os Pokémon 
 * nos mesmos grupos de ovos podem reproduzir.
 * 
 * @see Serializable
 * @see Pokemon
 * 
 * @author	Keila Fernandes
 */
@Entity
@Table(name="egg")
public class Egg implements Serializable{

	// Para manter a compatibilidade com as versões dessa classe 
	private static final long serialVersionUID = 1L; 
	
	/** Id que irá identificar o ovo, sendo que ele será único */
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO) //Cria automaticamente o id
	@Column(unique=true)
	private long id;
	
	/** Nome do ovo */
	@Column(nullable = false)
	private String name;
	
	/** Lista que irá conter os pokémons que possuem aquele ovo */
	/* Cria uma tabela chamada egg_pokemon onde há uma lista de pokemons para um ovo  */
	@ManyToMany(fetch = FetchType.LAZY) // Não é o lado dominante da relação
	@JoinTable(name = "pokemon_egg")
	@JoinColumn(name = "egg_id")
	@JsonIgnoreProperties({"egg"})
	//@JsonManagedReference //Resolve o problema que retorna a lista de ovos infinitamente
	private List<Pokemon> pokemon;

	
	//###########################  Getters and Setters  ###########################
	
	/** @return Retorna o id do pokémon*/
	public long getId() {
		return id;
	}

	/** @return Retorna o nome do pokémon*/
	public String getName() {
		return name;
	}

	/** Atribui o nome ao pokémon 
	 * @param name - nome que o pokémon irá receber */
	public void setName(String name) {
		this.name = name;
	}

	/** @return Retorna uma lista de pokémons que possuem aquele ovo */
	public List<Pokemon> getPokemon() {
		return pokemon;
	}

	/** Atribui pokémons na lista de pokémons que possuem aquele ovo
	 * @param pokemon - lista com os pokemons que possuem aquele ovo*/
	public void setPokemon(List<Pokemon> pokemon) {
		this.pokemon = pokemon;
	}
	
}
