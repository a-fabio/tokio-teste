package br.com.tokio.teste.transferencias.service;

import br.com.tokio.teste.transferencias.dto.PaginacaoDTO;
import br.com.tokio.teste.transferencias.model.Taxa;
import br.com.tokio.teste.transferencias.paged.Pagina;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.time.LocalDate;

@Service
public interface TaxaService {

    Taxa inativar (Long idTaxa);

    Pagina<Taxa> listarAtivas(PaginacaoDTO paginacao);

    Pagina<Taxa> listarInativas(PaginacaoDTO paginacao);

    BigDecimal calcularValorTotalTransferencia(LocalDate dataTransferencia, BigDecimal valorTransferencia);

    Taxa encontrarTaxaParaDataTransferencia(LocalDate dataTransferencia);
}
