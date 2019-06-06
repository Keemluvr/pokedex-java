package br.com.edu.ifsc.pokedex.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.edu.ifsc.pokedex.models.Nature;

//JpaRepository possui métodos prontos para se fazer persistência no banco de dados,
//então métodos como save, delete, findAll e entre outros. Então é só criar uma instância
//dessa interface (NatureRepository) e utilizar esses métodos no módulo NatureController.

/**
 * @see JpaRepository
 * @see Nature
 */

public interface NatureRepository extends JpaRepository<Nature, Long>{
	
	/* Método que procura uma única Nature pelo seu id. */
	Nature findById(long id);

	/** Método que procura uma única nature pelo seu nome. */
	Nature findByName(String name);
}
