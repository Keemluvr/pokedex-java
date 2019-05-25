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
	private long id;
	
	/**
	 * Nome da Nature
	 */
	@Column(nullable = false)
	private String name;
	
	
	
	// Métodos
	
	/**
	 * O método increase tem como objetivo aumentar alguma característica
	 * do stats do Pokemon, como o ataque, a defesa, a velocidade de ataque,
	 * velocidade de defesa e velocidade do Pokemon.
	 * 
	 * @param
	 */
	public void increase(Stat stat) {
		
	}
	
	/**
	 * O método decrease tem como objetivo diminuir alguma característica
	 * do stats do Pokemon, como o ataque, a defesa, a velocidade de ataque,
	 * velocidade de defesa e velocidade do Pokemon.
	 * 
	 * @param
	 */
	public void decrease(Stat stat) {
			
	}
	
	
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

}
