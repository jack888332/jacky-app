package demo.springbase.repository;

import demo.domain.Account;
import demo.kit.MyJdbcUtils;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;

import java.util.List;
import java.util.Map;

public class AccountDaoImpl implements AccountDao {
    private JdbcTemplate template = new JdbcTemplate(MyJdbcUtils.getDataSource());

    @Override
    public void save(Account account) {
        String sql = "insert into account(name, money) values (?, ?)";
        template.update(sql, account.getName(), account.getMoney());
    }

    @Override
    public void update(Account account) {
        String sql = "update account set name=?, money=? where id=?";
        template.update(sql, account.getName(), account.getMoney(), account.getId());
    }

    @Override
    public void delete(Integer accountId) {
        String sql = "delete from account where id=?";
        template.update(sql, accountId);
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
