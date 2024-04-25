package project2_line.merchant_management.view;

import project2_line.merchant_management.bean.Customer;
import project2_line.merchant_management.services.CustomerList;
import project2_line.merchant_management.util.CMUtility;

/**
 * ClassName: CustomerView
 * Package: com.myself01.merchant_management.view
 * Description:
 * 界面
 *
 * @Author Administrator
 * @Create 2024/3/8 0:05
 * @Version 1.0
 */
public class CustomerView {

    private CustomerList customers = new CustomerList(10);
    public CustomerView(){}
    boolean loopFlag = true;

    public void startView(){
        while (loopFlag){
            mainView();
            char key = CMUtility.readMenuSelection();
            System.out.println();
            Views(key);
        }
    }
    public void mainView(){
        for (int i = 0; i < 15; i++)System.out.print("-");
        System.out.print("拼电商户管理系统");
        for (int i = 0; i < 15; i++)System.out.print("-");
        System.out.print("\n                1 添加客户");
        System.out.print("\n                2 修改客户");
        System.out.print("\n                3 删除客户");
        System.out.print("\n                4 客户列表");
        System.out.print("\n                5 退出");
        System.out.print("\n\n                请选择（1-5）");
    }
    public void Views(char key){
        switch (key){
            case '1':
                addCustomer();
                break;
            case '2':
                updateCustomer();
                break;
            case '3':
                delCustomer();
                break;
            case '4':
                showCustomerList();
                break;
            case '5':
                exitCustomer();
                loopFlag = false;
                break;
            default:
                System.out.println("请输入正确的数字（1-5）");
                mainView();
                loopFlag = false;
        }
    }
    private void addCustomer(){
        System.out.println("---------------------添加客户---------------------");
        System.out.print("姓名：");
        String name = CMUtility.readString(4);
        System.out.print("性别：");
        char gender = CMUtility.readChar();
        System.out.print("年龄：");
        int age = CMUtility.readInt();
        System.out.print("电话：");
        String phone = CMUtility.readString(15);
        System.out.print("邮箱：");
        String email = CMUtility.readString(15);
        Customer cust = new Customer(name, gender, age, phone, email);
        boolean flag = customers.addCustomer(cust);
        if (flag) {
            System.out.println("---------------------添加完成---------------------");
        } else {
            System.out.println("----------------记录已满,无法添加-----------------");
        }
    }
    private void updateCustomer(){
        System.out.println("---------------------修改客户---------------------");
        int index = 0;
        Customer cust = null;
        for (;;) {
            System.out.print("请选择待修改客户编号(-1退出)：");
            index = CMUtility.readInt();
            if (index == -1) {
                return;
            }
            cust = customers.getCustomer(index - 1);
            if (cust == null) {
                System.out.println("无法找到指定客户！");
            } else
                break;
        }
        System.out.print("姓名(" + cust.getName() + ")：");
        String name = CMUtility.readString(4, cust.getName());
        System.out.print("性别(" + cust.getGender() + ")：");
        char gender = CMUtility.readChar(cust.getGender());
        System.out.print("年龄(" + cust.getAge() + ")：");
        int age = CMUtility.readInt(cust.getAge());
        System.out.print("电话(" + cust.getPhone() + ")：");
        String phone = CMUtility.readString(15, cust.getPhone());
        System.out.print("邮箱(" + cust.getEmail() + ")：");
        String email = CMUtility.readString(15, cust.getEmail());
        cust = new Customer(name, gender, age, phone, email);
        boolean flag = customers.replaceCustomer(index - 1, cust);
        if (flag) {
            System.out
                    .println("---------------------修改完成---------------------");
        } else {
            System.out.println("----------无法找到指定客户,修改失败--------------");
        }
    }
    private void delCustomer(){
        System.out.println("---------------------删除客户---------------------");
        int index = 0;
        Customer cust = null;
        for (;;) {
            System.out.print("请选择待删除客户编号(-1退出)：");
            index = CMUtility.readInt();
            if (index == -1) {
                return;
            }
            cust = customers.getCustomer(index - 1);
            if (cust == null) {
                System.out.println("无法找到指定客户！");
            } else
                break;
        }
        System.out.print("确认是否删除(Y/N)：");
        char yn = CMUtility.readConfirmSelection();
        if (yn == 'N')
            return;
        boolean flag = customers.deleteCustomer(index - 1);
        if (flag) {
            System.out
                    .println("---------------------删除完成---------------------");
        } else {
            System.out.println("----------无法找到指定客户,删除失败--------------");
        }
    }
    private void showCustomerList(){
        System.out.println("---------------------------客户列表---------------------------");
        Customer[] custs = customers.getAllCustomers();
        if (custs.length == 0) {
            System.out.println("没有客户记录！");
        } else {
            System.out.println("编号\t姓名\t性别\t年龄\t电话\t\t\t邮箱");
            for (int i = 0; i < custs.length; i++) {
//            System.out.println(i + 1 + "\t" + custs[i].getName() + "\t" + custs[i].getGender() + "\t" + custs[i].getAge() + "\t\t" + custs[i].getPhone() + "\t" + custs[i].getEmail());
                System.out.println((i+1) + "\t" + custs[i].getDetails());
            }
        }
        System.out.println("-------------------------客户列表完成-------------------------");
    }
    private void exitCustomer(){
        System.out.print("确认是否退出(Y/N)：");
        char yn = CMUtility.readConfirmSelection();
        if (yn == 'Y')
            loopFlag = false;
    }
}
