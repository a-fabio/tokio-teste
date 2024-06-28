package br.com.tokio.teste.transferencias.controller.advice;

import br.com.tokio.teste.transferencias.dto.RegraNegocioExceptionDTO;
import br.com.tokio.teste.transferencias.exception.DataAgendamentoRetroativaException;
import br.com.tokio.teste.transferencias.exception.DirecaoPaginacaoInvalidaException;
import br.com.tokio.teste.transferencias.exception.TaxaAplicavelNaoEncontradaParaDataException;
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
    public ResponseEntity<RegraNegocioExceptionDTO> handleDataAgendamentoRetroativa(Throwable e) {
        log.debug(e.getMessage(), e);

        return new ResponseEntity<>(new RegraNegocioExceptionDTO(e.getMessage(), HttpStatus.BAD_REQUEST, LocalDateTime.now().toString()), HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(value = {TaxaAplicavelNaoEncontradaParaDataException.class})
    public ResponseEntity<RegraNegocioExceptionDTO> handleTaxaAplicavelNaoEncontradaParaData(Throwable e) {
        log.debug(e.getMessage(), e);

        return new ResponseEntity<>(new RegraNegocioExceptionDTO(e.getMessage(), HttpStatus.BAD_REQUEST, LocalDateTime.now().toString()), HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(value = {DirecaoPaginacaoInvalidaException.class})
    public ResponseEntity<RegraNegocioExceptionDTO> handleDirecaoPaginacaoInvalida(Throwable e) {
        log.debug(e.getMessage(), e);

        return new ResponseEntity<>(new RegraNegocioExceptionDTO(e.getMessage(), HttpStatus.BAD_REQUEST, LocalDateTime.now().toString()), HttpStatus.BAD_REQUEST);
    }



}
