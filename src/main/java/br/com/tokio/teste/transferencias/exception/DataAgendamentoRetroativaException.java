package br.com.tokio.teste.transferencias.exception;

import br.com.tokio.teste.transferencias.exception.base.RegraNegocioException;

public class DataAgendamentoRetroativaException extends RegraNegocioException {

    private static final long serialVersionUID = -5599970319445391416L;

    public DataAgendamentoRetroativaException() {
    }

    public DataAgendamentoRetroativaException(String msg) {
        super(msg);
    }

    public DataAgendamentoRetroativaException(String msg, Throwable cause) {
        super(msg, cause);
    }

    public DataAgendamentoRetroativaException(Throwable cause) {
        super(cause);
    }

}
