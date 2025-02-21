public class OutOfOrderState implements VendingMachineState {
    @Override
    public void selectItem(VendingMachine machine, String item) {
        System.out.println("This vending machine is out of service... Item selection is unavailable.");
    }

    @Override
    public void insertCoin(VendingMachine machine, int amount) {
        System.out.println("This vending machine is out of service... Coin insertion is unavailable.");
    }

    @Override
    public void dispenseItem(VendingMachine machine) {
        System.out.println("This vending machine is out of service... Dispensing items is unavailable.");
    }

    @Override
    public void setOutOfOrder(VendingMachine machine) {
        System.out.println("The vending machine is already out of service.");
    }
}