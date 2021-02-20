package Minesweeper;

public class tile {
private boolean isBomb;
private int adjBombs;
private boolean isRevealed;

public tile(){
  isBomb = false;
  adjBombs =0;
  isRevealed=false;
}

public tile(boolean bomb){
isBomb = bomb;
adjBombs = 0;
isRevealed= false;
}

public void setadjBombs(int neighbors){
  adjBombs = neighbors;
}

public int getadjBombs(){
  return adjBombs;
}

public void setBomb(boolean bomb){
isBomb = bomb;
}

public boolean isBomb() {
  return isBomb;
}

public boolean isRevealed(){
  return isRevealed;
}

public void setRevealed(boolean b) {
  isRevealed = b;
}


}
