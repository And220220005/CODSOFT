import java.util.Scanner;

class BankAccount {
    double balance;
    String accountNumber;
    String accountHolderName;

    BankAccount(String accountNumber, String accountHolderName, double initialBalance) {
        this.accountNumber = accountNumber;
        this.accountHolderName = accountHolderName;
        this.balance = initialBalance;
    }

   double getBalance() {
        return balance;
    }

    void deposit(double amount) {
        balance += amount;
    }

     boolean withdraw(double amount) {
        if (amount <= balance) {
            balance -= amount;
            return true;
        } else {
            return false;
        }
    }

    String getAccountNumber() {
        return accountNumber;
    }

    String getAccountHolderName() {
        return accountHolderName;
    }
};

 class ATM {
    BankAccount account;
    String pin;
    double withdrawalLimit;

   ATM(BankAccount account, String pin, double withdrawalLimit) {
        this.account = account;
        this.pin = pin;
        this.withdrawalLimit = withdrawalLimit;
    }

   void checkBalance(String enteredPin) {
        if (enteredPin.equals(pin)) {
            System.out.println("Your current balance is: " + account.getBalance()+" Rupees");
        } else {
            System.out.println("Incorrect PIN. Please try again.");
        }
    }

    void withdraw(double amount, String enteredPin) {
        if (enteredPin.equals(pin)) {
            if (amount > 0) {
                if (account.getBalance() >= amount) {
                    if (amount <= withdrawalLimit) {
                        account.withdraw(amount);
                        System.out.println("Withdrawal successful. Remaining balance: " + account.getBalance()+" Rupees");
                    } else {
                        System.out.println("Withdrawal limit exceeded. Maximum withdrawal is " + withdrawalLimit+" Rupees");
                    }
                } else {
                    System.out.println("Insufficient funds. Please deposit more money.");
                }
            } else {
                System.out.println("Invalid withdrawal amount. Please enter a positive value.");
            }
        } else {
            System.out.println("Incorrect PIN. Please try again.");
        }
    }

   void deposit(double amount) {
        if (amount > 0) {
            account.deposit(amount);
            System.out.println("Deposit successful. New balance:" + account.getBalance()+" Rupees");
        } else {
            System.out.println("Invalid deposit amount. Please enter a positive value.");
        }
    }

   void changePin(String oldPin, String newPin) {
        if (oldPin.equals(pin)) {
            pin = newPin;
            System.out.println("PIN changed successfully.");
        } else {
            System.out.println("Incorrect old PIN. Please try again.");
        }
    }

    public static void main(String[] args) {
        BankAccount account = new BankAccount("1234567890", "John Doe", 1000.0);
        ATM atm = new ATM(account, "1234", 500.0);
        Scanner ob = new Scanner(System.in);

        while (true) {
            System.out.println("Welcome to Apex ATM");
            System.out.print("Please enter your PIN: ");
            String pin = ob.nextLine();

            System.out.println("Main Menu:");
            System.out.println("1. Check Balance");
            System.out.println("2. Withdraw Cash");
            System.out.println("3. Deposit Cash");
            System.out.println("4. Change PIN");
            System.out.println("5. Exit");
            System.out.print("Please select an option: ");
            int option = Integer.parseInt(ob.nextLine());

            switch (option) {
                case 1:
                    atm.checkBalance(pin);
                    break;
                case 2:
                    System.out.print("Enter amount to withdraw:Rupees ");
                    double withdrawAmount = Double.parseDouble(ob.nextLine());
                    atm.withdraw(withdrawAmount, pin);
                    break;
                case 3:
                    System.out.print("Enter amount to deposit: (in rupees)");
                    double depositAmount = Double.parseDouble(ob.nextLine());
                    atm.deposit(depositAmount);
                    break;
                case 4:
                    System.out.print("Enter old PIN: ");
                    String oldPin = ob.nextLine();
                    System.out.print("Enter new PIN: ");
                    String newPin = ob.nextLine();
                    atm.changePin(oldPin, newPin);
                    break;
                case 5:
                    System.out.println("Thank you for using Apex ATM. Meet you again!");
                    return;
                default:
                    System.out.println("Invalid option. Please try again.");
            }
        }
    }
};


