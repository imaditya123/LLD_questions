package splitwise;

import java.util.*;

public class PercentageStrategy implements SplitStrategy{

    private final Map<User,Double> percentages;

    public PercentageStrategy(Map<User,Double> percentages){
        this.percentages = percentages;
    }

    @Override
    public Map<User,Double> split(double amount,List<User> users){

        Map<User,Double> result = new HashMap<>();

        for(User user: users){
            result.put(user,amount*percentages.get(user)/100);
        }

        return result;

    }
    
}
