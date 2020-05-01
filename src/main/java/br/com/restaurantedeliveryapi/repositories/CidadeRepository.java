package br.com.ranchodomirodeliveryapi.repositories;

import br.com.ranchodomirodeliveryapi.models.Cidade;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CidadeRepository extends JpaRepository<Cidade, Long> {
}
