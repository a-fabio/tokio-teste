package br.com.tokio.teste.transferencias.exception;

import br.com.tokio.teste.transferencias.exception.base.RegraNegocioException;

public class DataAgendamentoRetroativaException extends RegraNegocioException {

    private static final long serialVersionUID = -5599970319445391416L;

    public DataAgendamentoRetroativaException(String msg) {
        super(msg);
    }

}
