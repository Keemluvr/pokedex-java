package br.com.edu.ifsc.pokedex.models;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**Classe que vai modelar a espécie do pokémon, ou seja, irá identificar em qual
 * evolução ele está.
 * 
 * @see Serializable
 * @see Evolution
 * 
 * @Author Keila Fernandes
 */
@Entity
@Table(name = "specie")
public class Specie implements Serializable{
	
	// Para manter a compatibilidade com as versões dessa classe
	private static final long serialVersionUID = 1L;

	/** Id que irá identificar o ovo, sendo que ele será único */
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO) // Cria automaticamente o id
	@Column(unique = true)
	private long id;

	
//	@Column(nullable = false)
//	private Evolution currentEvolution;
//	
//	@Column(nullable = false)
//	private List<Type> type;
	
	//###########################  Getters and Setters  ###########################
	
	/** @return Retorna o id da espécie */
	public long getId() {
		return id;
	}

	/** Atribui um novo id para a espécie 
	 * @param id - Novo id */
	public void setId(long id) {
		this.id = id;
	}
	
}
