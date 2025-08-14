# Vending Machine State Management System

A Java implementation of the **State Design Pattern** for efficient vending machine state management. This project demonstrates how to use state objects to manage different operational behaviors without complex conditional statements.

## 📋 Overview

The Vending Machine State Pattern allows you to manage a vending machine's different operational states (Idle, Item Selected, Dispensing, and Out of Order) using separate state classes. Instead of using complex if-else statements, the system delegates behavior to the current state object, making the code more maintainable and extensible.

## 🏗️ Architecture

This project implements the **State Design Pattern** with the following components:

- **VendingMachineState Interface**: Defines the contract for all state implementations
- **VendingMachine Context**: Main class that delegates operations to current state
- **Concrete State Classes**: IdleState, ItemSelectedState, DispensingState, and OutOfOrderState
- **Test Application**: Demonstrates the state pattern in action

### Design Pattern Benefits

- **Clean Separation**: Each state handles its own logic independently
- **Extensibility**: Easy to add new states without modifying existing code
- **Maintainability**: State-specific behavior is isolated and easy to understand
- **Testability**: Each state can be tested independently
- **Eliminates Complex Conditionals**: No more nested if-else statements

## 📊 UML Class Diagram

![image](https://github.com/user-attachments/assets/ae7b7c13-00ae-4639-b7a1-576aedbc6b7e)

The following diagram illustrates:
- The architecture of the Vending Machine State Pattern
- Relationships between the core components:
  - The `VendingMachineState` interface
  - Concrete implementations: `IdleState`, `ItemSelectedState`, `DispensingState`, `OutOfOrderState`
  - The `VendingMachine` context class
  - The test application class
- How the State design pattern is applied in this project

## 🚀 Features

- **Multiple Operational States**: Support for Idle, Item Selected, Dispensing, and Out of Order states
- **State-Specific Behavior**: Each state implements its own business logic
- **Automatic State Transitions**: States handle transitions to other states
- **Inventory Management**: Tracks item inventory and balance
- **Clean Architecture**: Well-structured, maintainable code

## 📁 Project Structure

```
vending-machine-state-pattern/
├── src/
│   ├── VendingMachine.java          # Main vending machine context class
│   ├── VendingMachineState.java     # State interface
│   ├── IdleState.java               # Idle state implementation
│   ├── ItemSelectedState.java       # Item selected state implementation
│   ├── DispensingState.java         # Dispensing state implementation
│   ├── OutOfOrderState.java         # Out of order state implementation
│   └── VendingMachineTest.java      # Test/demo application
└── README.md                        # Project documentation
```

## 🛠️ Installation & Setup

### Prerequisites

- Java Development Kit (JDK) 8 or higher
- Any Java IDE (IntelliJ IDEA, Eclipse, VS Code, etc.)

### Getting Started

1. **Clone or download** the project files
2. **Navigate** to the project directory
3. **Compile** the Java files:
   ```bash
   javac src/*.java
   ```
4. **Run** the application:
   ```bash
   java -cp src VendingMachineTest
   ```

## 📖 Usage

### Basic Usage

The main application (`VendingMachineTest.java`) demonstrates how to use the state pattern:

```java
// Create a vending machine with 10 items in inventory
VendingMachine vendingMachine = new VendingMachine(10);

// Select an item (transitions to ItemSelectedState)
vendingMachine.selectItem("Soda");

// Insert coins (allowed in ItemSelectedState)
vendingMachine.insertCoin(50);

// Dispense the item (transitions to DispensingState, then back to IdleState)
vendingMachine.dispenseItem();

// Set machine out of order (transitions to OutOfOrderState)
vendingMachine.setOutOfOrder();
```

### State-Specific Behavior

```java
// In IdleState - item selection is allowed
vendingMachine.selectItem("Chips");  // ✅ Allowed

// In IdleState - coin insertion is not allowed
vendingMachine.insertCoin(25);       // ❌ "Please select an item before inserting a coin."

// In OutOfOrderState - no operations are allowed
vendingMachine.selectItem("Soda");   // ❌ "Machine is out of order"
```

### Expected Output

When you run the application, you'll see:

```
Item selected: Soda
Coin inserted: 50
Dispensing Soda...
Item dispensed successfully!
The vending machine is now out of service.
Machine is out of order

Stock remaining: 9
Current balance: 40
```

## 🔄 State Transitions

```
    ┌─────────────┐
    │   IdleState │
    └─────┬───────┘
          │ selectItem()
          ▼
    ┌─────────────┐
    │ItemSelected │
    │   State     │
    └─────┬───────┘
          │ insertCoin() + dispenseItem()
          ▼
    ┌─────────────┐
    │ Dispensing  │
    │   State     │
    └─────┬───────┘
          │ (automatic)
          ▼
    ┌─────────────┐
    │   IdleState │
    └─────────────┘

    ┌─────────────┐
    │ OutOfOrder  │
    │   State     │
    └─────────────┘
          ▲
          │ setOutOfOrder()
    ┌─────┴───────┐
    │ Any State   │
    └─────────────┘
```

## 🔧 Extending the Project

### Adding New States

To add a new state (e.g., `MaintenanceState`):

1. **Create** a new class implementing the `VendingMachineState` interface
2. **Implement** all required methods (`selectItem()`, `insertCoin()`, `dispenseItem()`, `setOutOfOrder()`)
3. **Add** state transition logic as needed

Example:
```java
public class MaintenanceState implements VendingMachineState {
    @Override
    public void selectItem(VendingMachine machine, String item) {
        System.out.println("Machine is under maintenance. Please try again later.");
    }
    
    @Override
    public void insertCoin(VendingMachine machine, int amount) {
        System.out.println("Machine is under maintenance. Please try again later.");
    }
    
    @Override
    public void dispenseItem(VendingMachine machine) {
        System.out.println("Machine is under maintenance. Please try again later.");
    }
    
    @Override
    public void setOutOfOrder(VendingMachine machine) {
        System.out.println("Machine is already under maintenance.");
    }
}
```

## 🎯 Design Patterns Used

### State Pattern
- **Purpose**: Allow an object to alter its behavior when its internal state changes
- **Benefits**: Eliminates complex conditional statements and improves code organization
- **Implementation**: Each state class implements the `VendingMachineState` interface

### Context Pattern
- **Purpose**: Maintains a reference to a state object and delegates state-specific behavior
- **Benefits**: Provides a clean interface for state-dependent operations
- **Implementation**: `VendingMachine` class acts as the context and delegates to current state

## 🤝 Contributing

Feel free to contribute to this project by:
- Adding new states (e.g., `PaymentProcessingState`, `MaintenanceState`)
- Enhancing existing functionality (e.g., multiple item types, change calculation)
- Improving error handling and user feedback
- Adding comprehensive unit tests
- Updating documentation and examples

## 📄 License

This project is open source and available under the [MIT License](LICENSE).

---

**Note**: This implementation demonstrates clean code principles and design patterns best practices. The State pattern is particularly useful when an object's behavior depends on its state and the number of states is large or frequently changing.
