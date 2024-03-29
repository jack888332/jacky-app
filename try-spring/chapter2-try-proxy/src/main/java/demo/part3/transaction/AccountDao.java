package demo.part3.transaction;

import demo.domain.Account;

import java.util.List;

public interface AccountDao {
    int insert(Account account);

    int update(Account account);

    int delete(Integer accountId);

    Account findById(Integer accountId);

    List<Account> findAll();

    Account findAccountByName(String accountName);
}
