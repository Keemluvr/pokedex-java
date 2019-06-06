package br.com.edu.ifsc.pokedex.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.edu.ifsc.pokedex.models.Item;

//JpaRepository possui métodos prontos para se fazer persistência no banco de dados,
//então métodos como save, delete, findAll e entre outros. Então é só criar uma instância
//dessa interface (ItemRepository) e utilizar esses métodos no módulo ItemController.

/**
* @see JpaRepository
* @see Item
*/
public interface ItemRepository extends JpaRepository<Item, Long>{

	/* Método que procura um único item pelo seu id. */
	Item findById(long id);

	/** Método que procura um único item pelo seu nome. */
	Item findByName(String name);
}
