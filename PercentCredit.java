import java.util.*;
public class PercentCredit extends Credit {
    public PercentCredit(double amount, User paidBy, List<Split> splits) {
        super(amount, paidBy, splits);
    }   

    public boolean validate() {
        for (Split split : getSplits()) {
            if (!(split instanceof PercentSplit)) {
                return false;
            }
        }

        double addedSplitPercent = 0;
        for (Split split : getSplits()) {
            PercentSplit percentSplit = (PercentSplit) split;
            addedSplitPercent += percentSplit.getPercent();
        }

        if (addedSplitPercent!=100) {
            return false;
        }

        return true;
    }
}
