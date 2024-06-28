package br.com.tokio.teste.transferencias.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDate;

@Entity
@Table(name = "TRANSFERENCIA")
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@EntityListeners(AuditingEntityListener.class)
public class Transferencia {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID_TRANSFERENCIA", nullable = false)
    private Long id;

    @Column(name = "NR_CONTA_ORIGEM", nullable = false)
    private String numeroContaOrigem;

    @Column(name = "NR_CONTA_DESTINO", nullable = false)
    private String numeroContaDestino;

    @ManyToOne
    @JoinColumn(name = "ID_TAXA_APLICADA", nullable = false)
    private Taxa taxaAplicada;

    @Column(name = "VL_TRANSACAO", nullable = false)
    private BigDecimal valor;

    @Column(name = "VL_TRANSACAO_COM_TAXAS", nullable = false)
    private BigDecimal valorComTaxas;

    @Column(name = "DT_REALIZACAO", nullable = false)
    private LocalDate dataRealizacao;

    @CreatedDate
    @Column(name = "DT_CRIACAO", updatable = false, nullable = false)
    private LocalDate dataCriacao;
}
