package br.com.tokio.teste.transferencias.model;

import br.com.tokio.teste.transferencias.enumerator.StatusTaxa;
import lombok.*;

import javax.persistence.*;
import java.math.BigDecimal;

@Entity
@Table(name = "TAXA")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Taxa {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID_TAXA")
    private Long id;

    @Column(name = "QTD_DIAS_MINIMO", updatable = false)
    private Long quantidadeMinimaDias;

    @Column(name = "QTD_DIAS_MAXIMO", updatable = false)
    private Long quantidadeMaximaDias;

    @Column(name = "VL_AGRAVO_DESCONTO", updatable = false)
    private BigDecimal valorAgravoDesconto;

    @Column(name = "VL_PORCENTAGEM_TAXA", updatable = false)
    private Double valorPorcentagemTaxa;

    @Enumerated(EnumType.ORDINAL)
    @Column(name = "NR_STATUS")
    private StatusTaxa status;

}
