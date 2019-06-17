package br.com.edu.ifsc.pokedex.models;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;

/**Classe que vai modelar os status do Pokémon
 * 
 * @see Pokemon
 * @see Serializable
 * 
 * @author Keila Fernandes
 */
@MappedSuperclass //Define uma super classe mapeada. A super classe mapeada não é uma classe de persistência, porém permite o mapeamento de atributos comuns para subclasses
public class Stat implements Serializable {

	// Para manter a compatibilidade com as versões dessa classe
	private static final long serialVersionUID = 1L;

	/** Id que irá identificar o ovo, sendo que ele será único.
	 * Esse id também será o id do pokémon, pois pokémon herda esses status. */
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO) //Cria automaticamente o id
	@Column(unique=true)
	private long id;
	
	
	/** Poder de ataque do pokémon */
	@Column(nullable = false)
	private int attack;

	/** Poder de defesa do pokémon */
	@Column(nullable = false)
	private int defense;

	/** Ataque especial do pokémon */
	@Column(nullable = false)
	private int speedAttack;

	/** Ataque de defesa do pokémon */
	@Column(nullable = false)
	private int speedDefense;

	/** Velocidade do pokémon */
	@Column(nullable = false)
	private int speed;

	
	//###########################  Getters and Setters  ###########################

	/** @return Retorna o id do pokémon e consequentemente dos status */
	public long getId() {
		return id;
	}

	/** Atribui um novo valor para o id 
	 * @param id - Novo id*/
	public void setId(long id) {
		this.id = id;
	}
	
	/** @return Retorna o quantidade de ataque que o pokémon possui */
	public int getAttack() {
		return attack;
	}

	/** Atribui uma nova quantidade de ataque que o pokémon possui
	 * @param attack - Nova quantidade de attack */
	public void setAttack(int attack) {
		this.attack = attack;
	}

	/** @return Retorna a quantidade de defesa que o pokémon possui */
	public int getDefense() {
		return defense;
	}

	/** Atribui uma nova quantidade de defesa que o pokémon possui
	 * @param defense - Nova quantidade de defesa */
	public void setDefense(int defense) {
		this.defense = defense;
	}

	/** @return Retorna a velocidade de ataque que o pokémon possui */
	public int getSpeedAttack() {
		return speedAttack;
	}

	/** Atribui uma nova velocidade de ataque que o pokémon possui
	 * @param speedAttack - Nova velocidade de ataque */
	public void setSpeedAttack(int speedAttack) {
		this.speedAttack = speedAttack;
	}

	/** @return Retorna a velocidade de defesa do pokémon */
	public int getSpeedDefense() {
		return speedDefense;
	}

	/** Atribui uma nova velocidade de defesa do pokémon 
	 * @param speedDefense - Nova velocidade de ataque */
	public void setSpeedDefense(int speedDefense) {
		this.speedDefense = speedDefense;
	}

	/** @return Retorna a velocidade do pokémon */
	public int getSpeed() {
		return speed;
	}

	/** Atribui uma nova velocidade que o pokémon pode ter
	 * @param speed - Nova velocidade do pokémon*/
	public void setSpeed(int speed) {
		this.speed = speed;
	}

}
