package com.api.backend.service;

import com.api.backend.consumer_producer.producer.PagamentoRequestProducer;
import com.api.backend.dto.PagamentoDTO;
import com.fasterxml.jackson.core.JsonProcessingException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PagamentoService {

    @Autowired
    private PagamentoRequestProducer producer;

    public String solicitarPagamento(PagamentoDTO pagamentoDTO){
        try {
            producer.integrar(pagamentoDTO);
        }catch (JsonProcessingException e){
            return "Ocorreu um erro ao solicitar pagamento... " + e.getMessage();
        }

        return "Pagamento aguardando confirmação... ";
    }

    public void erroPagamento(String payload){
        System.err.println("========  ERRO  ========="+payload);
    }

    public void sucessoPagamento(String payload){
        System.out.println("=======  SUCESSO  ========"+payload);
    }


}
