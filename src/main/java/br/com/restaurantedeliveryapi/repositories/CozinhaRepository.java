package br.com.restaurantedeliveryapi.repositories;

import br.com.restaurantedeliveryapi.models.Cozinha;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CozinhaRepository extends JpaRepository<Cozinha, Long> {
}
