package Minesweeper;
import java.util.Scanner;

public class Minesweeper {


  public static void main(String[]args) {
    System.out.println("Welcome!\n");
    System.out.println("Press 1 for easy, 2 for medium, or 3 for hard.");
    Scanner reader = new Scanner(System.in);
    int d = reader.nextInt();
    int l = 0;
    int w = 0;
    int b =0;
    if(d==1){
    l = 5;
    w = 5;
    b = 5;
    }
    if(d==2){
    l = 8;
    w = 10;
    b = 10;
    }
    if(d==3){
    l = 14;
    w = 18;
    b = 40;
    }
    System.out.println();
    System.out.println("Enter the coordinates of a tile to reveal it, "+
    "row first, then column.\nThe number displayed on a revealed tile "
     +"is the number of bombs directly touching it \n (horizontally/vertically and diagonally).\n"+
     "Your objective is to reveal all of the tiles that are not bombs."+
     "  \nIf you reveal a bomb you lose.\nGood luck!");
     System.out.println();
     board test = new board(l,w,b);
     test.initialPrint();

     int x = -1;
     while ((x<0)||(x>l-1)){
     while (!reader.hasNextInt()){
        System.out.println("Invalid coordinate");
        reader.next();}
      x = reader.nextInt();
      if ((x<0)||(x>l-1)){
        System.out.println("Invalid coordinate");
      }}
    int y = -1;
    while ((y<0)||(y>w-1)){
    while (!reader.hasNextInt()){
       System.out.println("Invalid coordinate");
       reader.next();}
     y = reader.nextInt();
     if ((y<0)||(y>w-1)){
       System.out.println("Invalid coordinate");
   }}
     test.setBoard(x,y);
     //test.fullReveal();
      while ((test.win()==false)&&(test.lost()==false)){
        int z = -1;
        while ((z<0)||(z>l-1)){
        while (!reader.hasNextInt()){
           System.out.println("Invalid coordinate");
           reader.next();}
         z = reader.nextInt();
         if ((z<0)||(z>l-1)){
           System.out.println("Invalid coordinate");
       }}
       int a = -1;
       while ((a<0)||(a>w-1)){
       while (!reader.hasNextInt()){
          System.out.println("Invalid coordinate");
          reader.next();}
        a = reader.nextInt();
        if ((a<0)||(a>w-1)){
          System.out.println("Invalid coordinate");
      }}
        test.reveal(z,a);
      }
  }
}
