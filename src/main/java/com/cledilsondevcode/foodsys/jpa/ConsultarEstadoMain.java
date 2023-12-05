//package com.cledilsondevcode.foodsys.jpa;
//
//import com.cledilsondevcode.foodsys.FoodsysApplication;
//import com.cledilsondevcode.foodsys.domain.model.Cozinha;
//import com.cledilsondevcode.foodsys.domain.model.Estado;
//import com.cledilsondevcode.foodsys.domain.repository.CozinhaRepository;
//import com.cledilsondevcode.foodsys.domain.repository.EstadoRepository;
//import org.springframework.boot.WebApplicationType;
//import org.springframework.boot.builder.SpringApplicationBuilder;
//
//import java.util.List;
//
//
//public class ConsultarEstadoMain {
//
//        public static void main(String[] args) {
//            var applicationContext = new SpringApplicationBuilder(FoodsysApplication.class)
//                    .web(WebApplicationType.NONE)
//                    .run(args);
//
//            EstadoRepository cadastroEstado = applicationContext.getBean(EstadoRepository.class);
//
//            List<Estado> estados = cadastroEstado.listar();
//
//            for (Estado estado : estados){
//                System.out.println(estado.getNome());
//            }
//        }
//
//}
//
