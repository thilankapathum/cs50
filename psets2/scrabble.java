//package psets2;
import java.util.Scanner;

class Scrabble
{
    public static void main(String[] args)
    {
        Scanner sc = new Scanner(System.in);

        System.out.println("Player 1 Enter Word: ");
        String player1Word = sc.nextLine();
        int player1 = computeScore(player1Word);

        System.out.println("Player 2 Enter Word: ");
        String player2Word = sc.nextLine();
        int player2 = computeScore(player2Word);

        // Check scores and find winner
        if(player1 > player2)
        {
            System.out.println("Player 1 Wins. Score: " + player1);
        }
        else if(player2 > player1){
            System.out.println("Player 2 Wins. Score: " + player2);
        }
        else
        {
            System.out.println("Tie: " + player1);
        }

        sc.close();

    }

    static int computeScore(String s)
    {
        // Points for each letter
        int pointsArray[] = {1,3,3,2,1,4,2,4,1,8,5,1,3,1,1,3,10,1,1,1,1,4,4,8,4,10};

        // Uppercase the input
        s = s.toUpperCase();

        // Initialize variables
        int points = 0;
        int j = 0;
        int sLength = s.length();

        // Store word in a char array
        char sArray[] = s.toCharArray();

        // Calculate points
        for(int i = 0; i < sLength; i++)
        {
            j = sArray[i] - 65;
            if(j >= 0 && j <= 25)
            {
                points = points + pointsArray[j];
            }            

        }
        return points;
    }
}