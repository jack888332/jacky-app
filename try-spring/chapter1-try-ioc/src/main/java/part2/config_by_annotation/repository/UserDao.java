package part2.config_by_annotation.repository;

import domain.Account;

import java.util.List;

public interface UserDao {
    int insert(Account account);

    int update(Account account);

    int delete(Integer accountId);

    Account findById(Integer accountId);

    List<Account> findAll();
}
