import java.util.Scanner;
class Hours
{

    public static void main(String[] args) 
    {
        Scanner sc = new Scanner(System.in);

        System.out.println("Number of weeks taking CS50: ");
        int numOfWeeks = sc.nextInt();
        int hours[] = new int[numOfWeeks];

        for(int i = 0; i < numOfWeeks; i++)
        {
            System.out.println("Week " + i + " HW hours: ");
            hours[i] = sc.nextInt();
        }

        System.out.println("Enter T for Total hours or A for Average hours per week:");
        
        Scanner sc2 = new Scanner(System.in);
        String userResponse = sc2.nextLine();
        char userResponseChar = userResponse.charAt(0);
        
        if(userResponseChar == 'T')
        {
            int total = 0;
            for(int i = 0; i < numOfWeeks; i++)
            {
                total += hours[i];
            }
            System.out.println("Total is:" + total);
        }else if(userResponseChar == 'A')
        {
            double total = 0;
            for(int i = 0; i < numOfWeeks; i++)
            {
                total += hours[i];
            }
            double average = total/numOfWeeks;
            System.out.println("Average is:" + average);
        }

        sc.close();
        sc2.close();
    }
}