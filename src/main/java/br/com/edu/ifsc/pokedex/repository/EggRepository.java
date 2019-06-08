package br.com.edu.ifsc.pokedex.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.edu.ifsc.pokedex.models.Egg;

//JpaRepository possui métodos prontos para se fazer persistência no banco de dados,
//então métodos como save, delete, findAll e entre outros. Então é só criar uma instância
//dessa interface (EggRepository) e utilizar esses métodos no módulo EggController.

/**
 * @see JpaRepository
 * @see Egg
 */

public interface EggRepository extends JpaRepository<Egg, Long>{
	
	/* Método que procura um único ovo pelo seu id. */
	Egg findById(long id);

	/** Método que procura um único ovo pelo seu nome. */
	Egg findByName(String name);
}
