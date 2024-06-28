package br.com.tokio.teste.transferencias.exception.base;

public class RegraNegocioException extends RuntimeException {

        private static final long serialVersionUID = 3892011224682365401L;

        private Throwable erroThrowable;

        public RegraNegocioException() {
        }

        public RegraNegocioException(String msg) {
            super(msg);
        }

        public RegraNegocioException(String msg, Throwable cause) {
            super(msg, cause);
        }

        public RegraNegocioException(Throwable cause) {
            super(cause);
        }

        public Throwable getErroThrowable() {
            return erroThrowable;
        }

        public void setErroThrowable(Throwable erroThrowable) {
            this.erroThrowable = erroThrowable;
        }

}
