package by.volkov.producer.record;

import lombok.AccessLevel;
import lombok.Data;
import lombok.experimental.FieldDefaults;

import java.time.LocalDate;

@Data
@FieldDefaults(level = AccessLevel.PRIVATE)
public class RateExportMessage {

    Double sellRate;
    Currency sellIso;
    Integer sellCode;
    Double buyRate;
    Currency buyIso;
    Integer buyCode;
    Integer quantity;
    String name;
    LocalDate date;
}
