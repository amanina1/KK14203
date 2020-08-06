import java.util.Scanner;

class Menu
{
   String item;
   double price;
   
   Menu(String i, double p)
   {
      item = i;
      price = p;
   }
   
   public double getPrice()
   {
      return price;
   }
   
   String getItem()
   {
      return item;
   }
   
   void setItem(String item)
   {
      this.item = item;
   }
   
   public void printItem()
   {
      System.out.println(" " + item);
      System.out.print("Price : ");
   }
   
   void setPrice(double price)
   {
      this.price = price;
   }
   
   String getMenuItem()
   {
      return(item + "RM" + String.format("%.2f", price));
   }
   
   double calPrice(int quantity)
   {
      return ((double)(price * quantity));
   }
}

class Order
{
   private int i_Id;
   private String n_Name;
   private int q_Quantity;
   private double subTotal;
   
   Order(int id, String name, int quantity, double subtotal)
   {
      i_Id = id;
      n_Name = name;
      q_Quantity = quantity;
      subTotal = subtotal;
   }
}
   
public class Lab4_Exercise3
{
   public static void main(String[] args) throws java.io.IOException
   {
      Menu[] menu = new Menu[4];
      menu[0] = new Menu("[1] Nasi lemak", 2.00);
      menu[1] = new Menu("[2] Roti", 1.00);
      menu[2] = new Menu("[3] Teh tarik", 1.50);
      menu[3] = new Menu("[4] Kopi o", 1.00);
      
      char ch;
      int quantity;
      double price = 0;
      
      Scanner scan = new Scanner(System.in);
      System.out.println("Menu : ");
      System.out.println("--------------------");
      System.out.println(menu[0].getMenuItem());
      System.out.println(menu[1].getMenuItem());
      System.out.println(menu[2].getMenuItem());
      System.out.println(menu[3].getMenuItem());
      System.out.println("--------------------");
      System.out.println("Press n for new order | q to exit.");
      
      do
      {
         System.out.print("Add order : ");
         ch = (char) System.in.read();
         
         switch(ch)
         {
            case '1' :
               System.out.print("Nasi lemak - quantity : ");
               quantity = scan.nextInt();
               menu[0].printItem();
               price += (menu[0].getPrice() * quantity);
               System.out.println(menu[0].getPrice() * quantity);
               break;
               
            case '2' :
               System.out.print("Roti - quantity : ");
               quantity = scan.nextInt();
               menu[1].printItem();
               price += (menu[1].getPrice() * quantity);
               System.out.println(menu[1].getPrice() * quantity);
               break;
               
            case '3' :
               System.out.print("Teh tarik - quantity : ");
               quantity = scan.nextInt();
               menu[2].printItem();
               price += (menu[2].getPrice() * quantity);
               System.out.println(menu[2].getPrice() * quantity);
               break;
            
            case '4' :
               System.out.print("Kopi o - quantity : ");
               quantity = scan.nextInt();
               menu[3].printItem();
               price += (menu[3].getPrice() * quantity);
               System.out.println(menu[3].getPrice() * quantity);
               break;
               
            default:
               break;
         }
      }
      while(ch!='q');
      System.out.println("\nThank you for your order.");
      System.out.printf("Total due : RM %.2f", price);
   }
}

               
