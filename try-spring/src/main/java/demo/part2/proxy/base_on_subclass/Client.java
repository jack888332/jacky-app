package demo.part2.proxy.base_on_subclass;

import net.sf.cglib.proxy.Enhancer;
import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;

/**
 * 模拟：消费者通过代理商购买产品
 * 演示动态代理机制（基于子类）
 */
public class Client {
    public static void main(String[] args) {
        Producer producer = new Producer();

        Enhancer.create(producer.getClass(), new MethodInterceptor() {
            @Override
            public Object intercept(Object o, Method method, Object[] objects, MethodProxy methodProxy) throws Throwable {
                return 1;
            }
        });
    }
}
