abstract class Cake
{
   public String name;
   public String[] topping, toppingOrder;
   public double priceSmall, priceMedium, priceBig, totalPrice;
   public int size, quantity;

   Cake(String name)
   {
      this.name = name;
   }
   
   String getName()
   {
      return name;
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
   
   void printCake()
   {
      System.out.println("--------------------");
      System.out.println("      Cake Menu ");
      System.out.println(" --------------------");
      System.out.println(name + " with available toppings : ");
      for(int i = 0; i < topping.length; i++)
      {
         System.out.println((i + 1) + ") " + topping[i]);
      }
      System.out.println("\nPrice : ");
      System.out.println("[1] Small : " + priceSmall);
      System.out.println("[2] Medium : " + priceMedium);
      System.out.println("[3] Big : " + priceBig);
   }
   
   void printOrder()
   {
      System.out.println("\n Cake order detail : ");
      System.out.println("--------------------");
      System.out.println("Topping : ");
      for(int i = 0; i < toppingOrder.length; i++)
      {
         System.out.println(i + 1 + ") " + toppingOrder[i] + " ");
      }
      System.out.println("\nSize \t : " + getSize());
      System.out.println(" --------------------" );
      System.out.println("Total price : RM" + getTotalPrice());
      System.out.println("--------------------");
   }
}

class BlackForest extends Cake
{
   BlackForest(String name)
   {
      super(name);
   }
   
   void setCake(String[] t, double s, double m, double b)
   {
      topping = t;
      priceSmall = s;
      priceMedium = m;
      priceBig = b;
   }
}

public class Lab5_Exercise3
{
   public static void main(String args[])
   {
      Cake c = new BlackForest("BlackForest");
      String[] toppingOrder = {"Chocolate", "Cherries", "Whipped Cream"};
      c.setCake(toppingOrder, 45.00, 65.00, 80.00);
      c.printCake();
      
      String[] order = {"Chocolate", "Cherries"};
      c.cakeOrder(order, 1, 2);
      c.printOrder();
   }
}