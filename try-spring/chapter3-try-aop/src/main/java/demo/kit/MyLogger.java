package demo.kit;

import org.springframework.stereotype.Component;

@Component
public class MyLogger {
    public void print1() {
        System.out.println("已记录A");
    }

    public void print2() {
        System.out.println("已记录B");
    }
}
