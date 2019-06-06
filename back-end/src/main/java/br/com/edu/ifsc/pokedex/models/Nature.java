package br.com.edu.ifsc.pokedex.models;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * 
 *  Cada Pokémon tem uma natureza, selecionada aleatoriamente de um total de 25.
 *  A nature afeta o crescimento de um Pokémon Cada natureza aumenta um dos 
 *  seus atributos em 10% e diminui um por 10% (no momento em que atinge o nível 100).
 *  
 *  @author Keila
 * 
 */
@Entity
@Table(name = "nature")
public class Nature implements Serializable {

	// Para manter a compatibilidade com as versões dessa classe 
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO) //Cria automaticamente o id
	@Column(unique=true)
	private long id;
	
	/**
	 * Nome da Nature
	 */
	@Column(nullable = false)
	private String name;
	
	/**
	 * Nome do atributo do pokémon, que irá sem incrementado em 10%
	 * 
	 * Ex: attack
	 */
	@Column(nullable = false)
	private String attributeIncrease;
	
	/**
	 * Nome do atributo do pokémon, que irá sem decrementado em 10%
	 * 
	 * Ex: defense
	 */
	@Column(nullable = false)
	private String attributeDecrease;
	
	
//	
//	// Métodos
//	
//	/**
//	 * O método increase tem como objetivo aumentar alguma característica
//	 * do stats do Pokemon, como o ataque, a defesa, a velocidade de ataque,
//	 * velocidade de defesa e velocidade do Pokemon.
//	 * 
//	 * @param
//	 */
//	public void increase(String attributeIncrease) {
//		
//	}
//	
//	/**
//	 * O método decrease tem como objetivo diminuir alguma característica
//	 * do stats do Pokemon, como o ataque, a defesa, a velocidade de ataque,
//	 * velocidade de defesa e velocidade do Pokemon.
//	 * 
//	 * @param
//	 */
//	public void decrease(String attributeDecrease) {
//			
//	}
	
	
	// Getters and Setters

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAttributeIncrease() {
		return attributeIncrease;
	}

	public void setAttributeIncrease(String attributeIncrease) {
		this.attributeIncrease = attributeIncrease;
	}

	public String getAttributeDecrease() {
		return attributeDecrease;
	}

	public void setAttributeDecrease(String attributeDecrease) {
		this.attributeDecrease = attributeDecrease;
	}
	
	

}
