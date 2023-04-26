package by.volkov.consumer.entity;

import lombok.Data;

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
public class RateEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "rate-gen")
    @SequenceGenerator(name = "rate-gen", sequenceName = "rate_seq", allocationSize = 1)
    private Long id;

    @Column(name = "sell_rate", nullable = false)
    private Double sellRate;

    @Column(name = "sell_iso", nullable = false)
    @Enumerated(EnumType.STRING)
    private Currency sellIso;

    @Column(name = "sell_code", nullable = false)
    private Integer sellCode;

    @Column(name = "buy_rate", nullable = false)
    private Double buyRate;

    @Column(name = "buy_iso", nullable = false)
    @Enumerated(EnumType.STRING)
    private Currency buyIso;

    @Column(name = "buy_code", nullable = false)
    private Integer buyCode;

    @Column(nullable = false)
    private Integer quantity;

    @Column(name = "currency_name")
    private String currencyName;

    @Column(name = "rate_date", nullable = false)
    private LocalDate rateDate;
}
