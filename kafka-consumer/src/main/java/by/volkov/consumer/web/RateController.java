package by.volkov.consumer.web;

import by.volkov.consumer.service.RateService;
import by.volkov.consumer.vm.RateVM;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RequestMapping("/rates")
@RestController
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
public class RateController {

    RateService rateService;

    @GetMapping
    public List<RateVM> getRateVMs() {
        return rateService.getRateVMs();
    }
}
