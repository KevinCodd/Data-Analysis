package ManhattanDistance;
import java.util.Scanner;
import java.util.Random;

public class ChessBoardManhattanDistance {

    public static String[] ManhattanDistancePaths(String p1, String p2) { //returns array of all possible paths between two pieces

      int p1i = Integer.parseInt(p1.substring(1));
      int p2i = Integer.parseInt(p2.substring(1));

      int p1j = letterConverter(p1);
      int p2j = letterConverter(p2);

       if((p1i<1)||(p1i>8)||(p2i<1)||(p2i>8)||(p1j==-1)||(p2j==-1)||(p1.equals(p2))) { //Checks to make sure coordinates given are valid
           String[]Invalid = {"You entered invalid coordinates."};
           System.out.println(Invalid[0]);
           return Invalid;
       }

       long m = Math.abs(p2i-p1i); //distance travelled in vertical (number axis) direction
       long n = Math.abs(p2j-p1j); //distance travelled in horizontal (letter axis) direction
       int moves = (int)m+(int)n; //total number of moves made between pieces

       long pospaths=1; //if m or n = 0, there is only one posssible path

       if ((m!=0)&&(n!=0)){//prevents division by 0 in below formula
     pospaths = fact(m+n)/(fact(m)*fact(n)); /*total possibe number of paths using combination formula: n!/r!(n-r)!;
     n=total number of moves i.e.(m+n) in code; r=number of moves in given direction i.e. m or n.
     */}

   String [] paths = new String [(int)pospaths]; /*String array that contains every possible path of
   Manhattan distance coded in strings of i's (vertical moves) and j's (horizontal moves).
   */

   for(int i=0; i<paths.length; i++){ //initializes all elements of paths to prevent NullPointerException
       paths[i]="";
   }

   Random rand = new Random();
   while (!isFull(paths)){ //repeats filling cycle until paths is full of unique elements
   for (int i = firstEmpty(paths); i<pospaths; i++) { //starts loop from first empty element of paths each time
       int i1 = 0;
       int j1 = 0;
       for (int j = 0; j<moves;){ //fills ith element of paths w/string of random i's and j's
           int temp = rand.nextInt(2);
         if((temp==0)&&(i1<m)){
             paths[i]+="i";
             i1++; j++;
         }
         if((temp==1)&&(j1<n)){
             paths[i]+="j";
             j1++; j++;
       }
       }
       paths = repeatRemover(paths); //removes ith element of paths if it is a duplicate of a previous element
       for(int k =1; k<paths.length; k++){ //failsafe on repeatRemover to prevent some tested cases where the last element would be a repeat
            for(int l=0; l<k; l++){
                if(paths[l].equals(paths[k])){
                    paths[k]="";
                }
            }
        }
    }
    }

   System.out.println("The Manhattan distance between the two pieces is "+moves+".");
   System.out.println("There are "+pospaths+" possible paths between the two pieces making only horizontal and vertical moves.");
   System.out.println("Here is a list of all "+pospaths+" possible paths using standard chess coordinates:");
   return paths;
    }

    public static int letterConverter(String p){ //codes letters to number coordinates for use in distance formula
        int p1j =0;
        String letter1 = p.substring(0,1);
         switch (letter1) {
          case "A": p1j=1; break;
          case "B": p1j=2; break;
          case "C": p1j=3; break;
          case "D": p1j=4; break;
          case "E": p1j=5; break;
          case "F": p1j=6; break;
          case "G": p1j=7; break;
          case "H": p1j=8; break;
          default: p1j=-1; break;
           }
         return p1j;
    }

    public static String numberConverter(int pj) {//converts j coordinates back to letters
        String letter ="";
        switch (pj) {
          case 1: letter="A"; break;
          case 2: letter="B"; break;
          case 3: letter="C"; break;
          case 4: letter="D"; break;
          case 5: letter="E"; break;
          case 6: letter="F"; break;
          case 7: letter="G"; break;
          case 8: letter="H"; break;
           }
         return letter;
    }

    public static long fact(long n) { //factorial method, use longs b/c int only goes up to ~2.147 million so cannot handle above 12!
        if ((n==1)||(n==0)){
            return n;
        }
        else {
            return n*fact(n-1);
        }

    }

    public static String[] repeatRemover(String[]array) { //Removes duplicate array elements and puts all empty elements at end

       String []newarray = new String[(array.length)];

       newarray[0]=array[0];
       for (int i = 1; i <array.length; i++){
           int sum = 0;
           for (int j = 0; j<i; j++){
               if (array[i].equals(array[j])){
                   sum++;
               }
           }
           if (sum==0){
               newarray[i]=array[i];
           }
           else {
           newarray[i]="";
       }
        }
       int total = 0;
       for (int k = 0; k<newarray.length; k++){
           if (newarray[k].equals("")){
               total++;
           }
           else {
           newarray[k-total]=newarray[k];
           if(total>0){
               newarray[k]="";
           }
           }
       }
       return newarray;

   }


