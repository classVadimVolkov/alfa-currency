package by.volkov.useraccount.account.web;

import by.volkov.useraccount.account.service.AccountService;
import by.volkov.useraccount.account.vm.AccountVm;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
public class AccountController {

    AccountService accountService;

    @GetMapping("/users/{userId}/accounts/{accountId}")
    public AccountVm getUserAccount(@PathVariable Long userId, @PathVariable Long accountId) {
        return accountService.getUserAccountVm(userId, accountId);
    }
}
