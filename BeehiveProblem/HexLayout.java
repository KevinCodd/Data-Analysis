/*
Stores layouts of hexagons encoded as coordinates and has methods
*to rotate and shift the origin of these layouts
*/
package BeehiveProblem;
import java.util.ArrayList;
import java.util.Iterator;
import java.lang.Math;

public class HexLayout {

//Stores coordinates of all hexagons in layout
private double [][] Hexes;

  public HexLayout(ArrayList<double[]>seq) {
    Hexes = new double [seq.size()+1][2];
    Hexes[0][0] = 0;
    Hexes[0][1] = 0;
    Iterator<double[]> iter = seq.iterator();
    int i = 1;
    while(iter.hasNext()) {
      double [] arr = iter.next();
      //next coordinate = previous coordinate + change
      Hexes[i][0] = Hexes[i-1][0]+arr[0];
      Hexes[i][1] = Hexes[i-1][1]+arr[1];
      i++;
  }
}

/*
* Rotates Hexgrid by n*PI/3
* @param n - number of hex sides of rotation
*/
public double [][] rotate(double[][]Hexgrid, int n) {
double angle = (Math.PI/3)*n;
double [][] HexFinal = new double [Hexgrid.length][2];
for (int i = 0; i<Hexgrid.length; i++){
  //rotate all hexes by 60*n degrees with respect to origin hex
  HexFinal[i][0] = Hexgrid[i][0]*Math.cos(angle)-Hexgrid[i][1]*Math.sin(angle);
  HexFinal[i][1] = Hexgrid[i][0]*Math.sin(angle)+Hexgrid[i][1]*Math.cos(angle);
}
return HexFinal;
}
/*
*Shifts entire Hex layout to center Hexes[n] at the origin
* @param n - indicates which hex to make the origin
*/
public double [][] makeOrigin(int n) {
double [][] Hexclone = Hexes.clone();
for (int i = 0; i<Hexes.length; i++) {
Hexclone[i][0] -= Hexes[n][0];
Hexclone[i][1] -= Hexes[n][1];
}
return Hexclone;
}

//returns this object's Hexes matrix
public double [][] getHexLayout(){
  return Hexes;
}

}
