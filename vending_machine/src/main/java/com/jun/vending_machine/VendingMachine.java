package com.jun.vending_machine;

import java.util.Map;
import java.util.Set;
import java.util.HashMap;
import java.util.HashSet;

public class VendingMachine {
    private Map<Item, Integer> storage;
    private Set<String> menu;

    public VendingMachine() {
        storage = new HashMap<Item, Integer>();
        menu = new HashSet<>();
    };

    public void setStorage(Map<Item, Integer> storage) {
        this.storage = storage;
    }

    public void setMenu(Set<String> set) {
        this.menu = menu;
    }

    public Map<Item, Integer> getStorage() {
        return storage;
    }

    public Set<String> getMenu() {
        return menu;
    }

    public void stock(Item item, int quantity) {
        storage.put(item, storage.getOrDefault(item, 0) + quantity);
    }

    public void show() {
        storage.forEach((item, qty) -> System.out.printf("%s, %d원 (%d 개)%n", item.getName(), item.getPrice(), qty));
    }

    public int buy(String itemName, int money) {
        return buySingleItemAndReturn(itemName, money);
    }

    public int buySingleItemAndReturn(String itemName, int money) {
        // init
        Item target = null;
        for (Item item : storage.keySet()) {
            if (item.getName().equals(itemName)) {
                target = item;
                break;
            }
        }

        // constraint
        // if no item in storage, return money
        if (target == null || storage.get(target) < 1) {
            System.out.println("품절입니다.");
            return money;
        }

        // if not enough price for the item, return money
        if (money < target.getPrice()) {
            System.out.println("금액이 부족합니다.");
            return money;
        }

        // subtract item from storage
        System.out.printf("Buying %s, qty %d%n", target.getName(), 1);
        storage.put(target, storage.get(target) - 1);
        int change = money - target.getPrice();
        System.out.printf("%s 구매 완료! 잔돈 %d원%n", target.getName(), change);

        return change;
    }
}