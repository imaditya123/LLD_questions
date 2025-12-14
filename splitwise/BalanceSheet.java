package splitwise;

import java.util.*;

public class BalanceSheet {
    private static BalanceSheet instance;
    private final Map<User, Map<User, Double>> balances;

    private BalanceSheet() {
        balances = new HashMap<>();
    }

    public static synchronized BalanceSheet getInstance() {
        if (instance == null) {
            instance = new BalanceSheet();
        }
        return instance;
    }

    public void updateBalance(User from, User to, double amount) {
        balances.putIfAbsent(from, new HashMap<>());
        balances.get(from).put(
                to,
                balances.get(from).getOrDefault(to, 0.0) + amount
        );
    }

    public Map<User, Map<User, Double>> getBalances() {
        return balances;
    }

    
}
