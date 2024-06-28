package br.com.tokio.teste.transferencias.exception;

import br.com.tokio.teste.transferencias.exception.base.RegraNegocioException;

public class DirecaoPaginacaoInvalidaException extends RegraNegocioException {

    private static final long serialVersionUID = -6314666642131729420L;

    public DirecaoPaginacaoInvalidaException(String msg) {
        super(msg);
    }
}
