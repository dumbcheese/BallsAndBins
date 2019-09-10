import java.util.Random;
import java.util.Scanner;
import java.util.Vector;
 
public class BallsAndBins {
    static int[] throwBalls(int m, int n){
        int arr[]=new int [m];
        Random rand = new Random(System.nanoTime());
        for (int i=0; i<n; i++) {
            int a=rand.nextInt(m);
            arr[a]=arr[a]+1;
        }
        return arr;
    }
    public static void main(String[] args) {
 
        @SuppressWarnings("resource") Scanner keyboard=new Scanner(System.in);
        System.out.println("Enter Array Size: ");
        int m=keyboard.nextInt();
        System.out.println("Enter Ball Count: ");
        int n=keyboard.nextInt();
 
        int arr2[]=new int[m];
        int numOfZeros[] = new int [50];
        int moreThanAverage[]=new int[50];
        int twiceTheAverage[]=new int [50];
        int fullestBin[]=new int[50];
        int highest;
       
        for (int i=0; i<50; i++) {
            highest=0;
            arr2=throwBalls(m,n);
            for(int j = 0; j < m; j++){
                if(arr2[j]==0) numOfZeros[i]++;
                if (arr2[j]>(n/m)) moreThanAverage[i]++;
                if (arr2[j]>((2*n)/m)) twiceTheAverage[i]++;
                if (arr2[j]>highest) highest=arr2[j];
            }
            fullestBin[i]=highest;
        }
 
        double sum=0;
        double sumOfMoreThanAverage=0;
        double sumOfTwiceTheAverage=0;
        double sumOfFullest=0;
        double max=0;
        double min=numOfZeros[0];
        for (int i=0; i<50; i++){
        sum=sum+numOfZeros[i];
        sumOfMoreThanAverage=sumOfMoreThanAverage+moreThanAverage[i];
        sumOfTwiceTheAverage=sumOfTwiceTheAverage+twiceTheAverage[i];
        sumOfFullest=sumOfFullest+fullestBin[i];
        if (numOfZeros[i]<min) min=numOfZeros[i];
        if (numOfZeros[i]>max) max=numOfZeros[i];
       
        }
       
       
        System.out.println("The lowest number of empty bins is: " + min + ", expressed in percentages is: " + (min/m)*100 + "%");
        System.out.println("The highest number of empty bins is: " + max + ", expressed in percentages is: " + (max/m*100) + "%");
        System.out.println("The average number of empty bins: " + sum/50 + ", expressed in percentages is: " + (((sum/50)/m)*100) + "%");
       
        System.out.println("The average number of bins that had more than average number of balls is: "+sumOfMoreThanAverage/50 + ", represented in fractions is: "+(((sumOfMoreThanAverage/50)/m)*100)+"% ");
        System.out.println("The average number of bins that had more than twice the average number of balls is: "+sumOfTwiceTheAverage/50 + ", represented in fractions is: "+ (((sumOfTwiceTheAverage/50)/m)*100) +"% " );                
        System.out.println("The average number of balls in the fullest bin is: " + sumOfFullest/50 + ", represented in fractions is: " + (((sumOfFullest/50)*100)/n) + "% of the balls ");
    }
}