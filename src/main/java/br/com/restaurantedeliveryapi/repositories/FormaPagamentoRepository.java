package br.com.ranchodomirodeliveryapi.repositories;

import br.com.ranchodomirodeliveryapi.models.FormaPagamento;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FormaPagamentoRepository extends JpaRepository<FormaPagamento, Long> {
}
