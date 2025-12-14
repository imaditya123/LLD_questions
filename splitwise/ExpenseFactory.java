package splitwise;

import java.util.*;
public class ExpenseFactory {

    public static Expense createExpense(User paidBy,double amount,SplitStrategy strategy,List<User> participants){
        return new Expense(
            UUID.randomUUID().toString(),
            paidBy,
            amount,
            strategy,
            participants);

    }
}
