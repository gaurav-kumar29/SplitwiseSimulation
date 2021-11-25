import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Main {
    Manager creditManager = new Manager(); 
    public static void main(String[] args) {
        
        Main.AddUserUI addUserUI = new Main().new AddUserUI();

        Scanner scanner = new Scanner(System.in);
 
    }


    class AddUserUI
    extends JFrame
    implements ActionListener {
 
    // Components of the Form
    private Container c;
    private JLabel title;
    private JLabel name;
    private JTextField tname,tid;
    private JLabel mno;
    private JTextField tmno;
    private JLabel uid;
  
    //private JLabel add;
    private JButton add;
    private JButton reset,show,credit;
    private JTextArea tout;
    private JLabel res;
   
  //  Manager manager;
 
    // constructor, to initialize the components
    // with default values.
    public AddUserUI()//Manager manager)
    {
     //   this.manager = manager;
        setTitle("Add Users");
        setBounds(300, 90, 900, 600);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setResizable(false);
 
        c = getContentPane();
        c.setLayout(null);
 
        title = new JLabel("Add Users");
        title.setFont(new Font("Arial", Font.PLAIN, 30));
        title.setSize(300, 30);
        title.setLocation(300, 30);
        c.add(title);
 
        name = new JLabel("Name");
        name.setFont(new Font("Arial", Font.PLAIN, 20));
        name.setSize(100, 20);
        name.setLocation(100, 100);
        c.add(name);
 
        tname = new JTextField();
        tname.setFont(new Font("Arial", Font.PLAIN, 15));
        tname.setSize(190, 20);
        tname.setLocation(200, 100);
        c.add(tname);
 
        mno = new JLabel("Mobile");
        mno.setFont(new Font("Arial", Font.PLAIN, 20));
        mno.setSize(100, 20);
        mno.setLocation(100, 150);
        c.add(mno);
 
        tmno = new JTextField();
        tmno.setFont(new Font("Arial", Font.PLAIN, 15));
        tmno.setSize(150, 20);
        tmno.setLocation(200, 150);
        c.add(tmno);
 
        uid = new JLabel("User Id");
        uid.setFont(new Font("Arial", Font.PLAIN, 20));
        uid.setSize(100, 20);
        uid.setLocation(100, 200);
        c.add(uid);
         
        tid = new JTextField();
        tid.setFont(new Font("Arial", Font.PLAIN, 15));
        tid.setSize(150, 20);
        tid.setLocation(200, 200);
        c.add(tid);
        
        add = new JButton("Add User");
        add.setFont(new Font("Arial", Font.PLAIN, 15));
        add.setSize(100, 20);
        add.setLocation(150, 250);
        add.addActionListener(this);
        c.add(add);
  
 
        reset = new JButton("Reset");
        reset.setFont(new Font("Arial", Font.PLAIN, 15));
        reset.setSize(100, 20);
        reset.setLocation(270, 250);
        reset.addActionListener(this);
        c.add(reset);

        show = new JButton("Show");
        show.setFont(new Font("Arial", Font.PLAIN, 15));
        show.setSize(100, 20);
        show.setLocation(150, 300);
        show.addActionListener(this);
        c.add(show);
  
 
        credit = new JButton("Credit");
        credit.setFont(new Font("Arial", Font.PLAIN, 15));
        credit.setSize(100, 20);
        credit.setLocation(270, 300);
        credit.addActionListener(this);
        c.add(credit);
 
        tout = new JTextArea();
        tout.setFont(new Font("Arial", Font.PLAIN, 15));
        tout.setSize(300, 400);
        tout.setLocation(500, 100);
        tout.setLineWrap(true);
        tout.setEditable(false);
        c.add(tout);
 
        res = new JLabel("");
        res.setFont(new Font("Arial", Font.PLAIN, 20));
        res.setSize(500, 25);
        res.setLocation(100, 500);
        c.add(res);
 
  
 
        setVisible(true);
    }
 
    // method actionPerformed()
    // to get the action performed
    // by the user and act accordingly
    public void actionPerformed(ActionEvent e)
    {
        if (e.getSource() == add) {
                
                  String data = "Name : "
                      + tname.getText() + "\n"
                      + "Mobile : "
                      + tmno.getText() + "\n" + "User Id : "
                      + tid.getText() + "\n";
 

                tout.setText(data );
                tout.setEditable(false);
                creditManager.addUser(new User(tid.getText(), tname.getText(),tmno.getText()));
                res.setText("User Added Successfully..");
        }
 
        else if (e.getSource() == reset) {
            String def = "";
            tname.setText(def);
            tmno.setText(def);
            res.setText(def);
            tout.setText(def);
            tid.setText(def);
        }
        else if(e.getSource()==show){
            this.dispose();
            ShowBalanceUI showBalanceUI= new ShowBalanceUI();

        }
        else if(e.getSource()==credit){
            this.dispose();
            ExpenseUI expenseUI = new ExpenseUI();

        }
    }
}

class ShowBalanceUI
    extends JFrame
    implements ActionListener {
        
   
    // Components of the Form
    private Container c;
    private JLabel title;
    private JTextField tid;

    private JLabel uid;
 
    private JButton sub,show_specific, showCredit;
    private JButton reset;
    private JTextArea tout;
 

 
    // constructor, to initialize the components
    // with default values.
    public ShowBalanceUI()
    {  
        
        setTitle("Show Balance");
        setBounds(300, 90, 900, 600);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setResizable(false);
 
        c = getContentPane();
        c.setLayout(null);
 
        title = new JLabel("Show Balance");
        title.setFont(new Font("Arial", Font.PLAIN, 30));
        title.setSize(300, 30);
        title.setLocation(300, 30);
        c.add(title);

 
        uid = new JLabel("User Id");
        uid.setFont(new Font("Arial", Font.PLAIN, 20));
        uid.setSize(100, 20);
        uid.setLocation(100, 100);
        c.add(uid);
         
        tid = new JTextField();
        tid.setFont(new Font("Arial", Font.PLAIN, 15));
        tid.setSize(150, 20);
        tid.setLocation(200, 100);
        c.add(tid);
        
        show_specific = new JButton("Show for specific User");
        show_specific.setFont(new Font("Arial", Font.PLAIN, 15));
        show_specific.setSize(200, 20);
        show_specific.setLocation(150, 150);
        show_specific.addActionListener(this);
        c.add(show_specific);



 
        sub = new JButton("Show for all users");
        sub.setFont(new Font("Arial", Font.PLAIN, 15));
        sub.setSize(200, 20);
        sub.setLocation(150, 200);
        sub.addActionListener(this);
        c.add(sub);
 
        reset = new JButton("Reset");
        reset.setFont(new Font("Arial", Font.PLAIN, 15));
        reset.setSize(100, 20);
        reset.setLocation(200, 250);
        reset.addActionListener(this);
        c.add(reset);

        showCredit = new JButton("Credit");
        showCredit.setFont(new Font("Arial", Font.PLAIN, 15));
        showCredit.setSize(100, 20);
        showCredit.setLocation(200, 300);
        showCredit.addActionListener(this);
        c.add(showCredit);
 
        tout = new JTextArea();
        tout.setFont(new Font("Arial", Font.PLAIN, 15));
        tout.setSize(300, 400);
        tout.setLocation(500, 100);
        tout.setLineWrap(true);
        tout.setEditable(false);
        c.add(tout);
 
 
        setVisible(true);
    }
 
    // method actionPerformed()
    // to get the action performed
    // by the user and act accordingly
    public void actionPerformed(ActionEvent e)
    {
        if (e.getSource() == show_specific) {
             
               
           
                creditManager.showBalance(tid.getText());
                List<String> out=   creditManager.showBalances();
                String op = new String();
                for(int i=0; i<out.size();i++){
                    op+=out.get(i)+"\n";
                }
                tout.setText(op);
                tout.setEditable(false);
            }
           
 
        else if (e.getSource() == reset) {
            String def = "";
            tid.setText(def);
        
            tout.setText(def);
        }
        else if (e.getSource() == sub) {

            List<String> out=   creditManager.showBalances();
            String op = new String();
            for(int i=0; i<out.size();i++){
                op+=out.get(i)+"\n";
            }
            tout.setText(op);
            tout.setEditable(false);
    }
    else if (e.getSource() == showCredit) {
        this.dispose();
        ExpenseUI expenseUI = new ExpenseUI();
        
}
    }
}
class ExpenseUI
    extends JFrame
    implements ActionListener {
        
   
    // Components of the Form
    private Container c;
    private JLabel title;
    private JTextField tid,tnb,tborrowers,tamt,tparams;

    private JLabel uid,nb,borrowers,amt, params;
 
    private JButton exact,equal,percent,show;
    private JButton reset;
    private JTextArea tout;
 

        
    
    // constructor, to initialize the components
    // with default values.
    public ExpenseUI()
    {
      
        setTitle("Credit");
        setBounds(300, 90, 900, 600);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setResizable(false);
 
        c = getContentPane();
        c.setLayout(null);
 
        title = new JLabel("Credit");
        title.setFont(new Font("Arial", Font.PLAIN, 30));
        title.setSize(300, 30);
        title.setLocation(300, 30);
        c.add(title);

 
        uid = new JLabel("Paid by");
        uid.setFont(new Font("Arial", Font.PLAIN, 20));
        uid.setSize(100, 20);
        uid.setLocation(100, 100);
        c.add(uid);
         
        tid = new JTextField();
        tid.setFont(new Font("Arial", Font.PLAIN, 15));
        tid.setSize(150, 20);
        tid.setLocation(200, 100);
        c.add(tid);

        amt = new JLabel("Amount");
        amt.setFont(new Font("Arial", Font.PLAIN, 20));
        amt.setSize(100, 20);
        amt.setLocation(100, 250);
        c.add(amt);
         
        tamt = new JTextField();
        tamt.setFont(new Font("Arial", Font.PLAIN, 15));
        tamt.setSize(150, 20);
        tamt.setLocation(200, 250);
        c.add(tamt);

        nb = new JLabel("UserNo");
        nb.setFont(new Font("Arial", Font.PLAIN, 20));
        nb.setSize(100, 20);
        nb.setLocation(100, 150);
        c.add(nb);
         
        tnb = new JTextField();
        tnb.setFont(new Font("Arial", Font.PLAIN, 15));
        tnb.setSize(150, 20);
        tnb.setLocation(200,150);
        c.add(tnb);
        
        borrowers = new JLabel("Paid For");
        borrowers.setFont(new Font("Arial", Font.PLAIN, 20));
        borrowers.setSize(100, 20);
        borrowers.setLocation(100,200);
        c.add(borrowers);
         
        tborrowers = new JTextField();
        tborrowers.setFont(new Font("Arial", Font.PLAIN, 15));
        tborrowers.setSize(150, 20);
        tborrowers.setLocation(200, 200);
        c.add(tborrowers);
        
        equal = new JButton("Equal Split");
        equal.setFont(new Font("Arial", Font.PLAIN, 15));
        equal.setSize(200, 20);
        equal.setLocation(150, 300);
        equal.addActionListener(this);
        c.add(equal);

        percent = new JButton("Percent Split");
        percent.setFont(new Font("Arial", Font.PLAIN, 15));
        percent.setSize(200, 20);
        percent.setLocation(150, 350);
        percent.addActionListener(this);
        c.add(percent);



 
        exact = new JButton("Exact Split");
        exact.setFont(new Font("Arial", Font.PLAIN, 15));
        exact.setSize(200, 20);
        exact.setLocation(150, 400);
        exact.addActionListener(this);
        c.add(exact);
 
        reset = new JButton("Reset");
        reset.setFont(new Font("Arial", Font.PLAIN, 15));
        reset.setSize(100, 20);
        reset.setLocation(200, 450);
        reset.addActionListener(this);
        c.add(reset);

         
        show = new JButton("Show");
        show.setFont(new Font("Arial", Font.PLAIN, 15));
        show.setSize(100, 20);
        show.setLocation(200, 500);
        show.addActionListener(this);
        c.add(show);
 
        params = new JLabel("Enter Parameters");
        params.setFont(new Font("Arial", Font.PLAIN, 20));
        params.setSize(200, 20);
        params.setLocation(500,100);
        c.add(params);
         
        tparams = new JTextField();
        tparams.setFont(new Font("Arial", Font.PLAIN, 15));
        tparams.setSize(200, 20);
        tparams.setLocation(500, 150);
        c.add(tparams);
 
 
        setVisible(true);
    }
 
    // method actionPerformed()
    // to get the action performed
    // by the user and act accordingly
    public void actionPerformed(ActionEvent e)
    {
        if (e.getSource() == equal) {
            String paidBy = tid.getText();
            String[] users = tborrowers.getText().split(" ");
            Double amount = Double.parseDouble(tamt.getText());
            int noOfUsers = Integer.parseInt(tnb.getText());
            String expenseType = "EQUAL";
            java.util.List<Split> splits = new ArrayList<Split>();
            for (int i = 0; i < noOfUsers; i++) {
                splits.add(new EqualSplit(creditManager.userRecord.get(users[i])));
                
            }

            creditManager.addCredit(CreditType.EQUAL, amount, paidBy, splits);   
 

                
            }
           
 
        else if (e.getSource() == reset) {
            String def = "";
            tid.setText(def);
            tnb.setText(def);
            tborrowers.setText(def);
            
            tout.setText(def);
        }
        else if (e.getSource() == show) {
            this.dispose();
            ShowBalanceUI showBalanceUI= new ShowBalanceUI();
        }
        else if (e.getSource() == exact) {
            String paidBy = tid.getText();
            String[] users = tborrowers.getText().split(" ");
            Double amount = Double.parseDouble(tamt.getText());
            int noOfUsers = Integer.parseInt(tnb.getText());
           
            java.util.List<Split> splits = new ArrayList<Split>();
            for (int i = 0; i < noOfUsers; i++) {
                                        splits.add(new ExactSplit(creditManager.userRecord.get(users[i]), Double.parseDouble(tparams.getText().split(" ")[i])));
                                    }
                                    creditManager.addCredit(CreditType.EXACT, amount, paidBy, splits);
    }
    else if (e.getSource() == percent) {
        String paidBy = tid.getText();
            String[] users = tborrowers.getText().split(" ");
            Double amount = Double.parseDouble(tamt.getText());
            int noOfUsers = Integer.parseInt(tnb.getText());
          
            java.util.List<Split> splits = new ArrayList<Split>();
        for (int i = 0; i < noOfUsers; i++) {
                                    splits.add(new PercentSplit(creditManager.userRecord.get(users[i]), Double.parseDouble(tparams.getText().split(" ")[i])));
                                }
                                creditManager.addCredit(CreditType.PERCENT, amount, paidBy, splits);
}
    }
}
 

}
