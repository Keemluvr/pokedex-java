package br.com.edu.ifsc.pokedex.models;

import java.io.Serializable;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

/**
 * Classe que vai modelar o tipo do pokémon. Tipos referem-se a diferentes
 * propriedades elementares associadas tanto a Pokémon quanto a seus movimentos.
 * Existem 18 tipos oficiais totais de Pokémon.
 * 
 * 
 * @Author Keila Fernandes
 */
@Entity
@Table(name = "type")
public class Type implements Serializable {

	// Para manter a compatibilidade com as versões dessa classe
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO) // Cria automaticamente o id
	@Column(unique = true)
	private long id;

	/**
	 * Nome do tipo
	 */
	@Column
	private String name;

	
	/**
	 * Essa lista irá guardar o tipo dos pokémons que dão dano duplo no tipo em que
	 * se está sendo referenciado. Um tipo recebe dano duplo de vários tipos e
	 * vários tipos podem receber dano de vários outros tipos. Sendo assim, cria-se
	 * uma tabela para relacioná-los.
	 * 
	 * @see type
	 */
	@ManyToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	@JoinColumn(name = "id")
	@NotNull
	@JsonIgnoreProperties({ "doubleDamageFrom", "doubleDamageTo", "halfDamageFrom", "halfDamageTo", "noDamageFrom",
			"noDamageTo" }) //Ignora essas propriedades no retornar o JSON
	private List<Type> doubleDamageFrom;

	
	/**
	 * Essa lista irá guardar o tipo dos pokémons que recebem dano duplo no tipo em que
	 * se está sendo referenciado. Um tipo recebe dano duplo de vários tipos e
	 * vários tipos podem receber dano de vários outros tipos. Sendo assim, cria-se
	 * uma tabela para relacioná-los.
	 * 
	 * @see type
	 */
	@ManyToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	@JoinColumn(name = "id")
	@Column
	@NotNull
	@JsonIgnoreProperties({ "doubleDamageFrom", "doubleDamageTo", "halfDamageFrom", "halfDamageTo", "noDamageFrom",
			"noDamageTo" })
	private List<Type> doubleDamageTo;

	
	/**
	 * Essa lista irá guardar o tipo dos pokémons que dão 1/2 de dano no tipo em que
	 * se está sendo referenciado. Um tipo recebe dano duplo de vários tipos e
	 * vários tipos podem receber dano de vários outros tipos. Sendo assim, cria-se
	 * uma tabela para relacioná-los.
	 * 
	 * @see type
	 */
	@ManyToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	@JoinColumn(name = "id")
	@Column
	@NotNull
	@JsonIgnoreProperties({ "doubleDamageFrom", "doubleDamageTo", "halfDamageFrom", "halfDamageTo", "noDamageFrom",
			"noDamageTo" })
	private List<Type> halfDamageFrom;

	
	/**
	 * Essa lista irá guardar o tipo dos pokémons que recebe 1/2 de dano no tipo em que
	 * se está sendo referenciado. Um tipo recebe dano duplo de vários tipos e
	 * vários tipos podem receber dano de vários outros tipos. Sendo assim, cria-se
	 * uma tabela para relacioná-los.
	 * 
	 * @see type
	 */
	@ManyToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	@JoinColumn(name = "id")
	@Column
	@NotNull
	@JsonIgnoreProperties({ "doubleDamageFrom", "doubleDamageTo", "halfDamageFrom", "halfDamageTo", "noDamageFrom",
			"noDamageTo" })
	private List<Type> halfDamageTo;


	/**
	 * Essa lista irá guardar o tipo dos pokémons que dão dano no tipo em que
	 * se está sendo referenciado. Um tipo recebe dano duplo de vários tipos e
	 * vários tipos podem receber dano de vários outros tipos. Sendo assim, cria-se
	 * uma tabela para relacioná-los.
	 * 
	 * @see type
	 */
	@ManyToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	@JoinColumn(name = "id")
	@Column
	@NotNull
	@JsonIgnoreProperties({ "doubleDamageFrom", "doubleDamageTo", "halfDamageFrom", "halfDamageTo", "noDamageFrom",
			"noDamageTo" })
	private List<Type> noDamageFrom;


	/**
	 * Essa lista irá guardar o tipo dos pokémons que não recebem dano no tipo em que
	 * se está sendo referenciado. Um tipo recebe dano duplo de vários tipos e
	 * vários tipos podem receber dano de vários outros tipos. Sendo assim, cria-se
	 * uma tabela para relacioná-los.
	 * 
	 * @see type
	 */
	@ManyToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	@JoinColumn(name = "id")
	@Column
	@NotNull
	@JsonIgnoreProperties({ "doubleDamageFrom", "doubleDamageTo", "halfDamageFrom", "halfDamageTo", "noDamageFrom",
			"noDamageTo" })
	private List<Type> noDamageTo;

	// Getters and Setters

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public List<Type> getDoubleDamageFrom() {
		return doubleDamageFrom;
	}

	public void setDoubleDamageFrom(List<Type> doubleDamageFrom) {
		this.doubleDamageFrom = doubleDamageFrom;
	}

	public List<Type> getDoubleDamageTo() {
		return doubleDamageTo;
	}

	public void setDoubleDamageTo(List<Type> doubleDamageTo) {
		this.doubleDamageTo = doubleDamageTo;
	}

	public List<Type> getHalfDamageFrom() {
		return halfDamageFrom;
	}

	public void setHalfDamageFrom(List<Type> halfDamageFrom) {
		this.halfDamageFrom = halfDamageFrom;
	}

	public List<Type> getHalfDamageTo() {
		return halfDamageTo;
	}

	public void setHalfDamageTo(List<Type> halfDamageTo) {
		this.halfDamageTo = halfDamageTo;
	}

	public List<Type> getNoDamageFrom() {
		return noDamageFrom;
	}

	public void setNoDamageFrom(List<Type> noDamageFrom) {
		this.noDamageFrom = noDamageFrom;
	}

	public List<Type> getNoDamageTo() {
		return noDamageTo;
	}

	public void setNoDamageTo(List<Type> noDamageTo) {
		this.noDamageTo = noDamageTo;
	}

}
