package br.com.tokio.teste.transferencias.service;

import br.com.tokio.teste.transferencias.dto.PaginacaoDTO;
import br.com.tokio.teste.transferencias.dto.TransferenciaDTO;
import br.com.tokio.teste.transferencias.model.Transferencia;
import br.com.tokio.teste.transferencias.paged.Pagina;
import org.springframework.stereotype.Service;

@Service
public interface TransferenciaService {

    Pagina<Transferencia> listar(PaginacaoDTO paginacaoDTO);
    Transferencia cadastrar(TransferenciaDTO transferencia);

}
