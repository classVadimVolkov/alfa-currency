package by.volkov.useraccount.account.vm;

import by.volkov.useraccount.account.entity.Currency;
import lombok.Data;

import java.math.BigDecimal;

@Data
public class AccountVm {

    private Long id;
    private BigDecimal balance;
    private Currency currency;
}
