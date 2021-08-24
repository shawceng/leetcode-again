package threading;

import java.util.concurrent.Semaphore;

public class _1114按序打印 {
}

class Foo {

    volatile int state = 0;

    public Foo() {

    }

    public void first(Runnable printFirst) throws InterruptedException {

        // printFirst.run() outputs "first". Do not change or remove this line.
        printFirst.run();
        state = 1;
    }

    public void second(Runnable printSecond) throws InterruptedException {
        while (state != 1) {
            Thread.yield();
        }
        // printSecond.run() outputs "second". Do not change or remove this line.
        printSecond.run();
        state = 2;
    }

    public void third(Runnable printThird) throws InterruptedException {
        while (state != 2) {
            Thread.yield();
        }
        // printThird.run() outputs "third". Do not change or remove this line.
        printThird.run();
    }
}