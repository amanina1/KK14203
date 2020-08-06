import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.util.ArrayList;
import javax.swing.event.*;
import java.io.*;

class Cake
{
   public String name;
   public String[] topping, toppingOrder;
   public double priceSmall, priceMedium, priceBig, totalPrice;
   public int size, quantity;

   Cake(String name)
   {
      this.name = name;
   }
 
   void setCake(String[] Topping, double PriceSmall, double PriceMedium, double PriceBig)
   {
      this.topping = Topping;
      this.priceSmall = PriceSmall;
      this.priceMedium = PriceMedium;
      this.priceBig = PriceBig;
   }
   
   void cakeOrder(String[] toppingOrder, int qty, int size)
   {
      this.toppingOrder = toppingOrder;
      this.quantity = qty;
      this.size = size;
   }
   
   double getSizePrice()
   {
      if(size == 1)
      {
         return priceSmall;
      }
      else if(size == 2)
      {
         return priceMedium;
      }
      else
      {
         return priceBig;
      }
   }
   
   double getTotalPrice()
   {
      totalPrice = getSizePrice() * quantity + (toppingOrder.length * 10);
      return totalPrice;
   }
   
   String getSize()
   {
      String Size = "";
      if(size == 1)
      {
         Size = "Small";
      }
      else if(size == 2)
      {
         Size = "Medium";
      }
      else if (size == 3)
      {
         Size = "Big";
      }
      return Size;
   } 
   
   public String printOrder()
   {
      String content = "\n\n   Cake Order Detail :\n";
      content += "--------------------------------------\n";
      content += "   Topping Order : \n";
      for(int i=0; i<toppingOrder.length; i++){
         content += "   (" + (i+1) + ") " + toppingOrder[i] + " \n";
      } 
      content += "\n   Size : " + getSize() + "\n";
      content += "--------------------------------------\n";
      content += "   Total Price : RM" + getTotalPrice() + "\n"; 
      content += "--------------------------------------\n"; 
      return content;
   }      
}

public class Lab6_Exercise3 extends JPanel implements ActionListener{
   private JLabel label1;
   private JLabel label2;
   private JButton btadd;
   private JTextArea text1;
   private JComboBox cb;
   private JButton btorder, btclear;
   private static Cake cake;
   private static ArrayList<String> order;

   public Lab6_Exercise3() {
      String[] cbitems = {" ( Select ) "};
      label1 = new JLabel ("Cake Menu");
      label2 = new JLabel ("Select Toppings : ");
      btadd = new JButton ("Add Topping");
      text1 = new JTextArea (5, 5);
      JScrollPane jt1 = new JScrollPane(text1);
      cb = new JComboBox (cbitems);
      btorder = new JButton ("Order");
      btclear = new JButton("Clear");
        
      btadd.addActionListener(this);
      btorder.addActionListener(this);
   
      setPreferredSize (new Dimension (514, 500));
      setLayout (null);
   
      add (label1);
      add (label2);
      add (btadd);
      add (jt1);
      add (cb);
      add (btorder);
      add (btclear);
      
      btclear.addActionListener(this);
   
      label1.setBounds (195, 10, 100, 25);
      label2.setBounds (30, 55, 125, 25);
      btadd.setBounds (340, 55, 125, 25);
      jt1.setBounds (25, 160, 440, 300);
      cb.setBounds (140, 55, 180, 25);
      btorder.setBounds (340, 90, 125, 25);
      btclear.setBounds (340, 125, 125, 25);
   }
    
   public void actionPerformed(ActionEvent ae){
      String command = ae.getActionCommand(); 
      
      if(command.equals("Add Topping")){
         order.add(cb.getSelectedItem().toString());      
         text1.append(cb.getSelectedItem().toString() + "\n");   
      }
      else if(command.equals("Order")){
         String str_order[] = new String[order.size()]; 
         for (int i = 0; i < order.size(); i++) { 
            str_order[i] = order.get(i); 
         }   
         cake.cakeOrder(str_order, 1, 2);
         String content = cake.printOrder();
         text1.append(content);
      }
      else if
      (ae.getSource() == btclear)
      {
         text1.setText("");
         order.clear(); 
      }
      repaint();
   }
   
   public void updateCB(String[] topping){
      for(int i=0; i<topping.length; i++){
         cb.addItem(topping[i]);
      }      
   }

   public static void main (String[] args) {
      cake = new Cake("general");
      order = new ArrayList<String>();
      
      JFrame frame = new JFrame ("Cake Topping Order");
      String[] topping = {"Chocolate", "Cherries", "Whipped Cream"};
      cake.setCake(topping, 45.00, 65.00, 80.00); 
      
      Lab6_Exercise3 capp = new Lab6_Exercise3(); 
      capp.updateCB(topping);
      
      frame.setDefaultCloseOperation (JFrame.EXIT_ON_CLOSE);
      frame.getContentPane().add (capp);
      frame.pack();
      frame.setVisible (true);
   }
}