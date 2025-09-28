package org.example.View;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.example.Model.InscreaveseRepository;
import org.example.Model.SeguroIncrevase;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.Arrays;


@Configuration

public class LoadDatabase {
    Logger logger = LogManager.getLogger(this.getClass());


    @Bean
    CommandLineRunner initDatabase(InscreaveseRepository repository){
        return args -> {
                SeguroIncrevase seguro1 = new SeguroIncrevase( "Fernanda","rose","065151515","fernada@gmail.com","1234");
                ;
                repository.saveAll(Arrays.asList(seguro1));
                logger.info("Usuários salvos no banco de dados");
        };
    }

}
