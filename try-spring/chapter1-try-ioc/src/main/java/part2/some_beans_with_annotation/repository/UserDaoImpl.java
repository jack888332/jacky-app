package part2.some_beans_with_annotation.repository;

import domain.Account;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import javax.annotation.Resource;
import java.util.List;

//此类被载入IOC
@Repository("userDao")
public class UserDaoImpl implements UserDao {
    @Resource(name = "template")
    private JdbcTemplate template;

    @Override
    public int insert(Account account) {
        String sql = "insert into account(name, money) values (?, ?)";
        // 返回操作行数
        return template.update(sql, account.getName(), account.getMoney());
    }

    @Override
    public int update(Account account) {
        String sql = "update account set name=?, money=? where id=?";
        // 返回操作行数
        return template.update(sql, account.getName(), account.getMoney(), account.getId());
    }

    @Override
    public int delete(Integer accountId) {
        String sql = "delete from account where id=?";
        // 返回操作行数
        return template.update(sql, accountId);
    }

    @Override
    public Account findById(Integer accountId) {
        String sql = "select * from account where id=?";
        // 返回单行
        return template.queryForObject(sql, new BeanPropertyRowMapper<Account>(Account.class), accountId);
    }

    @Override
    public List<Account> findAll() {
        String sql = "select * from account";
        // 返回多行
        return template.query(sql, new BeanPropertyRowMapper<Account>(Account.class));
    }
}
