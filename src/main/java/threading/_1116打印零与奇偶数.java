package threading;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.Semaphore;
import java.util.function.IntConsumer;

public class _1116打印零与奇偶数 {
    public static void main(String[] args) {
        ZeroEvenOdd zerooddeven = new ZeroEvenOdd(5);
        new Thread(() -> {
            try {
                zerooddeven.zero(System.out::print);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }).start();

        new Thread(() -> {
            try {
                zerooddeven.even(System.out::print);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }).start();

        // n, n/2, n - n/2

        new Thread(() -> {
            try {
                zerooddeven.odd(System.out::print);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }).start();
    }

}

class ZeroEvenOdd {
    private int n;
    CountDownLatch zeroCountDownLatch = new CountDownLatch(0);
    CountDownLatch oddCountDownLatch = new CountDownLatch(1);
    CountDownLatch evenCountDownLatch = new CountDownLatch(1);

    public ZeroEvenOdd(int n) {
        this.n = n;
    }

    // printNumber.accept(x) outputs "x", where x is an integer.
    public void zero(IntConsumer printNumber) throws InterruptedException {
        for (int i = 1; i <= n; i++) {
            zeroCountDownLatch.await();

            printNumber.accept(0);

            zeroCountDownLatch = new CountDownLatch(1);
            if (i % 2 == 1) {
                oddCountDownLatch.countDown();
            } else {
                evenCountDownLatch.countDown();
            }

        }
    }

    public void odd(IntConsumer printNumber) throws InterruptedException {
        for (int i = 1; i <= n; i+=2) {
            oddCountDownLatch.await();

            printNumber.accept(i);

            zeroCountDownLatch.countDown();
            oddCountDownLatch = new CountDownLatch(1);
        }

    }

    public void even(IntConsumer printNumber) throws InterruptedException {
        for (int i = 2; i <= n; i+=2) {
            evenCountDownLatch.await();

            printNumber.accept(i);
            zeroCountDownLatch.countDown();
            evenCountDownLatch = new CountDownLatch(1);
        }
    }
}