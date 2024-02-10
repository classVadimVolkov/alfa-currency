package by.volkov.producer.model;

import lombok.AccessLevel;
import lombok.Data;
import lombok.experimental.FieldDefaults;

import java.time.LocalDate;

@Data
@FieldDefaults(level = AccessLevel.PRIVATE)
public class Rate {

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
