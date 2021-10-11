package cn.pjs.prototype;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author pjs
 * @create 2021-10-11   21:22
 */
public class ResumePrototype {
    public static void main(String[] args) throws CloneNotSupportedException {
        Resume resume = new Resume("丁一", 22, "男", new Work("2021-2022", "宝乐"));
        Resume resume1 = (Resume) resume.clone();
        resume1.setWork("2022-2023", "阿里巴巴");
        System.out.println(resume);
        System.out.println(resume1);
    }
}
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
class Work implements Cloneable {

    private String date;

    private String companyName;

    @Override
    public Object clone() throws CloneNotSupportedException {
        return super.clone();
    }
}

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
class Resume implements Cloneable {
    private String name;

    private Integer age;

    private String sex;

    private Work work;

    @Override
    public Object clone() throws CloneNotSupportedException {
        Resume resume = (Resume) super.clone();
        resume.setWork((Work) work.clone());
        return resume;
    }

    public void setWork(String date, String companyName) {
        this.work.setCompanyName(companyName);
        this.work.setDate(date);
    }
}
