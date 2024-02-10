package by.volkov.producer.service;

import by.volkov.producer.model.Rate;

import java.util.List;

public interface SendingService {

    void sendRecords(List<Rate> rates);
}
