package br.com.edu.ifsc.pokedex.models;

import java.io.Serializable;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;


/** Classe que vai modelar o pokemon
 * 
 * @see Serializable
 * @see Egg
 * @see Stat
 * 
 * @author	Keila Fernandes
 * @author	Cesar Henrique
 */
@Entity
@Table(name="pokemon")
public class Pokemon extends Stat implements Serializable{

	// Para manter a compatibilidade com as versões dessa classe 
	private static final long serialVersionUID = 1L; 
	
	/** Nome do pokémon */
	@Column(nullable = false)
	private String name;
	
	/** Peso do pokémon */
	@Column(nullable = false)
	private double weight;
	
	/** Altura do pokemon */
	@Column(nullable = false)
	private double height;
	
	/** Descrição do pokémon */
	@Column(nullable = false)
	private String description;
	
	/** Lista dos ovos que o pokémon possui */
	/* Cada Pokémon é atribuído a um ou mais grupos de ovos */
	@ManyToMany(cascade = CascadeType.ALL,  fetch = FetchType.LAZY)
	@JoinTable(name = "pokemon_egg")
	@JoinColumn(name = "pokemon_id")
	//@JsonBackReference //Resolve o problema que retorna a lista de ovos infinitamente
	private List<Egg> egg;
	
	
	//###########################  Getters and Setters  ###########################
	
	/** @return  Retorna o do nome do Pokémon */
	public String getName() {
		return name;
	}
	
	/** Atribui um novm nome para o pokémon 
	 * @param name - Novo nome do pokémon*/
	public void setName(String name) {
		this.name = name;
	}
	
	/** @return Retorna o peso do Pokemon */
	public double getWeight() {
		return weight;
	}
	
	/** Atribui um novo peso para o pokémon 
	 * @param weight - Novo peso do pokémon */
	public void setWeight(double weight) {
		this.weight = weight;
	}
	
	/** @return Retorna a altura do Pokemon */
	public double getHeight() {
		return height;
	}
	
	/** Atribui uma nova altura para o pokémon
	 * @param height - Nova altura do pokémon */
	public void setHeight(double height) {
		this.height = height;
	}
	
	/** @return Retorna a descrição do pokémon */
	public String getDescription() {
		return description;
	}
	
	/** Atribui uma nova descrição para o pokémon
	 * @param description - Nova descrição do pokémon */
	public void setDescription(String description) {
		this.description = description;
	}

	/** @return Retorna uma lista de ovos do pokémon
	 *  @see egg
	 */
	public List<Egg> getEgg() {
		return egg;
	}

	/** Atribui uma nova lista de ovos para o pokémon
	 * @param egg - Nova lista de ovos do pokémon
	 *  @see Egg
	 */
	public void setEgg(List<Egg> egg) {
		this.egg = egg;
	}
	
}
