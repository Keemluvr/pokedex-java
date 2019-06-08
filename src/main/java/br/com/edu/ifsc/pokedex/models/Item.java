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


@Entity
@Table(name="item")
public class Item implements Serializable{

	// Para manter a coevolutionpatibilidade com as versões dessa classe 
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO) //Cria automaticamente o id
	@Column(unique=true)
	private long id;
	
	
	/** Nome do item
	 */
	@Column(nullable = false)
	private String name;
	
	/** Lista de evoluções em que se usa esse item 
	 */
	
	
	@OneToMany( targetEntity = Evolution.class, fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	@Column
	private List<Evolution> evolutionUseThisItem;
	
	// Getters and Setters

	public long getId() {
		return id;
	}


	public void setId(long id) {
		this.id = id;
	}


	public String getItem() {
		return name;
	}


	public void setItem(String item) {
		this.name = item;
	}
	
}
