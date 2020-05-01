package br.com.ranchodomirodeliveryapi.repositories;

import br.com.ranchodomirodeliveryapi.models.Restaurante;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RestauranteRepository extends JpaRepository<Restaurante, Long> {
}
