package br.com.tokio.teste.transferencias.controller;

import br.com.tokio.teste.transferencias.dto.PaginacaoDTO;
import br.com.tokio.teste.transferencias.model.Taxa;
import br.com.tokio.teste.transferencias.paged.Pagina;
import br.com.tokio.teste.transferencias.service.TaxaService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;
import java.time.LocalDate;

@RestController
@RequestMapping("api/v1/taxa/")
@Api(tags = "taxa")
@Slf4j
public class TaxaController {

    @Autowired
    TaxaService taxaService;

    @GetMapping
    @ApiOperation(value = "Listagem de todas as taxas ativas")
    public Pagina<Taxa> listarAtivas(final PaginacaoDTO paginacao) {
        return taxaService.listarAtivas(paginacao);
    }

    @GetMapping("inativas")
    @ApiOperation(value = "Listagem de todas as taxas inativas")
    public Pagina<Taxa> listarInativas(final PaginacaoDTO paginacao) {
        return taxaService.listarInativas(paginacao);
    }

    @GetMapping("inativar/{idTaxa}")
    @ApiOperation(value = "Listagem de todas as taxas inativas")
    public Taxa inativar(@PathVariable("idTaxa") final Long idTaxa) {
        return taxaService.inativar(idTaxa);
    }

    @GetMapping("calcular/{dataTransferencia}/{valorTransferencia}")
    @ApiOperation(value = "Calcular valor final da transferência incluindo taxas de acordo com data da realização")
    public BigDecimal calcular(@PathVariable("dataTransferencia") @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate dataTransferencia, @PathVariable("valorTransferencia") BigDecimal valorTransferencia) {
        return taxaService.calcularValorTotalTransferencia(dataTransferencia, valorTransferencia);
    }
}
