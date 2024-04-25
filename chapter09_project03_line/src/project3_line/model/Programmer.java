package project3_line.model;

import project3_line.model.model_interface.Equipment;
import project3_line.service.Status;

import static project3_line.service.Status.FREE;

/**
 * ClassName: Programmer
 * Package: com.myself00.project3_line.model
 * Description:
 * 程序员子类
 * @Author Administrator
 * @Create 2024/4/19 17:54
 * @Version 1.0
 */
public class Programmer extends Employee  {

    private int memberId;

    //基本属性
    private Status status = FREE;

    private Equipment device;


    public Programmer(int id, String name, int age, double salary, int job,Equipment device) {
        super(id, name, age, salary,job);
        this.status = status;
        this.device = device;
    }

    public int getMemberId() {
        return memberId;
    }

    public void setMemberId(int memberId) {
        this.memberId = memberId;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    public Equipment getDevice() {
        return device;
    }

    public void setDevice(Equipment device) {
        this.device = device;
    }
}
