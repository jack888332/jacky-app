package part3.all_beans_with_annotation;

import domain.kit.MyJdbcUtils;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.core.JdbcTemplate;

import javax.sql.DataSource;

/**
 * 指定当前类是配置类（替代XML）
 */
@Configuration
/**
 * 指定要扫描哪些包中的组件，让IOC载入它们
 */
@ComponentScan("part2.some_beans_with_annotation")
public class MySpringConfig {
    // IOC 载入 JdbcTemplate 的实例
    @Bean(name = "template")
    public JdbcTemplate newJdbcTemplate(@Qualifier("ds1") DataSource ds) {
        return new JdbcTemplate(ds);
    }

    // IOC 载入 DataSource 的实例
    @Bean(name = "ds1")
    public DataSource newDataSource() {
        return MyJdbcUtils.getDataSource();
    }
}
