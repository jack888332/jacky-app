package part2.some_beans_with_annotation.service;

import domain.Account;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import part2.some_beans_with_annotation.repository.UserDao;

import java.util.List;

@Service("userService")
public class UserServiceImpl implements UserService {
    //从IOC根据id找到对应的bean进行装配
    @Autowired
    private UserDao accountDao;

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
