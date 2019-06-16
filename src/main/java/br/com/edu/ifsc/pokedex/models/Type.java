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

/** Classe que vai modelar o tipo do pokémon. 
 * Tipos referem-se a diferentes propriedades elementares associadas tanto a 
 * Pokémon quanto a seus movimentos.
 * Existem 18 tipos oficiais totais de Pokémon.
 * 
 * @see Serializable
 * @see Type
 * 
 * @Author Keila Fernandes
 */
@Entity
@Table(name = "type")
public class Type implements Serializable {

	// Para manter a compatibilidade com as versões dessa classe
	private static final long serialVersionUID = 1L;
	
	/** Id que irá identificar o ovo, sendo que ele será único */
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO) // Cria automaticamente o id
	@Column(unique = true)
	private long id;

	/** Nome do tipo */
	@Column(nullable = false)
	private String name;

	/** Essa lista irá guardar o tipo dos pokémons que dão dano duplo no tipo em que
	 * se está sendo referenciado. Um tipo recebe dano duplo de vários tipos e
	 * vários tipos podem receber dano de vários outros tipos. 
	 * 
	 * @see type
	 */
	// Sendo assim, cria-se uma tabela para relacioná-los.
	@ManyToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	@JoinColumn(name = "id")
	@NotNull
	@JsonIgnoreProperties({ "doubleDamageFrom", "doubleDamageTo", "halfDamageFrom", "halfDamageTo", "noDamageFrom",
			"noDamageTo" }) //Ignora essas propriedades no retornar o JSON
	private List<Type> doubleDamageFrom;

	
	/**
	 * Essa lista irá guardar o tipo dos pokémons que recebem dano duplo no tipo em que
	 * se está sendo referenciado. Um tipo recebe dano duplo de vários tipos e
	 * vários tipos podem receber dano de vários outros tipos. 
	 * 
	 * @see type
	 */
	// Sendo assim, cria-se uma tabela para relacioná-los.
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
	 * vários tipos podem receber dano de vários outros tipos.
	 * 
	 * @see type
	 */
	// Sendo assim, cria-se uma tabela para relacioná-los.
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
	 * vários tipos podem receber dano de vários outros tipos.
	 * 
	 * @see type
	 */
	// Sendo assim, cria-se uma tabela para relacioná-los.
	@ManyToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	@JoinColumn(name = "id")
	@Column
	@NotNull
	@JsonIgnoreProperties({ "doubleDamageFrom", "doubleDamageTo", "halfDamageFrom", "halfDamageTo", "noDamageFrom",
			"noDamageTo" })
	private List<Type> halfDamageTo;


	/**
	 * Essa lista irá guardar o tipo dos pokémons que não dão dano no tipo em que
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
	 * vários tipos podem receber dano de vários outros tipos.
	 * 
	 * @see type
	 */
	// Sendo assim, cria-se uma tabela para relacioná-los.
	@ManyToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	@JoinColumn(name = "id")
	@Column
	@NotNull
	@JsonIgnoreProperties({ "doubleDamageFrom", "doubleDamageTo", "halfDamageFrom", "halfDamageTo", "noDamageFrom",
			"noDamageTo" })
	private List<Type> noDamageTo;

	
	//###########################  Getters and Setters  ###########################

	/** @return Retorna o nome do pokémon */
	public String getName() {
		return name;
	}
	
	/** Atribui um novo nome para a tipagem 
	 * @param name - Novo nome da tipagem*/
	public void setName(String name) {
		this.name = name;
	}

	/** @return Retorna uma lista com os tipos que essa tipagem da dano duplo*/
	public List<Type> getDoubleDamageFrom() {
		return doubleDamageFrom;
	}

	/** Atribui uma nova lista com os tipos que essa tipagem da dano duplo
	 * @param doubleDamageFrom - Nova lista de tipos que que essa tipagem da dano duplo */
	public void setDoubleDamageFrom(List<Type> doubleDamageFrom) {
		this.doubleDamageFrom = doubleDamageFrom;
	}
	/** @return Retorna uma lista com os tipos que essa tipagem recebe dano duplo*/
	public List<Type> getDoubleDamageTo() {
		return doubleDamageTo;
	}

	/** Atribui uma nova lista com os tipos essa tipagem recebe dano duplo 
	 * @param doubleDamageTo - Nova lista de tipagens que essa tipagem recebe dano duplo */
	public void setDoubleDamageTo(List<Type> doubleDamageTo) {
		this.doubleDamageTo = doubleDamageTo;
	}

	/** @return Retorna uma lista com os tipos que essa tipagem da 1/2 de dano*/
	public List<Type> getHalfDamageFrom() {
		return halfDamageFrom;
	}

	/** Atribui uma nova lista com os tipos que essa tipagem da 1/2 de dano
	 * @param haldDamageFrom - Nova lista de tipos que essa tipagem dá 1/2 de dano */
	public void setHalfDamageFrom(List<Type> halfDamageFrom) {
		this.halfDamageFrom = halfDamageFrom;
	}

	/** @return Retorna uma lista com os tipos que essa tipagem recebe 1/2 de dano*/
	public List<Type> getHalfDamageTo() {
		return halfDamageTo;
	}

	/** Atribui uma nova lista com os tipos que recebem 1/2 de dano
	 * @param halfDamageTo - Nova lista de tipos que recebem 1/2 de dano */
	public void setHalfDamageTo(List<Type> halfDamageTo) {
		this.halfDamageTo = halfDamageTo;
	}

	/** @return Retorna uma lista com os tipos que essa tipagem não dá dano*/
	public List<Type> getNoDamageFrom() {
		return noDamageFrom;
	}

	/** Atribui uma nova lista com tipagens que esse tipo não dá dano
	 * @param noDamageFrom - Nova lista de tipos que não dá dano*/
	public void setNoDamageFrom(List<Type> noDamageFrom) {
		this.noDamageFrom = noDamageFrom;
	}

	/** @return Retorna uma lista com os tipos que essa tipagem não recebe dano*/
	public List<Type> getNoDamageTo() {
		return noDamageTo;
	}

	/** Atribui uma nova lista com tipagens que esse tipo não recebe dano
	 * @param noDamageTo - Nova lista de tipos que não recebem dano */
	public void setNoDamageTo(List<Type> noDamageTo) {
		this.noDamageTo = noDamageTo;
	}

}
