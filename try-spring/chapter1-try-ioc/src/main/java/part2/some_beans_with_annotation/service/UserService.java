package part2.some_beans_with_annotation.service;

import domain.Account;

import java.util.List;

public interface UserService {
    void save(Account account);

    void update(Account account);

    void delete(Integer accountId);

    Account findById(Integer accountId);

    List<Account> findAll();
}
