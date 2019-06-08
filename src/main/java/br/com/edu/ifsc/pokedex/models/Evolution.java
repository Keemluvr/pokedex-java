package br.com.edu.ifsc.pokedex.models;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
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
	
	/** Evolução anterior
	 */
	@Column
	private Evolution priorEvolution;
	
	/** Próxima evolução
	 */
	@Column
	private Evolution nextEvolution;
	
	@Column
	private int evolutionByLevel;
	
	@ManyToOne
	@JoinColumn(name="evolutionByStones")
	private Item evolutionByStones;
	
	/** Por troca
	 * */
	@Column 
	private Item evolutionByTrading;
	
	/** Por amizade
	 * */
	@Column
	private boolean evolutionByFriendship;
	
	@Column 
	private String evolutionByOtherCondition;
	
	@Column
	private boolean notEvolution;
	
	
	// Getters and Setters

	

	public int getEvolutionByLevel() {
		return evolutionByLevel;
	}

	public Evolution getPriorEvolution() {
		return priorEvolution;
	}

	public void setPriorEvolution(Evolution priorEvolution1) {
		this.priorEvolution = priorEvolution1;
	}

	public Evolution getNextEvolution() {
		return nextEvolution;
	}

	public void setNextEvolution(Evolution nextEvolution) {
		this.nextEvolution = nextEvolution;
	}

	public void setEvolutionByLevel(int evolutionByLevel) {
		this.evolutionByLevel = evolutionByLevel;
	}

	public Item getEvolutionByStones() {
		return evolutionByStones;
	}

	public void setEvolutionByStones(Item evolutionByStones) {
		this.evolutionByStones = evolutionByStones;
	}

	public Item isEvolutionByTrading() {
		return evolutionByTrading;
	}

	public void setEvolutionByTrading(Item evolutionByTrading) {
		this.evolutionByTrading = evolutionByTrading;
	}

	public boolean isEvolutionByFriendship() {
		return evolutionByFriendship;
	}

	public void setEvolutionByFriendship(boolean evolutionByFriendship) {
		this.evolutionByFriendship = evolutionByFriendship;
	}

	public String getEvolutionByOtherCondition() {
		return evolutionByOtherCondition;
	}

	public void setEvolutionByOtherCondition(String evolutionByOtherCondition) {
		this.evolutionByOtherCondition = evolutionByOtherCondition;
	}

	public boolean isNotEvolution() {
		return notEvolution;
	}

	public void setNotEvolution(boolean notEvolution) {
		this.notEvolution = notEvolution;
	}
	
	

}
