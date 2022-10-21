import java.util.Date;

public class PhoneApp {

    private SchoolCard schoolCard;
    private SocialCard socialCard;
    private StudentCard studentCard;

    private int date[] = new int[3];

    public void coopWithCardBalance(SchoolCard schoolCard, float money) {
        this.schoolCard = schoolCard;
        this.schoolCard.increaseCard(money);
    }

    public void coopWithCardBalance(SocialCard socialCard, float money) {
        this.socialCard = socialCard;
        this.socialCard.increaseCard(money);
    }

    public void coopWithCardBalance(StudentCard studentCard, float money) {
        this.studentCard = studentCard;
        this.studentCard.increaseCard(money);
    }

    public void coopWithCardRoads(SchoolCard schoolCard, float money) {
        this.schoolCard = schoolCard;
        float tax = 20.0f;
        float roads = money/tax;
        float mon = money%tax;
        this.socialCard.increaseCard(mon);
        this.schoolCard.increaseCard((int)roads);
    }

    public void coopWithCardRoads(SocialCard socialCard, float money) {
        this.socialCard = socialCard;
        float tax = 30.0f;
        float roads = money/tax;
        float mon = money%tax;
        this.socialCard.increaseCard(mon);
        this.socialCard.increaseCard((int)roads);
    }

    public void coopWithCardRoads(StudentCard studentCard, float money) {
        this.studentCard = studentCard;
        float tax = 35.0f;
        float roads = money/tax;
        float mon = money%tax;
        this.socialCard.increaseCard(mon);
        this.studentCard.increaseCard((int)roads);
    }

    public void coopWithSubDate(StudentCard studentCard, float money) {
        this.studentCard = studentCard;
        float tax = 300.0f;
        if(money >= tax) {
            int[] localDate = calcDate(1);
            this.date[0] = localDate[0];
            this.date[1] = localDate[1];
            this.date[2] = localDate[2];
            this.studentCard.buyMonthlySubscription(this.date);
            System.out.println("Подписка успешно оформлена");
        } else
            System.out.println("Недостаточно средств для оформления подписки");
    }

    public void coopWithSubDate(SchoolCard schoolCard, float money) {
        this.schoolCard = schoolCard;
        float tax = 100.0f;
        if(money >= tax) {
            int[] localDate = calcDate(1);
            this.date[0] = localDate[0];
            this.date[1] = localDate[1];
            this.date[2] = localDate[2];
            this.schoolCard.buyMonthlySubscription(this.date);
            System.out.println("Подписка успешно оформлена");
        } else
            System.out.println("Недостаточно средств для оформления подписки");
    }

    public void coopWithSubDate(SocialCard socialCard, float money) {
        this.socialCard = socialCard;
        float tax = 400.0f;
        if(money >= tax) {
            int[] localDate = calcDate(1);
            this.date[0] = localDate[0];
            this.date[1] = localDate[1];
            this.date[2] = localDate[2];
            this.socialCard.buyMonthlySubscription(this.date);
            System.out.println("Подписка успешно оформлена");
        } else
            System.out.println("Недостаточно средств для оформления подписки");
    }

    public static int[] calcDate(int m) {
        String[] months = new String[]
                {"Jan", "Feb", "Mar", "Apr", "May", "Jun", "Jul", "Aug", "Sep", "Oct", "Nov", "Dec"};
        int[] localDate = new int[3];
        int month = 0;
        Date date = new Date();
        String monthStr = date.toString().substring(4, 7);
        String dayStr = date.toString().substring(8, 10);
        String yearStr = date.toString().substring(26, 28);
        for(int i = 0; i<months.length; i++) {
            if(months[i].equals(monthStr)) {
                month = i + m;
            }
        }
        int day = Integer.parseInt(dayStr);
        int year = Integer.parseInt(yearStr);
        localDate[0] = day;
        localDate[1] = month;
        localDate[2] = year;
        return localDate;
    }

}
