package by.volkov.consumer.service;

import by.volkov.consumer.config.KafkaConsumerConfig;
import by.volkov.consumer.record.RateImportMessage;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import lombok.extern.slf4j.Slf4j;
import org.apache.kafka.clients.consumer.ConsumerRecords;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Service;

import java.time.Duration;

@Slf4j
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
@Service
public class RecordConsumerService implements ConsumerService {

    static boolean isOpen = true;
    static final Duration timeout = Duration.ofSeconds(5);

    final KafkaConsumerConfig consumerConfig;
    final RateService rateService;

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
