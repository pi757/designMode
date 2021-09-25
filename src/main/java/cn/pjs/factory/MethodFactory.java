package cn.pjs.factory;

/** 工厂方法模式
 * @author pjs
 * @create 2021-09-25   23:06
 */
public class MethodFactory {
    public static void main(String[] args) {
        IFactory factory = new UndergraduateFactory();
        LeiFeng leiFeng = factory.creatLeiFeng();
        leiFeng.buyRice();
        leiFeng.sweep();
        leiFeng.wash();
    }
}

abstract class LeiFeng {
    public void sweep () {
        System.out.println("扫地");
    }
    public void wash () {
        System.out.println("洗衣");
    }
    public void buyRice () {
        System.out.println("买米");
    }
}

interface IFactory {

    LeiFeng creatLeiFeng();

}
class Undergraduate extends LeiFeng {

}

class Volunteer extends LeiFeng {

}

class UndergraduateFactory implements IFactory {

    @Override
    public LeiFeng creatLeiFeng() {
        return new Undergraduate();
    }
}
class VolunteerFactory implements IFactory {

    @Override
    public LeiFeng creatLeiFeng() {
        return new Volunteer();
    }
}