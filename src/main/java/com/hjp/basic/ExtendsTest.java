package com.hjp.basic;

/*
  第一个规则：子类的构造过程中，必须调用其父类的构造方法。一个类，如果我们不写构造方法，那么编译器会帮我们加上一个默认
  的构造方法（就是没有参数的构造方法），但是如果你自己写了构造方法，那么编译器就不会给你添加了，所以有时候当你new一个
  子类对象的时候，肯定调用了子类的构造方法，但是如果在子类构造方法中我们并没有显示的调用基类的构造方法，如：super();
  这样就会调用父类没有参数的构造方法。

  第二个规则：如果子类的构造方法中既没有显示的调用基类构造方法，而基类中又没有无参的构造方法，则编译出错，所以，通常我们
  需要显示的：super(参数列表)，来调用父类有参数的构造函数，此时无参的构造函数就不会被调用。

  总之，一句话：子类没有显示调用父类构造函数，不管子类构造函数是否带参数都默认调用父类无参的构造函数，若父类没有则编译出错。
 */
public class ExtendsTest {
    public static void main(String[] args) {
        new Child("mike");
    }
}

class People {
    String name;

    public People() {
        System.out.print(1);
    }

    public People(String name) {
        System.out.print(2);
        this.name = name;
    }
}

class Child extends People {
    People father;

    public Child(String name) {
        super();
        System.out.print(3);
        this.name = name;
        father = new People(name + ":F");
    }

    public Child() {
        System.out.print(4);
    }

}
