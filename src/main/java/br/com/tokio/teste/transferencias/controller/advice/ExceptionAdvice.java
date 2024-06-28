package br.com.tokio.teste.transferencias.controller.advice;

import br.com.tokio.teste.transferencias.dto.RegraNegocioExceptionReturnDTO;
import br.com.tokio.teste.transferencias.exception.DataAgendamentoRetroativaException;
import br.com.tokio.teste.transferencias.exception.TaxaAplicavelNaoEncontradaParaDataException;
import br.com.tokio.teste.transferencias.exception.base.RegraNegocioException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.time.LocalDateTime;

@RestControllerAdvice
@Slf4j
public class ExceptionAdvice {

    @ExceptionHandler(value = {DataAgendamentoRetroativaException.class})
    public ResponseEntity<RegraNegocioExceptionReturnDTO> handleDataAgendamentoRetroativa(Throwable e) {
        log.debug(e.getMessage(), e);

        return new ResponseEntity<>(new RegraNegocioExceptionReturnDTO (e.getMessage(), HttpStatus.BAD_REQUEST, LocalDateTime.now().toString()), HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(value = {TaxaAplicavelNaoEncontradaParaDataException.class})
    public ResponseEntity<RegraNegocioExceptionReturnDTO> handleTaxaAplicavelNaoEncontradaParaData(Throwable e) {
        log.debug(e.getMessage(), e);

        return new ResponseEntity<>(new RegraNegocioExceptionReturnDTO (e.getMessage(), HttpStatus.BAD_REQUEST, LocalDateTime.now().toString()), HttpStatus.BAD_REQUEST);
    }

}
