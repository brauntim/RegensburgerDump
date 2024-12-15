import java.util.*;

public class SortList {
    public class Person {
        private String name;
        private int size;
        private Job job;

        public Person(String name, int size, Job job) {
            this.name = name;
            this.size = size;
            this.job = job;
        }

        public String getName() {
            return this.name;
        }

        public int getSize() {
            return this.size;
        }

        public Job getJob() {
            return this.job;
        }
    }

    public class Job {
        private String name;
        private double salary;

        public Job(String name, double salary) {
            this.name = name;
            this.salary = salary;
        }

        public String getName() {
            return this.name;
        }

        public double getSalary() {
            return this.salary;
        }
    }



    public static void main(String[] args) throws Exception {
        List<Person> list = new ArrayList<>();
        
    }
}
