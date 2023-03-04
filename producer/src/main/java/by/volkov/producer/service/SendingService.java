package by.volkov.producer.service;

import by.volkov.producer.record.RateExportMessage;

import java.util.List;

public interface SendingService {

    void sendRecords(List<RateExportMessage> rateExportMessages);
}
