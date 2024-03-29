package br.com.edu.ifsc.pokedex.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.edu.ifsc.pokedex.models.Pokemon;

//JpaRepository possui métodos prontos para se fazer persistência no banco de dados,
//então métodos como save, delete, findAll e entre outros. Então é só criar uma instância
//dessa interface (PokemonRepository) e utilizar esses métodos no módulo Pokemon.

/**
 * @see JpaRepository
 * @see Pokemon
 */

public interface PokemonRepository extends JpaRepository<Pokemon, Long> {

	/** Método que procura um único pokemon pelo seu id. */
	Pokemon findById(long id);
	
	/** Método que procura um único pokemon pelo seu nome. */
	Pokemon findByName(String name);
}
