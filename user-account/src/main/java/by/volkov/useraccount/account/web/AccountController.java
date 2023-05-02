package by.volkov.useraccount.account.web;

import by.volkov.useraccount.account.service.AccountService;
import by.volkov.useraccount.account.vm.AccountVm;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
@RequiredArgsConstructor
public class AccountController {

    private final AccountService accService;

    @GetMapping("/users/{userId}/accounts/{accountId}")
    public AccountVm getUserAccount(@PathVariable Long userId, @PathVariable Long accountId) {
        return accService.getUserAccountVm(userId, accountId);
    }
}
