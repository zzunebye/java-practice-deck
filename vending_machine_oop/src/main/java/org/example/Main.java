package org.example;

public class Main {
    public static void main(String[] args) {
        VendingMachine vm = new VendingMachine();

        vm.addProduct(new Product("콜라", 1200, 5));
        vm.addProduct(new Product("사이다", 1300, 3));
        vm.addProduct(new Product("커피", 1500, 2));
        vm.addProduct(new Product("초코바", 800, 10));

        vm.displayProducts();

        vm.insertMoney(5000);

        vm.selectProduct("콜라");
        vm.selectProduct("사이다");
        vm.selectProduct("커피");

        vm.insertMoney(2000);
        vm.selectProduct("초코바");
        vm.selectProduct("콜라"); // 재고가 없을 경우

        vm.returnChange();


        // 잔돈 반환 후 잔액 확인
        System.out.println("--- 모든 거래 종료 ---");
        vm.selectProduct("생수"); // 잔액이 0원이므로 실패

    }
}