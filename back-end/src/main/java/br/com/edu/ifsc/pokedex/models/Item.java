package br.com.edu.ifsc.pokedex.models;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonBackReference;

@Entity
@Table(name="item")
public class Item implements Serializable{

	// Para manter a compatibilidade com as versões dessa classe 
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO) //Cria automaticamente o id
	private long id;
	
	
	/** Nome do item
	 */
	@Column(nullable = false)
	private String item;

//	/** Cria uma tabela chamada item_evolution onde há uma lista de itens para 
//	 *  uma evolução
//	 */
//	@ManyToMany(fetch = FetchType.LAZY) // Não é o lado dominante da relação
//	@JoinTable(name = "pokemon_egg")
//	@JoinColumn(name = "egg_id")
//	@JsonBackReference //Resolve o problema que retorna a lista de itens infinitamente
//	private List<Pokemon> pokemon;
	
	
	// Getters and Setters

	public long getId() {
		return id;
	}


	public void setId(long id) {
		this.id = id;
	}


	public String getItem() {
		return item;
	}


	public void setItem(String item) {
		this.item = item;
	}
	
}
