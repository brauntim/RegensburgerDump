import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;

public class App {
    public static void main(String[] args) throws Exception {
          HashMap<String, String> CapitalCities = new HashMap<>();
          ArrayList<Integer> Population = new ArrayList<>();

          CapitalCities.put("England", "London");
          CapitalCities.put("Germany", "Berlin");
          CapitalCities.put("USA", "Washington D.C.");

          Iterator<Integer> it = Population.iterator();
          Population.add(1000);
          Population.add(300000);
          Population.add(41746174);

          System.out.println(CapitalCities);

          for (String i : CapitalCities.values()) {
               System.out.println(i);
          }
       
          for (String i : CapitalCities.keySet()) {
               System.out.println(i);
          }

          System.out.println(it.next());
     }
}
