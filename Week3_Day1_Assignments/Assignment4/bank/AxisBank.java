package org.bank;

public class AxisBank extends BankInfo {
	
	@Override
	protected void deposit() {
		// TODO Auto-generated method stub
		super.deposit();
		System.out.println("This is from AxisBank class");
	}

	public static void main(String[] args) {
		BankInfo objBankInfo = new BankInfo();		 
		AxisBank objAxisBank = new AxisBank();
		
		objAxisBank.deposit();
		objAxisBank.saving();
		objBankInfo.deposit();
		objAxisBank.fixedac();

	}

}
