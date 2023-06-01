import java.util.Scanner;
class Llama{
    public static void main(String[] args) 
    {

        // method to return number of years
        int startPopulation = population(9, "Enter Start Size: ");
        int endPopulation = population(startPopulation, "Enter End Size: ");

        int i = 0;
        for(i = 0; startPopulation <= endPopulation; i++)
        {
            startPopulation = startPopulation + startPopulation/3 - startPopulation/4 - startPopulation%3 + startPopulation%4;
        }

        System.out.println("Years: " + i);

    }

    static int population(int rightValue, String propmptText)
    {
        
        // Create Scanner object to get user input
        Scanner sc = new Scanner(System.in);
        int leftValue=0;

        do
        {
            System.out.println(propmptText);
            leftValue = sc.nextInt();

        } while(leftValue < rightValue);

        return leftValue;
    }
}