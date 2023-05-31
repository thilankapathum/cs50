//package psets1.cash;

import java.util.Scanner;

class Cash{

    public static void main(String[] args){

        Scanner sc = new Scanner(System.in);  // create Scanner object
        int cents=0;  // initialize cents value
        
        cents = tryCatch(cents, sc);  // method to parse String to int using try catch
        sc.close();  // close scanner to prevent memory leak

        // Calculate quarters:
        int quarters = calculateQuarters(cents);
        System.out.println("Quarters are: "+quarters);

        cents = cents - quarters*25;  // Substract the value of quarters from the initial cents value

        // Calculate dimes:
        int dimes = calculateDimes(cents);
        System.out.println("Dimes are: "+dimes);

        cents-=dimes*10;
        
        //Calculate Nickels:
        int nickels = calculateNickels(cents);
        System.out.println("Nickels are: "+ nickels);
        cents -= nickels*5;

        // Print remaining cents:
        System.out.println("Cents are: "+ cents);
    }

    static int calculateQuarters(int q){
        int quarters = q/25;
        return quarters;
    }

    static int calculateDimes(int d){
        int dimes = d/10;
        return dimes;
    }

    static int calculateNickels(int n){
        int nickels = n/5;
        return nickels;
    }

    static int calculateCents(int c){
        return c;
    }

    static int tryCatch(int cents,Scanner sc){

            System.out.println("Enter cents: ");
            String userInput = sc.nextLine();

            try {
                cents = Integer.parseInt(userInput);
            } catch (Exception e) {
                // System.out.println(e);  // Print exception error
                System.out.println("Enter valid int!");
                cents=tryCatch(cents, sc);
            }
            return cents;
    }
}

