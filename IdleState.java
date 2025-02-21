public class IdleState implements VendingMachineState {
    @Override
    public void selectItem(VendingMachine machine, String item) {
        System.out.println("Item selected: " + item);
        machine.setSelectedItem(item);
        machine.setItemSelected(true);
        machine.setState(new ItemSelectedState());
    }

    @Override
    public void insertCoin(VendingMachine machine, int amount) {
        System.out.println("Please select an item before inserting a coin!");
    }

    @Override
    public void dispenseItem(VendingMachine machine) {
        if (!machine.isItemSelected()) {
            System.out.println("No item has been chosen! Please select an item first!");
        }
    }

    @Override
    public void setOutOfOrder(VendingMachine machine) {
        System.out.println("The vending machine is now out of service!");
        machine.setState(new OutOfOrderState());
    }
}