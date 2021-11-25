// import javax.swing.*;
// import java.awt.*;
// import java.awt.event.*;

// class AddUserUI
//     extends JFrame
//     implements ActionListener {
 
//     // Components of the Form
//     private Container c;
//     private JLabel title;
//     private JLabel name;
//     private JTextField tname,tid;
//     private JLabel mno;
//     private JTextField tmno;
//     private JLabel uid;
  
//     //private JLabel add;
//     private JButton add;
//     private JButton reset,show,credit;
//     private JTextArea tout;
//     private JLabel res;
   
//     Manager manager;
 
//     // constructor, to initialize the components
//     // with default values.
//     public AddUserUI(Manager manager)
//     {
//         this.manager = manager;
//         setTitle("Add Users");
//         setBounds(300, 90, 900, 600);
//         setDefaultCloseOperation(EXIT_ON_CLOSE);
//         setResizable(false);
 
//         c = getContentPane();
//         c.setLayout(null);
 
//         title = new JLabel("Add Users");
//         title.setFont(new Font("Arial", Font.PLAIN, 30));
//         title.setSize(300, 30);
//         title.setLocation(300, 30);
//         c.add(title);
 
//         name = new JLabel("Name");
//         name.setFont(new Font("Arial", Font.PLAIN, 20));
//         name.setSize(100, 20);
//         name.setLocation(100, 100);
//         c.add(name);
 
//         tname = new JTextField();
//         tname.setFont(new Font("Arial", Font.PLAIN, 15));
//         tname.setSize(190, 20);
//         tname.setLocation(200, 100);
//         c.add(tname);
 
//         mno = new JLabel("Mobile");
//         mno.setFont(new Font("Arial", Font.PLAIN, 20));
//         mno.setSize(100, 20);
//         mno.setLocation(100, 150);
//         c.add(mno);
 
//         tmno = new JTextField();
//         tmno.setFont(new Font("Arial", Font.PLAIN, 15));
//         tmno.setSize(150, 20);
//         tmno.setLocation(200, 150);
//         c.add(tmno);
 
//         uid = new JLabel("User Id");
//         uid.setFont(new Font("Arial", Font.PLAIN, 20));
//         uid.setSize(100, 20);
//         uid.setLocation(100, 200);
//         c.add(uid);
         
//         tid = new JTextField();
//         tid.setFont(new Font("Arial", Font.PLAIN, 15));
//         tid.setSize(150, 20);
//         tid.setLocation(200, 200);
//         c.add(tid);
        
//         add = new JButton("Add User");
//         add.setFont(new Font("Arial", Font.PLAIN, 15));
//         add.setSize(100, 20);
//         add.setLocation(150, 250);
//         add.addActionListener(this);
//         c.add(add);
  
 
//         reset = new JButton("Reset");
//         reset.setFont(new Font("Arial", Font.PLAIN, 15));
//         reset.setSize(100, 20);
//         reset.setLocation(270, 250);
//         reset.addActionListener(this);
//         c.add(reset);

//         show = new JButton("Show");
//         show.setFont(new Font("Arial", Font.PLAIN, 15));
//         show.setSize(100, 20);
//         show.setLocation(150, 300);
//         show.addActionListener(this);
//         c.add(show);
  
 
//         credit = new JButton("Credit");
//         credit.setFont(new Font("Arial", Font.PLAIN, 15));
//         credit.setSize(100, 20);
//         credit.setLocation(270, 300);
//         credit.addActionListener(this);
//         c.add(credit);
 
//         tout = new JTextArea();
//         tout.setFont(new Font("Arial", Font.PLAIN, 15));
//         tout.setSize(300, 400);
//         tout.setLocation(500, 100);
//         tout.setLineWrap(true);
//         tout.setEditable(false);
//         c.add(tout);
 
//         res = new JLabel("");
//         res.setFont(new Font("Arial", Font.PLAIN, 20));
//         res.setSize(500, 25);
//         res.setLocation(100, 500);
//         c.add(res);
 
  
 
//         setVisible(true);
//     }
 
//     // method actionPerformed()
//     // to get the action performed
//     // by the user and act accordingly
//     public void actionPerformed(ActionEvent e)
//     {
//         if (e.getSource() == add) {
                
//                   String data = "Name : "
//                       + tname.getText() + "\n"
//                       + "Mobile : "
//                       + tmno.getText() + "\n" + "User Id : "
//                       + tid.getText() + "\n";
 

//                 tout.setText(data );
//                 tout.setEditable(false);
//                 manager.addUser(new User(tid.getText(), tname.getText(),tmno.getText()));
//                 res.setText("User Added Successfully..");
//         }
 
//         else if (e.getSource() == reset) {
//             String def = "";
//             tname.setText(def);
//             tmno.setText(def);
//             res.setText(def);
//             tout.setText(def);
//             tid.setText(def);
//         }
//         else if(e.getSource()==show){
//             this.dispose();
//             ShowBalanceUI showBalanceUI= new ShowBalanceUI(manager);

//         }
//         else if(e.getSource()==credit){
//             this.dispose();
//             ExpenseUI expenseUI = new ExpenseUI(manager);

//         }
//     }
// }