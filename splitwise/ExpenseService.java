package splitwise;
import java.util.Map;

public class ExpenseService {

    private final BalanceSheet balanceSheet;

    public ExpenseService(BalanceSheet balanceSheet) {
        this.balanceSheet = balanceSheet;
    }

    public void addExpense(Expense expense) {
        Map<User, Double> splits = expense.getSplits();

        for (Map.Entry<User, Double> entry : splits.entrySet()) {
            User user = entry.getKey();
            double amount = entry.getValue();

            if (!user.equals(expense.getPaidBy())) {
                balanceSheet.updateBalance(
                        user,
                        expense.getPaidBy(),
                        amount
                );
            }
        }
    }
}
