package br.com.tokio.teste.transferencias.repository;

import br.com.tokio.teste.transferencias.enumerator.StatusTaxa;
import br.com.tokio.teste.transferencias.model.Taxa;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TaxaRepository extends JpaRepository<Taxa, Long>, JpaSpecificationExecutor<Taxa> {

    @Query("SELECT t FROM Taxa t WHERE t.status = :status")
    public List<Taxa> findByStatus(StatusTaxa status);

}
