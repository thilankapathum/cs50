import java.util.Scanner;

// Amex 15 Digits: 34 37
// MasterCard 16 digits: 51 52 53 54 55
// Visa 13 16 digits: 4

class Credit{

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        long num = 4003600000000014L;

        System.out.println("Enter Credit Card Number: ");
        String userInput = sc.nextLine();

        num = Long.parseLong(userInput);

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

            // Calculate checksum:
            int othersSum = 0, numberSumP=0;

            // Calulate sum of products of odd locations and store in numberSumP:
            for(int m=1;m<16;m+=2){

                if(2*numberArray[m]<10){
                    numberSumP += 2*numberArray[m]; 
                }else{
                    numberSumP += 2*numberArray[m]-9; // Check for multiplications > 10 to add those digits
                }
            }

            // Calculate sum of even locations and store in othersSum:
            for(int i=0;i<16;i+=2){
                othersSum += numberArray[i];
            }

            System.out.println("Total NUMBERSUM: " + (numberSumP+othersSum));

        }else{
            System.out.println("Number out of range");
        }
        

    }
}