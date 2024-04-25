package project2_line.merchant_management.bean;

/**
 * ClassName: Customer
 * Package: com.myself01.merchant_management.bean
 * Description:
 * 客户类
 *
 * @Author Administrator
 * @Create 2024/3/7 9:36
 * @Version 1.0
 */
public class Customer {
    private String name;

    private char gender;
    private int age;
    private String phone;
    private  String email;

    public Customer(){}
    public Customer(String userName,char gender,int age,String telephone,String email){
        this.name = userName;
        this.gender = gender;
        this.age = age;
        this.phone = telephone;
        this.email = email;
    }

    public Customer(String userName){
        this.name = userName;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public char getGender() {
        return gender;
    }

    public void setGender(char gender) {
        this.gender = gender;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
    public String getDetails() {
        return name + "\t" + gender + "\t" + age + "\t" + phone + "\t" + email;
    }
}
