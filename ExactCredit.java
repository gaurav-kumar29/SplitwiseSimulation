import java.util.*;
public class ExactCredit extends Credit{
    public ExactCredit(double amount, User paidBy, List<Split> splits) {
        super(amount, paidBy, splits);
    }  
    
    public boolean validate() {
        for (Split split : getSplits()) {
            if (!(split instanceof ExactSplit)) {
                return false;
            }
        }

        double tAmt = getAmount();
        double addedSplitAmount = 0;
        for (Split split : getSplits()) {
            ExactSplit exactSplit = (ExactSplit) split;
            addedSplitAmount += exactSplit.getAmount();
        }

        if (tAmt != addedSplitAmount) {
            return false;
        }

        return true;
    }
}
