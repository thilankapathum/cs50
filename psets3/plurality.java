import java.util.Scanner;

class Plurality{
    final int MAX = 9;
    public static void main(String[] args){

        int candidatesCount = 0; // Get number of Candidates
        int votersCount = 0; // Get number of voters

        Scanner sc = new Scanner(System.in);

        // Get candidates count
        do{
            try {
                sc.reset();
                System.out.print("Number of Candidates: ");
                candidatesCount = sc.nextInt();

            } catch (Exception e) {
                sc.next();
                continue;

            } finally{
                sc.nextLine();
            }

        }while(candidatesCount <= 0);
        

        String[] candidatesName = new String[candidatesCount];
        
        // Get Candidate Names
        for(int i = 0; i < candidatesCount; i++){

            System.out.println("Enter Candidate" + (i+1) + " Name: ");
            candidatesName[i] = sc.nextLine();
        }

        Candidate[] candidates = new Candidate[candidatesCount]; // Create candidates object array

        // Add candidate names for object array
        for(int i = 0; i < candidatesCount; i++){
            candidates[i] = new Candidate();
            candidates[i].name = candidatesName[i];
        }

        // Get number of voters
        do{
            try {
                sc.reset();
                System.out.print("Number of Voters: ");
                votersCount = sc.nextInt();

            } catch (Exception e) {
                sc.next();
                continue;

            } finally{
                sc.nextLine();
            }

        }while(votersCount <= 0);

        String[] votersPreference = new String[votersCount];

        // Get voter preferences (votes)
        for(int i = 0; i < votersCount; i++){

            boolean candidateAvailable = true;

            do{
                System.out.println("Enter Vote " + (i+1));
                votersPreference[i] = sc.nextLine();
                candidateAvailable = vote(candidates,votersPreference[i]);
            } while(!candidateAvailable);

        }

        // Print all candidates and votes (not essential)
        System.out.println();
        for(int i = 0; i < candidatesCount; i++){
            System.out.println(candidates[i].name + " Votes: " + candidates[i].votes);
        }

        printWinner(candidates);

        sc.close();
    }

    // Method to cast Vote
    static boolean vote(Candidate[] candidates, String candidateName){

        int candidateCount = candidates.length;
        boolean candidateAvailable = false;

        // Check for each candidate
        for(int i = 0; i < candidateCount; i++){

            // checking the voter input & candidate name
            if(candidateName.equals(candidates[i].name)){
                candidates[i].votes += 1;
                candidateAvailable = true;
            }
                
        }

        // Voter input mismatch
        if(!candidateAvailable){
            System.out.println("Candidate is Unavailable");
        }
        return candidateAvailable;
    }

    // Print Winner(s)
    static void printWinner(Candidate[] candidates){

        int candidateCount = candidates.length;
        int maxVotes = 0;

        // Finding the maximum votes
        for(int i = 0; i < candidateCount; i++){
            if(candidates[i].votes > maxVotes){
                maxVotes = candidates[i].votes;
            }
        }

        // Printing candidates with max votes
        for(int i = 0; i < candidateCount; i++){
            if(maxVotes == candidates[i].votes){
                System.out.println("Winner is: " + candidates[i].name);
            }
        }
    }

}

class Candidate{
    String name;
    int votes;
}