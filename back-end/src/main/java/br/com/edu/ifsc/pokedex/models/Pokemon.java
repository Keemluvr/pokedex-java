package br.com.edu.ifsc.pokedex.models;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;



@Entity
@Table(name="pokemon")
public class Pokemon implements Serializable{

	// Para manter a compatibilidade com as versões dessa classe 
	private static final long serialVersionUID = 1L; 
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO) //Cria automaticamente o id
	private long id;
	
	@Column
	private String name;
	
	@Column
	private double weight;
	
	@Column
	private double height;
	
	@Column
	private String description;
	
	/** Cria uma tabela chamada egg_pokemon onde há um ovo para muitos pokemons
	 */
	@ManyToOne
	private Egg egg = new Egg();
	
	
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
	
	public double getWeight() {
		return weight;
	}
	
	public void setWeight(double weight) {
		this.weight = weight;
	}
	
	public double getHeight() {
		return height;
	}
	
	public void setHeight(double height) {
		this.height = height;
	}
	
	public String getDescription() {
		return description;
	}
	
	public void setDescription(String description) {
		this.description = description;
	}

	public Egg getEgg() {
		return egg;
	}

	public void setEgg(Egg egg) {
		this.egg = egg;
	}
	
}
