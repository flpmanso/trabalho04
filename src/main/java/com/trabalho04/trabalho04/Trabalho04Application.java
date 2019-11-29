package com.trabalho04.trabalho04;

import com.trabalho04.trabalho04.DAO.MarcacaoDAO;
import com.trabalho04.trabalho04.model.Marcacao;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.sql.Date;
import java.sql.Time;
import java.sql.Timestamp;
import java.time.LocalDate;
import java.util.Calendar;
import java.util.stream.LongStream;

@SpringBootApplication
public class Trabalho04Application {

    public static void main(String[] args) {
        SpringApplication.run(Trabalho04Application.class, args);
    }

    @Bean
    CommandLineRunner init(MarcacaoDAO marcacao) {
        return args -> {
            marcacao.deleteAll();
            LongStream.range(1, 11)
                    .mapToObj(i -> {
                        Marcacao m = new Marcacao();
                        m.setNome("Marcacao " + i);
                        m.setLongitude(i);
                        m.setLatitude(i);
                        m.setDataInclusao(Calendar.getInstance());
                        return m;
                    })
                    .map(v -> marcacao.save(v))
                    .forEach(System.out::println);
        };
    }
}

