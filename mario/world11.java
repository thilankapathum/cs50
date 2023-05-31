import java.util.Scanner;

public class world11{
    public static void main(String[] args){

        Scanner sc = new Scanner(System.in);    // create scanner object
        System.out.println("Enter height: ");   // prompt  user input

        String marioHeight = sc.nextLine(); // scan into String using scanner object

        sc.close(); // close scanner object to prevent memory leak

        // parse String to Int:
        try{
            int n = Integer.parseInt(marioHeight); //parse String to Int
            mario(n); // call mario method
        }
        catch (NumberFormatException e){
            e.printStackTrace();
            System.out.println("Invalid number");
        }

    }

    static void mario(int n){
        for(int i=n;i>0;i--){
            
            for(int j=i;j>1;j--){
                System.out.print(" "); //print blanks (descending order)
               }

            for(int k=0;k<n-i+1;k++){
                System.out.print("#"); //print # (ascending order)
            }
            System.out.println(""); // new line
        }
    }
}