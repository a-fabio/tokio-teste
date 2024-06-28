package br.com.tokio.teste.transferencias.controller;

import br.com.tokio.teste.transferencias.model.Taxa;
import br.com.tokio.teste.transferencias.service.TaxaService;
import io.swagger.annotations.Api;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("api/v1/taxa")
@Api(tags = "taxa")
@Slf4j
public class TaxaController {

    @Autowired
    TaxaService taxaService;

    @GetMapping
    public List<Taxa> listar() {
        return taxaService.listar();
    }
}
