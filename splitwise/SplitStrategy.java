package splitwise;
import java.util.*;

public interface SplitStrategy {
    Map<User,Double> split(double amount,List<User> users);
} 