package demo.part3.transaction.impl.use_proxy;

import demo.domain.Account;
import demo.kit.BinderForThreadAndConnection;
import demo.part3.transaction.AccountDao;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.sql.SQLException;
import java.util.List;

@Repository("accountDao2")
public class AccountDaoImpl implements AccountDao {
    @Autowired
    QueryRunner qr;
    @Autowired
    private BinderForThreadAndConnection binder;

    @Override
    public int insert(Account account) {
        int rows = 0;
        try {
            String sql = "insert into account(name, money) values (?, ?)";
            rows = qr.update(binder.getConnectionInThread(), sql, account.getName(), account.getMoney());
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return rows;
    }

    @Override
    public int update(Account account) {
        int rows = 0;
        try {
            String sql = "update account set name=?, money=? where id=?";
            rows = qr.update(binder.getConnectionInThread(), sql, account.getName(), account.getMoney(), account.getId());
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return rows;
    }

    @Override
    public int delete(Integer accountId) {
        int rows = 0;
        try {
            String sql = "delete from account where id=?";
            rows = qr.update(binder.getConnectionInThread(), sql, accountId);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return rows;
    }

    @Override
    public Account findById(Integer accountId) {
        // 建立DB连接，执行DML，返回单行
        try {
            String sql = "select * from account where id=?";
            return qr.query(binder.getConnectionInThread(), sql, new BeanHandler<>(Account.class), accountId);
        } catch (SQLException e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        }
    }

    @Override
    public List<Account> findAll() {
        // 建立DB连接，执行DML，返回多行
        try {
            String sql = "select * from account";
            return qr.query(binder.getConnectionInThread(), sql, new BeanListHandler<>(Account.class));
        } catch (SQLException e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        }
    }

    @Override
    public Account findAccountByName(String accountName) {
        // 建立DB连接，执行DML，返回多行
        try {
            String sql = "select * from account where name=?";
            List<Account> accounts = qr.query(binder.getConnectionInThread(), sql,
                    new BeanListHandler<>(Account.class), accountName);
            if (accounts == null || accounts.size() == 0) {
                return null;
            }
            if (accounts.size() > 1) {
                throw new RuntimeException("结果集不唯一，数据有问题");
            }
            return accounts.get(0);
        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        }
    }
}
