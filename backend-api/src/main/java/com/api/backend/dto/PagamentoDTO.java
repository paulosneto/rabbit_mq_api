package com.api.backend.dto;

import java.math.BigDecimal;

public record PagamentoDTO(String numeroPedido, BigDecimal valor, String produto) {
}
