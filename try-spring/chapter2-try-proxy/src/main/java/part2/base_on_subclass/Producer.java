package part2.base_on_subclass;

/**
 * 模拟：厂商的业务（涵盖代理合约所涉及的业务）
 */
public class Producer {
    public void sale(float money) {
        System.out.println("销售产品，收款：" + money);
    }

    public void serviceAfterSale(float money) {
        System.out.println("提供售后服务，收款：" + money);
    }
}
