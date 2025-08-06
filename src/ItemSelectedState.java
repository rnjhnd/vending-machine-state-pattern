public class ItemSelectedState implements VendingMachineState {
    @Override
    public void selectItem(VendingMachine machine, String item) {
        System.out.println("Item chosen. Please insert the required coins.");
    }

    @Override
    public void insertCoin(VendingMachine machine, int amount) {
        machine.addBalance(amount);
        System.out.println("Coin accepted. Current balance: " + machine.getBalance());
        
            if (machine.getBalance() >= machine.getItemPrice()) {
                System.out.println("Sufficient funds detected. Dispensing your item...");
                machine.setState(new DispensingState());
                machine.dispenseItem();
        }
    }

    @Override
    public void dispenseItem(VendingMachine machine) {
        System.out.println("Please insert sufficient coins.");
    }

    @Override
    public void setOutOfOrder(VendingMachine machine) {
        System.out.println("The machine is now out of service.");
        machine.setState(new OutOfOrderState());
    }
}