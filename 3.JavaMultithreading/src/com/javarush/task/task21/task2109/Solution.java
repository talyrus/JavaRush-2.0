package com.javarush.task.task21.task2109;

/* 
Запретить клонирование
*/
public class Solution {
    public static class A implements Cloneable {
        private int i;
        private int j;

        public A(int i, int j) {
            this.i = i;
            this.j = j;
        }

        public int getI() {
            return i;
        }

        public int getJ() {
            return j;
        }

        @Override
        protected A clone() throws CloneNotSupportedException {
            return new A(getI(), getJ());
        }
    }

    public static class B extends A {
        private String name;

        public B(int i, int j, String name) {
            super(i, j);
            this.name = name;
        }

        public String getName() {
            return name;
        }

        @Override
        protected B clone() throws CloneNotSupportedException {
            throw new CloneNotSupportedException();
        }
    }

    public static class C extends B implements Cloneable {
        public C(int i, int j, String name) {
            super(i, j, name);
        }

        @Override
        protected C clone() throws CloneNotSupportedException {
            C newC;
            int i = getI();
            int j = getJ();
            String name = getName();
            newC = new C(i, j, name);
            return newC;
        }
    }

    public static void main(String[] args) {
        A a = new A(11, 22);
        System.out.println("a.i = " + a.getI() + " a.j = " + a.getJ());
        A aa = null;
        try {
            aa = a.clone();
            System.out.println("aa.i = " + aa.getI() + " aa.j = " + aa.getJ());
        } catch (CloneNotSupportedException e) {
            System.out.println("Объект не может быть клонированным - A.");
        }

        B b = new B(33, 44, "class B");
        System.out.println("b.i = " + b.getI() + " b.j = " + b.getJ() + " name = " + b.getName());
        B bb = null;
        try {
            bb = b.clone();
            System.out.println("bb.i = " + bb.getI() + " bb.j = " + bb.getJ() + " name = " + bb.getName());
        } catch (CloneNotSupportedException e) {
            System.out.println("Объект не может быть клонированным - B.");
        }

        B c = new C(55, 66, "class C");
        System.out.println("c.i = " + c.getI() + " c.j = " + c.getJ() + " name = " + c.getName());
        B cc = null;
        try {
            cc = c.clone();
            System.out.println("cc.i = " + cc.getI() + " cc.j = " + cc.getJ() + " name = " + cc.getName());
        } catch (CloneNotSupportedException e) {
            System.out.println("Объект не может быть клонированным - C.");
        }
    }
}
