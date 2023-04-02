import classes.*;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.text.ParseException;
import java.util.Vector;


public class Main {
    public static void main(String[] args) throws ParseException {

    Service service = Service.getInit();
    service.doGeneralCommands();
    }
}