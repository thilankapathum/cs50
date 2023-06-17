class Plurality{
    final int MAX = 9;
    public static void main(String[] args){

        int candidatesCount = 3; // Get number of Candidates

        //String[] candidatesName = new String[candidatesCount];
        String[] candidatesName = {"Alice", "Charlie", "Bob"};

        Candidate[] candidates = new Candidate[candidatesCount]; // Create candidates array

        for(int i = 0; i < candidatesCount; i++){
            candidates[i] = new Candidate();
            candidates[i].name = candidatesName[i];
        }

        int votersCount = 6;

        String[] votersPreference = {"Alice", "Alice", "Bob", "Bob", "Charlie", "Charlie"};

        for(int j = 0; j < votersCount; j++){

            /* for(int i = 0; i < candidatesCount; i++){
                if(votersPreference[j] == candidates[i].name){
                    candidates[i].votes += 1;
                }
            } */

            vote(candidates,votersPreference[j]);
            
        }
        


        for(int i = 0; i < candidatesCount; i++){
            System.out.println(candidates[i].name + candidates[i].votes);
        }

        printWinner(candidates);
    }

    // Method to cast Vote
    static void vote(Candidate[] candidates, String candidateName){

        int candidateCount = candidates.length;
        boolean candidateAvailable = false;

        // Check for each candidate
        for(int i = 0; i < candidateCount; i++){

            // checking the voter input & candidate name
            if(candidateName == candidates[i].name){
                candidates[i].votes += 1;
                candidateAvailable = true;
            }
                
        }

        // Voter input mismatch
        if(!candidateAvailable){
            System.out.println("Candidate is Unavailable");
        }
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