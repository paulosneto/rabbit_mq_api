package com.api.backend.consumer_producer.consumer;

import com.api.backend.service.PagamentoService;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.Message;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Service;

@Service
public class PagamentoResponseSucessoConsumer {

    @Autowired
    private PagamentoService pagamentoService;

    @RabbitListener(queues = {"pagamento-response-sucesso"})
    public void receive(@Payload Message message){
        String payload = String.valueOf(message.getPayload());
        pagamentoService.sucessoPagamento(payload);
    }
}
