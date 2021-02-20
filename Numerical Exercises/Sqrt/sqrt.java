package sqrt129;
import java.util.Scanner;
//Returns sqare root of any real number
public class sqrt {

public static void main(String args[]) {

System.out.println("Please enter a number to get its square root.");
Scanner reader = new Scanner(System.in);
double input = reader.nextDouble();

if (input == 0) {
  System.out.println("The square root of "+input+" is 0");
}
else { //selects initial increment size based on (approx) order of mag.
int exp = magFinder(input);
double inc = 1;
if(exp>=0){
  for(int i = 0; i<exp; i++){
    inc*=10;
  }}
  else if(exp<0){
    for(int i = 0; i>exp; i--) {
      inc/=10;
    }
  }

if(input >= 1){
  double square = 0;
  double base = 0;
  double total =0;
for(int i = 0; i<24; i++){
while(square<input){
  square = (total+base)*(total+base);
  if(square>input){
    base-=inc;
    square = (total+base)*(total+base);
    break;}
    if(square==input){
      break;
    }
  base+=inc;}
total+=base;
if(square==input){
break;}
inc/=10;
base=0;
}
System.out.println("The square root of "+input+" is "+total+".");
  }

  else if(input <= -1){
    input = -input;
    double square = 0;
    double base = 0;
    double total =0;
  for(int i = 0; i<24; i++){
  while(square<input){
    square = (total+base)*(total+base);
    if(square>input){
      base-=inc;
      square = (total+base)*(total+base);
      break;}
      if(square==input){
        break;
      }
    base+=inc;}
  total+=base;
  if(square==input){
  break;}
  inc/=10;
  base=0;
  }
  System.out.println("The square root of "+-input+" is "+total+"i.");
    }

else if(input < 1 && input > 0){
      double square = 1;
      double base = 0;
      double total = 1;
    for(int i = 0; i<24; i++){
    while(square>input){
      square = (total-base)*(total-base);
      if(square<input){
        base-=inc;
        square = (total-base)*(total-base);
        break;}
        if(square==input){
          break;}
      base+=inc;}
    total-=base;
    if(square==input){
    break;}
    inc/=10;
    base=0;
    }
    System.out.println("The square root of "+input+" is "+total+".");
      }

      else if(input > -1 && input < 0){
        input = -input;
        double square = 1;
        double base = 0;
        double total = 1;
      for(int i = 0; i<24; i++){
      while(square>input){
        square = (total-base)*(total-base);
        if(square<input){
          base-=inc;
          square = (total-base)*(total-base);
          break;}
          if(square==input){
            break;}
        base+=inc;}
      total-=base;
      if(square==input){
      break;}
      inc/=10;
      base=0;
      }
      System.out.println("The square root of "+-input+" is "+total+"i.");
        }
}
}



public static int magFinder(double n){
if(n >= 1){
  int count = -1;
  while(n>1){
    n/=10;
    count++;
  }
  return count;
}
else if(n <= -1){
  int count = -1;
  while(n < -1){
    n/=10;
    count++;
  }
  return count;
}
else if(n < 1 && n > 0){
  int count = 0;
  while(n<1){
    n*=10;
    count--;
  }
  return count;
}
else if(n >= -1 && n < 0){
  int count = 0;
  while(n>-1){
    n*=10;
    count--;
  }
  return count;
}
return 0;
}

}
