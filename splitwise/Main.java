package splitwise;

import java.util.*;

public class Main {

    public static void main(String[] args) {

        // 1. Create Users
        User u1 = new User("U1", "Alice" );
        User u2 = new User("U2", "Bob");
        User u3 = new User("U3", "Charlie" );

        // 2. Create Group
        List<User> groupMembers = Arrays.asList(u1, u2, u3);
        Group tripGroup = new Group("G1", "Goa Trip", groupMembers);

        // 3. Get BalanceSheet Singleton
        BalanceSheet balanceSheet = BalanceSheet.getInstance();

        // 4. Create Expense Service
        ExpenseService expenseService = new ExpenseService(balanceSheet);

        // 5. Create Split Strategy (Equal Split)
        SplitStrategy equalSplit = new EqualStrategy();

        // 6. Create Expense using Factory
        Expense expense1 = ExpenseFactory.createExpense(
                u1,            // Paid by Alice
                300.0,         // Amount
                equalSplit,
                tripGroup.getMembers()
        );

        // 7. Add Expense
        expenseService.addExpense(expense1);

        // 8. Print Balances
        printBalances(balanceSheet);
    }

    private static void printBalances(BalanceSheet balanceSheet) {
        System.out.println("------ BALANCES ------");
        for (Map.Entry<User, Map<User, Double>> entry : balanceSheet.getBalances().entrySet()) {
            User from = entry.getKey();
            for (Map.Entry<User, Double> balance : entry.getValue().entrySet()) {
                User to = balance.getKey();
                double amount = balance.getValue();

                if (amount > 0) {
                    System.out.println(
                            from.getName() + " owes " +
                            to.getName() + " : ₹" + amount
                    );
                }
            }
        }
    }
}
