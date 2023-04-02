import classes.*;
import java.text.ParseException;

public class Main {
    public static void main(String[] args) throws ParseException {
    Service service = Service.getInit();
    service.doGeneralCommands();
    }
}