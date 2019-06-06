package br.com.edu.ifsc.pokedex.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.edu.ifsc.pokedex.models.Evolution;


//JpaRepository possui métodos prontos para se fazer persistência no banco de dados,
//então métodos como save, delete, findAll e entre outros. Então é só criar uma instância
//dessa interface (EvolutionRepository) e utilizar esses métodos no módulo Pokemon.

/**
* @see JpaRepository
* @see Evolution
*/
public interface EvolutionRepository  extends JpaRepository<Evolution, Long>{

}
