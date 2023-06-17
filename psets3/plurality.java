class Plurality{
    final int MAX = 9;
    public static void main(String[] args){

        int candidatesCount = 3; // Get number of Candidates

        //String[] candidatesName = new String[candidatesCount];
        String[] candidatesName = {"Alice", "Charile", "Bob"};

        Candidate[] candidates = new Candidate[candidatesCount]; // Create candidates array

        for(int i = 0; i < candidatesCount; i++){
            candidates[i] = new Candidate();
            candidates[i].name = candidatesName[i];
        }

        int votersCount = 3;

        String[] votersPreference = {"Alice", "Alice", "Bob"};

        for(int j = 0; j < votersCount; j++){

            for(int i = 0; i < candidatesCount; i++){
                if(votersPreference[j] == candidates[i].name){
                    candidates[i].votes += 1;
                }
            }
            
        }
        


        for(int i = 0; i < candidatesCount; i++){
            System.out.println(candidates[i].name + candidates[i].votes);
        }
    }
}

class Candidate{
    String name;
    int votes;
}