package cn.pjs.strategy;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.Scanner;

/**
 * @author pjs
 * @create 2021-09-25   16:54
 */
public class CashStrategy {
    public static void main(String[] args) {
        Client client = new Client();
        client.start();
    }
}
class Client {
    public void start() {
        for (;;) {
            System.out.println("请输入折扣策略");
            Scanner scanner = new Scanner(System.in);
            String next = scanner.next();
            CashContext cashContext = new CashContext(next);
            System.out.println("请输入金额");
            BigDecimal money = scanner.nextBigDecimal();
            BigDecimal result = cashContext.getResult(money);
            System.out.printf("应收%s元", result);
        }
    }
}
@NoArgsConstructor
class CashContext {
    private CashSuper strategy;
    public CashContext(String type) {
        switch (type) {
            case "正常收费":
                strategy = new CashNormal();
                break;
            case "满300减100":
                strategy = new CashReturn(BigDecimal.valueOf(300), BigDecimal.valueOf(100));
                break;
            case "打八折":
                strategy = new CashRebate(BigDecimal.valueOf(0.8));
                break;
            default:
                throw new RuntimeException("没有这个销售策略");
        }
    }
    public BigDecimal getResult(BigDecimal money) {
        return strategy.getResult(money);
    }
}

abstract class CashSuper {
    public BigDecimal getResult(BigDecimal money) {
        return BigDecimal.ZERO;
    }
}

class CashNormal extends CashSuper{
    @Override
    public BigDecimal getResult(BigDecimal money) {
        return money;
    }
}
@AllArgsConstructor
class CashReturn extends CashSuper{

    private final BigDecimal total;

    private final BigDecimal sub;

    @Override
    public BigDecimal getResult(BigDecimal money) {
        if (money.compareTo(total) < 0) {
            return money;
        }
        BigDecimal divide = money.divide(total, 0, RoundingMode.DOWN);
        return money.subtract(sub.multiply(divide));
    }
}
@AllArgsConstructor
class CashRebate extends CashSuper{
    private final BigDecimal rebate;

    @Override
    public BigDecimal getResult(BigDecimal money) {
        return money.multiply(rebate);
    }
}
