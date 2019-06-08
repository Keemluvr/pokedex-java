package br.com.edu.ifsc.pokedex.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.edu.ifsc.pokedex.models.Type;

//JpaRepository possui métodos prontos para se fazer persistência no banco de dados,
//então métodos como save, delete, findAll e entre outros. Então é só criar uma instância
//dessa interface (TypeRepository) e utilizar esses métodos no módulo Pokemon.

/**
* @see JpaRepository
* @see Type
*/
@Repository
public interface TypeRepository extends JpaRepository<Type, Long>{

	/** Método que procura um único tipo pelo seu id. */
	Type findById(long id);
	
	/** Método que procura um único tipo pelo seu nome. */
	Type findByName(String name);
	
}