    public static boolean isFull(String[]array) { //Checks to see if String array is full i.e. has no empty elements
      for (int i = 0; i<array.length; i++){
          if (array[i].equals("")) {
              return false;
          }
      }

      return true;
    }

    public static int firstEmpty(String[]array) { //identifies first empty element of array
        for (int i =0; i<array.length; i++){
            if(array[i].equals("")){
                return i;
            }
        }
        return array.length;
    }

    public static void main(String[] args) {
        Scanner reader = new Scanner(System.in);
        System.out.println("Please enter the coordinates of two chess pieces e.g. A1, B2 etc. using letters A-H"
                + " and numbers 1-8.\nUse capital letters and don't use spaces.");
        String p1=reader.next();
        String p2=reader.next();

        String[]array = ManhattanDistancePaths(p1,p2);

      int p1i = Integer.parseInt(p1.substring(1));
      int p2i = Integer.parseInt(p2.substring(1));

      String p1s =p1.substring(0,1);
      String p2s = p1.substring(0,1);

      int p1j = letterConverter(p1);
      int p2j = letterConverter(p2);

      int m =(p2i-p1i);
      int n =(p2j-p1j);
      int moves = Math.abs(m)+Math.abs(n);

        for(int i =0; i< array.length; i++){
            int i1 = 0;
            int j1 = 0;
            System.out.print((i+1)+". ");
            for (int j=1; j<moves+1; j++){
                if ((m>0)&&(n>0)){ //all the conditions in here control for whether pieces are moving up or down / left or right
                if(array[i].substring(j-1,j).equals("i")){
                    System.out.print(numberConverter(p1j+j1)+(p1i+i1)+"->");
                    i1++;}
                if(array[i].substring(j-1,j).equals("j")){
                    System.out.print(numberConverter(p1j+j1)+(p1i+i1)+"->");
                    j1++;}
                }
                if ((m>0)&&(n<0)){
                if(array[i].substring(j-1,j).equals("i")){
                    System.out.print(numberConverter(p1j-j1)+(p1i+i1)+"->");
                    i1++;}
                if(array[i].substring(j-1,j).equals("j")){
                    System.out.print(numberConverter(p1j-j1)+(p1i+i1)+"->");
                    j1++;}
                }
                 if ((m<0)&&(n<0)){
                if(array[i].substring(j-1,j).equals("i")){
                    System.out.print(numberConverter(p1j-j1)+(p1i-i1)+"->");
                    i1++;}
                if(array[i].substring(j-1,j).equals("j")){
                    System.out.print(numberConverter(p1j-j1)+(p1i-i1)+"->");
                    j1++;}
                }
                  if ((m<0)&&(n>0)){
                if(array[i].substring(j-1,j).equals("i")){
                    System.out.print(numberConverter(p1j+j1)+(p1i-i1)+"->");
                    i1++;}
                if(array[i].substring(j-1,j).equals("j")){
                    System.out.print(numberConverter(p1j+j1)+(p1i-i1)+"->");
                    j1++;}
                  }
                  if ((m<0)&&(n==0)){
                if(array[i].substring(j-1,j).equals("i")){
                    System.out.print(numberConverter(p1j+j1)+(p1i-i1)+"->");
                    i1++;}
                if(array[i].substring(j-1,j).equals("j")){
                    System.out.print(numberConverter(p1j+j1)+(p1i-i1)+"->");
                    }
                  }
                    if ((m>0)&&(n==0)){
                if(array[i].substring(j-1,j).equals("i")){
                    System.out.print(numberConverter(p1j+j1)+(p1i+i1)+"->");
                    i1++;}
                if(array[i].substring(j-1,j).equals("j")){
                    System.out.print(numberConverter(p1j+j1)+(p1i+i1)+"->");
                    }
                  }
                   if ((m==0)&&(n>0)){
                if(array[i].substring(j-1,j).equals("i")){
                    System.out.print(numberConverter(p1j+j1)+(p1i-i1)+"->");
                    }
                if(array[i].substring(j-1,j).equals("j")){
                    System.out.print(numberConverter(p1j+j1)+(p1i-i1)+"->");
                    j1++;}
                  }
                  if ((m==0)&&(n<0)){
                if(array[i].substring(j-1,j).equals("i")){
                    System.out.print(numberConverter(p1j-j1)+(p1i-i1)+"->");
                    }
                if(array[i].substring(j-1,j).equals("j")){
                    System.out.print(numberConverter(p1j-j1)+(p1i-i1)+"->");
                    j1++;}
                  }
                }

            System.out.print(p2);
            System.out.print("\n\n");
            }

        for(int i =1; i<array.length; i++){ //indicates if any elements are repeats/not unique
            for(int j=0; j<i; j++){
                if(array[j].equals(array[i])){
                    System.out.println("Repeat "+array[i]);
                }
            }
        }
    }
}
