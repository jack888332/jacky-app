package mykit;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.sql.SQLException;

@Component
public class TransactionManager {
    @Autowired
    private BinderForThreadAndConnection binder;

    /**
     * 开始：取消自动提交
     */
    public void start() {
        try {
            binder.getConnectionInThread().setAutoCommit(false);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    /**
     * 提交事务
     */
    public void commit() {
        try {
            binder.getConnectionInThread().commit();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    /**
     * 回滚事务
     */
    public void rollback() {
        try {
            binder.getConnectionInThread().rollback();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    /**
     * 结束：关闭连接（连接仍在线程中）
     */
    public void close() {
        try {
            binder.getConnectionInThread().close();
            binder.unbind();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}