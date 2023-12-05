//package com.cledilsondevcode.foodsys.jpa;
//
//import com.cledilsondevcode.foodsys.FoodsysApplication;
//import com.cledilsondevcode.foodsys.domain.repository.CozinhaRepository;
//import com.cledilsondevcode.foodsys.domain.model.Cozinha;
//import org.springframework.boot.WebApplicationType;
//import org.springframework.boot.builder.SpringApplicationBuilder;
//
//public class ExclusaoCozinhaMain {
//
//    public static void main(String[] args) {
//        var applicationContext = new SpringApplicationBuilder(FoodsysApplication.class)
//                .web(WebApplicationType.NONE)
//                .run(args);
//
//        CozinhaRepository cadastroCozinha = applicationContext.getBean(CozinhaRepository.class);
//
//        Cozinha cozinha1 = new Cozinha();
//        cozinha1.setId(1L);
//
//        cadastroCozinha.remover(cozinha1);
//
//    }
//
//}
