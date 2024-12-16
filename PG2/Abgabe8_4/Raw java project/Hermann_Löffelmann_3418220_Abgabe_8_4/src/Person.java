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
