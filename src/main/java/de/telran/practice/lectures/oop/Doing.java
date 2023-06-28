package de.telran.practice.lectures.oop;

public interface Doing {
    int SOME_VALUE = 0;

    void move();
    void doSomething();
    void makeSomething();
    void createSomething();

    //java 8+
    default String sayMyName(String name) {
        System.out.println("Hello " + name);
        return name;
    }

    //java 9+
    private String doPrivate() {
        return "private";
    }

    static void doSomethingStatic() {
        System.out.println("Interface static");
    }
}
