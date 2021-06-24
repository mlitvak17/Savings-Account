package savingsaccount;

public class SavingsAccount {
    
    private static double annuallInterestRate; //annual inerest rate for all account holders
    private double savingsBalance; //the amount the saver currently has on deposit
    
    public SavingsAccount(double total){
        savingsBalance = total;    
    }
    
    public double getsavingsBalance(){
        return savingsBalance;
    }
    
    public static void setInterestRate(double intRate){
        annuallInterestRate = intRate;
    }
    
    public void calculateMonthlyInterest(double interest){
        savingsBalance += ((savingsBalance * annuallInterestRate)/12);
    }
    
    public static void main(String[] args) {

        SavingsAccount saver1 = new SavingsAccount(2000.00);
        SavingsAccount saver2 = new SavingsAccount(3000.00);
        System.out.println("Savings Account Balances\nMonth\t    Saver1    Saver2");
        
        for (int i = 1; i<=13; i++) {
            if (i <= 12){
                setInterestRate(0.04);
                saver1.calculateMonthlyInterest(annuallInterestRate);
                saver2.calculateMonthlyInterest(annuallInterestRate);
            }
            else if(i==13) {
                setInterestRate(0.05);
                saver1.calculateMonthlyInterest(annuallInterestRate);
                saver2.calculateMonthlyInterest(annuallInterestRate);
            }
            
            else{
                throw new java.lang.RuntimeException("Months aren't to surpass 13 and yet did!");
            }
            System.out.printf("%d\t   %4.2f   %4.2f\n", i, saver1.getsavingsBalance(), saver2.getsavingsBalance());
        }
    } 
}
