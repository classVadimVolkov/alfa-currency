package by.volkov.useraccount.account.mapper;

import by.volkov.useraccount.account.model.Account;
import by.volkov.useraccount.account.vm.AccountVm;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface AccountMapper {

    AccountVm toVm(Account account);
}
