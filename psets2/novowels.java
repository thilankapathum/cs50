import java.util.Scanner;

class Novowels
{
    public static void main(String[] args)
    {
        Scanner sc = new Scanner(System.in);

        String userInputString = "";

        // Check for empty inputs
        do
        {
            System.out.println("Enter word: ");
            userInputString = sc.nextLine();
        }
        while(userInputString.isEmpty());

        // use replace method to get result
        String userOutString = replace(userInputString);
        System.out.println(userOutString);
        
        sc.close();
        
    }

    static String replace(String userInput)
    {
        // Enter letters to a char array
        char[] words = userInput.toCharArray();

        for(int i = 0; i < userInput.length(); i++)
        {
            switch(words[i])
            {
                case 'a':
                    words[i] = '6';
                    break;

                case 'e':
                    words[i] = '3';
                    break;
                
                case 'i':
                    words[i] = '1';
                    break;
                
                case 'o':
                    words[i] = '0';
                    break;

                default:
                    break;
            }
        }

        // Convert char array to String
        String reString = new String(words);
        return reString;
    }
}