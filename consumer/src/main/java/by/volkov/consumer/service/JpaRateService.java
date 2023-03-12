package by.volkov.consumer.service;

import by.volkov.consumer.entity.RateEntity;
import by.volkov.consumer.record.RateImportMessage;
import by.volkov.consumer.vm.RateVM;

import java.util.List;

public interface JpaRateService {

    RateEntity save(RateImportMessage message);

    List<RateVM> getRateVMs();
}
