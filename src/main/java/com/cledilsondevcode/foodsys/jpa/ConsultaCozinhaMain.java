//package com.cledilsondevcode.foodsys.jpa;
//
//import com.cledilsondevcode.foodsys.FoodsysApplication;
//import com.cledilsondevcode.foodsys.domain.repository.CozinhaRepository;
//import com.cledilsondevcode.foodsys.domain.model.Cozinha;
//import org.springframework.boot.WebApplicationType;
//import org.springframework.boot.builder.SpringApplicationBuilder;
//
//import java.util.List;
//
//public class ConsultaCozinhaMain {
//
//    public static void main(String[] args) {
//        var applicationContext = new SpringApplicationBuilder(FoodsysApplication.class)
//                .web(WebApplicationType.NONE)
//                .run(args);
//
//        CozinhaRepository cadastroCozinha = applicationContext.getBean(CozinhaRepository.class);
//
//        List<Cozinha> cozinhas = cadastroCozinha.listar();
//
//        for (Cozinha cozinha : cozinhas){
//            System.out.println(cozinha.getNome());
//        }
//    }
//
//}
