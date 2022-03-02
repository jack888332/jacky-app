package demo.thread.part6.provider_and_customer;

public class Box {
    private int stocks;

    public void putGoods() {
        ++stocks;
        System.out.println("Provider put goods into the box. Stock:" + stocks);
    }

    public void getGoods() {
        --stocks;
        System.out.println("Customer get goods from the box. Stock:" + stocks);
    }
}
