public class DispensingState implements VendingMachineState {
    @Override
    public void selectItem(VendingMachine machine, String item) {
        System.out.println("Currently dispensing an item. Please wait...");
    }

    @Override
    public void insertCoin(VendingMachine machine, int amount) {
        System.out.println("Processing your request. Please wait...");
    }

    @Override
    public void dispenseItem(VendingMachine machine) {
        machine.decreaseItemStock();
        machine.setBalance(machine.getBalance() - machine.getItemPrice());
        System.out.println("Your item is ready! Switching back to Idle Mode...");
        machine.setState(new IdleState());
    }

    @Override
    public void setOutOfOrder(VendingMachine machine) {
        System.out.println("The vending machine is now out of service.");
        machine.setState(new OutOfOrderState());
    }
}