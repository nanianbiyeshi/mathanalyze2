package shufen2;

import java.util.Scanner;

public class zuixiao {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		jutil1 ju=new jutil1();
		while(true) {
		System.out.println("Ĭ�ϱ��ʽ������:1");
		System.out.println("��ѡ���ʽ������:2");
		String jie2=new Scanner(System.in).next();
		
		 if(jie2.equals("1"))
		 ju.fang1();
		  else
			ju.fang2();}

	}

}
