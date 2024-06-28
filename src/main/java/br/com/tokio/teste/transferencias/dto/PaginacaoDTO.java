package br.com.tokio.teste.transferencias.dto;

import br.com.tokio.teste.transferencias.exception.DirecaoPaginacaoInvalidaException;
import io.micrometer.core.instrument.util.StringUtils;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.ToString;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

import static br.com.tokio.teste.transferencias.enumerator.MensagensException.DIRECAO_PAGINACAO_INVALIDA;

@Data
@EqualsAndHashCode
@NoArgsConstructor
public class PaginacaoDTO implements Serializable {

    public static final int DEFAULT_SIZE = 5;
    public static final int MAX_SIZE = Integer.MAX_VALUE;
    private String ordenacao;
    private String direcaoOrdenacao;
    private Integer tamanhoPagina;
    private Integer pagina;

    public void setToFullResult() {
        pagina = 1;
        tamanhoPagina = MAX_SIZE;
    }

    public PageRequest toPageRequest() {
        return PageRequest.of(pagina, tamanhoPagina);
    }

    public Pageable toPageable() {
        return toPageable(DEFAULT_SIZE, MAX_SIZE, toSort());
    }

    public Sort.Direction toDirection() {
        if (StringUtils.isEmpty(direcaoOrdenacao)) {
            return Sort.Direction.ASC;
        }
        return Sort.Direction.fromOptionalString(direcaoOrdenacao)
                .orElseThrow(() -> new DirecaoPaginacaoInvalidaException(DIRECAO_PAGINACAO_INVALIDA.getDescricao()));
    }

    public List<Sort.Order> toOrders() {
        if (!StringUtils.isEmpty(ordenacao)) {
            String[] ordenacoes = ordenacao.split(",");
            return Arrays.stream(ordenacoes).map(o -> new Sort.Order(toDirection(), o)).collect(Collectors.toList());
        } else {
            return Collections.emptyList();
        }
    }

    public Sort toSort(List<Sort.Order> ordenacoesAnteriores, List<Sort.Order> ordenacoesPosteriores) {
        List<Sort.Order> orders = new ArrayList<>();
        orders.addAll(ordenacoesAnteriores);
        orders.addAll(toOrders());
        orders.addAll(ordenacoesPosteriores);
        orders.add(Sort.Order.by("id")); // em último caso
        return Sort.by(orders);
    }

    public Sort toSort() {
        return toSort(Collections.emptyList(), Collections.emptyList());
    }

    public Pageable toPageable(Sort sort) {
        return toPageable(DEFAULT_SIZE, MAX_SIZE, sort);
    }

    public Pageable toPageable(int defaultSize, int maxSize, Sort sort) {
        int page = pagina == null || pagina < 1 ? 0 : (pagina - 1);
        int size;
        if (tamanhoPagina == null || tamanhoPagina <= 0) {
            size = defaultSize;
        } else if (tamanhoPagina > maxSize) {
            size = maxSize;
        } else {
            size = tamanhoPagina;
        }
        return PageRequest.of(page, size, sort);
    }
}