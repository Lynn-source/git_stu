import java.util.Scanner;
import java.util.Random;
public class HelloWorld {
   public static void main(String[] args) {
      int [] userCard = new int[5];
      int [] dealerCard = new int[5];
      Scanner scnr = new Scanner(System.in);
      Random rand = new Random ();
      double savedMoney = 0;
      System.out.println("Enter Money to Play With.");
      System.out.println("Max amount = $1000. Min amount = $1");
      System.out.println("Savings: ");
        savedMoney = scnr.nextDouble();
      while (savedMoney < 0 || savedMoney > 1000){
          System.out.println("Insufficient amount. Enter a new savings: ");
          savedMoney = scnr.nextDouble();
      }

      System.out.println("");
      System.out.println("MENU");
      System.out.println("b - Blackjack");
      System.out.println("s - Slot Machine");
      System.out.println("m - Savings");
      System.out.println("q - Quit");
      System.out.println("");
      System.out.print("Choose an option:");

      double moneyBet = 0;
      double newWinnings = 0;
      int hitNumber = 0;
      int i = 0;
      int userTotal = 0;
      int dealerTotal = 0;
      char option = 'e';
      
      while (option != 'q'){
          option = scnr.next().charAt(0);
          
          if (option == 'b'){
        	  System.out.print("How much are you betting?: ");
        	  moneyBet = scnr.nextInt();
        	  hitNumber = 0;
        	  dealerCard[0] = rand.nextInt(11)+1;
        	  dealerCard[1] = rand.nextInt(11)+1;
        	  userCard[0] = rand.nextInt(11)+1;
        	  userCard[1] = rand.nextInt(11)+1;
        	  userTotal = userCard[0] + userCard[1];
        	  dealerTotal = dealerCard[0] + dealerCard[1];
        	  System.out.println("Your cards: " + userCard[0] + ", " + userCard[1]);
        	  System.out.println("Your card total is: " + userTotal);
        	  System.out.println("The dealer's faceup card: " + dealerCard[0]);
        	  System.out.println("Would you like to...");
        	  System.out.println("hit? Type '1' ");
        	  System.out.println("stand? Type '2'");
        	  System.out.println("");
        	  System.out.println("Choose an option:");
        	      int blackjackOption = scnr.nextInt();
        	     
        	  while (blackjackOption < 1 || blackjackOption > 2){
        		  System.out.println("Invalid Response. Try Again.");
        		  blackjackOption = scnr.nextInt();
        	  }

        	  while (blackjackOption > 0 && blackjackOption < 3){
        		  if (blackjackOption == 1){
        			  hitNumber++;
        			  i = hitNumber;
        			  userCard[i + 1] = rand.nextInt(11)+1;

        			  for (i = 2; i < 5; i++){
        				  userTotal = userTotal + userCard[i];
        			  }
        			  System.out.println("Your card total is: " + userTotal);
        			  System.out.println("The dealer's faceup card: " + dealerCard[0]);
        			  System.out.println("Would you like to...");
        			  System.out.println("hit? Type '1'");
        			  System.out.println("stand? Type '2'");
        			  System.out.println("");
        			  System.out.println("Choose an option:");
        			  	  blackjackOption = scnr.nextInt();
        		  } //if blackjackOption ==1
        		  
        		  else if (blackjackOption == 2){
        			  System.out.println("Your card total is: " + userTotal);
        			  dealerTotal = dealerCard[0] + dealerCard[1];
        			  System.out.println("Dealer's card total is: " + dealerTotal);
        			  
        			  if ((dealerTotal < 22 && dealerTotal > userTotal) || (dealerTotal > 21 && userTotal > 21) || (userTotal > 21 && dealerTotal < 21))
        			  {
        				  System.out.println("You Lose! You Lost $" + moneyBet);
        				  savedMoney = savedMoney - moneyBet;
        			  }
        			  else if (userTotal < 22 && userTotal > dealerTotal){
        				  newWinnings = moneyBet * (3/2);
        				  System.out.println("You Win! You Won $" + newWinnings);
        				  savedMoney = savedMoney + newWinnings + moneyBet;
        			  }
        			  else if (userTotal == dealerTotal && userTotal < 22){
        				  System.out.println("You Tie! You Win $0");
        			  }
        			  System.out.println("");
        			  System.out.println("MENU");
        			  System.out.println("b - Blackjack");
        			  System.out.println("s - Slot Machine");
        			  System.out.println("m - Save Money");
        			  System.out.println("q - Quit");
        			  System.out.println("");
        			  System.out.print("Choose an option:");
        			      option = scnr.next().charAt(0);
        		  }
        		  else {
        			  System.out.println("Invalid Option. Choose again: ");
        		  }//invalid option
        	  }  //while blackjackoption is between 1 and 3
          }  //if option = b
          else if (option == 's'){
        	  System.out.print("How much are you betting?: ");
        	  moneyBet = scnr.nextInt();
        	  System.out.println("");
        	  System.out.println("MENU");
        	  System.out.println("b - Blackjack");
        	  System.out.println("s - Slot Machine");
        	  System.out.println("m - Save Money");
        	  System.out.println("q - Quit");
        	  System.out.println("");
        	  System.out.println("Choose an option:");
          } //option = s
          else if (option == 'm'){
        	  System.out.println("Savings: " + savedMoney);
        	  System.out.println("");
        	  System.out.println("MENU");
        	  System.out.println("b - Blackjack");
        	  System.out.println("s - Slot Machine");
        	  System.out.println("m - Save Money");
        	  System.out.println("q - Quit");
        	  System.out.println("");
        	  System.out.println("Choose an option:");
          } //option = m
          else if (option == 'q'){
          } //option = q
          else {
        	  System.out.println("Invalid Response. Try Again.");
          } //invalid response
      }  //while option != q
   }  //main
} //class
	   