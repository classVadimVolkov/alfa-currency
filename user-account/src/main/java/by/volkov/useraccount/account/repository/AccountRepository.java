package by.volkov.useraccount.account.repository;

import by.volkov.useraccount.account.model.Account;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AccountRepository extends JpaRepository<Account, Long> {

    Account getAccountByIdAndUserId(Long id, Long userId);
}
