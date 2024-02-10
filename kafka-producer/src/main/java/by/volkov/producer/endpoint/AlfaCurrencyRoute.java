package by.volkov.producer.endpoint;

import by.volkov.producer.service.SendingService;
import by.volkov.producer.record.RateExportMessage;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import com.fasterxml.jackson.datatype.jsr310.deser.LocalDateDeserializer;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import lombok.extern.slf4j.Slf4j;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Arrays;
import java.util.List;

@Component
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
@Slf4j
public class AlfaCurrencyRoute {

    static HttpClient CLIENT = HttpClient.newHttpClient();

    static HttpRequest REQUEST = HttpRequest.newBuilder()
            .uri(URI.create("https://developerhub.alfabank.by:8273/partner/1.0.1/public/rates"))
            .GET()
            .build();

    static ObjectMapper MAPPER = new ObjectMapper()
            .registerModule(new JavaTimeModule().addDeserializer(LocalDate.class,
                    new LocalDateDeserializer(DateTimeFormatter.ofPattern("d.MM.yyyy"))));

    SendingService sendingService;

    @Scheduled(fixedRate = 5000)
    public void sendMessages() throws IOException, InterruptedException {
        HttpResponse<String> response = CLIENT.send(REQUEST, HttpResponse.BodyHandlers.ofString());
        JsonNode jsonNode = MAPPER.readTree(response.body());
        List<RateExportMessage> rateExportMessages = Arrays.asList(MAPPER.readValue(jsonNode.get("rates").toString(), RateExportMessage[].class));

        log.info(rateExportMessages.toString());
        if (!rateExportMessages.isEmpty()) {
            sendingService.sendRecords(rateExportMessages);
        }
    }
}
