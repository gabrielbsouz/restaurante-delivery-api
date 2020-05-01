package br.com.restaurantedeliveryapi.repositories;

import br.com.restaurantedeliveryapi.models.Permissao;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PermissaoRepository extends JpaRepository<Permissao, Long> {
}
