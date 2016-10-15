public abstract class Employee {
    private Rank rank;
    private String name;

    private Call currentCall = null;
    public Employee(Rank rank) {
        this.rank = rank;
    }


    public void assignCall(Call c) {};
    public Call getCall(){
        return currentCall;
    };

    public void setRank(Rank rank) {
        this.rank = rank;
    }


}
