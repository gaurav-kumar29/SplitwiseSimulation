import java.util.*;
public class EqualCredit extends Credit {
    public EqualCredit(double amount, User paidBy, List<Split> splits){
        super(amount, paidBy, splits);
    }

    public boolean validate() {
        for (Split split : getSplits()) {
            if (!(split instanceof EqualSplit)) {
                return false;
            }
        }

        return true;
    }
    
}
