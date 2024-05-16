package com.api.backend.controller;


import com.api.backend.dto.PagamentoDTO;
import com.api.backend.service.PagamentoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/pagamentos")
public class PagamentoFacadeController {

        @Autowired
        private PagamentoService pagamentoService;

        @PostMapping
        public ResponseEntity<String> processar(@RequestBody PagamentoDTO pagamentoDTO){
            return ResponseEntity.ok().body(pagamentoService.solicitarPagamento(pagamentoDTO));

        }


}
