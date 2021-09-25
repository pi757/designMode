package cn.pjs.factory;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.Scanner;

/**
 * @author pjs
 * @create 2021-09-25   14:49
 */
public class SimpleFactory {
    public static void main(String[] args){
        Client client = new Client();
        client.start();
    }
}
@Data
@AllArgsConstructor
class Client {

    public void start(){
        while (true) {
            System.out.println("请输入运算符");
            Scanner scanner = new Scanner(System.in);
            String next = scanner.next();
            char operation = next.charAt(0);
            Operation operation1 = Factory.creatOperation(operation);
            System.out.println("请输入第一个数");
            BigDecimal num1 = scanner.nextBigDecimal();
            System.out.println("请输入第二个数");
            BigDecimal num2 = scanner.nextBigDecimal();
            operation1.setNum1(num1);
            operation1.setNum2(num2);
            System.out.println(operation1.getResult().toString());
        }
    }
}
class Factory {

    public static Operation creatOperation(char operation) {
        switch (operation) {
            case '+' :
                return new AddOperation();
            case '-' :
                return new SubOperation();
            case '*' :
                return new MulOperation();
            case '/' :
                return new DivOperation();
            default:
                throw new RuntimeException("运算符错误");
        }
    }
}

@Data
@AllArgsConstructor
@NoArgsConstructor
abstract class Operation {
    private BigDecimal num1;

    private BigDecimal num2;

    public BigDecimal getResult() {
        return BigDecimal.ZERO;
    }
}

/**
 * 加法
 */
class AddOperation extends Operation {
    public AddOperation() {
    }

    public AddOperation(BigDecimal num1, BigDecimal num2) {
        super(num1, num2);
    }

    @Override
    public BigDecimal getResult() {
        return getNum1().add(getNum2());
    }
}

/**
 * 减法
 */
class SubOperation extends Operation {
    public SubOperation() {
    }

    public SubOperation(BigDecimal num1, BigDecimal num2) {
        super(num1, num2);
    }

    @Override
    public BigDecimal getResult() {
        return getNum1().subtract(getNum2());
    }
}

/**
 * 乘法
 */
class MulOperation extends Operation {
    public MulOperation() {
    }

    public MulOperation(BigDecimal num1, BigDecimal num2) {
        super(num1, num2);
    }

    @Override
    public BigDecimal getResult() {
        return getNum1().multiply(getNum2());
    }
}

/**
 * 除法
 */
class DivOperation extends Operation {
    public DivOperation() {
    }

    public DivOperation(BigDecimal num1, BigDecimal num2) {
        super(num1, num2);
    }

    @Override
    public BigDecimal getResult() {
        return getNum1().divide(getNum2(), 2, RoundingMode.HALF_UP);
    }
}
