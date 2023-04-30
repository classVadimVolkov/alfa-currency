package by.volkov.useraccount.account.web;

import by.volkov.useraccount.account.service.AccountService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.RestController;

@RestController
@AllArgsConstructor
public class AccountController {

    private final AccountService accountService;
}
