import java.util.Scanner;

class Credit{

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        long num = 4003600000000014L;

        System.out.println("Enter Credit Card Number: ");
        String userInput = sc.nextLine();

        num = Long.parseLong(userInput);

        sc.close();

        
        long max = 100000000000000000L;
        //long num = 54003600000000014L; 378282246310005 30569309025904 4222222222222

        // Check for long inputs > 16 digits:
        if (num*10<max){

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

            System.out.print("NUMBER ARRAY: ");

            for(int l=0;l<16;l++){
                System.out.print(numberArray[l]);
            }

            // Calculate checksum:

            int n[]=new int[8];
            int productsSum = 0;
            int othersSum = 0;

            for(int m=1,p=0;m<16;m+=2,p++){
                //n+=2*numberArray[m];
                

                if(2*numberArray[m]<10){
                    n[p] = 2*numberArray[m];
                }else{
                    n[p]= 2*numberArray[m]-9;
                }

            }
            System.out.print("Products Sum: ");

            for(int i=0;i<8;i++){
                System.out.print(n[i] + "-");
                productsSum += n[i];
            }

            for(int i=0;i<16;i+=2){
                othersSum += numberArray[i];
            }

            System.out.println("Products Sum: "+productsSum);
            System.out.println("Others Sum: "+othersSum);
            System.out.println("Total: " + (othersSum+productsSum));

        }else{
            System.out.println("Number out of range");
        }
        

    }
}