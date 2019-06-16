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
import javax.persistence.OneToMany;
import javax.persistence.Table;

/** Classe que vai modelar os items.
 * Eles são objetos a serem coletados e usados ​​para propósitos específicos, 
 * incluindo progresso através da história do jogo, captura de Pokémon, 
 * cura de seus Pokémon, ajuda de Pokémon em batalha, melhoria de suas estatísticas 
 * e até Pokémon em evolução.
 * Nessa API específica os itens servirão mais para auxiliar na evolução.
 * 
 * @see Serializable
 * 
 * @Author	Keila Fernandes
 */
@Entity
@Table(name="item")
public class Item implements Serializable{

	// Para manter a coevolutionpatibilidade com as versões dessa classe 
	private static final long serialVersionUID = 1L;
	
	/** Id que irá identificar o ovo, sendo que ele será único */
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO) //Cria automaticamente o id
	@Column(unique=true)
	private long id;
	
	
	/** Nome do item */
	@Column(nullable = false)
	private String name;
	
	/** Lista de evoluções em que se usa esse item */
	@OneToMany( targetEntity = Evolution.class, fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	@Column
	private List<Evolution> evolutionUseThisItem;
	
	
	//###########################  Getters and Setters  ###########################

	/** @return Retorna o id do item */
	public long getId() {
		return id;
	}

	/** Atriu um valor ao id do item
	 * @param id - Novo id que irá ser atribuído ao atual*/
	public void setId(long id) {
		this.id = id;
	}

	/** @return Retorna o nome do item */
	public String getItem() {
		return name;
	}

	/** Atribui um nome ao item
	 * @param name - Nome que será atribuído ao item */
	public void setItem(String name) {
		this.name = name;
	}
	
}
