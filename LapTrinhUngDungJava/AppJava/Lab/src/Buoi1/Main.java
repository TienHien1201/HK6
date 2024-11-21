package Buoi1;

public class Main {
	public static void main(String[] args) {
	     System.out.println("--------------------");
	     FlashLamp denpin=new FlashLamp();
	     
	     Battery pin=new Battery();
	     denpin.setBattery(pin);
	     
	     for (int i=0;i<15; i++)
	     {
	         denpin.TurnOn();
	         System.out.println("Trang thai den:"+denpin.status);
	         denpin.TurnOff();
	        pin.decreaseEnergy();
	     }
	 
		
		}
	}