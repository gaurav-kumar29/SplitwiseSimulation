import java.util.*;
public class CreditController {
    public static Credit createCredit(CreditType creditType, double amount, User paidBy, List<Split> splits) {
        if(creditType == CreditType.EXACT){
            return new ExactCredit(amount, paidBy, splits);
        }
        else if(creditType == CreditType.PERCENT){
            for (Split split : splits) {
                PercentSplit percentSplit = (PercentSplit) split;
                split.setAmount((amount*percentSplit.getPercent())/100.0);
            }
            return new PercentCredit(amount, paidBy, splits);
        }
        else if(creditType == CreditType.EQUAL){
            int noOfSplits = splits.size();
            double splitAmount = ((double) Math.round(amount*100/noOfSplits))/100.0;
            for (Split split : splits) {
                split.setAmount(splitAmount);
            }
            splits.get(0).setAmount(splitAmount + (amount - splitAmount*noOfSplits)); //the first split gets the remainder
            return new EqualCredit(amount, paidBy, splits);
        }
        else {
            return null;
        }
    }
}
