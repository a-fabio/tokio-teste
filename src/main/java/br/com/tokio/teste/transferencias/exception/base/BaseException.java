package br.com.tokio.teste.transferencias.exception.base;

public class BaseException extends RuntimeException {

        private static final long serialVersionUID = 9217130565625259969L;

        private Throwable erroThrowable;

        public BaseException() {
        }

        public BaseException(String msg) {
            super(msg);
        }

        public BaseException(String msg, Throwable cause) {
            super(msg, cause);
        }

        public BaseException(Throwable cause) {
            super(cause);
        }

        public Throwable getErroThrowable() {
            return erroThrowable;
        }

        public void setErroThrowable(Throwable erroThrowable) {
            this.erroThrowable = erroThrowable;
        }

}
