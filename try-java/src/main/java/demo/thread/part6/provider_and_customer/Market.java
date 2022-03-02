package demo.thread.part6.provider_and_customer;

public class Market {
    public static void main(String[] args) {
        Box box = new Box();
        Thread thread1 = new Thread(new Provider(box),"生产者");
        Thread thread2 = new Thread(new Customer(box),"消费者");
        thread1.start();
        thread2.start();
    }
}
