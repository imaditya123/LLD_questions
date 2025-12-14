package splitwise;

import java.util.*;
public class Expense {
    private final String id;
    private final User paidBy;
    private final double amount;
    private final SplitStrategy splitStrategy;
    private final List<User> participants;

    public Expense(String id,User paidBy,double amount,SplitStrategy splitStrategy,List<User> participants){
        this.id = id;
        this.paidBy = paidBy;
        this.amount = amount;
        this.splitStrategy = splitStrategy;
        this.participants = participants;
    }
    public User getPaidBy() { return paidBy; }
    public double getAmount() { return amount; }

    public Map<User, Double> getSplits() {
        return splitStrategy.split(amount, participants);
    }

}
