package br.com.tokio.teste.transferencias.dto;

import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import java.math.BigDecimal;
import java.time.LocalDate;

@Data
public class TransferenciaDTO {

    private String numeroContaOrigem;
    private String numeroContaDestino;
    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
    private LocalDate dataRealizacaoTransferencia;
    private BigDecimal valor;

}
