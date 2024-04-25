package project1_line.account;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Scanner;

//自定义数据的记录类型
//public修饰 的类唯一且与文件名一致
public class ChargeToAnAccount{
	static ArrayList<Record> list = new ArrayList<Record>(); //无法从静态上下文中引用非静态变量

	public static void main(String[] args){
		Record record = new Record();//创建Record类对象，给其属性赋值，并将其存入list（0）中
		record.type = "收入";
		record.time = getTime();
		record.use = "基本资金";
		record.fund = 10000.0;
		list.add(record);					
		initialize();//调用初始化方法生成界面
	}

	public static void initialize(){
		Scanner selection = new Scanner(System.in);
		for(int i = 0 ; i <= 20; i++)
			System.out.print("-");
		System.out.print("Mg记账软件");
		for(int i = 0 ; i <= 20; i++)
			System.out.print("-");
		System.out.print("\n");
		System.out.println("			1 收支明细");
		System.out.println("			2 登记收入");
		System.out.println("			3 登记支出");
		System.out.println("			4 退出");
		System.out.print("请选择1-4：");
		int serial = selection.nextInt();
		switch(serial){
			case 1: detail();break;//显示收支明细
			case 2: income();break;//登记收入
			case 3: expense();break;//登记支出
			case 4: exit();break;//退出
			default:
				System.out.println("请输入正确的序号");
				initialize();
		}
		
	}

	public static void detail(){
                 System.out.println("---------------------------------------------------------------------------------------");
                 System.out.println("时间\t\t\t\t\t\t1收支\t\t账户金额\t\t收支金额\t\t说    明\n");
                 System.out.println("---------------------------------------------------------------------------------------");
		for(int i = 0; i < list.size(); i++){//按照时间顺序显示所有的收支记录		System.out.println("-----------------当前收支明细记录-----------------");
			System.out.print( list.get(i).time + "\t");//时间
   			System.out.print( list.get(i).type + "\t\t\t");//类型
			System.out.print(list.get(i).fund + "\t\t");//账户金额
			System.out.print(((i == 0 )? list.get(i).fund : list.get(i).fund-list.get(i-1).fund) + "\t\t");//收支金额
			System.out.print(list.get(i).use);//说明用途
               		System.out.println("\n---------------------------------------------------------------------------------------");
		}
		initialize();
	}

	public static void income(){
		Record record = new Record();
		Scanner selection = new Scanner(System.in);
		System.out.print("收入资金：" );
		double  earn= selection.nextDouble();
		System.out.print("收入来源：" );
		String using = selection.next();
		record.type = "收入";
		record.time = getTime();
		record.fund = list.get(list.size() - 1).fund + earn;
		record.use = using;		
		list.add(record);
		System.out.println("回款成功");
		initialize();
	}	

	public static void expense(){
		Record record = new Record();
		Scanner selection = new Scanner(System.in);
		System.out.print("支出资金：" );
		double  expen= selection.nextDouble();
		System.out.print("支出去向：" );
		String using = selection.next();
		if(expen <= list.get(list.size() - 1).fund){
			record.fund = list.get(list.size() - 1).fund - expen;
			System.out.println("付款成功");
			record.type = "支出";
			record.time = getTime();
			record.use = using;
			list.add(record);
		}
		else
		System.out.println("付款失败");
		initialize();		
	}
	public static void exit(){
		System.out.println("确认退出？（Y/N）");
		Scanner selection = new Scanner(System.in);
		String  confirm = selection.next();
		if(confirm.equals("Y") || confirm.equals("y")) {	
			selection.close();
		}
		else if(confirm.equals("N") || confirm.equals("n")) {
			initialize();
		}
		else {
			System.out.println("请输入Y/y或N/n");
			exit();
		}
	}	
	public static String getTime(){//获取当前时间，返回String类型的时间数据
		SimpleDateFormat formatter= new SimpleDateFormat("yyyy-MM-dd 'at' HH:mm:ss");//("yyyy-MM-dd 'at' HH:mm:ss z")中的z表示时区
		Date date = new Date(System.currentTimeMillis());
		String time = (String)formatter.format(date);//System.out.println(formatter.format(date));
		System.out.println(formatter.format(date));
		return time;
	}

}