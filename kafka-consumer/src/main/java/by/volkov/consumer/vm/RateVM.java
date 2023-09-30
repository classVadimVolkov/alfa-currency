package by.volkov.consumer.vm;

import by.volkov.consumer.model.Currency;
import lombok.AccessLevel;
import lombok.Data;
import lombok.experimental.FieldDefaults;

import java.time.LocalDate;

@Data
@FieldDefaults(level = AccessLevel.PRIVATE)
public class RateVM {

    Long id;
    Double sellRate;
    Currency sellIso;
    Integer sellCode;
    Double buyRate;
    Currency buyIso;
    Integer buyCode;
    Integer quantity;
    String currencyName;
    LocalDate rateDate;
}
