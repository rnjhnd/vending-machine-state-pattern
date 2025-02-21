public class VendingMachine {
    private int inventory;
    private int balance;
    private String selectedItem;
    private int itemPrice = 10;
    private boolean isItemSelected = false;

    private VendingMachineState currentState;

    public VendingMachine(int inventory) {
        this.inventory = inventory;
        this.balance = 0;
        this.currentState = new IdleState();
    }

    public void setState(VendingMachineState newState) {
        this.currentState = newState;
    }

    public void selectItem(String item) {
        currentState.selectItem(this, item);
    }

    public void insertCoin(int amount) {
        currentState.insertCoin(this, amount);
    }

    public void dispenseItem() {
        currentState.dispenseItem(this);
    }

    public void setOutOfOrder() {
        currentState.setOutOfOrder(this);
    }

    public int getBalance() {
        return balance;
    }

    public int getInventory() {
        return inventory;
    }

    public void addBalance(int amount) {
        balance += amount;
    }

    public void setBalance(int amount) {
        balance = amount;
    }

    public String getSelectedItem() {
        return selectedItem;
    }

    public void setSelectedItem(String selectedItem) {
        this.selectedItem = selectedItem;
    }

    public void decreaseItemStock() {
        inventory--;
    }
 
    public int getItemPrice() {
        return itemPrice;
    }

    public boolean isItemSelected() {
        return isItemSelected;
    }
    
    public void setItemSelected(boolean selected) {
        this.isItemSelected = selected;
    }

    @Override
    public String toString() {
        return "\nStock remaining: " + inventory + "\nCurrent balance: " + balance;
    }
}