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

import com.fasterxml.jackson.annotation.JsonManagedReference;

/** Classe que vai modelar o pokemon
 * 
 * @see Egg
 * @see Stat
 * 
 * @Author	Keila Fernandes
 * @Author	Cesar Henrique
 */
@Entity
@Table(name="pokemon")
public class Pokemon extends Stat implements Serializable{

	// Para manter a compatibilidade com as versões dessa classe 
	private static final long serialVersionUID = 1L; 
	
	
	/** Variável que irá guardar o nome do pokemon
	 */
	@Column
	private String name;
	
	/** Variável que irá guardar o peso do pokemon
	 */
	@Column
	private double weight;
	
	/** Variável que irá guardar a altura do pokemon
	 */
	@Column
	private double height;
	
	/** Variável que irá guardar a descrição do pokemon
	 */
	@Column
	private String description;
	
	/** Cada Pokémon é atribuído a um ou mais grupos de ovos.
	 */
	@ManyToMany(cascade = CascadeType.ALL,  fetch = FetchType.LAZY)
	@JoinTable(name = "pokemon_egg")
	@JoinColumn(name = "pokemon_id")
	@JsonManagedReference //Resolve o problema que retorna a lista de ovos infinitamente
	private List<Egg> egg;
	
	
	// Getters and Setters
	
	/** Retorna o valor do nome do Pokemon
	 */
	public String getName() {
		return name;
	}
	
	/** Altera o valor da variável name pelo que foi passado no parametro
	 */
	public void setName(String name) {
		this.name = name;
	}
	
	/** Retorna o valor do weight do Pokemon
	 */
	public double getWeight() {
		return weight;
	}
	
	/** Altera o valor da variável weight pelo que foi passado no parametro
	 */
	public void setWeight(double weight) {
		this.weight = weight;
	}
	
	/** Retorna o valor do height do Pokemon
	 */
	public double getHeight() {
		return height;
	}
	
	/** Altera o valor da variável height pelo que foi passado no parametro
	 */
	public void setHeight(double height) {
		this.height = height;
	}
	
	/** Retorna o valor do description do Pokemon
	 */
	public String getDescription() {
		return description;
	}
	
	/** Altera o valor da variável description pelo que foi passado no parametro
	 */
	public void setDescription(String description) {
		this.description = description;
	}

	/** Retorna a lista de eggs do pokemon
	 * 
	 * @see Egg
	 */
	public List<Egg> getEgg() {
		return egg;
	}

	/** Altera o valor da lista de eggs pelo que foi passado no parametro
	 * 
	 *  @see Egg
	 */
	public void setEgg(List<Egg> egg) {
		this.egg = egg;
	}
	
}
