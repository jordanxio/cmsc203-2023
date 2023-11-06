public class CheckingAccount extends BankAccount {
    // Step 2: Static constant FEE representing the cost of clearing one check
    private static final double FEE = 0.15; // 15 cents

    // Step 3: Constructor
    public CheckingAccount(String name, double initialAmount) {
        super(name, initialAmount);
        // Initialize accountNumber as specified
        setAccountNumber(getAccountNumber() + "-10");
    }

    // Step 4: Override the withdraw method
    @Override
    public boolean withdraw(double amount) {
        // Calculate the total amount to be withdrawn (including the fee)
        double totalAmount = amount + FEE;

        // Call the withdraw method from the superclass
        boolean success = super.withdraw(totalAmount);

        // Return the same result as the superclass withdraw method
        return success;
    }

    // Other methods and properties specific to CheckingAccount can be added here
}
