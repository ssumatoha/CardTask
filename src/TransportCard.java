abstract class TransportCard implements ICard{

    private float balance;
    private int roads;
    private int[] subDate = new int[3];


    public void increaseCard(float increaseBalance) {
        this.balance += increaseBalance;
    }

    public void decreaseCard(float decreaseBalance) {
        this.balance -= decreaseBalance;
    }

    public void increaseCard(int increaseRoads) {
        this.roads += increaseRoads;
    }

    public void decreaseCard(int decreaseRoads) {
        this.roads -= decreaseRoads;
    }

    public void buyMonthlySubscription(int[] subDate) {
        for(int i = 0; i < 3; i++){
            this.subDate[i] = subDate[i];
        }
    }

    public float getBalance() {
        return this.balance;
    }

    public int getRoads() {
        return this.roads;
    }

    public int[] getSubDate() {
        return this.subDate;
    }


}
