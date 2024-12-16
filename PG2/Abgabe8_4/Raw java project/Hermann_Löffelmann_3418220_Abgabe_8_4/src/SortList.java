import java.util.List;
import java.util.ArrayList;

public class SortList {

    public static void main(String[] args) throws Exception {
        List<Person> list = new ArrayList<>();
        
        Job designerJob = new Job("Designer", 4000);
        Job leiterJob = new Job("Bfz-Leiter", 5500);
        Job studentJob = new Job("Student", 0);
        Job studentinJob = new Job("Studentin", 400);

        Person person1 = new Person("Mounett", 172, designerJob);
        Person person2 = new Person("Hermann", 180, leiterJob);
        Person person3 = new Person("Hermann Hagen", 187, studentJob);
        Person person4 = new Person("Annalena", 173, studentinJob);

        list.add(person1);
        list.add(person2);
        list.add(person3);
        list.add(person4);

        for (Person person : list) {
            printf()
        }

        
        
    }
}
