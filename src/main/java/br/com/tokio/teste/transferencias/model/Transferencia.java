package br.com.tokio.teste.transferencias.model;

import lombok.Data;
import org.springframework.data.annotation.CreatedDate;

import javax.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDateTime;

@Entity
@Table(name = "TAXA")
@Data
public class Transferencia {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID_TRANSFERENCgIA")
    private Long id;

    @Column(name = "NR_CONTA_ORIGEM")
    private String numeroContaOrigem;

    @Column(name = "NR_CONTA_DESTINO")
    private String numeroContaDestino;

    @ManyToOne
    @JoinColumn(name = "ID_TAXA_APLICADA")
    private Taxa taxaAplicada;

    @Column(name = "VL_TRANSACAO")
    private BigDecimal valor;

    @Column(name = "VL_TRANSACAO_COM_TAXAS")
    private BigDecimal valorComTaxas;

    @Column(name = "DT_REALIZACAO")
    private LocalDateTime dataRealizacao;

    @CreatedDate
    @Column(name = "DT_CRIACAO", updatable = false)
    private LocalDateTime dataCriacao;
}
