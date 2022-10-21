import java.util.Date;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Main {

    public static void main(String[] args) {
        StudentCard studentCard = new StudentCard();
        CashMachine cashMachine = new CashMachine();
        PaymentTerminal paymentTerminal = new PaymentTerminal();

        cashMachine.coopWithSubDate(studentCard, 300.0f);
        paymentTerminal.initCard(studentCard);
        paymentTerminal.info();
    }
}
