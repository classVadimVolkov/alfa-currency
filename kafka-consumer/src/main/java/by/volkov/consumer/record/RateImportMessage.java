package by.volkov.consumer.record;

import by.volkov.consumer.model.Currency;
import lombok.AccessLevel;
import lombok.Data;
import lombok.experimental.FieldDefaults;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Data
@FieldDefaults(level = AccessLevel.PRIVATE)
public class RateImportMessage {

    BigDecimal sellRate;
    Currency sellIso;
    Integer sellCode;
    BigDecimal buyRate;
    Currency buyIso;
    Integer buyCode;
    Integer quantity;
    String name;
    LocalDateTime date;
}
