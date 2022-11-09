package homework13.task2;

import homework13.task2.A;
import homework13.task2.B;
import homework13.task2.C;

public class Thread2Task2 extends Thread {
    A a = new A();
    B b = new B();
    C c = new C();

    @Override
    public void run() {
        synchronized (B.class) {
            b.methodB(c);
            System.out.println("Lock B.class in 2");
            synchronized (C.class) {
                c.methodC(a);
                System.out.println("Lock C.class in 2");
                synchronized (A.class) {
                    a.methodA(b);
                    System.out.println("Lock A.class in 2");
                }
            }
        }
    }
}
