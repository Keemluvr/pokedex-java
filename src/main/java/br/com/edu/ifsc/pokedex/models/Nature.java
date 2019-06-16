package br.com.edu.ifsc.pokedex.models;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/** Classe que vai modelar a natureza do pokémon. 
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
	
	/** Id que irá identificar a natureza, sendo que ele será único */
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO) //Cria automaticamente o id
	@Column(unique=true)
	private long id;
	
	/** Nome da natureza */
	@Column(nullable = false)
	private String name;
	
	/**Nome do atributo do pokémon, que irá sem incrementado em 10% 
	 * Atributos possíveis: Attack, Defense, Speed Attack, Speed Defense e Speed*/
	@Column(nullable = false)
	private String attributeIncrease;
	
	/**  Nome do atributo do pokémon, que irá sem decrementado em 10% 
	 * Atributos possíveis: Attack, Defense, Speed Attack, Speed Defense e Speed*/
	@Column(nullable = false)
	private String attributeDecrease;
	
	
//	//################################  Métodos  #################################
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
	
	
	//###########################  Getters and Setters  ###########################

	
	/** @return Retorna o id da natureza */
	public long getId() {
		return id;
	}

	/** Atriu um valor ao id da natureza
	 * @param id - Novo id que irá ser atribuído ao atual*/
	public void setId(long id) {
		this.id = id;
	}

	/** @return Retorna o nome da natureza*/
	public String getName() {
		return name;
	}

	/** Atribui um novo nome para a natureza 
	 * @param name - Nome da natureza*/
	public void setName(String name) {
		this.name = name;
	}

	/** @return Retorna o atributo que esse natureza incrementa em 10% */
	public String getAttributeIncrease() {
		return attributeIncrease;
	}

	/** Atribui um novo atributo que a natureza incrementa em 10%
	 * @param attributeIncrease - Novo do atributo que irá incrementar*/
	public void setAttributeIncrease(String attributeIncrease) {
		this.attributeIncrease = attributeIncrease;
	}

	/** @return Retorna o atributo que esse natureza decrementa em 10% */
	public String getAttributeDecrease() {
		return attributeDecrease;
	}

	/** Atribui um novo atributo que a natureza decrementa em 10%
	 * @param attributeDecrease - Novo do atributo que irá decrementar*/
	public void setAttributeDecrease(String attributeDecrease) {
		this.attributeDecrease = attributeDecrease;
	}

}
