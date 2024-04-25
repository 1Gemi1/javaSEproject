package project3_line.model.model_interface;

/**
 * ClassName: Printer
 * Package: com.myself00.project3_line.model.model_interface
 * Description:
 * 设备接口Printer实现子类
 *
 * @Author Administrator
 * @Create 2024/4/19 19:10
 * @Version 1.0
 */
public class Printer implements Equipment{

    private String name;
    //类型
    private String type;

    public Printer(String name, String type) {
        this.name = name;
        this.type = type;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    @Override
    public String getDescription() {
        //return "name: " + this.name + " type: " + this.type;
        return this.name + "Printer";
    }
}
