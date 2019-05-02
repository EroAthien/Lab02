
import java.util.Random;
import java.util.*;
import javax.swing.*;

public class blackJack
{  
   public static int getpickCards(int[] deck)
   {
      int card = new Random().nextInt(deck.length);

      return deck[card];
    }
    public static void getWinner(int playtotalCard, int dealtotalCard)
    {  
      if (playtotalCard > dealtotalCard)
      {
         System.out.println("You win!");
      }
      else if (dealtotalCard > playtotalCard)
      {
         System.out.println("Dealer wins!");
      }
      else if (dealtotalCard == playtotalCard)
      {
         System.out.println("It's a tie!");
      }
    }


   public static void main(String[] args) 
   {
      
      int deck[] = {1,1,1,1,2,2,2,2,3,3,3,3,4,4,4,4,5,5,5,5,6,6,6,6,7,7,7,7,8,8,8,8,9,9,9,9,10,10,10,10,11,11,11,11,12,12,12,12,13,13,13,13};
      char replay = 'y';
      char hitStay;
      char bust = 'n';
      int standNumber = 17;
      int dealCard1 = 0;
      int dealCard2 = 0;
      int dealCard = 0;
      int totaldealCard = 0;
      int playCard1 = 0;
      int playCard2 = 0;
      int playCard = 0;
      int totalplayCard = 0;
      
      Scanner jack = new Scanner(System.in);
      
      while (replay == 'y')
      {
         bust = 'n';
         
         dealCard1 = getpickCards(deck);
         dealCard2 = getpickCards(deck);
         totaldealCard = dealCard1 + dealCard2;
         
         playCard1 = getpickCards(deck);
         playCard2 = getpickCards(deck);
         totalplayCard = playCard1 + playCard2;
         
         System.out.println("Dealer's visible card is " + dealCard2);
         
         System.out.println("Your first card: " + playCard1 +
                           "\nThen your second card: " + playCard2);
         System.out.print("Hit or Stay??? (Press \"h\" for hit and \"s\" for stay): ");
         hitStay = jack.next().charAt(0);
         
      while (hitStay != 'h' && hitStay != 's')
         {
            System.out.print("Invalid input, please enter \"h\" or \"s\": ");
            hitStay = jack.next().charAt(0);
         }
         
         
      while (hitStay == 'h')
         {
            
            playCard = getpickCards(deck);
            totalplayCard = totalplayCard + playCard;
            System.out.println("The new card is " + playCard +
                              "\nNow you total card number is " + totalplayCard);
            
         if (totalplayCard > 21)
            {
               System.out.println("Cards bust, dealer wins!");
               bust = 'y';
               hitStay = 's';
            }
         else
            {
               System.out.print("Hit or Stay??? (Press \"h\" for hit and \"s\" for stay):");
               hitStay = jack.next().charAt(0);
               
              
            while (hitStay != 'h' && hitStay != 's')
               {
                  System.out.print("Invalid input, please enter \"h\" or \"s\": ");
                  hitStay = jack.next().charAt(0);
               }
            }
         if (bust != 'y')
         {
            
         while (totaldealCard <= 17)
         {
               
              dealCard = getpickCards(deck);
              totaldealCard = totaldealCard + dealCard;
           
          if (totaldealCard > 21)
            {
              System.out.println("Dealer got " + totaldealCard);
              System.out.println("Dealer busts, you win!");
              bust = 'y';
            }
         }
            
         if (bust != 'y')
         {
            System.out.println("Dealer got " + totaldealCard);
            getWinner(totalplayCard, totaldealCard);
         }

         System.out.print("Would you like to play again?(enter \"y\" or \"n\"): ");
         replay = jack.next().charAt(0);
      
 
         while (replay != 'y' && replay != 'n')
         {
            System.out.print("Invalid input, please enter \"y\" or \"n\": ");
            replay = jack.next().charAt(0);
         }
      }
   }
}
}
}