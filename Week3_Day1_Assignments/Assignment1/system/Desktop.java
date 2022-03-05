package org.system;

public class Desktop extends Computer {
	
	public void desktopSize()  {
		System.out.println("My computer size is 1024 * 728");
	
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Desktop objDesktop = new Desktop();
		objDesktop.desktopSize();
		objDesktop.computerModel();
	}

}
