
import java.util.Scanner;

class Plurality
{
    public static void main(String[] args)
    {
        System.out.println(getString("Hello"));
    }

    static String getString(String message)
    {
        Scanner sc = new Scanner(System.in);
        String returnString = null;

        try
        {
            System.out.println(message);
            returnString = sc.nextLine();
        }
        catch(Exception e)
        {
            System.out.println(e);
        }
        finally
        {
            sc.close();
        }
        

        return returnString;
        
    }

}