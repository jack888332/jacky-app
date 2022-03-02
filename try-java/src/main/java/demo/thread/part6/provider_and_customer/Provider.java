package demo.thread.part6.provider_and_customer;

public class Provider implements Runnable {
    private Box box;

    Provider(Box box) {
        this.box = box;
    }

    @Override
    public void run() {
        for (int i = 0; i < 5; i++) {
            box.putGoods();
        }
    }
}
