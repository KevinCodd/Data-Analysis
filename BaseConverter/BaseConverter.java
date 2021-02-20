package BaseConverter;

public class BaseConverter{

public static void main(String[] args) {
args = new String[] {"4567", "16"};

int n = Integer.parseInt(args[0]); //number to convert
int k = Integer.parseInt(args[1]); //base to convert it to

int exp = 0;
for (int power =1; power <= (n/k); power *=k ) {
exp++; //determines order of magnitude i.e. number of digit places of n in base k
}
int digit = 0;
String highbase ="";
for (int pow=exp; pow>=0; pow--){ //pow is exactly same as exp; created for purpose of for loop
    digit = (int)(n/Math.pow(k, pow)); //prints out number of k's at each order of magnitude i.e. digit place

    if (digit > 9) {
    switch (digit) { //symbols for digits higher than 9, up to 15
        case 10:  highbase ="A"; break;
         case 11: highbase ="B"; break;
         case 12: highbase ="C"; break;
         case 13: highbase ="D"; break;
         case 14: highbase ="E"; break;
         case 15: highbase ="F"; break;
    }
    System.out.print(highbase);
    }
    else {
    System.out.print(digit);}
    n%=(Math.pow(k,pow)); //sets n equal to remainder of n that is not taken up by previous orders of magnitude
}
System.out.println();

}
}
