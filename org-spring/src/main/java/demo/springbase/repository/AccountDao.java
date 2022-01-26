package demo.springbase.repository;

import demo.domain.Account;

import java.util.List;

public interface AccountDao {
    void save(Account account);

    void update(Account account);

    void delete(Integer accountId);

    Account findById(Integer accountId);

    List<Account> findAll();
}
