package cn.pjs.decorator;

import lombok.NoArgsConstructor;

/**
 * @author pjs
 * @create 2021-09-25   21:38
 */
public class FineryDecorator {

    public static void main(String[] args) {
        Person person = new Person("pjs");
        TShirts tShirts = new TShirts();
        BigTrouser bigTrouser = new BigTrouser();
        Sneakers sneakers = new Sneakers();
        businessSuit businessSuit = new businessSuit();
        tie tie = new tie();
        leatherShoes leatherShoes = new leatherShoes();
        tShirts.decorator(person);
        bigTrouser.decorator(tShirts);
        sneakers.decorator(bigTrouser);
        sneakers.show();

    }
}
@NoArgsConstructor
class Person {
    private String name;
    public Person(String name) {
        this.name = name;
    }

    public void show() {
        System.out.printf("%s的穿搭", name);
    }

}
@NoArgsConstructor
abstract class Finery extends Person{

    private Person component;

    public void decorator(Person component) {
        this.component = component;
    }

    @Override
    public void show() {
        if (component != null) {
            component.show();
        }
    }
}
class TShirts extends Finery {
    @Override
    public void show() {
        System.out.println("T恤");
        super.show();
    }
}
class BigTrouser extends Finery {
    @Override
    public void show() {
        System.out.println("阔腿裤");
        super.show();
    }
}
class Sneakers extends Finery {
    @Override
    public void show() {
        System.out.println("运动鞋");
        super.show();
    }
}
class businessSuit extends Finery {
    @Override
    public void show() {
        System.out.println("西装");
        super.show();
    }
}
class tie extends Finery {
    @Override
    public void show() {
        System.out.println("领带");
        super.show();
    }
}
class leatherShoes extends Finery {
    @Override
    public void show() {
        System.out.println("皮鞋");
        super.show();
    }
}
