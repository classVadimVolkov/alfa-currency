package by.volkov.consumer.vm;

import by.volkov.consumer.entity.Currency;
import lombok.Data;

import java.time.LocalDate;

@Data
public class RateVM {

    private Long id;
    private Double sellRate;
    private Currency sellIso;
    private Integer sellCode;
    private Double buyRate;
    private Currency buyIso;
    private Integer buyCode;
    private Integer quantity;
    private String currencyName;
    private LocalDate rateDate;
}
