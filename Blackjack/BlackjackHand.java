package Blackjack;

public class BlackjackHand extends Hand {


    public void GetBlackJack(){
    if((total==21)&&(cards==2)){
   System.out.println("Your hand is a Blackjack!");
}

    }
}
