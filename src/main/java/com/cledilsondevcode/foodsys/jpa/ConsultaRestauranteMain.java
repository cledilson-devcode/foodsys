//package com.cledilsondevcode.foodsys.jpa;
//
//import com.cledilsondevcode.foodsys.FoodsysApplication;
//import com.cledilsondevcode.foodsys.domain.model.FormaPagamento;
//import com.cledilsondevcode.foodsys.domain.repository.FormaPagamentoRepository;
//import com.cledilsondevcode.foodsys.domain.repository.RestauranteRepository;
//import com.cledilsondevcode.foodsys.domain.model.Restaurante;
//import org.springframework.boot.WebApplicationType;
//import org.springframework.boot.builder.SpringApplicationBuilder;
//
//import java.util.List;
//
//public class ConsultaRestauranteMain {
//
//    public static void main(String[] args) {
//        var applicationContext = new SpringApplicationBuilder(FoodsysApplication.class)
//                .web(WebApplicationType.NONE)
//                .run(args);
//
//        RestauranteRepository cadastroRestaurante = applicationContext.getBean(RestauranteRepository.class);
//
//        List<Restaurante> restaurantes = cadastroRestaurante.listar();
//
//        for (Restaurante restaurante : restaurantes){
//            System.out.printf("%s - %f - %s \n", restaurante.getNome(), restaurante.getTaxa_frete(), restaurante.getCozinha().getNome() );
//        }
//
//
//    }
//
//}
