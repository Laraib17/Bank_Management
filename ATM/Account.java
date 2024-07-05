import java.text.DecimalFormat;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Account {
	
	private int cn;
	private int pn;
	private double cb = 0;
	private double sb = 0;

	Scanner input = new Scanner(System.in);
	DecimalFormat moneyFormat = new DecimalFormat("'$'###,##0.00");

	public Account() {
	}

	public Account(int cn, int pn) {
		this.cn = cn;
		this.pn = pn;
	}

	public Account(int cn, int pn, double cb, double sb) {
		this.cn = cn;
		this.pn = pn;
		this.cb = cb;
		this.sb = sb;
	}

	public int setcn(int cn) {
		this.cn = cn;
		return cn;
	}

	public int getcn() {
		return cn;
	}

	public int setPinNumber(int pn) {
		this.pn = pn;
		return pn;
	}

	public int getPinNumber() {
		return pn;
	}

	public double getCheckingBalance() {
		return cb;
	}

	public double getSavingBalance() {
		return sb;
	}

	public double calcCheckingWithdraw(double amount) {
		cb = (cb - amount);
		return cb;
	}

	public double calcSavingWithdraw(double amount) {
		sb = (sb - amount);
		return sb;
	}

	public double calcCheckingDeposit(double amount) {
		cb = (cb + amount);
		return cb;
	}

	public double calcSavingDeposit(double amount) {
		sb = (sb + amount);
		return sb;
	}

	public void calcCheckTransfer(double amount) {
		cb = cb - amount;
		sb = sb + amount;
	}

	public void calcSavingTransfer(double amount) {
		sb = sb - amount;
		cb = cb + amount;
	}

	public void getCheckingWithdrawInput() {
		boolean end = false;
		while (!end) {
			try {
				System.out.println("\nCurrent Checkings Account Balance: " + moneyFormat.format(cb));
				System.out.print("\nAmount you want to withdraw from Checkings Account: ");
				double amount = input.nextDouble();
				if ((cb - amount) >= 0 && amount >= 0) {
					calcCheckingWithdraw(amount);
					System.out.println("\nCurrent Checkings Account Balance: " + moneyFormat.format(cb));
					end = true;
				} else {
					System.out.println("\nBalance Cannot be Negative.");
				}
			} catch (InputMismatchException e) {
				System.out.println("\nInvalid Choice.");
				input.next();
			}
		}
	}

	public void getsavingWithdrawInput() {
		boolean end = false;
		while (!end) {
			try {
				System.out.println("\nCurrent Savings Account Balance: " + moneyFormat.format(sb));
				System.out.print("\nAmount you want to withdraw from Savings Account: ");
				double amount = input.nextDouble();
				if ((sb - amount) >= 0 && amount >= 0) {
					calcSavingWithdraw(amount);
					System.out.println("\nCurrent Savings Account Balance: " + moneyFormat.format(sb));
					end = true;
				} else {
					System.out.println("\nBalance Cannot Be Negative.");
				}
			} catch (InputMismatchException e) {
				System.out.println("\nInvalid Choice.");
				input.next();
			}
		}
	}

	public void getCheckingDepositInput() {
		boolean end = false;
		while (!end) {
			try {
				System.out.println("\nCurrent Checkings Account Balance: " + moneyFormat.format(cb));
				System.out.print("\nAmount you want to deposit from Checkings Account: ");
				double amount = input.nextDouble();
				if ((cb + amount) >= 0 && amount >= 0) {
					calcCheckingDeposit(amount);
					System.out.println("\nCurrent Checkings Account Balance: " + moneyFormat.format(cb));
					end = true;
				} else {
					System.out.println("\nBalance Cannot Be Negative.");
				}
			} catch (InputMismatchException e) {
				System.out.println("\nInvalid Choice.");
				input.next();
			}
		}
	}

	public void getSavingDepositInput() {
		boolean end = false;
		while (!end) {
			try {
				System.out.println("\n Your Current Savings Account Balance: " + moneyFormat.format(sb));
				System.out.print("\nYour Amount you want to deposit into your Savings Account: ");
				double amount = input.nextDouble();

				if ((sb + amount) >= 0 && amount >= 0) {
					calcSavingDeposit(amount);
					System.out.println("\n Your Current Savings Account Balance: " + moneyFormat.format(sb));
					end = true;
				} else {
					System.out.println("\nYour Balance Can't Be Negative:");
				}
			} catch (InputMismatchException e) {
				System.out.println("\nInvalid Choice, write correct options");
				input.next();
			}
		}
	}

	public void getTransferInput(String accType) {
		boolean end = false;
		while (!end) {
			try {
				if (accType.equals("Checkings")) {
					System.out.println("\nTranfers funds to:");
					System.out.println("1. Savings Account");
					System.out.println("2. Exit");
					System.out.print("\nChoice: ");
					int choice = input.nextInt();
					switch (choice) {
					case 1:
						System.out.println("\nCurrent Checkings Account Balance: " + moneyFormat.format(cb));
						System.out.print("\nAmount you want to deposit into your Savings Account: ");
						double amount = input.nextDouble();
						if ((sb + amount) >= 0 && (cb - amount) >= 0 && amount >= 0) {
							calcCheckTransfer(amount);
							System.out.println("\nCurrent Savings Account Balance: " + moneyFormat.format(sb));
							System.out.println(
									"\nCurrent Checkings Account Balance: " + moneyFormat.format(cb));
							end = true;
						} else {
							System.out.println("\nBalance Cannot Be Negative.");
						}
						break;
					case 2:
						return;
					default:
						System.out.println("\nInvalid Choice. please choose 1 or 2");
						break;
					}
				} else if (accType.equals("Savings")) {
					System.out.println("\nSelect an account you wish to tranfers funds to: ");
					System.out.println("1. Checkings Account");
					System.out.println("2. Exit");
					System.out.print("\nChoice: ");
					int choice = input.nextInt();
					switch (choice) {
					case 1:
						System.out.println("\nCurrent Savings Account Balance: " + moneyFormat.format(sb));
						System.out.print("\nAmount you want to deposit into your savings account: ");
						double amount = input.nextDouble();
						if ((cb + amount) >= 0 && (sb - amount) >= 0 && amount >= 0) {
							calcSavingTransfer(amount);
							System.out.println("Please wait....");
							System.out.println("\nCurrent checkings account balance: " + moneyFormat.format(cb));
							System.out.println("\nCurrent savings account balance: " + moneyFormat.format(sb));
							end = true;
						} else {
							System.out.println("\nBalance Cannot Be Negative.");
						}
						break;
					case 2:
						return;
					default:
						System.out.println("\nInvalid Choice.");
						break;
					}
				}
			} catch (InputMismatchException e) {
				System.out.println("\nInvalid Choice.");
				input.next();
			}
		}
	}
}
