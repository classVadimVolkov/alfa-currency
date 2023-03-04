package by.volkov.producer.endpoints;

import by.volkov.producer.service.SendingService;
import by.volkov.producer.record.RateExportMessage;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import com.fasterxml.jackson.datatype.jsr310.deser.LocalDateDeserializer;
import lombok.AllArgsConstructor;
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

@Slf4j
@AllArgsConstructor
@Component
public class AlfaCurrencyRoute {
    private static final ObjectMapper mapper = new ObjectMapper()
            .registerModule(new JavaTimeModule().addDeserializer(LocalDate.class,
                    new LocalDateDeserializer(DateTimeFormatter.ofPattern("d.MM.yyyy"))));
    private static final HttpClient client = HttpClient.newHttpClient();
    private static final HttpRequest request = HttpRequest.newBuilder()
            .uri(URI.create("https://developerhub.alfabank.by:8273/partner/1.0.1/public/rates"))
            .GET()
            .build();

    private SendingService sendingService;

    @Scheduled(fixedRate = 5000)
    public void sendMessages() throws IOException, InterruptedException {
        HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());
        JsonNode jsonNode = mapper.readTree(response.body());
        List<RateExportMessage> rateExportMessages = Arrays.asList(mapper.readValue(jsonNode.get("rates").toString(), RateExportMessage[].class));

        log.info(rateExportMessages.toString());
        sendingService.sendRecords(rateExportMessages);
    }
}
