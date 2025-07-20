package com.jun.vending_machine;

/**
 * Hello world!
 *
 */
public class App {
    public static void main( String[] args )
    {sle
        VendingMachine vm = new VendingMachine();
        vm.stock(new Item("Coke", 1000), 5);
        vm.stock(new Item("Sprite", 800), 4);
        vm.stock(new Item("OrangeJuice", 700), 2);

        vm.show();
        vm.buy("Coke", 2000);
    }
}
