

public class Client {
    public static void main(String[] args) {
        Drone d = new Drone("Fano", true);
        Drone d1 = new Drone("Roma", true);
        Drone d2 = new Drone("Milano", true);
        Drone d3 = new Drone("Monopoli", true);

        d.start();
        d1.start();
        d2.start();
        d3.start();

        try {
            d.join();
            d1.join();
            d2.join();
            d3.join();
        } catch (InterruptedException ex) {
            System.out.println(ex);
        }
    }

}