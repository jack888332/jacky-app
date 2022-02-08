package mykit;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.sql.SQLException;

@Component
public class TransactionManager {
    @Autowired
    BinderForThreadAndConnection binder;

    public void init(){
        try {
            binder.getConnectionInThread().setAutoCommit(false);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void commit(){
        try {
            binder.getConnectionInThread().commit();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void rollback(){
        try {
            binder.getConnectionInThread().rollback();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void close(){
        try {
            binder.getConnectionInThread().close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
