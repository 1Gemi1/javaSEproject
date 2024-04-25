package project3_line.model;

import project3_line.model.model_interface.Equipment;

/**
 * ClassName: Architect
 * Package: com.myself00.project3_line.model
 * Description:
 * 架构师子类
 *
 * @Author Administrator
 * @Create 2024/4/19 17:55
 * @Version 1.0
 */
public class Architect extends Designer{
    private double stock;

    public Architect(int id, String name, int age, double salary, int job, Equipment device, double bonus, double stock) {
        super(id, name, age, salary, job,device, bonus);
        this.stock = stock;
    }

    public double getStock() {
        return stock;
    }

    public void setStock(double stock) {
        this.stock = stock;
    }
}
