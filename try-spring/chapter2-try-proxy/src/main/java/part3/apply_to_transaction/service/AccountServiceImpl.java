package part3.apply_to_transaction.service;

import domain.Account;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import part3.apply_to_transaction.repository.AccountDao;

import java.util.List;

/**
 * 事务控制应该在业务层，不应该在持久层。
 * 同属一个事务的若干DM（数据库修改）操作，不应该各自新建DB连接，而是应该由一个线程统一管理，公用一个DB连接
 */
@Service
public class AccountServiceImpl implements AccountService {
    @Autowired
    private AccountDao accountDao;

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

    @Override
    public void transfer(String sourceName, String targetName, Float money) {
        System.out.println("transfer....");
        //2.1根据名称查询转出账户
        Account source = accountDao.findAccountByName(sourceName);
        //2.2根据名称查询转入账户
        Account target = accountDao.findAccountByName(targetName);
        //2.3转出账户减钱
        source.setMoney(source.getMoney() - money);
        //2.4转入账户加钱
        target.setMoney(target.getMoney() + money);
        //2.5更新转出账户
        accountDao.update(source);
//            int i=1/0;
        //2.6更新转入账户
        accountDao.update(target);
    }
}