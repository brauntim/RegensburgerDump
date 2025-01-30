import java.io.IOException;

public class App {
    public static void main(String[] args) {
        String getOS = System.getProperty("os.name");
        String getJavaVersion = System.getProperty("java.version");

        System.out.println("OS: " + getOS);
        System.out.println("Java-version: " + getJavaVersion);

        System.out.println(System.getProperty("user.name"));

        String classpath = System.getenv("CLASSPATH");

        if (classpath != null) {
            System.out.println(classpath);
        } else {
            System.out.println("Classpath isn't set!");
        }
        System.out.println(System.getProperty("java.class.path"));

        System.out.println(System.currentTimeMillis());

        Runtime rt = Runtime.getRuntime();
        
        String[] cmdArray = {"notepad-plus-plus"};
        try { 
            rt.exec(cmdArray);
        } catch (IOException e) {
        }

        int cpu = rt.availableProcessors();
        System.out.println(cpu);
    }
}
