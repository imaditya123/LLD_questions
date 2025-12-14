package splitwise;
import java.util.*;

public class Group {
    private String id;
    private String name;
    private List<User> members;


    public Group(String  id,String name,List<User> members){
        this.id = id;
        this.name = name;

        this.members = members;
    }

    public String getId(){
        return this.id;
    }

    public String getName(){
        return this.name;
    }

    public List<User> getMembers(){
        return this.members;
    }


}
