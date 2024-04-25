package project3_line.model.model_interface;

/**
 * ClassName: NoteBook
 * Package: com.myself00.project3_line.model.model_interface
 * Description:
 * 设备接口NoteBook实现子类
 *
 * @Author Administrator
 * @Create 2024/4/19 19:09
 * @Version 1.0
 */
public class NoteBook implements Equipment{
    //型号
    private String model;
    //价格
    private double price;

    public NoteBook(String model, double price) {
        this.model = model;
        this.price = price;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    @Override
    public String getDescription() {
        //return "model: " + this.model + " price: " + this.price;
        return this.model + "NoteBook";
    }
}
