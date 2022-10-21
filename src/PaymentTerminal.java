public class PaymentTerminal {

    private SocialCard socialCard;
    private SchoolCard schoolCard;
    private StudentCard studentCard;

    private float balance;
    private int roads;
    private int[] subDate = new int[3];
    private boolean subDateStatus;

    public void initCard(SocialCard socialCard) {
        this.socialCard = socialCard;
        this.balance = socialCard.getBalance();
        this.roads = socialCard.getRoads();
        int[] localSubDate = socialCard.getSubDate();
        for(int i = 0; i < 3; i++)
            this.subDate[i] = localSubDate[i];

        statusSub(this.subDate);
        if(subDateStatus){
            System.out.println("Оплачено!");
        } else if(this.roads >= 1){
            this.socialCard.decreaseCard(1);
            System.out.println("Оплачено!");
        } else if(this.balance >= 40.0f){
            this.socialCard.decreaseCard(40.0f);
            System.out.println("Оплачено!");
        } else
            System.out.println("Не хватает средств. Пополните карту!");

        info();
    }

    public void initCard(SchoolCard schoolCard) {
        this.schoolCard = schoolCard;
        this.balance = schoolCard.getBalance();
        this.roads = schoolCard.getRoads();
        int[] localSubDate = schoolCard.getSubDate();
        for(int i = 0; i < 3; i++)
            this.subDate[i] = localSubDate[i];

        statusSub(this.subDate);
        if(subDateStatus){
            System.out.println("Оплачено!");
        } else if(this.roads >= 1){
            this.schoolCard.decreaseCard(1);
            System.out.println("Оплачено!");
        } else if(this.balance >= 30.0f){
            this.schoolCard.decreaseCard(30.0f);
            System.out.println("Оплачено!");
        } else
            System.out.println("Не хватает средств. Пополните карту!");

        info();
    }

    public void initCard(StudentCard studentCard) {
        this.studentCard = studentCard;
        this.balance = studentCard.getBalance();
        this.roads = studentCard.getRoads();
        int[] localSubDate = studentCard.getSubDate();
        for(int i = 0; i < 3; i++)
            this.subDate[i] = localSubDate[i];

        statusSub(this.subDate);
        if(subDateStatus){
            System.out.println("Оплачено!");
        } else if(this.roads >= 1){
            this.studentCard.decreaseCard(1);
            System.out.println("Оплачено!");
        } else if(this.balance >= 45.0f){
            this.studentCard.decreaseCard(45.0f);
            System.out.println("Оплачено!");
        } else
            System.out.println("Не хватает средств. Пополните карту!");

        info();
    }

    public void info() {
        System.out.println("Баланс на карте: " + this.balance);
        System.out.println("Поездок на карте: " + this.roads);
        String result = statusSub(this.subDate);
        System.out.println(result);
    }

    private String statusSub(int[] subDate) {
        if(this.subDate[0] == 0) {
            this.subDateStatus = false;
            return "Статус подписки: не оформлена";
        } else {
            int[] localDate = PhoneApp.calcDate(0);
            if(localDate[2] <= subDate[2]){
                if(localDate[1] <= subDate[1]){
                    if(localDate[0] <= subDate[0]){
                        this.subDateStatus = true;
                        return "Статус подписки: действует";
                    } else {
                        this.subDateStatus = false;
                        return "Статус подписки: просрочена";
                    }
                } else {
                    this.subDateStatus = false;
                    return "Статус подписки: просрочена";
                }
            } else {
                this.subDateStatus = false;
                return "Статус подписки: просрочена";
            }
        }
    }

}
