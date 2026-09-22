package samplearrays;

public class BankAccount {

    String name;
    double currentBalance;
    // Adding a counter variable in order to track the progress of transactions (modular solution until I make sure it is permitted
    private int counter = 0;
    //TO-DO: Initialize an Array with 1000 in size that stores Double called 'transactions' to keep track of the user's transactions
    private double[] transactions = new double[1000];

    public BankAccount(String name, int startingBalance){
        // constructor logic
        this.name = name;
        this.currentBalance = startingBalance;
    }

    public void deposit(double amount){
        if (amount < 0 ){
            System.out.println("Invalid deposit amount.");
        }
        else{
            // adding the deposit to the transactions array
            if (this.counter < this.transactions.length-1) {
                // we will use the add-first increment-second approach so the counter points to the next slot
                transactions[counter] = amount;
                counter++;
            }
            // incrementing the value of the current balance and printing the result
            this.currentBalance+=amount;
            System.out.println(this.name + " has deposited " + amount + "\n New Balance: " + this.currentBalance + ".");
        }
    }

    public void withdraw(double amount){
        if (amount < 0 || amount > this.currentBalance){
            System.out.println("Invalid withdrawal amount");
        }
        else{
            // let's compute the new value of balance first
            this.currentBalance -= amount;

            // let's add it to the transaction as a negative value:
            if (this.counter < this.transactions.length-1){
                transactions[counter] = -amount;
                counter++;
                // let's display an indicator message:
                System.out.println(this.name + " has withdrawn " + amount + "\n New Balance: " + this.currentBalance + ".");
            }
        }
    }

    public void displayTransactions(){
        System.out.println("=========== Transactions Recorded ===========");
        for (int i = 0; i<=this.counter;i++){
            if (this.transactions[i]>=0){
                System.out.println("Deposit of : " + this.transactions[i]);
            }
            else{
                System.out.println("Withdrawal of : " + this.transactions[i]);
            }
        }
        System.out.println("===========        END        ===========");
    }

    public void displayBalance(){
        System.out.println(this.name + "'s current balance is : " + this.currentBalance + ".");
    }

    public static void main(String[] args) {

        BankAccount john = new BankAccount("John Doe", 100);

        // ----- DO NOT CHANGE -----

        //Testing..
        john.displayBalance();
        john.deposit(0.25);
        john.withdraw(100.50);
        john.withdraw(40.90);
        john.deposit(-90.55);
        john.deposit(3000);
        john.displayTransactions();
        john.displayBalance();

        // ----- DO NOT CHANGE -----

    }

}
