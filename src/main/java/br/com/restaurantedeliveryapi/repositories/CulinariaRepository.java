package br.com.restaurantedeliveryapi.repositories;

import br.com.restaurantedeliveryapi.models.Culinaria;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CulinariaRepository extends JpaRepository<Culinaria, Long> {
}
