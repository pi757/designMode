package cn.pjs.proxy;

import lombok.AllArgsConstructor;
import lombok.Data;

/**
 * @author pjs
 * @create 2021-09-25   22:32
 */
public class PursuitProxy {
    public static void main(String[] args) {
        SchoolGirl jiaojiao = new SchoolGirl("jiaojiao");
        Pursuit pursuit = new Pursuit(jiaojiao);
        DaiLi daiLi = new DaiLi(pursuit);
        daiLi.giveChocolate();
        daiLi.giveDills();
        daiLi.giveFlowers();
    }
}

interface IGiveGift {
    /**
     * 送娃娃
     */
    void giveDills();

    /**
     * 送花
     */
    void giveFlowers();

    /**
     * 送巧克力
     */
    void giveChocolate();
}

class Pursuit implements IGiveGift {

    private final SchoolGirl jj;

    public Pursuit(SchoolGirl jj) {
        this.jj = jj;
    }

    @Override
    public void giveDills() {
        System.out.printf("%s送你娃娃\n", jj.getName());
    }

    @Override
    public void giveFlowers() {
        System.out.printf("%s送你花\n", jj.getName());
    }

    @Override
    public void giveChocolate() {
        System.out.printf("%s送你巧克力\n", jj.getName());
    }
}

class DaiLi implements IGiveGift{

    private Pursuit pursuit;

    public DaiLi(Pursuit pursuit) {
        this.pursuit = pursuit;
    }

    @Override
    public void giveDills() {
        pursuit.giveDills();
    }

    @Override
    public void giveFlowers() {
        pursuit.giveFlowers();
    }

    @Override
    public void giveChocolate() {
        pursuit.giveChocolate();
    }

}
@Data
@AllArgsConstructor
class SchoolGirl {
    private String name;
}

