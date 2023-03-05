package by.volkov.consumer.service;

import by.volkov.consumer.entity.RateEntity;
import by.volkov.consumer.record.RateImportMessage;

public interface JpaRateService {

    RateEntity save(RateImportMessage message);
}
