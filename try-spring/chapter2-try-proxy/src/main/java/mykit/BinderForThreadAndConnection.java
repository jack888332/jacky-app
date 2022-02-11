package mykit;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.sql.DataSource;
import java.sql.Connection;

@Component
public class BinderForThreadAndConnection {
    private ThreadLocal<Connection> tl = new ThreadLocal<>();
    @Autowired
    private DataSource dataSource;

    /**
     * 从数据库获取一个连接，并绑定到一个线程
     * @return
     */
    public Connection getConnectionInThread() {
        try{
            //1.先从ThreadLocal上获取
            Connection connection = tl.get();
            //2.判断当前线程上是否有连接
            if (connection == null) {
                //3.从数据源中获取一个连接，并且存入ThreadLocal中
                connection = dataSource.getConnection();
                tl.set(connection);
            }
            //4.返回当前线程上的连接
            return connection;
        }catch (Exception e){
            throw new RuntimeException(e);
        }
    }

    public void unbind(){
        tl.remove();
    }
}