package br.com.tokio.teste.transferencias.service;

import br.com.tokio.teste.transferencias.model.Taxa;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

@Service
public interface TaxaService {


    List<Taxa> listarAtivas();

    BigDecimal calcularValorTotalTransferencia(LocalDate dataTransferencia, BigDecimal valorTransferencia);

    Taxa encontrarTaxaParaDataTransferencia(LocalDate dataTransferencia);
}
