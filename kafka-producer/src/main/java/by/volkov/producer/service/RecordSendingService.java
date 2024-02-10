package by.volkov.producer.service;

import by.volkov.producer.model.Rate;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.experimental.FieldDefaults;
import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.support.KafkaHeaders;
import org.springframework.messaging.Message;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
@Slf4j
public class RecordSendingService implements SendingService {

    static String TOPIC_NAME = "rate";

    static List<Rate> lastRates = new ArrayList<>();

    KafkaTemplate<String, Rate> kafkaTemplate;


    @Override
    public void sendRecords(List<Rate> rates) {
            rates.stream()
                    .filter(rate -> !lastRates.contains(rate))
                    .map(RecordSendingService::buildMessage)
                    .forEach(message -> {
                        kafkaTemplate.send(message);
                        log.info("Record has been sent");
                    });
            lastRates = rates;
    }

    private static Message<Rate> buildMessage(Rate rate) {
        return MessageBuilder.withPayload(rate)
                .setHeader(KafkaHeaders.TOPIC, TOPIC_NAME)
                .setHeader(KafkaHeaders.MESSAGE_KEY, rate.getSellIso() + "to" + rate.getBuyIso())
                .build();
    }
}
