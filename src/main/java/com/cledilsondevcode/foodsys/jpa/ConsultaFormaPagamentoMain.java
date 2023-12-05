//package com.cledilsondevcode.foodsys.jpa;
//
//import com.cledilsondevcode.foodsys.FoodsysApplication;
//import com.cledilsondevcode.foodsys.domain.model.FormaPagamento;
//import com.cledilsondevcode.foodsys.domain.repository.FormaPagamentoRepository;
//import org.springframework.boot.WebApplicationType;
//import org.springframework.boot.builder.SpringApplicationBuilder;
//
//import java.util.List;
//
//public class ConsultaFormaPagamentoMain {
//
//    public static void main(String[] args) {
//        var applicationContext = new SpringApplicationBuilder(FoodsysApplication.class)
//                .web(WebApplicationType.NONE)
//                .run(args);
//
//
//        FormaPagamentoRepository cadastroPagamento = applicationContext.getBean(FormaPagamentoRepository.class);
//
//        List<FormaPagamento> formaPagamentos = cadastroPagamento.listar();
//
//        for (FormaPagamento formaPagamento : formaPagamentos){
//            System.out.println(formaPagamento.getDescricao() );
//        }
//    }
//
//}
