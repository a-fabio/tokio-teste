package br.com.tokio.teste.transferencias.repository;

import br.com.tokio.teste.transferencias.model.Transferencia;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TransferenciaRepository extends JpaRepository<Transferencia, Long> {



}
