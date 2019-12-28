public class Main {
    public static void main(String[] args) {
        CoffeeMachine deLonghi = new CoffeeMachine();
        boolean status;
        do {
            status=deLonghi.processAction();
        }
        while (status);

    }
}
