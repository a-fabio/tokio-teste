package br.com.tokio.teste.transferencias.enumerator;

import lombok.AllArgsConstructor;
import lombok.Getter;


@Getter
@AllArgsConstructor
public enum MensagensException {

    DATA_AGENDAMENTO_RETROATIVA(1,"ERRO-0001: Não é permitido agendar transferência para data retroativa!"),
    TAXA_APLICAVEL_NAO_ENCONTRADA_PARA_DATA(2, "ERRO-0002: Não há taxa ativa aplicável para data informada!"),
    DIRECAO_PAGINACAO_INVALIDA(3, "ERRO-0003: Direção da paginação inválida informada!");

    private Integer codigo;
    private String descricao;
}
