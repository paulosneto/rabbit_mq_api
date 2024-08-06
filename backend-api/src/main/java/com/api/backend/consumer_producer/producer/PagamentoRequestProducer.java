package com.api.backend.consumer_producer.producer;

import com.api.backend.dto.PagamentoDTO;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

// "Componet" que conterá a classe de injeção de comunicação com o rabbitmq(AMQTemplate)
@Component
public class PagamentoRequestProducer {

    // Injeção de dependência para leitura e demanda das filas
    @Autowired
    private AmqpTemplate amqpTemplate;

    // Usado para deserializar os objetos strings enviado para o servidor
    private final ObjectMapper objectMapper = new ObjectMapper();

    public void integrar(PagamentoDTO pagamentoDTO) throws JsonProcessingException {
        amqpTemplate.convertAndSend(
                "pagamento-request-exchange",
                "pagamento-request-rout-key",
                objectMapper.writeValueAsString(pagamentoDTO));
    }
}
