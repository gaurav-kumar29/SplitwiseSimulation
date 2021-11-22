import java.util.*;
public class Manager {
    List<Credit> credits;
    Map<String, User> userMap;
    Map<String, Map<String, Double> > balanceSheet;

    public Manager(){
        credits = new ArrayList<Credit>();
        userMap = new HashMap<String, User>();
        balanceSheet = new HashMap<String, Map<String, Double> >();
    }
}
