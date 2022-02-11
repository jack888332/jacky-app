package part3.run_transaction_without_proxy.service;

import domain.Account;

import java.util.List;

public interface AccountService {
    void insert(Account account);

    void update(Account account);

    void delete(Integer accountId);

    Account findById(Integer accountId);

    List<Account> findAll();

    /**
     * @param sourceName
     * @param targetName
     * @param money
     */
    void transfer(String sourceName, String targetName, Float money);
}