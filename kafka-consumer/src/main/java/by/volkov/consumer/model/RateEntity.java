package by.volkov.consumer.model;

import lombok.AccessLevel;
import lombok.Data;
import lombok.experimental.FieldDefaults;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import java.math.BigDecimal;
import java.time.LocalDateTime;

@Entity
@Table(name = "rate")
@Data
@FieldDefaults(level = AccessLevel.PRIVATE)
public class RateEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;

    BigDecimal sellRate;

    @Enumerated(EnumType.STRING)
    Currency sellIso;

    Integer sellCode;

    BigDecimal buyRate;

    @Enumerated(EnumType.STRING)
    Currency buyIso;

    Integer buyCode;

    Integer quantity;

    String currencyName;

    LocalDateTime rateDate;
}
