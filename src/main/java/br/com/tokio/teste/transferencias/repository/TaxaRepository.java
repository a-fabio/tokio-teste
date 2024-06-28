package br.com.tokio.teste.transferencias.repository;

import br.com.tokio.teste.transferencias.model.Taxa;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TaxaRepository extends JpaRepository<Taxa, Long> {

}
