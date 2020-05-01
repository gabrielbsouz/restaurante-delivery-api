package br.com.restaurantedeliveryapi.repositories;

import br.com.restaurantedeliveryapi.models.Cidade;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CidadeRepository extends JpaRepository<Cidade, Long> {
}
