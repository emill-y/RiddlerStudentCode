import java.io.*;
import org.junit.jupiter.api.Test;

public class RiddlerTester {

    private Riddler solver = new Riddler();
    private String encrypted = "";

    @Test
    public void testOne() {
        setTestData("1");
        solver.decryptOne(encrypted);
    }

    @Test
    public void testTwo() {
        setTestData("2");
        solver.decryptTwo(encrypted);
    }

    @Test
    public void testThree() {
        setTestData("3");
        solver.decryptThree(encrypted);
    }

    @Test
    public void testFour() {
        setTestData("4");
        solver.decryptFour(encrypted);
    }

    @Test
    public void testFive() {
        setTestData("5");
        solver.decryptFive(encrypted);
    }

    private void setTestData(String text) {
        // Open files
        try {
            BufferedReader encryptedReader = new BufferedReader(new FileReader("test_files/" + text + "_encrypted.txt"));
            String line;
            while((line = encryptedReader.readLine()) != null) {
                encrypted += line;
            }
        } catch (IOException e) {
            System.out.println("Error opening test file " + text + "_encrypted.txt");
            e.printStackTrace();
        }
    }
}