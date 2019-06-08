package br.com.edu.ifsc.pokedex.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.edu.ifsc.pokedex.models.Stat;

//JpaRepository possui métodos prontos para se fazer persistência no banco de dados,
//então métodos como save, delete, findAll e entre outros. Então é só criar uma instância
//dessa interface (StatRepository) e utilizar esses métodos no módulo StatController.

/**
* @see JpaRepository
* @see Stat
*/

public interface StatRepository extends JpaRepository<Stat, Long>{
	
	/* Método que procura um único ovo pelo seu id. */
	Stat findById(long id);
}

