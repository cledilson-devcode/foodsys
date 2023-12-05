//package com.cledilsondevcode.foodsys.jpa;
//
//import com.cledilsondevcode.foodsys.FoodsysApplication;
//import com.cledilsondevcode.foodsys.domain.model.FormaPagamento;
//import com.cledilsondevcode.foodsys.domain.model.Permissao;
//import com.cledilsondevcode.foodsys.domain.repository.PermissaoRepository;
//import org.springframework.boot.WebApplicationType;
//import org.springframework.boot.builder.SpringApplicationBuilder;
//
//import java.util.List;
//
//public class ConsultaPermissaoMain {
//
//    public static void main(String[] args) {
//        var applicationContext = new SpringApplicationBuilder(FoodsysApplication.class)
//                .web(WebApplicationType.NONE)
//                .run(args);
//
//
//        PermissaoRepository cadastroPermissao = applicationContext.getBean(PermissaoRepository.class);
//
//        List<Permissao> permissaos = cadastroPermissao.listar();
//
//        for (Permissao permissao : permissaos){
//            System.out.printf("Nome: %s - Descrição: %s \n", permissao.getNome(), permissao.getDescricao() );
//        }
//    }
//
//}
