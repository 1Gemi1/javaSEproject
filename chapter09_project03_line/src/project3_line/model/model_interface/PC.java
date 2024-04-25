package project3_line.model.model_interface;

/**
 * ClassName: PC
 * Package: com.myself00.project3_line.model.model_interface
 * Description:
 * 设备接口pc实现子类
 *
 * @Author Administrator
 * @Create 2024/4/19 19:07
 * @Version 1.0
 */
public class PC implements Equipment {
    //型号
    private String model;
    //显示器
    private String display;

    public PC(String model, String display) {
        this.model = model;
        this.display = display;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getDisplay() {
        return display;
    }

    public void setDisplay(String display) {
        this.display = display;
    }


    @Override
    public String getDescription() {
        //return "model: " + this.model + " display: " + this.display;
        return this.model + "PC";
    }
}
