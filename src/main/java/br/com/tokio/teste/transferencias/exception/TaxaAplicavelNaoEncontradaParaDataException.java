package br.com.tokio.teste.transferencias.exception;

import br.com.tokio.teste.transferencias.exception.base.RegraNegocioException;

public class TaxaAplicavelNaoEncontradaParaDataException extends RegraNegocioException {

    private static final long serialVersionUID = -5599970319445391416L;

    public TaxaAplicavelNaoEncontradaParaDataException() {
    }

    public TaxaAplicavelNaoEncontradaParaDataException(String msg) {
        super(msg);
    }

    public TaxaAplicavelNaoEncontradaParaDataException(String msg, Throwable cause) {
        super(msg, cause);
    }

    public TaxaAplicavelNaoEncontradaParaDataException(Throwable cause) {
        super(cause);
    }

}