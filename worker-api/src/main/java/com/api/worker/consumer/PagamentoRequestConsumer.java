package com.api.worker.consumer;


import com.api.worker.service.PagamentoErroProducerService;
import com.api.worker.service.PagamentoSucessoProducerService;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.Message;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Component;

import java.util.Random;

@Component
public class PagamentoRequestConsumer {

    @Autowired
    private PagamentoErroProducerService erroProducerService;
    @Autowired
    private PagamentoSucessoProducerService sucessoProducerService;

    @RabbitListener(queues = {"pagamento-request-queue"})
    public void receberMessagem(@Payload Message message){
        System.out.println(message);
        if (new Random().nextBoolean()) {
            sucessoProducerService.gerarResposta("Messagem: Pagamento feito com sucesso... "+ message);
        }else{
            erroProducerService.gerarResposta("Erro ao processar pagamento... "+message);
        }
    }


}
