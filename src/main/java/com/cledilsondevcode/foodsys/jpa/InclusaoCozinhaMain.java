//package com.cledilsondevcode.foodsys.jpa;
//
//import com.cledilsondevcode.foodsys.FoodsysApplication;
//import com.cledilsondevcode.foodsys.domain.repository.CozinhaRepository;
//import com.cledilsondevcode.foodsys.domain.model.Cozinha;
//import org.springframework.boot.WebApplicationType;
//import org.springframework.boot.builder.SpringApplicationBuilder;
//
//public class InclusaoCozinhaMain {
//
//    public static void main(String[] args) {
//        var applicationContext = new SpringApplicationBuilder(FoodsysApplication.class)
//                .web(WebApplicationType.NONE)
//                .run(args);
//
//        CozinhaRepository cadastroCozinha = applicationContext.getBean(CozinhaRepository.class);
//
//        Cozinha cozinha1 = new Cozinha();
//        cozinha1.setNome("Brasileira");
//
//        Cozinha cozinha2 = new Cozinha();
//        cozinha2.setNome("Japonesa");
//
//        cadastroCozinha.salvar(cozinha1);
//        cadastroCozinha.salvar(cozinha2);
//    }
//
//}
