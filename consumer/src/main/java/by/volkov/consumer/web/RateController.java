package by.volkov.consumer.web;

import by.volkov.consumer.service.RateService;
import by.volkov.consumer.vm.RateVM;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RequestMapping("/rates")
@RestController
@RequiredArgsConstructor
public class RateController {

    private final RateService rateService;

    @GetMapping
    public List<RateVM> getRateVMs() {
        return rateService.getRateVMs();
    }
}
