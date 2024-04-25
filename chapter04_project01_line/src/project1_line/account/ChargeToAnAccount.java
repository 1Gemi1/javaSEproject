package project1_line.account;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Scanner;

//�Զ������ݵļ�¼����
//public���� ����Ψһ�����ļ���һ��
public class ChargeToAnAccount{
	static ArrayList<Record> list = new ArrayList<Record>(); //�޷��Ӿ�̬�����������÷Ǿ�̬����

	public static void main(String[] args){
		Record record = new Record();//����Record����󣬸������Ը�ֵ�����������list��0����
		record.type = "����";
		record.time = getTime();
		record.use = "�����ʽ�";
		record.fund = 10000.0;
		list.add(record);					
		initialize();//���ó�ʼ���������ɽ���
	}

	public static void initialize(){
		Scanner selection = new Scanner(System.in);
		for(int i = 0 ; i <= 20; i++)
			System.out.print("-");
		System.out.print("Mg�������");
		for(int i = 0 ; i <= 20; i++)
			System.out.print("-");
		System.out.print("\n");
		System.out.println("			1 ��֧��ϸ");
		System.out.println("			2 �Ǽ�����");
		System.out.println("			3 �Ǽ�֧��");
		System.out.println("			4 �˳�");
		System.out.print("��ѡ��1-4��");
		int serial = selection.nextInt();
		switch(serial){
			case 1: detail();break;//��ʾ��֧��ϸ
			case 2: income();break;//�Ǽ�����
			case 3: expense();break;//�Ǽ�֧��
			case 4: exit();break;//�˳�
			default:
				System.out.println("��������ȷ�����");
				initialize();
		}
		
	}

	public static void detail(){
                 System.out.println("---------------------------------------------------------------------------------------");
                 System.out.println("ʱ��\t\t\t\t\t\t1��֧\t\t�˻����\t\t��֧���\t\t˵    ��\n");
                 System.out.println("---------------------------------------------------------------------------------------");
		for(int i = 0; i < list.size(); i++){//����ʱ��˳����ʾ���е���֧��¼		System.out.println("-----------------��ǰ��֧��ϸ��¼-----------------");
			System.out.print( list.get(i).time + "\t");//ʱ��
   			System.out.print( list.get(i).type + "\t\t\t");//����
			System.out.print(list.get(i).fund + "\t\t");//�˻����
			System.out.print(((i == 0 )? list.get(i).fund : list.get(i).fund-list.get(i-1).fund) + "\t\t");//��֧���
			System.out.print(list.get(i).use);//˵����;
               		System.out.println("\n---------------------------------------------------------------------------------------");
		}
		initialize();
	}

	public static void income(){
		Record record = new Record();
		Scanner selection = new Scanner(System.in);
		System.out.print("�����ʽ�" );
		double  earn= selection.nextDouble();
		System.out.print("������Դ��" );
		String using = selection.next();
		record.type = "����";
		record.time = getTime();
		record.fund = list.get(list.size() - 1).fund + earn;
		record.use = using;		
		list.add(record);
		System.out.println("�ؿ�ɹ�");
		initialize();
	}	

	public static void expense(){
		Record record = new Record();
		Scanner selection = new Scanner(System.in);
		System.out.print("֧���ʽ�" );
		double  expen= selection.nextDouble();
		System.out.print("֧��ȥ��" );
		String using = selection.next();
		if(expen <= list.get(list.size() - 1).fund){
			record.fund = list.get(list.size() - 1).fund - expen;
			System.out.println("����ɹ�");
			record.type = "֧��";
			record.time = getTime();
			record.use = using;
			list.add(record);
		}
		else
		System.out.println("����ʧ��");
		initialize();		
	}
	public static void exit(){
		System.out.println("ȷ���˳�����Y/N��");
		Scanner selection = new Scanner(System.in);
		String  confirm = selection.next();
		if(confirm.equals("Y") || confirm.equals("y")) {	
			selection.close();
		}
		else if(confirm.equals("N") || confirm.equals("n")) {
			initialize();
		}
		else {
			System.out.println("������Y/y��N/n");
			exit();
		}
	}	
	public static String getTime(){//��ȡ��ǰʱ�䣬����String���͵�ʱ������
		SimpleDateFormat formatter= new SimpleDateFormat("yyyy-MM-dd 'at' HH:mm:ss");//("yyyy-MM-dd 'at' HH:mm:ss z")�е�z��ʾʱ��
		Date date = new Date(System.currentTimeMillis());
		String time = (String)formatter.format(date);//System.out.println(formatter.format(date));
		System.out.println(formatter.format(date));
		return time;
	}

}