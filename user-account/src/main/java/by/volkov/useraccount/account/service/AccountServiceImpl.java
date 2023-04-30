package by.volkov.useraccount.account.service;

import by.volkov.useraccount.account.repository.AccountRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class AccountServiceImpl implements AccountService {

    private final AccountRepository accRepo;
}
