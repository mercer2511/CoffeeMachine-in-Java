package machine;

import java.util.Scanner;

public class CoffeeMachine {

    static int CMwater = 400;
    static int CMmilk = 540;
    static int CMbeans = 120;
    static int CMcups = 9;
    static int CMcash = 550;

    public static void ShowData() {
        System.out.println(CMwater+" ml of water");
        System.out.println(CMmilk+" ml of milk");
        System.out.println(CMbeans+" g of coffee beans");
        System.out.println(CMcups+" disposable cups");
        System.out.println("$"+CMcash+" of money");
    }

    public static void ActionMenu(String entrada,Scanner sc) {
        switch (entrada) {
            case "buy" -> {
                System.out.println("What do you want to buy? 1 - espresso, 2 - latte, 3 - cappuccino:");
                var cafe = sc.nextLine();
                BuyMenu(cafe);
            }
            case "fill" -> {
                System.out.println("Write how many ml of water you want to add:");
                var water = sc.nextInt();
                CoffeeMachine.CMwater += water;
                System.out.println("Write how many ml of milk you want to add:");
                var milk = sc.nextInt();
                CoffeeMachine.CMmilk += milk;
                System.out.println("Write how many grams of coffee beans you want to add:");
                var beans = sc.nextInt();
                CoffeeMachine.CMbeans += beans;
                System.out.println("Write how many disposable cups you want to add:");
                var cups = sc.nextInt();
                CoffeeMachine.CMcups += cups;
            }
            case "take" -> {
                System.out.println("I gave you $" + CoffeeMachine.CMcash);
                CoffeeMachine.CMcash = 0;
            }
        }
    }

    public static void BuyMenu(String entrada) {
        CoffeeMachine.CMcups -= 1;
        switch (entrada) {
            case "1":
                CMwater -= 250;
                CMbeans -= 16;
                CMcash += 4;
                break;

            case "2":
                CMwater -= 350;
                CMmilk -= 75;
                CMbeans -= 20;
                CMcash += 7;
                break;

            case "3":
                CMwater -= 200;
                CMmilk -= 100;
                CMbeans -= 12;
                CMcash += 6;
                break;

        }
    }

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        ShowData();
        System.out.println("Write action (buy, fill, take):");
        String option = input.nextLine();
        ActionMenu(option, input);
        ShowData();
    }
}
