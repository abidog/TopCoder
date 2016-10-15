public class Call {

    private int callId;
    private Rank rank;
    private Employee handler;
    private Caller caller;
    private int time;

    public Call(Caller caller) {
        this.caller = caller;
        rank = Rank.Responder;
    }

    public void incrementRank() {};
    public Rank getRank(){
        return rank;
    };

}
