package br.com.restaurantedeliveryapi.repositories;

import br.com.restaurantedeliveryapi.models.Restaurante;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RestauranteRepository extends JpaRepository<Restaurante, Long> {
}
