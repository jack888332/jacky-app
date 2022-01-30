package demo.springbase.config_by_annotation.service;

import demo.domain.Account;
import demo.springbase.config_by_annotation.repository.AccountDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AccountServiceImpl implements AccountService {

    private AccountDao accountDao;

    //从IOC根据id找到对应的bean进行装配
    @Autowired
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
