package part1.config_by_xml.service;

import domain.Account;

import java.util.List;

public interface AccountService {
    void save(Account account);

    void update(Account account);

    void delete(Integer accountId);

    Account findById(Integer accountId);

    List<Account> findAll();
}
