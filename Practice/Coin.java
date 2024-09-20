public class Coin
{
   // Constant to represent heads - non-instance variable
   private static int HEADS = 1;

   // Current value of the coin - instance variable
   private int value = 0;

   // Method to randomly set the value of the coin to heads or tails
   public void flip()
   {
      if (Math.random() < 0.5)
          value = 0;
      else
         value = 1;
   }

   // Method returns "Head" or "Tail"
   public String toString()
   {
      if (value == HEADS) 
        return "Head";
      else 
        return "Tail";
   }

   public static void main(String[] args)
   {
      Coin myCoin = new Coin();
      for (int i = 1; i <= 5; i++)
      {
         myCoin.flip();
         System.out.println(myCoin);
         System.out.println(myCoin.toString());
      }
   }
}
