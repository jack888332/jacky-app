package demo.thread.part6.provider_and_customer;

public class Customer implements Runnable {
    private Box box;

    Customer(Box box) {
        this.box = box;
    }

    @Override
    public void run() {
        while (true) {
            box.getGoods();
        }
    }
}
