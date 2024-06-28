package br.com.tokio.teste.transferencias.controller;

import br.com.tokio.teste.transferencias.dto.PaginacaoDTO;
import br.com.tokio.teste.transferencias.dto.TransferenciaDTO;
import br.com.tokio.teste.transferencias.model.Transferencia;
import br.com.tokio.teste.transferencias.paged.Pagina;
import br.com.tokio.teste.transferencias.service.TransferenciaService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/v1/transferencia")
@Api(tags = "transferencia")
public class TransferenciaController {

    @Autowired
    TransferenciaService transferenciaService;

    @GetMapping
    @ApiOperation(value = "Listagem de todas as transferencias agendadas")
    public Pagina<Transferencia> listarAtivas(final PaginacaoDTO paginacao) {
        return transferenciaService.listar(paginacao);
    }

    @PostMapping
    @ApiOperation(value = "Cadastro de agendamento de transferencia")
    public Transferencia cadastrar(@Validated TransferenciaDTO transferencia) {
        return transferenciaService.cadastrar(transferencia);
    }

}
