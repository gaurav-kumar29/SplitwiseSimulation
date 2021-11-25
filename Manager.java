import java.util.*;
public class Manager {
    List<Credit> credits;
    Map<String, User> userRecord;
    Map<String, Map<String, Double> > creditRecord;

    public Manager(){
        credits = new ArrayList<Credit>();
        userRecord = new HashMap<String, User>();
        creditRecord = new HashMap<String, Map<String, Double> >();
    }

    public void addUser(User user) {
        userRecord.put(user.getId(), user);
        creditRecord.put(user.getId(), new HashMap<String, Double>());
    }

    public void addCredit(CreditType creditType, double amount, String paidBy, List<Split> splits) {
        Credit credit = CreditController.createCredit(creditType, amount, userRecord.get(paidBy), splits);
        credits.add(credit);
        for (Split split : credit.getSplits()) {
            String paidTo = split.getUser().getId();
            Map<String, Double> balances = creditRecord.get(paidBy);
            if (!balances.containsKey(paidTo)) {
                balances.put(paidTo, 0.0);
            }
            balances.put(paidTo, balances.get(paidTo) + split.getAmount());

            balances = creditRecord.get(paidTo);
            if (!balances.containsKey(paidBy)) {
                balances.put(paidBy, 0.0);
            }
            balances.put(paidBy, balances.get(paidBy) - split.getAmount());
        }
    }

    public List<String> showBalance(String userId) {
        boolean emptyBalance = true;
        List<String> out = new ArrayList<>();
        for (Map.Entry<String, Double> userBalance : creditRecord.get(userId).entrySet()) {
            if (userBalance.getValue() != 0) {
                emptyBalance = false;
               out.add(printBalance(userId, userBalance.getKey(), userBalance.getValue()));
            }

        }

        if (emptyBalance) {
            System.out.println("No balances");
            out.add("No balances");
        }
        return out;
    }

    public List<String> showBalances() {
        List<String> out = new ArrayList<>();
        int i=0;
        boolean emptyBalance = true;
        for (Map.Entry<String, Map<String, Double>> allBalances : creditRecord.entrySet()) {
            for (Map.Entry<String, Double> userBalance : allBalances.getValue().entrySet()) {
                if (userBalance.getValue() > 0) {
                    emptyBalance = false;
                     out.add(printBalance(allBalances.getKey(), userBalance.getKey(), userBalance.getValue()));
                     i++;
                }
            }
        }

        if (emptyBalance) {
            System.out.println("No balances");
            out.add("No balances");
        }
        return out;
    }

    private String printBalance(String user1, String user2, double amount) {
        String userName1 = userRecord.get(user1).getName();
        String userName2 = userRecord.get(user2).getName();
        if (amount < 0) {
            System.out.println(userName1 + " owes " + userName2 + ": " + Math.abs(amount));
            return userName1 + " owes " + userName2 + ": " + Math.abs(amount);
        } else if (amount > 0) {
            System.out.println(userName2 + " owes " + userName1 + ": " + Math.abs(amount));
            return userName2 + " owes " + userName1 + ": " + Math.abs(amount);
        }
        else{
            return "";
        }
    }
}
