package Blackjack;
import java.util.Scanner;
import java.util.Random;

public class Blackjack {


    public static void main(String[] args) {

        int[]deck = new int[52];
         for (int i=0; i<deck.length; i++){
            deck[i]=i; //each number represent a card: 0-12 = A,2,3 etc. of Spades, 13-25 = Diamonds, 26-38=Hearts, 29-51 = Clubs
        }              //implicitly sorts cards by suit then by rank
         Shuffle(deck);

         Random r = new Random();
         int Dealer = r.nextInt(6)+16;

        System.out.println("Cards are coded with a value followed by a suit i.e. AS = Ace of Spades, 9C = 9 of Clubs, etc.");
        System.out.println("Key:");
        System.out.println("S=Spades; D=Diamonds; H=Hearts; C=Clubs;");
        System.out.println("A=Ace; J=Jack; Q=Queen; K=King.");
        System.out.println();
        System.out.println("The dealer's hand has a value of "+Dealer+".");

        Scanner reader = new Scanner(System.in);
        System.out.println("Enter any character to draw a card.");
        String input=reader.next();

        BlackjackHand h = new BlackjackHand();

        for(int i=0; i<12; i++) {//impossible for max number of draws to be >11
            h.AddCard(deck[i]);
            h.showHand();

            if(h.getTotal()>Dealer){
            break;}
            System.out.println("Enter any character to draw a card.");
            reader.next();
        }

        h.GetBlackJack(); //Sees if hand is a blackjack
        if(h.getTotal()<=21){
            System.out.println("You win!");
        }
        else{
            System.out.println("You lose!");
        }
    }




    public static int[] Shuffle(int[]array){
        Random rand = new Random();
         for(int i = array.length-1; i>0; i--){ //shuffles deck
          int j = rand.nextInt(i+1);
            int temp = array[i];
            array[i] = array[j];
            array[j] = temp;
}
         return array;
    }
}
