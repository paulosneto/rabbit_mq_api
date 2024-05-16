package com.api.backend.domain;

import com.api.backend.dto.PagamentoDTO;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Pagamento {

    private String numeroPedido;
    private BigDecimal valor;
    private String produto;

    public Pagamento(PagamentoDTO pagamentoDTO) {
        this.numeroPedido = pagamentoDTO.numeroPedido();
        this.valor = pagamentoDTO.valor();
        this.produto = pagamentoDTO.produto();
    }
}
