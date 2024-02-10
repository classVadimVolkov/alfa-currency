package by.volkov.consumer.record;

import by.volkov.consumer.model.Currency;
import lombok.AccessLevel;
import lombok.Data;
import lombok.experimental.FieldDefaults;

import java.time.LocalDateTime;

@Data
@FieldDefaults(level = AccessLevel.PRIVATE)
public class RateImportMessage {

    Double sellRate;
    Currency sellIso;
    Integer sellCode;
    Double buyRate;
    Currency buyIso;
    Integer buyCode;
    Integer quantity;
    String name;
    LocalDateTime date;
}
