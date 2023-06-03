import java.util.Scanner;

class Password
{
    public static void main(String[] args)
    {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter Password: ");
        String password = sc.nextLine();

        // check password validity from method checkPassword
        boolean passwordValid = checkPassword(password);

        // Criteria
        if(passwordValid)
        {
            System.out.println("Your password is Valid!");
        }
        else
        {
            System.out.println("Your password needs at least one uppercase letter, lowercase letter, number and symbol!");
        }

        sc.close();
    }

    static boolean checkPassword(String password)
    {
        int passLength = password.length();

        // Parse String to char array
        char passArray[] = password.toCharArray();

        // required booleans
        boolean upperCase = false;
        boolean lowerCase = false;
        boolean number = false;
        boolean symbol = false;
        boolean retunBool = false;

        // check for validity criteria
        for(int i = 0; i < passLength; i++)
        {
            int letter = (int) passArray[i];

            if(letter >= 65 && letter <= 90)
            {
                upperCase = true;
            }
            else if (letter >= 97 && letter <= 122)
            {
                lowerCase = true;
            }
            else if(letter >= 48 && letter<= 57)
            {
                number = true;
            }
            else if(letter >= 33 && letter <= 126)
            {
                symbol = true;
            }

            if(upperCase && lowerCase && number && symbol)
            {
                retunBool = true;

                // break for loop if all conditions are passed
                break;
            }
        }

        return retunBool;
    }
}