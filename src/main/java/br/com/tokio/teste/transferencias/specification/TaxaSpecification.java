package br.com.tokio.teste.transferencias.specification;

import br.com.tokio.teste.transferencias.enumerator.StatusTaxa;
import br.com.tokio.teste.transferencias.model.Taxa;
import br.com.tokio.teste.transferencias.model.Taxa_;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Component;

@Component
@Slf4j
public class TaxaSpecification {

    public Specification<Taxa> addClausula(Specification<Taxa> where, Specification<Taxa> clausula) {
        if (where == null) {
            return Specification.where(clausula);
        } else {
            return where.and(clausula);
        }
    }

    public Specification<Taxa> whereStatusTaxa(StatusTaxa status) {
        log.info("Adicionando cláusula whereStatusTaxa, valor: " + status.name());

        return (root, cq, cb) -> cb.equal(root.get(Taxa_.status), status.ordinal());
    }

    public Specification<Taxa> whereQuantidadeMinimaDiasMenorIgual(Long dias) {

        if (dias == null) return null;

        log.info("Adicionando cláusula whereQuantidadeMinimaDiasMenorIgual, valor: " + dias.toString());

        return (root, cq, cb) -> cb.lessThanOrEqualTo(root.get(Taxa_.quantidadeMinimaDias), dias);
    }

    public Specification<Taxa> whereQuantidadeMaximaDiasMaiorIgual(Long dias) {

        if (dias == null) return null;

        log.info("Adicionando cláusula whereQuantidadeMaximaDiasMaiorIgual, valor: " + dias.toString());

        return (root, cq, cb) -> cb.greaterThanOrEqualTo(root.get(Taxa_.quantidadeMaximaDias), dias);
    }

}
