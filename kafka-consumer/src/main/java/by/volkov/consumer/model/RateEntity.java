package by.volkov.consumer.model;

import lombok.AccessLevel;
import lombok.Data;
import lombok.experimental.FieldDefaults;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import java.time.LocalDate;

@Entity
@Table(name = "rate")
@Data
@FieldDefaults(level = AccessLevel.PRIVATE)
public class RateEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "rate-gen")
    @SequenceGenerator(name = "rate-gen", sequenceName = "rate_seq", allocationSize = 1)
    Long id;

    @Column(name = "sell_rate", nullable = false)
    Double sellRate;

    @Column(name = "sell_iso", nullable = false)
    @Enumerated(EnumType.STRING)
    Currency sellIso;

    @Column(name = "sell_code", nullable = false)
    Integer sellCode;

    @Column(name = "buy_rate", nullable = false)
    Double buyRate;

    @Column(name = "buy_iso", nullable = false)
    @Enumerated(EnumType.STRING)
    Currency buyIso;

    @Column(name = "buy_code", nullable = false)
    Integer buyCode;

    @Column(nullable = false)
    Integer quantity;

    @Column(name = "currency_name")
    String currencyName;

    @Column(name = "rate_date", nullable = false)
    LocalDate rateDate;
}
