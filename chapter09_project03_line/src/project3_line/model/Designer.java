package project3_line.model;

import project3_line.model.model_interface.Equipment;

/**
 * ClassName: Designer
 * Package: com.myself00.project3_line.model
 * Description:
 * 设计师子类
 *
 * @Author Administrator
 * @Create 2024/4/19 17:55
 * @Version 1.0
 */
public class Designer extends Programmer{

    private double bonus;

    public Designer(int id, String name, int age, double salary, int job, Equipment device, double bonus) {
        super(id, name, age, salary, job, device);
        this.bonus = bonus;
    }

    public double getBonus() {
        return bonus;
    }

    public void setBonus(double bonus) {
        this.bonus = bonus;
    }
}
