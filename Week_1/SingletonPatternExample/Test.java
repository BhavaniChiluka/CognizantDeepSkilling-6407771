public class Test {
    public static void main(String[] args) {
        Logger l1 = Logger.getInstance();
        l1.log("First log message");

        Logger l2 = Logger.getInstance();
        l2.log("Second log message");

        if (l1 == l2) {
            System.out.println("Both l1 and l2 are the same instance.");
        } else {
            System.out.println("Both l1 and l2 are the different instance.");
        }
    }
}
