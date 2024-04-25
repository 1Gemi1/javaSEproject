package project3_line.model;

/**
 * ClassName: Employee
 * Package: com.myself00.project3_line.model
 * Description:
 * 员工父类
 *
 * @Author Administrator
 * @Create 2024/4/19 17:51
 * @Version 1.0
 */
public class Employee {
    //不同子类有区分度的属性
    private int id;
    //基本属性
    private String name;
    private int age;
    private double salary;
    private int job;

    public Employee(int id, String name, int age, double salary,int job) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.salary = salary;
        this.job = job;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    public int getJob() {
        return job;
    }

    public void setJob(int job) {
        this.job = job;
    }
}
