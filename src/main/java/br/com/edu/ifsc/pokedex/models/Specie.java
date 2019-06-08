package br.com.edu.ifsc.pokedex.models;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * Classe que vai modelar a specie do pokémon, ou seja, irá identificar em qual
 * evolução ele está.
 * 
 * @see
 * @see
 * 
 * @Author Keila Fernandes
 */
@Entity
@Table(name = "specie")
public class Specie implements Serializable{
	
	// Para manter a compatibilidade com as versões dessa classe
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO) // Cria automaticamente o id
	@Column(unique = true)
	private long id;
	
//	@Column(nullable = false)
//	private Evolution currentEvolution;
//	
//	@Column(nullable = false)
//	private List<Type> type;
}
