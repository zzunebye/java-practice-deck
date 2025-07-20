package org.example;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class VendingMachine {
    // 자판기 상품은 Product 객체로 관리하지만, 역시 private 접근자로 직접적인 접근을 제한해야한다.
    // 필드를 명시적으로 초기화 -> 생성자보다 먼저 실행됨.
    private List<Product> products = new ArrayList<>();
    private int currentBalance = 0;

    public VendingMachine() {
        // 기본 생성자
        // 초기 상품 목록을 비워둠
    }

    // 초기 상품 목록을 생성과 동시에 입력하려 할 경우를 위한 생성자
    public VendingMachine(List<Product> initialProducts) {
        // 필드 초기화
        this.products = initialProducts;
    }


    // 자판기에 상품 채우기
    public void addProduct(Product product) {
        products.add(product);
    }

    // 1. 돈 투입
    public void insertMoney(int money) {
        currentBalance += money;
        System.out.println(money + "원이 투입되었습니다. 현재 잔액: " + currentBalance + "원");
    }

    // 2. 상품 목록 표시
    public void displayProducts() {
        System.out.println("--- 구매 가능한 상품 ---");
        for (Product product : products) {
            System.out.println(product.getName() + " (" + product.getPrice() + "원) - 재고: " + product.getStock() + "개");
        }
        System.out.println("----------------------");
    }

    // 3. 상품 선택 및 연속 구매 -> 캡슐화 구현.
    public void selectProduct(String productName) {
        // 이름으로 상품 찾기
        // Optinal 은 다트의 optional Type과 비슷한 기능이지만 이를 래퍼 클래스로 구현함.
        Optional<Product> selected = products.stream()
                .filter(p -> p.getName().equals(productName))
                .findFirst();

        if (selected.isPresent()) {
            Product product = selected.get();
            // 재고 확인
            if (product.getStock() <= 0) {
                System.out.println("죄송합니다. '" + productName + "' 상품은 품절입니다.");
                return;
            }
            // 잔액 확인 (객체 멤버인 currentBalance를 사용)
            if (currentBalance < product.getPrice()) {
                System.out.println("잔액이 부족합니다. 현재 잔액: " + currentBalance + "원");
                return;
            }

            // 구매 처리
            currentBalance -= product.getPrice();
            product.decreaseStock();

            System.out.println("'" + productName + "' 구매 완료! 맛있게 드세요.");
            System.out.println("남은 잔액: " + currentBalance + "원");

        } else {
            System.out.println("'" + productName + "' 상품을 찾을 수 없습니다.");
        }
    }

    public int getCurrentBalance() {
        return currentBalance;
    }

    // 4. 잔돈 반환 (잔돈 레버)
    public int returnChange() {
        int change = currentBalance;
        currentBalance = 0;
        if (change > 0) {
            System.out.println(change + "원의 잔돈이 반환되었습니다.");
        }
        return change;
    }
}
