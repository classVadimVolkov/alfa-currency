package by.volkov.producer.service;

import by.volkov.producer.record.RateExportMessage;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

import java.util.List;

@Slf4j
@AllArgsConstructor
@Service
public class RecordSendingService implements SendingService {

    private static final String TOPIC_NAME = "rate";
    private final KafkaTemplate<String, RateExportMessage> kafkaTemplate;


    @Override
    public void sendRecords(List<RateExportMessage> rateExportMessages) {
        //TODO: compare previous list of records with a new one to exclude duplicates
        // if there is a difference then send new data via Kafka
        rateExportMessages.forEach(rateExportMessage -> kafkaTemplate.send(TOPIC_NAME, rateExportMessage.getSellIso() + "to" + rateExportMessage.getBuyIso(), rateExportMessage));
        log.info("Record has been sent");
    }
}
