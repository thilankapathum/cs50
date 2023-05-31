import java.util.Scanner;

class World11_2{
    public static void main(String[] args){

        Scanner sc = new Scanner(System.in);

        System.out.println("Enter block size: ");
        String userInput = sc.nextLine();

        sc.close();

        try {
            int n = Integer.parseInt(userInput);
            mario(n);
        } catch (NumberFormatException e) {
            e.printStackTrace();
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

            System.out.print("   "); // print spacing
            
            for(int l=0;l<n-i+1;l++){
                System.out.print("#"); // print # ascending order
            }
            System.out.println(""); // new line
        }
    }
}