package by.volkov.useraccount.account.vm;

import by.volkov.useraccount.account.model.Currency;
import lombok.AccessLevel;
import lombok.Data;
import lombok.experimental.FieldDefaults;

import java.math.BigDecimal;

@Data
@FieldDefaults(level = AccessLevel.PRIVATE)
public class AccountVm {

    Long id;
    BigDecimal balance;
    Currency currency;
}
