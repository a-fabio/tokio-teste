package br.com.tokio.teste.transferencias.service.impl;

import br.com.tokio.teste.transferencias.enumerator.StatusTaxa;
import br.com.tokio.teste.transferencias.enumerator.MensagensException;
import br.com.tokio.teste.transferencias.exception.DataAgendamentoRetroativaException;
import br.com.tokio.teste.transferencias.exception.TaxaAplicavelNaoEncontradaParaDataException;
import br.com.tokio.teste.transferencias.model.Taxa;
import br.com.tokio.teste.transferencias.repository.TaxaRepository;
import br.com.tokio.teste.transferencias.service.TaxaService;
import br.com.tokio.teste.transferencias.specification.TaxaSpecification;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.List;
import java.util.Optional;

@Service
public class TaxaServiceImpl implements TaxaService {

    @Autowired private TaxaRepository taxaRepository;
    @Autowired private TaxaSpecification taxaSpecification;

    @Override
    public List<Taxa> listarAtivas() {
        return taxaRepository.findByStatus(StatusTaxa.ATIVA);
    }

    @Override
    public BigDecimal calcularValorTotalTransferencia(LocalDate dataTransferencia, BigDecimal valorTransferencia) {

        Taxa taxaEncontrada = encontrarTaxaParaDataTransferencia(dataTransferencia);

        BigDecimal valorTaxa = calcularValorTaxa(taxaEncontrada, valorTransferencia);

        return valorTransferencia.add(valorTaxa).add(taxaEncontrada.getValorAgravoDesconto());
    }

    @Override
    public Taxa encontrarTaxaParaDataTransferencia(LocalDate dataTransferencia) {
        Long intervaloDataTransferenciaDataAtual = calcularDiasAteTransferencia(dataTransferencia);

        Specification<Taxa> where = null;

        where = taxaSpecification.addClausula(where, taxaSpecification.whereStatusTaxa(StatusTaxa.ATIVA));;
        where = taxaSpecification.addClausula(where, taxaSpecification.whereQuantidadeMinimaDiasMenorIgual(intervaloDataTransferenciaDataAtual));
        where = taxaSpecification.addClausula(where, taxaSpecification.whereQuantidadeMaximaDiasMaiorIgual(intervaloDataTransferenciaDataAtual));

        Optional<Taxa> taxaEncontrada = taxaRepository.findOne(where);

        if (taxaEncontrada.isEmpty()) throw new TaxaAplicavelNaoEncontradaParaDataException(MensagensException.TAXA_APLICAVEL_NAO_ENCONTRADA_PARA_DATA.getDescricao());

        return taxaEncontrada.get();
    }

    private Long calcularDiasAteTransferencia(LocalDate dataTransferencia) {

        if (dataTransferencia.isBefore(LocalDate.now())) throw new DataAgendamentoRetroativaException(MensagensException.DATA_AGENDAMENTO_RETROATIVA.getDescricao());

        return ChronoUnit.DAYS.between(LocalDate.now(), dataTransferencia);
    }

    private BigDecimal calcularValorTaxa(Taxa taxa, BigDecimal valorTransferencia) {

        return valorTransferencia.multiply(new BigDecimal(taxa.getValorPorcentagemTaxa()).divide(BigDecimal.valueOf(100)));
    }
}
