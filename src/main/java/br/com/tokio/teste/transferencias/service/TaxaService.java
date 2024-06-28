package br.com.tokio.teste.transferencias.service;

import br.com.tokio.teste.transferencias.model.Taxa;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface TaxaService {

    List<Taxa> listar();

}
