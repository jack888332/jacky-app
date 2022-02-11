package part3.apply_to_transaction;

import domain.kit.MyDataSource;
import org.apache.commons.dbutils.QueryRunner;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.core.JdbcTemplate;

import javax.sql.DataSource;

@Configuration
@ComponentScan({"part3.run_transaction_without_proxy", "mykit"})
public class MySpringConfig {
    // IOC 载入 JdbcTemplate 的实例
    @Bean(name = "template")
    public JdbcTemplate newJdbcTemplate(@Qualifier("ds1") DataSource ds) {
        return new JdbcTemplate(ds);
    }

    // IOC 载入 DataSource 的实例
    @Bean(name = "ds1")
    public DataSource newDataSource() {
        return MyDataSource.getDataSource();
    }

    @Bean
    public QueryRunner newQueryRunner() {
        return new QueryRunner();
    }
}