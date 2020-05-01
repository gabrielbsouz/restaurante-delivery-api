package br.com.ranchodomirodeliveryapi.repositories;

import br.com.ranchodomirodeliveryapi.models.Permissao;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PermissaoRepository extends JpaRepository<Permissao, Long> {
}
