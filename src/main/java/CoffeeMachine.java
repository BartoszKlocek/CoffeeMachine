import java.util.Scanner;

public class CoffeeMachine {
    private Scanner scanner;
    private int water;
    private int milk;
    private int beans;
    private int cups;
    private int money;


    public CoffeeMachine() {
        this.scanner = new Scanner(System.in);
        this.water = 400;
        this.milk = 540;
        this.beans = 120;
        this.cups = 9;
        this.money = 550;
    }

    public void printState() {
        System.out.println("The coffe machine has:\n");
        System.out.println(this.water + " of water");
        System.out.println(this.milk + " of milk");
        System.out.println(this.beans + " of coffe beans");
        System.out.println(this.cups + " of cups");
        System.out.println(this.money + " PLN");
    }

    public void buy(int type) {
        int water = 0;
        int milk = 0;
        int beans = 0;
        int money = 0;

        switch (type) {
            case 1:
                water = 250;
                milk = 0;
                beans = 16;
                money = 4;
                break;

            case 2:
                water = 350;
                milk = 75;
                beans = 20;
                money = 7;
                break;
            case 3:
                water = 200;
                milk = 100;
                beans = 12;
                money = 6;
                break;
            default:
                break;

        }

        if (this.water < water) {
            System.out.println("Sorry,not enough water!");
        } else if (this.milk < milk) {
            System.out.println("Sorry,not enough milk!");
        } else if (this.beans < beans) {
            System.out.println("Sorry,not enough beans!");
        } else if (this.cups < cups) {
            System.out.println("Sorry,not enough milk!");
        } else {
            System.out.println("I have enough resources!");
            this.water -= water;
            this.milk -= milk;
            this.beans -= beans;
            this.cups -= 1;
            this.money += money;
        }

    }


    public void fill(int water, int milk, int coffeeBeans, int cups) {
        this.water += water;
        this.milk += milk;
        this.beans += coffeeBeans;
        this.cups += cups;
    }

    public void take() {
        this.money = 0;
    }

    public void remaining() {
        System.out.println("The coffe machine has:\n");
        System.out.println(this.water + " of water");
        System.out.println(this.milk + " of milk");
        System.out.println(this.beans + " of coffe beans");
        System.out.println(this.cups + " of cups");
        System.out.println(this.money + " of money");
    }

    public void processFill() {
        System.out.println("Write how many ml of water do you want to add:");
        int water = scanner.nextInt();
        System.out.println("Write how many ml of milk do you want to add:");
        int milk = scanner.nextInt();
        System.out.println("Write how many grams of coffee beans do you want to add:");
        int beans = scanner.nextInt();
        System.out.println("Write how many disposable cups of coffee do you want to add:");
        int cups = scanner.nextInt();
        this.fill(water, milk, beans, cups);
    }

    public void processTake() {
        System.out.println("I'll give you: " + this.money);
        this.take();
    }

    public void processBuy() {
        System.out.println("What do you want to buy? 1 - espresso, 2 - latte, 3 - cappuccino, back - to main menu:");
        String type = scanner.nextLine();
        if (type.equals("back")) {
            return;
        }
        this.buy(Integer.valueOf(type));

    }

    public boolean processAction() {
        System.out.println("Write action (buy, fill, take, remaining, exit):");
        String action = this.scanner.nextLine();

        switch (action) {
            case "buy":
                this.processBuy();
                break;

            case "fill":
                this.processFill();
                break;
            case "take":
                this.processTake();
                break;

            case "remaining":
                this.remaining();
                break;

            case "exit":
                return false;
            default:
                break;
        }
        return true;
    }


}
