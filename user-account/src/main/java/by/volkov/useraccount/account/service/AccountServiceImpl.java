package by.volkov.useraccount.account.service;

import by.volkov.useraccount.account.entity.Account;
import by.volkov.useraccount.account.mapper.AccountMapper;
import by.volkov.useraccount.account.repository.AccountRepository;
import by.volkov.useraccount.account.vm.AccountVm;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AccountServiceImpl implements AccountService {

    private final AccountRepository accRepo;
    private final AccountMapper mapper;

    public AccountVm getUserAccountVm(Long userId, Long accountId) {
        //TODO: check if not found
        Account accountByIdAndUserId = accRepo.getAccountByIdAndUserId(accountId, userId);
        return mapper.toVm(accountByIdAndUserId);
    }
}
