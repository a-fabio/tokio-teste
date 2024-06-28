package br.com.tokio.teste.transferencias.service;

import br.com.tokio.teste.transferencias.dto.TransferenciaDTO;
import br.com.tokio.teste.transferencias.model.Transferencia;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface TransferenciaService {

    List<Transferencia> listar();
    Transferencia cadastrar(TransferenciaDTO transferencia);

}
