package demo.springbase.repository;

import demo.domain.Account;
import demo.kit.MyJdbcUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

@Repository //此类被载入IOC
public class AccountDaoImpl implements AccountDao {
    private JdbcTemplate template;

    @Autowired
    private void setJdbcTemplate(JdbcTemplate template) {
        this.template = template;
    }

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
