package by.volkov.useraccount.account.service;

import by.volkov.useraccount.account.mapper.AccountMapper;
import by.volkov.useraccount.account.repository.AccountRepository;
import by.volkov.useraccount.account.vm.AccountVm;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
public class AccountServiceImpl implements AccountService {

    AccountRepository accountRepository;
    AccountMapper accountMapper;

    public AccountVm getUserAccountVm(Long userId, Long accountId) {
        //TODO: check if not found
        var account = accountRepository.getAccountByIdAndUserId(accountId, userId);
        return accountMapper.toVm(account);
    }
}
