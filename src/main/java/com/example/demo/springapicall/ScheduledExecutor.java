package com.example.demo.springapicall;

import com.example.demo.springapicall.model.CatFact;
import lombok.extern.slf4j.Slf4j;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.client.WebClient;
import org.springframework.web.reactive.function.client.WebClientResponseException;

@Component
@EnableScheduling
@Slf4j
public class ScheduledExecutor {

    @Scheduled(fixedRateString = "${app.schedule.rate-ms}")
    public void execute() {

        try {

            CatFact[] pronostico = WebClient.create() // crea un api client
                    .get().uri("https://cat-fact.herokuapp.com/facts")
                    .retrieve() // obtiene la respuesta
                    .bodyToMono(CatFact[].class) // interpreta el body JSON completo como un array de CatFact
                    .block();

            log.info("==== CAT FACTS =====");
            for (CatFact fact : pronostico) {
                log.info("* " + fact.getText());
            }

        } catch (WebClientResponseException responseException) {
            log.error("Se produjo un error en la consulta HTTP", responseException);
        }
    }

}
