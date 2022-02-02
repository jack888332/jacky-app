package demo.part2.proxy.base_on_interface;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * 模拟：消费者通过代理商购买产品
 * 演示动态代理机制（基于接口）
 */
public class Client {
    public static void main(String[] args) {
        Producer producer = new Producer();

        AgencyContract agency = (AgencyContract) Proxy.newProxyInstance(
                producer.getClass().getClassLoader(),
                producer.getClass().getInterfaces(),
                new InvocationHandler() {
                    /**
                     * 在执行被代理对象的方法（在其接口中被定义）前，都经过此方法预处理
                     * @param proxy    代理对象的引用
                     * @param method   要代理执行的方法
                     * @param args     要代理执行的方法所需的形参
                     * @return 与要代理执行的方法，有相同的返回值
                     */
                    @Override
                    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
                        Object result = null;
                        Float money = (Float) args[0];
                        if ("sale".equals(method.getName())) {
                            return method.invoke(producer, money * 0.9f);
                        }
                        if ("serviceAfterSale".equals(method.getName())) {
                            return method.invoke(producer, money * 0.9f);
                        }
                        return result;
                    }
                });

        agency.sale(10000f);
        agency.serviceAfterSale(1000f);
    }
}
