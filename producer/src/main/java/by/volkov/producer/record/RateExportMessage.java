package by.volkov.producer.record;

import lombok.Data;

import java.time.LocalDate;


@Data
public class RateExportMessage {
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
