import java.util.logging.*;

public class App {
    private static final Logger logger = Logger.getLogger(App.class.getName());

    public static void main(String[] args) {
        try {
            int result = 4 / 0;
        } catch (Exception e) {
            logger.log(Level.SEVERE, "Can't divide by zero", e);
        }
    }
}