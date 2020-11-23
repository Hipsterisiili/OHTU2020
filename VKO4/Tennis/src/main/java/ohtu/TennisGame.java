package ohtu;

public class TennisGame {
    
    private int p1Score = 0;
    private int p2Score = 0;
    private String player1Name;
    private String player2Name;
    private String winner;

    public TennisGame(String player1Name, String player2Name) {
        this.player1Name = player1Name;
        this.player2Name = player2Name;
        this.winner = "";
    }

    public void wonPoint(String playerName) {
        if (playerName.equals(player1Name)){
            p1Score += 1;
            //System.out.println("P1SCORE");
        }
        else {
            p2Score += 1;
            //System.out.println("P2SCORE");
        }
    }

    public String getScore() {
        if(winnerExists()){
            return "Win for " + winner;
        }
        return p1Print() + p2Print();
    }
    
    public String p1Print(){
        if(p1Score == 0){
            return "Love-";
        } else if (p1Score == 1){
            return "Fifteen-";
        }else if (p1Score == 2){
            return "Thirty-";
        }else if (p1Score == 3){
            return "Forty-";
        }
        else return "incompatible number";
    }
    
    public String p2Print(){
        if(p1Score == p2Score){
            return "All\n";
        }
        if(p2Score == 0){
            return "Love\n";
        } else if (p2Score == 1){
            return "Fifteen\n";
        }else if (p2Score == 2){
            return "Thirty\n";
        }else if (p2Score == 3){
            return "Forty\n";
        }
        else return "incompatible number";
    }
    
    public boolean winnerExists(){
        if(p1Score >= 4){
            winner = "player1";
            return true;
        } else if (p2Score >= 4){
            winner = "player2";
            return true;
        }
        return false;
    }
}