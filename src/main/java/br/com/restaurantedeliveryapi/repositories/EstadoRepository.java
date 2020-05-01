package br.com.restaurantedeliveryapi.repositories;

import br.com.restaurantedeliveryapi.models.Estado;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EstadoRepository extends JpaRepository<Estado, Long> {
}
