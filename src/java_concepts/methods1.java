package java_concepts;

public class methods1 {
    public static void main (String[] args) {
        int highScorePosition = calculateHighScorePosition(1500);
        displayHighScorePosition("Ashwin", highScorePosition);

        highScorePosition = calculateHighScorePosition(90);
        displayHighScorePosition("shanks", highScorePosition);
    }
    public static void displayHighScorePosition (String pname, int position){
        System.out.println(pname + " managed to get into position " + position + " on the high score table");
    }
    public static int calculateHighScorePosition(int playerScore){
        if(playerScore >= 1000) {
            return 1;
        } else if(playerScore >= 500 && playerScore < 1000){
            return 2;
        } else if(playerScore >= 100 && playerScore < 500) {
            return 3;
        } else  {
            return 4;
        }
    }
}

