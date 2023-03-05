package by.volkov.consumer.service;

import by.volkov.consumer.config.KafkaConsumerConfig;
import by.volkov.consumer.mapper.RateMapper;
import by.volkov.consumer.record.RateImportMessage;
import by.volkov.consumer.repository.RateRepository;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.apache.kafka.clients.consumer.ConsumerRecords;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Service;

import java.time.Duration;

@Slf4j
@AllArgsConstructor
@Service
public class RecordConsumerService implements ConsumerService {

    private static boolean isOpen = true;
    private static final Duration timeout = Duration.ofSeconds(5);
    private final KafkaConsumerConfig consumerConfig;
    private final RateService rateService;

    @EventListener(ApplicationReadyEvent.class)
    @Override
    public void receiveRecords() {
        try (var kafkaConsumer = consumerConfig.kafkaConsumer()) {
            while (isOpen) {
                log.info("Receiving records...");
                ConsumerRecords<String, RateImportMessage> records = kafkaConsumer.poll(timeout);
                records.forEach(record -> {
                    log.info("offset=" + record.offset());
                    log.info("partition=" + record.partition());
                    log.info("key=" + record.key());
                    log.info("value=" + record.value());
                    log.info("Message has been received");

                    rateService.save(record.value());
                });
           }
        }
    }
}
