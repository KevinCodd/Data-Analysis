/*
https://icpcarchive.ecs.baylor.edu/index.php?option=com_onlinejudge&Itemid=8&category=7&page=show_problem&problem=405
*/
package BeehiveProblem;
import java.util.ArrayList;
import java.lang.Math;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class BeehiveProblem {

public static void main(String[]args) {
String workingDir = System.getProperty("user.dir");

try {
BufferedReader br = new BufferedReader(new FileReader(workingDir+"/BeehiveProblem/input.txt"));

int numInputs = Integer.parseInt(br.readLine());
for(int i = 0; i<numInputs; i++) {
  String t = br.readLine();
  String h = br.readLine();
  br.readLine();
  System.out.println(layoutCompare(t,h));
}
br.close();
}
catch(FileNotFoundException e){
  System.out.println("FNF");
}
catch(IOException e){
  System.out.println("IO");
}
}


/*Compares two record pairs by holding one in a fixed orientation at a fixed origin
* and comparing it to the other with each of its hexes as the origin in all six orientations
* Returns true if all coordinates in the two layouts match
*/
public static boolean layoutCompare(String t, String h) {

char [] tcharseq = t.toCharArray();
char [] hcharseq = h.toCharArray();
//returns false if number of letters in strings are not equal
if(tcharseq.length!=hcharseq.length) {
  return false;
}

else {
  ArrayList<double[]>tseq = new ArrayList<double[]>();
  ArrayList<double[]>hseq = new ArrayList<double[]>();
/*convert strings to list of 2d arrays containing coordinate changes corresponding
/to direction letters*/
  for (int i = 0; i < tcharseq.length; i++){

      double [] tpath = letterSwitch(tcharseq[i]);
      double [] hpath = letterSwitch(hcharseq[i]);
      //returns false for invalid letters
      if(tpath[0]==0|hpath[0]==0) {
        return false;
      }
      tseq.add(tpath);
      hseq.add(hpath);
      }

      HexLayout tHex = new HexLayout(tseq);
      HexLayout hHex = new HexLayout(hseq);

      for(int i = 0; i<tHex.getHexLayout().length; i++){
        /*Tries each hex as the origin in each orientation and compares it to other
        If they match, return true */
        for(int j = 0; j<6; j++) {
          if (Same(tHex.rotate(tHex.makeOrigin(i),j), hHex.getHexLayout())) return true;
        }
      }
  }
  return false;
}


public static double [] letterSwitch(char letter) {
  double [] path = new double [2];
  switch(letter){
    //coordinate changes parameterized to a hex side length of 1
    case 'a': path[0] = Math.sqrt(3)/2; path[1]=1.5; break;
    case 'b': path[0] = -Math.sqrt(3)/2; path[1]=1.5; break;
    case 'c': path[0] = -Math.sqrt(3); path[1]=0; break;
    case 'd': path[0] = -Math.sqrt(3)/2; path[1]=-1.5; break;
    case 'e': path[0] = Math.sqrt(3)/2; path[1]=-1.5; break;
    case 'f': path[0] = Math.sqrt(3); path[1]=0; break;
    default: path[0]=0; path[1]=0;
  }
  return path;
}


//checks if two hex layouts are the same
public static boolean Same(double [][] t, double [][] h){
  for(int i = 0; i<t.length; i++){
    boolean contains = false;
    for(int j = 0; j<h.length; j++) {
      if(compare(t[i][0],h[j][0])&&compare(t[i][1],h[j][1])){
      contains = true;
      break;
      }
    }
    if(contains == false){
      return false;
    }
  }
  return true;
}


//compares individual values within a tolerance to control for rounding error
public static boolean compare(double a, double b) {
if(Math.abs(a-b)<0.001){
  return true;
}
return false;
}

}
