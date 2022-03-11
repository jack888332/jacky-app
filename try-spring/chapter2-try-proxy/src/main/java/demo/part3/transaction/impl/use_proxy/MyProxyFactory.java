package demo.part3.transaction.impl.use_proxy;

import demo.kit.TransactionManager;
import demo.part3.transaction.AccountService;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

@Setter
@Component
public class MyProxyFactory {
    @Autowired
    @Qualifier("accountService2")
    AccountService accountService;
    @Autowired
    private TransactionManager tm;

    public AccountService getAccountService() {
        AccountService agency = (AccountService) Proxy.newProxyInstance(
                accountService.getClass().getClassLoader(),
                accountService.getClass().getInterfaces(),
                new InvocationHandler() {
                    @Override
                    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
                        Object result = null;
                        try {
                            tm.start();
                            result = method.invoke(accountService, args);
                            tm.commit();
                        } catch (Throwable e) {
                            e.printStackTrace();
                            tm.rollback();
                        } finally {
                            tm.close();
                        }
                        return result;
                    }
                });
        return agency;
    }
}
