// import javax.swing.*;
// import java.awt.*;
// import java.awt.event.*;
// import java.util.*;
// class ExpenseUI
//     extends JFrame
//     implements ActionListener {
        
//     Manager manager;
//     // Components of the Form
//     private Container c;
//     private JLabel title;
//     private JTextField tid,tnb,tborrowers,tamt;

//     private JLabel uid,nb,borrowers,amt;
 
//     private JButton exact,equal,percent;
//     private JButton reset;
//     private JTextArea tout;
 

        
    
//     // constructor, to initialize the components
//     // with default values.
//     public ExpenseUI(Manager manager)
//     {
//         this.manager = manager;
//         setTitle("Credit");
//         setBounds(300, 90, 900, 600);
//         setDefaultCloseOperation(EXIT_ON_CLOSE);
//         setResizable(false);
 
//         c = getContentPane();
//         c.setLayout(null);
 
//         title = new JLabel("Credit");
//         title.setFont(new Font("Arial", Font.PLAIN, 30));
//         title.setSize(300, 30);
//         title.setLocation(300, 30);
//         c.add(title);

 
//         uid = new JLabel("Paid by");
//         uid.setFont(new Font("Arial", Font.PLAIN, 20));
//         uid.setSize(100, 20);
//         uid.setLocation(100, 100);
//         c.add(uid);
         
//         tid = new JTextField();
//         tid.setFont(new Font("Arial", Font.PLAIN, 15));
//         tid.setSize(150, 20);
//         tid.setLocation(200, 100);
//         c.add(tid);

//         amt = new JLabel("Amount");
//         amt.setFont(new Font("Arial", Font.PLAIN, 20));
//         amt.setSize(100, 20);
//         amt.setLocation(100, 250);
//         c.add(amt);
         
//         tamt = new JTextField();
//         tamt.setFont(new Font("Arial", Font.PLAIN, 15));
//         tamt.setSize(150, 20);
//         tamt.setLocation(200, 250);
//         c.add(tamt);

//         nb = new JLabel("Number");
//         nb.setFont(new Font("Arial", Font.PLAIN, 20));
//         nb.setSize(100, 20);
//         nb.setLocation(100, 150);
//         c.add(nb);
         
//         tnb = new JTextField();
//         tnb.setFont(new Font("Arial", Font.PLAIN, 15));
//         tnb.setSize(150, 20);
//         tnb.setLocation(200,150);
//         c.add(tnb);
        
//         borrowers = new JLabel("Paid For");
//         borrowers.setFont(new Font("Arial", Font.PLAIN, 20));
//         borrowers.setSize(100, 20);
//         borrowers.setLocation(100,200);
//         c.add(borrowers);
         
//         tborrowers = new JTextField();
//         tborrowers.setFont(new Font("Arial", Font.PLAIN, 15));
//         tborrowers.setSize(150, 20);
//         tborrowers.setLocation(200, 200);
//         c.add(tborrowers);
        
//         equal = new JButton("Equal Split");
//         equal.setFont(new Font("Arial", Font.PLAIN, 15));
//         equal.setSize(200, 20);
//         equal.setLocation(150, 300);
//         equal.addActionListener(this);
//         c.add(equal);

//         percent = new JButton("Percent Split");
//         percent.setFont(new Font("Arial", Font.PLAIN, 15));
//         percent.setSize(200, 20);
//         percent.setLocation(150, 350);
//         percent.addActionListener(this);
//         c.add(percent);



 
//         exact = new JButton("Exact Split");
//         exact.setFont(new Font("Arial", Font.PLAIN, 15));
//         exact.setSize(200, 20);
//         exact.setLocation(150, 400);
//         exact.addActionListener(this);
//         c.add(exact);
 
//         reset = new JButton("Reset");
//         reset.setFont(new Font("Arial", Font.PLAIN, 15));
//         reset.setSize(100, 20);
//         reset.setLocation(200, 450);
//         reset.addActionListener(this);
//         c.add(reset);
 
//         tout = new JTextArea();
//         tout.setFont(new Font("Arial", Font.PLAIN, 15));
//         tout.setSize(300, 400);
//         tout.setLocation(500, 100);
//         tout.setLineWrap(true);
//         tout.setEditable(false);
//         c.add(tout);
 
 
//         setVisible(true);
//     }
 
//     // method actionPerformed()
//     // to get the action performed
//     // by the user and act accordingly
//     public void actionPerformed(ActionEvent e)
//     {
//         if (e.getSource() == equal) {
//             String paidBy = uid.getText();
//             String[] users = tborrowers.getText().split(" ");
//             Double amount = 1000.0;//Double.parseDouble(tamt.getText());
//             int noOfUsers = 1;//Integer.parseInt(nb.getText());
//             String expenseType = "EQUAL";
//             java.util.List<Split> splits = new ArrayList<Split>();
//             for (int i = 0; i < noOfUsers; i++) {
//                 splits.add(new EqualSplit(manager.userRecord.get(users[i])));
//                 System.out.println(users[i]);
//             }
//             System.out.println(paidBy+amount+noOfUsers);
//             manager.addCredit(CreditType.EQUAL, amount, paidBy, splits);   
 

//                 tout.setText("EQUAL");
//                 tout.setEditable(false);
//             }
           
 
//         else if (e.getSource() == reset) {
//             String def = "";
//             tid.setText(def);
//             tnb.setText(def);
//             tborrowers.setText(def);
            
//             tout.setText(def);
//         }
//         else if (e.getSource() == exact) {
//             String data
//                 = "Exact "
//                   + tid.getText() + "\n";
           


//             tout.setText(data);
//             tout.setEditable(false);
//     }
//     }
// }
 