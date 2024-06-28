package br.com.tokio.teste.transferencias.controller;

import br.com.tokio.teste.transferencias.dto.TransferenciaDTO;
import br.com.tokio.teste.transferencias.model.Transferencia;
import br.com.tokio.teste.transferencias.service.TransferenciaService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1/transferencia")
@Api(tags = "transferencia")
public class TransferenciaController {

    @Autowired
    TransferenciaService transferenciaService;

    @GetMapping
    @ApiOperation(value = "Listagem de todas as transferencias agendadas")
    public List<Transferencia> listarAtivas() {
        return transferenciaService.listar();
    }

    @PostMapping
    @ApiOperation(value = "Cadastro de agendamento de transferencia")
    public Transferencia cadastrar(@RequestBody TransferenciaDTO transferencia) {
        return transferenciaService.cadastrar(transferencia);
    }

}
