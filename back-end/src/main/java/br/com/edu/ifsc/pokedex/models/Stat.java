package br.com.edu.ifsc.pokedex.models;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/** Classe que 
 * 
 * 
 * @Author	Keila Fernandes
 */

@Entity
@Table(name="stat")
public class Stat implements Serializable{

	// Para manter a compatibilidade com as versões dessa classe 
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.SEQUENCE) //Cria automaticamente o id
	private long id;
	
	/**
	 *  Poder de ataque do pokemon
	 */
	@Column(nullable = false)
	private int attack;
	
	/**
	 *  Poder de defesa do pokemon
	 */
	@Column(nullable = false)
	private int defense;
	
	/**
	 *  Ataque especial do pokemon
	 */
	@Column(nullable = false)
	private int specialAttack;
	
	/**
	 *  Ataque de defesa do pokemon
	 */
	@Column(nullable = false)
	private int specialDefense;
	
	/**
	 *  Velocidade do pokemon
	 */
	@Column(nullable = false)
	private int speed;

	
	// Getters and Setters
	
	public int getAttack() {
		return attack;
	}

	public void setAttack(int attack) {
		this.attack = attack;
	}

	public int getDefense() {
		return defense;
	}

	public void setDefense(int defense) {
		this.defense = defense;
	}

	public int getSpecialAttack() {
		return specialAttack;
	}

	public void setSpecialAttack(int specialAttack) {
		this.specialAttack = specialAttack;
	}

	public int getSpecialDefense() {
		return specialDefense;
	}

	public void setSpecialDefense(int specialDefense) {
		this.specialDefense = specialDefense;
	}

	public int getSpeed() {
		return speed;
	}

	public void setSpeed(int speed) {
		this.speed = speed;
	}
	
	
	
}
