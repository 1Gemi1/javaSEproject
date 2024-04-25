package project2_line.merchant_management.services;

import project2_line.merchant_management.bean.Customer;

/**
 * ClassName: CustomerList
 * Package: com.myself01.merchant_management.services
 * Description:
 * 功能实现与管理
 *
 * @Author Administrator
 * @Create 2024/3/8 0:07
 * @Version 1.0
 */
public class CustomerList {
    private Customer[] customers;
    private int total = 0;

    public CustomerList(){}
    //用途：构造器，用来初始化customers数组
    //参数：totalCustomer：指定customers数组的最大空间
    public CustomerList(int totalCustomer){
        customers = new Customer[totalCustomer];
    }

    //用途：将参数customer添加组中最后一个客户对象记录之后
    //参数：customer指定要添加的客户对象
    //返回：添加成功返回true；false表示数组已满，无法添加
    public boolean addCustomer(Customer customer){
        if (total < customers.length){
            customers[total] = customer;
            total++;
            return true;
        }else{
            System.out.println("数组已满，无法添加");
            return false;
        }
    }

    //用途：用参数customer替换数组中由index指定的对象
    //参数：customer指定替换的新客户对象
    //index指定所替换对象在数组中的位置，从0开始
    //返回：替换成功返回true；false表示索引无效，无法替换
    public boolean replaceCustomer(int index,Customer cust){
        if (index < total && index >= 0 ) {
            customers[index] = cust;
            return true;
        }else {
            System.out.println("索引无效，无法替换");
            return false;
        }
    }

    //用途：从数组中删除参数index指定索引位置的客户对象记录
    //参数： index指定所删除对象在数组中的索引位置，从0开始
    //返回：删除成功返回true；false表示索引无效，无法删除
    public boolean deleteCustomer(int index){
        if (index < total && index >= 0 ) {
            for (int i = index; i < total - 1 ; i++) {
                customers[i] = customers[i+1];
            }
            total--;
            customers[total] = null;
            return true;
        }else {
            System.out.println("索引无效，无法删除");
            return false;
        }
    }

    //用途：返回数组中记录的所有客户对象
    //返回： Customer[] 数组中包含了当前所有客户对象，该数组长度与对象个数相同。
    public Customer[] getAllCustomers() {
        Customer[] custs = new Customer[total];
        for (int i = 0; i < total; i++) {
            custs[i] = customers[i];
        }
        return custs;
    }


    //用途：返回参数index指定索引位置的客户对象记录
    //参数：index指定所要获取的客户在数组中的索引位置，从0开始
    //返回：封装了客户信息的Customer对象
    public Customer getCustomer(int index) {
        if (index < total && index >= 0 ) {
        }else {
            System.out.println("索引无效，无法获取");
            return null;
        }
        return customers[index];
    }

    public int getTotal() {
        return total;
    }

}
