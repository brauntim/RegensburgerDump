import java.util.Date;
public class App {
    public static void main(String[] args) throws Exception {
        CurrentTime();
    }
    public static void CurrentTime() {
        Date date = new Date();
        System.out.println(date.toString());
    }
}
