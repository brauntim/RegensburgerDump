public class Person implements Comparable<Person> {
        private String name;
        private int size;
        private Job job;

        public Person(String name, int size, Job job) {
            this.name = name;
            this.size = size;
            this.job = job;
        }

        public String getName() {
            return name;
        }

        public int getSize() {
            return size;
        }

        public Job getJob() {
            return job;
        }

        @Override
        public int CompareTo(Person other) {
            int salaryCompared = Double.compare(this.job.getSalary(), other.job.getSalary());
            if (salaryCompared != 0) return salaryCompared;
    
            return Integer.compare(other.getSize(), this.getSize());
        }
}
