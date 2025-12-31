import java.util.Random;

public class main {

    public static void main(String[] args)
    {
        Random random = new Random();
        int idProcess = random.nextInt(11);
        CriticalResource criticalResource = new CriticalResource();
        MulticastContext multicast = new MulticastContext(idProcess);

    }
}