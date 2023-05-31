import java.util.Scanner;

// Amex 15 Digits: 34 37
// MasterCard 16 digits: 51 52 53 54 55
// Visa 13 16 digits: 4

class Credit{
    

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.println("Enter Credit Card Number: ");
        String userInput = sc.nextLine();

        long num = Long.parseLong(userInput);

        sc.close();

        long max = 100000000000000000L; // Maximum value that a credit card can get/10
        long min = 1000000000000L; // Min value that a credit card can get/10

        // Check for long inputs < 16 digits:
        if (num*10<max && num>min){

            int numberArray[] = new int[16];
            int k = 0;

            // Save digits in numberArray[] in reverse order:
            for(long i=10L;i<max;i*=10){

                long remainder = num%i;
                num-=remainder;
                long digit = 10*remainder/i;
                int x = (int) digit;
                numberArray[k] = x;
                k++;
            }

            k=0; // return k to 0 prevent becoming garbage

            int checkSum = 0;

            // Calulate checkSum:
            for(int m=1;m<16;m+=2){

                checkSum += numberArray[m-1]; // sum even numbered positions

                // Sum odd numbered positions:
                if(2*numberArray[m]<10){
                    checkSum += 2*numberArray[m]; 
                }else{
                    checkSum += 2*numberArray[m]-9; // Check for multiplications > 10 to add those digits
                }
            }

            // System.out.println("Total CHECKSUM: " + (checkSum));

            // Check for Card Validity:
            if(numberArray[15]==5 && numberArray[14]>0 && numberArray[14]<6 && checkSum%10==0){
                System.out.println("MASTERCARD");
            }
            else if(numberArray[15]==0 && numberArray[14]==3 && (numberArray[13]==7 || numberArray[13]==4 && checkSum%10==0)){
                System.out.println("AMEX");
            }else if(numberArray[15]==4 && checkSum%10==0){
                System.out.println("VISA");
            }else if(numberArray[15]==0 && numberArray[14]==0 && numberArray[13]==0 && numberArray[12]==4 && checkSum%10==0){
                System.out.println("VISA");
            }else{
                System.out.println("INVALID!!"); 
            } 

        }else{
            System.out.println("INVALID!");
        }
    }
    
}