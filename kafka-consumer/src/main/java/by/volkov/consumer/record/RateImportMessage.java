package by.volkov.consumer.record;

import by.volkov.consumer.entity.Currency;
import lombok.Data;

import java.time.LocalDate;


@Data
public class RateImportMessage {
    private Double sellRate;
    private Currency sellIso;
    private Integer sellCode;
    private Double buyRate;
    private Currency buyIso;
    private Integer buyCode;
    private Integer quantity;
    private String name;
    private LocalDate date;
}
