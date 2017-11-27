package jiatupian;

import org.omg.PortableInterceptor.ObjectReferenceFactoryHolder;

public class wait {
static int i =0;
static int s=5;
static Object o=new Object();
Thread thread2;
	static  void f1 () {
		new Thread() {
			public void run(){
				for(int s =0;s<200;s++)
				{System.out.println(s);
					i++;
					if(i==5)
					{try {
						
					} catch (Exception e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}}
//					try {
//							Thread.sleep(1000);
//					} catch (InterruptedException e) {
//						// TODO Auto-generated catch block
//						e.printStackTrace();
//					}
				}
			}
		}.start();
	}
	static void f2() {
new Thread(new Runnable() {
			
			@Override
			public void run() {
				for(int s =0;s<200;s++)
				{
					System.out.println("~~~"+s);
//					try {
//						Thread.sleep(1000);
//					} catch (InterruptedException e) {
//						// TODO Auto-generated catch block
//						e.printStackTrace();
//					}
				}
				
			}
		}).start(); ;
	}
	public static  void main(String[] args) {

		
		
//		thread.start();
		 {
			
		}{	f1();}
		 {
			
		}{	f2();}

	}
}
