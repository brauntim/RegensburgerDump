import java.text.SimpleDateFormat;
import java.util.Date;                //veraltet

public class App {
    public static void main (String[] args) {  
    Date currentDate = new Date();

    System.out.println(currentDate);

    
    SimpleDateFormat sdf = new SimpleDateFormat("dd.MM.yyyy G 'at' HH:mm:ss z");

    String formattedDate = sdf.format(currentDate);

    System.out.println(formattedDate);
    }
}
