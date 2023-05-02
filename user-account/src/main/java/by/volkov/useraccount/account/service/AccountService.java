package by.volkov.useraccount.account.service;

import by.volkov.useraccount.account.vm.AccountVm;

public interface AccountService {

    AccountVm getUserAccountVm(Long userId, Long accountId);
}
