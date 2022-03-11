package part2.not_all_beans_in_xml.repository;

import domain.Account;

import java.util.List;

public interface UserDao {
    int insert(Account account);

    int update(Account account);

    int delete(Integer accountId);

    Account findById(Integer accountId);

    List<Account> findAll();
}
