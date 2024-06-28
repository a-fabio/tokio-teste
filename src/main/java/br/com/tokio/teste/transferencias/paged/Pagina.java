package br.com.tokio.teste.transferencias.paged;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.domain.Page;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Pagina<T> {

    private List<T> conteudo;
    private int pagina;
    private int quantidadePaginas;
    private long quantidadeResultados;

    public static <T> Pagina<T> fromPage(Page<T> page) {
        return new Pagina<>(page.getContent(), page.getNumber() + 1, page.getTotalPages(), page.getTotalElements());
    }

}
