public class VendingMachineTest {
    public static void main(String[] args) {
        VendingMachine vendingMachine = new VendingMachine(10);

        vendingMachine.selectItem("Soda");
        vendingMachine.insertCoin(50);
        vendingMachine.dispenseItem();
        vendingMachine.setOutOfOrder();

        vendingMachine.selectItem("Chips");
        System.out.println(vendingMachine);
    }
}