package by.volkov.consumer.service;

import by.volkov.consumer.entity.RateEntity;
import by.volkov.consumer.mapper.RateMapper;
import by.volkov.consumer.record.RateImportMessage;
import by.volkov.consumer.repository.RateRepository;
import by.volkov.consumer.vm.RateVM;
import lombok.Data;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Data
@Slf4j
public class RateService implements JpaRateService {

    private final RateRepository rateRepository;
    private final RateMapper rateMapper;

    @Override
    @Transactional
    public RateEntity save(RateImportMessage message) {
        var rateEntity = rateRepository.save(rateMapper.toEntity(message));
        log.info("Saved entity in DB: " + rateEntity);
        return rateEntity;
    }

    @Override
    public List<RateVM> getRateVMs() {
        return rateMapper.toVMs(rateRepository.findAll());
    }
}
