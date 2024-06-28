package br.com.tokio.teste.transferencias.service.impl;

import br.com.tokio.teste.transferencias.model.Taxa;
import br.com.tokio.teste.transferencias.repository.TaxaRepository;
import br.com.tokio.teste.transferencias.service.TaxaService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TaxaServiceImpl implements TaxaService {

    @Autowired private TaxaRepository taxaRepository;

    @Override
    public List<Taxa> listar() {
        return taxaRepository.findAll();
    }
}
