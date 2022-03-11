package demo.part1.base_on_interface;

/**
 * 模拟：厂商和代理商的合约行为
 */
public interface AgencyContract {
    /**
     * 销售商品
     * @param money 涉及金额
     */
    public void sale(float money);

    /**
     * 提供售后服务
     * @param money 涉及金额
     */
    public void serviceAfterSale(float money);
}
