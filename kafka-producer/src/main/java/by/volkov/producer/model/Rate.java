package by.volkov.producer.model;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.util.StdConverter;
import lombok.AccessLevel;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.FieldDefaults;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;

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
    @JsonDeserialize(converter = LocalDateToLocalDateTimeConverter.class)
    @EqualsAndHashCode.Exclude
    LocalDateTime date;

    private static class LocalDateToLocalDateTimeConverter extends StdConverter<LocalDate, LocalDateTime> {
        public LocalDateTime convert(LocalDate localDate) {
            return localDate.atTime(LocalTime.now());
        }
    }
}
