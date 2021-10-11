package cn.pjs.templateMethod;

import lombok.Data;

/**
 * @author pjs
 * @create 2021-10-11   22:23
 */
public class PaperTemplateMethod {

    public static void main(String[] args) {
        StudentAPaper studentAPaper = new StudentAPaper();
        studentAPaper.setName("丁一");
        studentAPaper.show();
        StudentBPaper studentBPaper = new StudentBPaper();
        studentBPaper.setName("王二");
        studentBPaper.show();
    }
}

@Data
class Paper {
    private String name;
    private void question1() {
        System.out.println("一加一等于几\n a.0  b.1   c.2");
        System.out.printf("答案是%s\n", answer1());
    }
    private void question2() {
        System.out.println("2是奇数吗\n a.是 b. 不是");
        System.out.printf("答案是%s\n", answer2());
    }

    public void show() {
        System.out.println(name);
        question1();
        question2();
    }

    public String answer1() {
        return "";
    }
    public String answer2() {
        return "";
    }
}

class StudentAPaper extends Paper{
    @Override
    public String answer1() {
        return "b";
    }

    @Override
    public String answer2() {
        return "a";
    }
}
class StudentBPaper extends Paper{
    @Override
    public String answer1() {
        return "a";
    }

    @Override
    public String answer2() {
        return "b";
    }
}

