import java.util.*;

class Account {
    int balance;
    String tran_his = "";
    int tran;
    String str;

    Account() {
        balance = 100000;
        tran_his = " ";
        tran = 0;
    }

    void Transaction() {
        if (tran == 0) {
            System.out.println("No Transactions");
        } else {
            System.out.println("Transactions is = \n" + tran_his);
        }

    }

    void Withdraw(int amount) {
        if (balance > amount) {
            tran++;
            balance = balance - amount;
            str = "withdraw  " + amount + "\n";
            tran_his = tran_his.concat(str);
            System.out.println("Withdraw Successful");
            System.out.println("---------------------------------------------------");
        } else {
            System.out.println("Insufficient Funds!");
            System.out.println("---------------------------------------------------");
        }

    }

    void Deposit(int amount) {
        tran++;
        balance = balance + amount;
        str = "Deposite  " + amount + "\n";
        tran_his = tran_his.concat(str);
        System.out.println("Deposit Successful");
        System.out.println("---------------------------------------------------");
    }

    void Transfer(int trans_acc, int amount) {
        if (balance > amount) {
            tran++;
            balance = balance - amount;
            str = "Transfer  " + amount + " to : " + trans_acc + "\n";
            tran_his = tran_his.concat(str);
            System.out.println("Transfer Successful");
            System.out.println("---------------------------------------------------");
        } else {
            System.out.println("Insufficient Funds!");
            System.out.println("---------------------------------------------------");
        }
    }

}

class Atm {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int id = 123456;
        int pass = 123456;
        int id1, pass1;
        int ch, amount;
        System.out.println("Please Log In to Your Account");
        System.out.print("Log in id = ");
        id1 = sc.nextInt();
        System.out.print("Password = ");
        pass1 = sc.nextInt();
        Account ac = new Account();
        System.out.println("-----------------------Welcome----------------------------");
        while (true) {
            if (id1 == id && pass1 == pass) {

                System.out.println(
                        "Please select following options:\n1) Transaction History \n2) Withdraw \n3) Deposit \n4) Transfer \n5) Quite");
                ch = sc.nextInt();

                switch (ch) {
                    case 1:
                        System.out.println("-----------------------Transaction----------------------------");
                        ac.Transaction();
                        System.out.println("-----------------------Transaction----------------------------");
                        break;

                    case 2:
                        System.out.println("Enter amount to be withdraw");
                        amount = sc.nextInt();
                        if (amount < 10000) {
                            ac.Withdraw(amount);
                        } else {
                            System.out.println("Your only withdraw 10000 at one transaction");
                            System.out.println("---------------------------------------------------");
                        }
                        break;

                    case 3:
                        System.out.println("Enter amount to be deposite");
                        amount = sc.nextInt();
                        if (amount < 100000) {
                            ac.Deposit(amount);
                        } else {
                            System.out.println("Your only deposite 100000 at one transaction");
                            System.out.println("---------------------------------------------------");
                        }
                        break;

                    case 4:
                        int trans_acc;
                        System.out.println("Enter Receiver Account Number");
                        trans_acc = sc.nextInt();
                        System.out.println("Enter amount to be Transefer");
                        amount = sc.nextInt();
                        if (amount <= 50000) {
                            ac.Transfer(trans_acc, amount);
                        } else {
                            System.out.println("Your only withdraw 50000 at one transaction");
                            System.out.println("---------------------------------------------------");
                        }
                        break;

                    case 5:
                        System.out.println("-------------------Thank You-------------------------");
                        System.exit(0);
                        break;

                }
            } else {
                System.out.println("You enter wrong id and password : ");
                System.exit(0);
            }
        }

    }
}