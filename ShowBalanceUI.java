// import javax.swing.*;
// import java.awt.*;
// import java.awt.event.*;
 
// class ShowBalanceUI
//     extends JFrame
//     implements ActionListener {
        
//     Manager manager;    
//     // Components of the Form
//     private Container c;
//     private JLabel title;
//     private JTextField tid;

//     private JLabel uid;
 
//     private JButton sub,show_specific;
//     private JButton reset;
//     private JTextArea tout;
 

 
//     // constructor, to initialize the components
//     // with default values.
//     public ShowBalanceUI(Manager manager)
//     {  
//         this.manager = manager;
//         setTitle("Show Balance");
//         setBounds(300, 90, 900, 600);
//         setDefaultCloseOperation(EXIT_ON_CLOSE);
//         setResizable(false);
 
//         c = getContentPane();
//         c.setLayout(null);
 
//         title = new JLabel("Show Balance");
//         title.setFont(new Font("Arial", Font.PLAIN, 30));
//         title.setSize(300, 30);
//         title.setLocation(300, 30);
//         c.add(title);

 
//         uid = new JLabel("User Id");
//         uid.setFont(new Font("Arial", Font.PLAIN, 20));
//         uid.setSize(100, 20);
//         uid.setLocation(100, 100);
//         c.add(uid);
         
//         tid = new JTextField();
//         tid.setFont(new Font("Arial", Font.PLAIN, 15));
//         tid.setSize(150, 20);
//         tid.setLocation(200, 100);
//         c.add(tid);
        
//         show_specific = new JButton("Show for specific User");
//         show_specific.setFont(new Font("Arial", Font.PLAIN, 15));
//         show_specific.setSize(200, 20);
//         show_specific.setLocation(150, 150);
//         show_specific.addActionListener(this);
//         c.add(show_specific);



 
//         sub = new JButton("Show for all users");
//         sub.setFont(new Font("Arial", Font.PLAIN, 15));
//         sub.setSize(200, 20);
//         sub.setLocation(150, 200);
//         sub.addActionListener(this);
//         c.add(sub);
 
//         reset = new JButton("Reset");
//         reset.setFont(new Font("Arial", Font.PLAIN, 15));
//         reset.setSize(100, 20);
//         reset.setLocation(200, 250);
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
//         if (e.getSource() == show_specific) {
//                 String data
//                     = "Id : "
//                       + tid.getText() + "\n";
               
//                 if(!tid.getText().equals("")){
//                 manager.showBalance(tid.getText());
//                 }
//                 else{
//                     tout.setText("Enter an existing user id");
//                 }
//                 tout.setText(data);
//                 tout.setEditable(false);
//             }
           
 
//         else if (e.getSource() == reset) {
//             String def = "";
//             tid.setText(def);
        
//             tout.setText(def);
//         }
//         else if (e.getSource() == sub) {
//             String data
//                 = "ALL  "
//                   + tid.getText() + "\n";
           
//             manager.showBalances();

//             tout.setText(data);
//             tout.setEditable(false);
//     }
//     }
// }
