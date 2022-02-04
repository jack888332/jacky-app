package part1.all_beans_in_xml.service;


import domain.Account;
import part1.all_beans_in_xml.repository.AccountDao;

import java.util.List;

public class AccountServiceImpl implements AccountService {
    private AccountDao accountDao;

    //从IOC根据id找到对应的bean进行赋值
    public void setAccountDao(AccountDao account) {
        this.accountDao = account;
    }

    @Override
    public void save(Account account) {
        int rows = accountDao.insert(account);
        if (rows > 0) {
            System.out.println("insert ok");
        }
    }

    @Override
    public void update(Account account) {
        int rows = accountDao.update(account);
        if (rows > 0) {
            System.out.println("update ok");
        }
    }

    @Override
    public void delete(Integer accountId) {
        int rows = accountDao.delete(accountId);
        if (rows > 0) {
            System.out.println("delete ok");
        }
    }

    @Override
    public Account findById(Integer accountId) {
        return accountDao.findById(accountId);
    }

    @Override
    public List<Account> findAll() {
        return accountDao.findAll();
    }
}
