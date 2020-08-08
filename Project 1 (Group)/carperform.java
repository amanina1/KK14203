
import java.io.FileNotFoundException;

public class carperform {
   public static void main (String [] args){
      RentalSystem hello = new RentalSystem();
      hello.setS();
      try {hello.saveToFile();}
      catch (FileNotFoundException e){}
   }
}