package splitwise;

import java.util.*;

public class EqualStrategy implements SplitStrategy {
    
    @Override
    public Map<User,Double> split(double amount, List<User> users){
        double share = amount/users.size();

        Map<User,Double> result = new HashMap<>();

        for(User user: users){
            result.put(user,share);
        }
        return result;
    }
}
