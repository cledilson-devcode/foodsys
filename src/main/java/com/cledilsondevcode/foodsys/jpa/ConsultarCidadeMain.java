//package com.cledilsondevcode.foodsys.jpa;
//
//import com.cledilsondevcode.foodsys.FoodsysApplication;
//import com.cledilsondevcode.foodsys.domain.model.Cidade;
//import com.cledilsondevcode.foodsys.domain.model.Restaurante;
//import com.cledilsondevcode.foodsys.domain.repository.CidadeRepository;
//import com.cledilsondevcode.foodsys.domain.repository.RestauranteRepository;
//import org.springframework.boot.WebApplicationType;
//import org.springframework.boot.builder.SpringApplicationBuilder;
//
//import java.util.List;
//
//public class ConsultarCidadeMain {
//
//    public static void main(String[] args) {
//        var applicationContext = new SpringApplicationBuilder(FoodsysApplication.class)
//                .web(WebApplicationType.NONE)
//                .run(args);
//
//        CidadeRepository cadastraCidade = applicationContext.getBean(CidadeRepository.class);
//
//        List<Cidade> cidades = cadastraCidade.listar();
//
//        for (Cidade cidade : cidades){
//            System.out.printf("%s  - %s \n", cidade.getNome(), cidade.getEstado().getNome() );
//        }
//
//
//    }
//
//}
