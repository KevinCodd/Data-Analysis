package Minesweeper;
import java.util.Random;

public class board {
private int length;
private int width;
private int bombs;
private tile[][]array;

public board(int l, int w, int b){
  length = l;
  width = w;
  bombs = b;
  array = new tile [l][w];
}

public void setBoard(int x, int y){
  Random rand = new Random();
  for(int i =0; i<array.length; i++){
    for(int j=0; j<array[i].length; j++){
      array[i][j] = new tile();
    }
  }
  for(int i = 0; i<bombs; i++){
    int l = rand.nextInt(length);
    int w = rand .nextInt(width);
    while (((l==x)&&(w==y))||(array[l][w].isBomb() == true)) {
      l = rand.nextInt(length);
      w = rand .nextInt(width);
    }
    array[l][w].setBomb(true);
  }
  reveal(x,y);
}

public void reveal(int x, int y){
if (array[x][y].isBomb()==false){
checkNeighbors(x,y);
array[x][y].setRevealed(true);
if(array[x][y].getadjBombs()==0){
zeroReveal(x,y);}
  printBoard();
}
else {
  array[x][y].setRevealed(true);
  for(int i =0; i<length; i++){
    for(int j = 0; j<width; j++){
      if(array[i][j].isBomb()){
        array[i][j].setRevealed(true);
      }}}
      System.out.println("You lose!");
      printBoard();
}
}

public boolean lost(){
  int count =0;
  for(int i =0; i<length; i++){
    for(int j = 0; j<width; j++){
      if((array[i][j].isBomb())&&(array[i][j].isRevealed())){
        count++;
      }}}
      if(count == bombs){
        return true;
      }
      return false;
}

public void checkNeighbors(int x, int y){
  int count =0;
  if(y!=width-1){
    boolean bomb = array[x][y+1].isBomb();
    if(bomb==true){
      count++;}}
  if(y!=0){
    boolean bomb = array[x][y-1].isBomb();
    if(bomb==true){
      count++;}}
  if(x!=length-1){
    boolean bomb = array[x+1][y].isBomb();
    if(bomb==true){
      count++;}}
  if(x!=0){
    boolean bomb = array[x-1][y].isBomb();
    if(bomb==true){
      count++;}}
  if((y!=width-1)&&(x!=0)){
    boolean bomb = array[x-1][y+1].isBomb();
    if(bomb==true){
      count++;}}
  if((y!=0)&&(x!=0)){
    boolean bomb = array[x-1][y-1].isBomb();
    if(bomb==true){
      count++;}}
  if((y!=width-1)&&(x!=length-1)){
    boolean bomb = array[x+1][y+1].isBomb();
    if(bomb==true){
      count++;}}
  if((y!=0)&&(x!=length-1)){
    boolean bomb = array[x+1][y-1].isBomb();
    if(bomb==true){
      count++;}}
array[x][y].setadjBombs(count); }

public void printBoard(){
  System.out.print("    ");
  for(int i=0; i<width; i++){
    System.out.print(i+" ");
  }
  System.out.println();
  System.out.print("    ");
  for(int i=0; i<width; i++){
    System.out.print("- ");
  }
  System.out.println();
  for(int i=0; i<length; i++){
    System.out.print(i+" | ");
    for(int j=0; j<width; j++){
      if((array[i][j].isRevealed()==true)&&(!array[i][j].isBomb())){
        System.out.print(array[i][j].getadjBombs()+" ");
      }
      else if((array[i][j].isBomb())&&(array[i][j].isRevealed())){
        System.out.print("b ");
      }
      else {
        System.out.print("* ");
      }
    }
    System.out.println();
  }
  System.out.println();
}

  public void initialPrint(){
    System.out.print("    ");
    for(int i=0; i<width; i++){
      System.out.print(i+" ");
    }
    System.out.println();
    System.out.print("    ");
    for(int i=0; i<width; i++){
      System.out.print("- ");
    }
    System.out.println();
    for(int i=0; i<length; i++){
    System.out.print(i+" | ");
    for(int j=0; j<width; j++){
    System.out.print("* ");
    }
    System.out.println();
  } System.out.println();
}

public boolean win(){
  int count =0;
  for(int i =0; i<length; i++){
    for(int j = 0; j<width; j++){
      if(array[i][j].isRevealed()){
        count++;
      }
    }
  }
    if(count == (length*width-bombs)){
      System.out.println("You win!");
      return true;
    }
    return false;
}

  public void zeroReveal(int x, int y){ //degenerates into cycle of two coordinates calling eachother
  array[x][y].setRevealed(true);
  if(x!=(length-1)){
  checkNeighbors(x+1, y);
  if(array[x+1][y].getadjBombs()>0){
    array[x+1][y].setRevealed(true);}
  if((array[x+1][y].getadjBombs()==0)&&(!array[x+1][y].isRevealed())){
    zeroReveal(x+1,y);}}
  if(x!=0){
  checkNeighbors(x-1, y);
  if(array[x-1][y].getadjBombs()>0){
    array[x-1][y].setRevealed(true);}
  if((array[x-1][y].getadjBombs()==0)&&(!array[x-1][y].isRevealed())){
    zeroReveal(x-1, y);}}
  if(y!=(width-1)){
  checkNeighbors(x, y+1);
  if(array[x][y+1].getadjBombs()>0){
    array[x][y+1].setRevealed(true);}
  if((array[x][y+1].getadjBombs()==0)&&(!array[x][y+1].isRevealed())){
    zeroReveal(x, y+1);}}
  if(y!=0){
  checkNeighbors(x, y-1);
  if(array[x][y-1].getadjBombs()>0){
    array[x][y-1].setRevealed(true);}
  if((array[x][y-1].getadjBombs()==0)&&(!array[x][y-1].isRevealed())){
    zeroReveal(x, y-1);}}
  if((y!=0)&&(x!=length-1)){
  checkNeighbors(x+1, y-1);
  if(array[x+1][y-1].getadjBombs()>0){
    array[x+1][y-1].setRevealed(true);}
  if((array[x+1][y-1].getadjBombs()==0)&&(!array[x+1][y-1].isRevealed())){
    zeroReveal(x+1, y-1);}}
  if((y!=width-1)&&(x!=length-1)){
    checkNeighbors(x+1, y+1);
    if(array[x+1][y+1].getadjBombs()>0){
      array[x+1][y+1].setRevealed(true);}
    if((array[x+1][y+1].getadjBombs()==0)&&(!array[x+1][y+1].isRevealed())){
      zeroReveal(x+1, y+1);}}
  if((y!=0)&&(x!=0)){
    checkNeighbors(x-1, y-1);
    if(array[x-1][y-1].getadjBombs()>0){
      array[x-1][y-1].setRevealed(true);}
    if((array[x-1][y-1].getadjBombs()==0)&&(!array[x-1][y-1].isRevealed())){
      zeroReveal(x-1, y-1);}}
  if((y!=width-1)&&(x!=0)){
    checkNeighbors(x-1, y+1);
    if(array[x-1][y+1].getadjBombs()>0){
      array[x-1][y+1].setRevealed(true);}
    if((array[x-1][y+1].getadjBombs()==0)&&(!array[x-1][y+1].isRevealed())){
      zeroReveal(x-1, y+1);}}
  }

public void fullReveal(){
  for(int i=0; i<length; i++)
  for(int j=0; j<width; j++){
    checkNeighbors(i,j);
    array[i][j].setRevealed(true);
  }
  printBoard();
}








}
