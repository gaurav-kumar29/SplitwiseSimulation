import java.util.*;
public class Manager {
    List<Credit> credits;
    Map<String, User> userRecord;
    Map<String, Map<String, Double> > balanceSheet;

    public Manager(){
        credits = new ArrayList<Credit>();
        userRecord = new HashMap<String, User>();
        balanceSheet = new HashMap<String, Map<String, Double> >();
    }

    public void addUser(User user) {
        userRecord.put(user.getId(), user);
        balanceSheet.put(user.getId(), new HashMap<String, Double>());
    }

    public void addCredit(CreditType creditType, double amount, String paidBy, List<Split> splits) {
        Credit credit = CreditController.createCredit(creditType, amount, userRecord.get(paidBy), splits);
        credits.add(credit);
        for (Split split : credit.getSplits()) {
            String paidTo = split.getUser().getId();
            Map<String, Double> balances = balanceSheet.get(paidBy);
            if (!balances.containsKey(paidTo)) {
                balances.put(paidTo, 0.0);
            }
            balances.put(paidTo, balances.get(paidTo) + split.getAmount());

            balances = balanceSheet.get(paidTo);
            if (!balances.containsKey(paidBy)) {
                balances.put(paidBy, 0.0);
            }
            balances.put(paidBy, balances.get(paidBy) - split.getAmount());
        }
    }

    public void showBalance(String userId) {
        boolean emptyBalance = true;
        for (Map.Entry<String, Double> userBalance : balanceSheet.get(userId).entrySet()) {
            if (userBalance.getValue() != 0) {
                emptyBalance = false;
                printBalance(userId, userBalance.getKey(), userBalance.getValue());
            }
        }

        if (emptyBalance) {
            System.out.println("No balances");
        }
    }

    public void showBalances() {
        boolean emptyBalance = true;
        for (Map.Entry<String, Map<String, Double>> allBalances : balanceSheet.entrySet()) {
            for (Map.Entry<String, Double> userBalance : allBalances.getValue().entrySet()) {
                if (userBalance.getValue() > 0) {
                    emptyBalance = false;
                    printBalance(allBalances.getKey(), userBalance.getKey(), userBalance.getValue());
                }
            }
        }

        if (emptyBalance) {
            System.out.println("No balances");
        }
    }

    private void printBalance(String user1, String user2, double amount) {
        String userName1 = userRecord.get(user1).getName();
        String userName2 = userRecord.get(user2).getName();
        if (amount < 0) {
            System.out.println(userName1 + " owes " + userName2 + ": " + Math.abs(amount));
        } else if (amount > 0) {
            System.out.println(userName2 + " owes " + userName2 + ": " + Math.abs(amount));
        }
    }
}
