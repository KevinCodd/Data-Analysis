package Blackjack;


public class Hand {
    public int total;
    public int cards;
    public int[]hand;


    public Hand() {
        total=0;
        cards=0;
        hand = new int[52];
        for(int i=0; i<hand.length; i++){
            hand[i]=52;
        }
    }

    public void AddCard(int n){
        hand[n]=n;//implicitly arranges cards by suit, value, in hand array
        String card ="";
         int value = n%13; //gets card value from rank
                switch (value){
                    case 0: card+="A"; break;
                    case 1: card+="2"; break;
                    case 2: card+="3"; break;
                    case 3: card+="4"; break;
                    case 4: card+="5"; break;
                    case 5: card+="6"; break;
                    case 6: card+="7"; break;
                    case 7: card+="8"; break;
                    case 8: card+="9"; break;
                    case 9: card+="10"; break;
                    case 10: card+="J"; break;
                    case 11: card+="Q"; break;
                    case 12: card+="K"; break;
                }

                int suit = n/13; //gets card suit from rank
                switch(suit){
                    case 0: card+="S"; break;
                    case 1: card+="D"; break;
                    case 2: card+="H"; break;
                    case 3: card+="C"; break;
                }
                System.out.println(card);

                if(((value)>0)&&((value)<10)){
                    total+=((value)+1);
                    System.out.println("+"+((value)+1));
                }
                else if((value)==0){
                    if(total+11>21){//condition implicitly ensures 2nd, 3rd, 4th ace are 1's
                        total+=1;
                        System.out.println("+"+1);
                    }
                    else {
                        total+=11;
                        System.out.println("+"+11);
                    }
                }
                else{
                    total+=10;
                    System.out.println("+"+10);
                }
        cards++;
    }
    public void showHand() {
        System.out.print("Your hand: ");
        for(int i=0; i<hand.length; i++){ //Prints hand out in rank order: 0-12=A-K Spades, 13-25=A-K Diamonds, etc.
            if(hand[i]!=52){
        String card ="";
         int value = hand[i]%13; //gets card value from rank
                switch (value){
                    case 0: card+="A"; break;
                    case 1: card+="2"; break;
                    case 2: card+="3"; break;
                    case 3: card+="4"; break;
                    case 4: card+="5"; break;
                    case 5: card+="6"; break;
                    case 6: card+="7"; break;
                    case 7: card+="8"; break;
                    case 8: card+="9"; break;
                    case 9: card+="10"; break;
                    case 10: card+="J"; break;
                    case 11: card+="Q"; break;
                    case 12: card+="K"; break;
                }

                int suit = hand[i]/13; //gets card suit from rank
                switch(suit){
                    case 0: card+="S"; break;
                    case 1: card+="D"; break;
                    case 2: card+="H"; break;
                    case 3: card+="C"; break;
                }
                System.out.print(card+" ");
            }
        }
         System.out.println();
         System.out.println("The value of your hand is "+total+".");
    }

public int getTotal() {
    return total;
}
}
