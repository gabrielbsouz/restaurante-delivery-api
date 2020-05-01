package br.com.restaurantedeliveryapi.repositories;

import br.com.restaurantedeliveryapi.models.FormaPagamento;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FormaPagamentoRepository extends JpaRepository<FormaPagamento, Long> {
}
