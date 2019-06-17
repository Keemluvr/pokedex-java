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
 * @see Serializable
 * @see Evolution
 * @see Pokemon
 * @see Item
 * 
 * @author	Keila Fernandes
 */
@Entity
@Table(name="evolution")
public class Evolution implements Serializable{

	// Para manter a compatibilidade com as versões dessa classe 
	private static final long serialVersionUID = 1L;
	
	/** Id que irá identificar a evolução, sendo que ele será único */
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO) //Cria automaticamente o id
	@Column(unique=true)
	private long id;
	
	/** Evolução anterior ou null caso não haja uma evolução anterior*/
	@Column
	private Evolution priorEvolution;
	
	/** Próxima evolução ou null caso não haja uma evolução posterior*/
	@Column
	private Evolution nextEvolution;
	
	/** Se o pokémon evolui por level, então deve-se passar nesse atributo o level
	 * que o pokémon evolui, se não evolui por level, coloca-se como null */
	@Column
	private int evolutionByLevel;
	
	/** Se o pokémon evolui por uma pedra, então deve-se passar nesse atributo qual 
	 * pedra que o pokémon usa para a próxima evolução, se não evolui por nenhuma, 
	 * coloca-se como null */
	@ManyToOne
	@JoinColumn(name="evolutionByStones")
	private Item evolutionByStones;
	
	/** Se o pokémon evolui por troca então deve-se passar nesse atributo qual 
	 * item que o pokémon usa para a próxima evolução, se não evolui por nenhuma, 
	 * coloca-se como null */
	@Column 
	private Item evolutionByTrading;
	
	/** Se o pokémon evolui por amizade, então deve-se passar nesse atributo um 
	 * booleano, onde true é para quando o pokémon evolui pela amizade e false é quando
	 * a próxima evolução não é pela amizade */
	@Column
	private boolean evolutionByFriendship;
	
	/** Se o pokémon evolui por outra condição, deve-se descrever como ele evolui, se não,
	 * passa o atributo como null */
	@Column 
	private String evolutionByOtherCondition;
	
	/** Se o pokémon não possui um próxima evolução, deve-se passar true nesse parâmetro */
	@Column
	private boolean notEvolution;
	
	
	//###########################  Getters and Setters  ###########################

	/** @return Retorna o level que que acontece a próxima evolução do pokémon */
	public int getEvolutionByLevel() {
		return evolutionByLevel;
	}

	/** @return Retorna a evolução que antecedeu o pokémon atual, se não possui uma evolução antecessora,
	 * retorna um null */
	public Evolution getPriorEvolution() {
		return priorEvolution;
	}

	/** Atribui uma evolução anterior para a evolução atual.
	 * @param priorEvolution - A evolução anterior */
	public void setPriorEvolution(Evolution priorEvolution) {
		this.priorEvolution = priorEvolution;
	}

	/** @return Retorna a próxima evolução do pokémon */
	public Evolution getNextEvolution() {
		return nextEvolution;
	}

	/** Atribui uma próxima evolução para a evolução atual. 
	 * @param nextEvolution - Próxima evolução do pokémon */
	public void setNextEvolution(Evolution nextEvolution) {
		this.nextEvolution = nextEvolution;
	}

	/** Atribui um nível para a próxima evolução do pokémon 
	 * @param  evolutionByLevel - O level em que o pokémon evolui para o próximo level */
	public void setEvolutionByLevel(int evolutionByLevel) {
		this.evolutionByLevel = evolutionByLevel;
	}

	/** @return Retorna a pedra que leva a próxima evolução do pokémon */
	public Item getEvolutionByStones() {
		return evolutionByStones;
	}

	/** Atribui a evolutionByStones qual pedra é reponsável pela próxima evolução do pokémon
	 * @param  evolutionByStones - Pedra que será responsável pela próxima evolução*/
	public void setEvolutionByStones(Item evolutionByStones) {
		this.evolutionByStones = evolutionByStones;
	}

	/** @return Retorna o item responsável pela evolução na hora da troca do pokémon */
	public Item isEvolutionByTrading() {
		return evolutionByTrading;
	}

	/** Atribui qual o item que ao se fazer a troca do pokémon deve acompanhá-lo, para que a
	 * evolução aconteça
	 * @param  evolutionByTrading - item que irá junto com a troca do pokémon */
	public void setEvolutionByTrading(Item evolutionByTrading) {
		this.evolutionByTrading = evolutionByTrading;
	}

	/** @return Retorna true se a próxima evolução acontece por amizade e false se não acontece por amizade */
	public boolean isEvolutionByFriendship() {
		return evolutionByFriendship;
	}

	/** Atribui um booleano para caso o pokémon evolua por amizade
	 * @param evolutionByFriendship - True se o pokémon evoluir para a próxima evolução por amizade 
	 * e false se não evoluir com amizade */
	public void setEvolutionByFriendship(boolean evolutionByFriendship) {
		this.evolutionByFriendship = evolutionByFriendship;
	}

	/** @return Retorna qual a outra condição que pode levar o pokémon a evoluir para a próxima evolução */
	public String getEvolutionByOtherCondition() {
		return evolutionByOtherCondition;
	}

	/** Atribui qual condição pode levar a próxima do pokémon
	 * @param evolutionByOtherCondition - Qual a condição para o pokémon evoluir */
	public void setEvolutionByOtherCondition(String evolutionByOtherCondition) {
		this.evolutionByOtherCondition = evolutionByOtherCondition;
	}

	/** @return Retorna se o pokémon possui uma próxima evolução */
	public boolean isNotEvolution() {
		return notEvolution;
	}

	/** Atribui ao pokémon se ele possui uma evolução ou não
	 * @param notEvolution -  true se o pokemon não possui uma próxima evolução e false para caso o pokémon 
	 * possua uma próxima evolução */
	public void setNotEvolution(boolean notEvolution) {
		this.notEvolution = notEvolution;
	}
	
	

}
