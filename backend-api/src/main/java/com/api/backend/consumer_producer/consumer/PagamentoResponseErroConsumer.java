package com.api.backend.consumer_producer.consumer;

import com.api.backend.service.PagamentoService;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.Message;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;

@Component
public class PagamentoResponseErroConsumer {

    @Autowired
    private PagamentoService pagamentoService;

    @RabbitListener(queues = {"pagamento-response-erro"})
    public void receive(@Payload Message message){
        System.out.println("Message - "+ message.getPayload() +" Data: "+ LocalDateTime.now());

        String payload = String.valueOf(message.getPayload());

        pagamentoService.erroPagamento(payload);
    }
}
