package demo.debug;

import demo.domain.Profession;
import demo.domain.User;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class SingleThreadDebug {
    public static void main(String[] args) {
        User user = new User();
        user.setName("Jacky").setProfession(Profession.Lawyer);
        debugLogin(user);
    }

    private static int add(int a, int b) {
        return a + b;
    }

    private static void debugCodeBlock() {
        int watchedValue = 1;
        System.out.println("watchedValue：" + watchedValue);
        ++watchedValue;
        System.out.println("watchedValue：" + watchedValue);
        watchedValue = add(100, 200);
        System.out.println("watchedValue：" + watchedValue);
        watchedValue = add(100, 200);
        System.out.println("watchedValue：" + watchedValue);
    }

    private static void debugArrayList() {
        List<String> names = new ArrayList<>();
        names.add("Jack");
        names.add("Mike");
        names.add("Tony");
        names.add("Rose");

        Iterator<String> iterator = names.iterator();
        while (iterator.hasNext()) {
            String name = iterator.next();
            if ("Mike".equals(name)) {
                //在遍历时，改变元素个数
                names.add("Fuck");
            }
        }
    }

    private static void debugLogin(User user){
        switch(user.getProfession().name()){
            case "Nurse":
                System.out.println("Nurse");
                break;
            case "Lawyer":
                System.out.println("Lawyer");
                break;
            case "Student":
                System.out.println("Student");
        }
    }
}
