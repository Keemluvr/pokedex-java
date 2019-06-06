package br.com.edu.ifsc.pokedex.models;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/** Classe que vai modelar a evolução do pokémon
 * 
 * @see 
 * @see 
 * 
 * @Author	Keila Fernandes
 */
@Entity
@Table(name="evolution")
public class Evolution implements Serializable{

	// Para manter a compatibilidade com as versões dessa classe 
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO) //Cria automaticamente o id
	@Column(unique=true)
	private long id;
	
	// Métodos
	
	/** */
	public int evolutionByLevel() {
		return 0;
	}
	
	/** */
	public int evolutionByStones() {
		return 0;
	}
	
	/** */
	public int evolutionByTrading() {
		return 0;
	}
	
	/** */
	public int evolutionByFriendship() {
		return 0;
	}
	
	/** */
	public int evolutionByOtherCondition() {
		return 0;
	}
	
	/** */
	public int notEvolution() {
		return 0;
	}

}
