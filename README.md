# Vending Machine State Management System

A Java implementation of a vending machine using the **State Design Pattern** to manage different operational states and their associated behaviors.

## 📋 Table of Contents

- [Overview](#overview)
- [Problem Statement](#problem-statement)
- [Solution: State Pattern Implementation](#solution-state-pattern-implementation)
- [Project Structure](#project-structure)
- [Features](#features)
- [Installation & Usage](#installation--usage)
- [Code Examples](#code-examples)
- [State Transitions](#state-transitions)
- [UML Class Diagram](#uml-class-diagram)
- [Benefits of State Pattern](#benefits-of-state-pattern)
- [Contributing](#contributing)
- [License](#license)

## 🎯 Overview

This project demonstrates the implementation of the **State Design Pattern** to manage a vending machine's different operational states. Instead of using complex conditional statements, the system uses separate state classes to handle behavior based on the current state of the vending machine.

## ❓ Problem Statement

Traditional vending machine implementations often rely on conditional statements within a single class to check the machine's state and determine valid actions. This approach becomes:

- **Cumbersome** as the number of states grows
- **Error-prone** due to complex state logic
- **Hard to maintain** when adding new states or behaviors
- **Difficult to test** individual state behaviors

## 💡 Solution: State Pattern Implementation

The State Pattern provides a clean solution by:

1. **Defining State Interface**: `VendingMachineState` interface with common operations
2. **Creating Concrete States**: Separate classes for each state (`IdleState`, `ItemSelectedState`, `DispensingState`, `OutOfOrderState`)
3. **Delegating Behavior**: The main `VendingMachine` class delegates operations to the current state object
4. **Managing Transitions**: Each state handles its own transitions to other states

## 📁 Project Structure

```
vending-machine-state-pattern/
├── README.md
├── src/
│   ├── VendingMachine.java          # Main vending machine class
│   ├── VendingMachineState.java     # State interface
│   ├── IdleState.java              # Idle state implementation
│   ├── ItemSelectedState.java      # Item selected state implementation
│   ├── DispensingState.java        # Dispensing state implementation
│   ├── OutOfOrderState.java        # Out of order state implementation
│   └── VendingMachineTest.java     # Test/demo class
└── UML Class Diagram.png           # System architecture diagram
```

## ✨ Features

### State Management
- **Idle State**: Allows item selection, prevents coin insertion and dispensing
- **Item Selected State**: Allows coin insertion and dispensing, prevents item selection
- **Dispensing State**: No operations allowed, automatically returns to idle after completion
- **Out of Order State**: All operations disabled

### Core Operations
- Item selection with inventory tracking
- Coin insertion with balance management
- Item dispensing with automatic inventory reduction
- System status management (out of order functionality)

## 🚀 Installation & Usage

### Prerequisites
- Java 8 or higher
- Any Java IDE (IntelliJ IDEA, Eclipse, VS Code, etc.)

### Running the Application

1. **Clone or download** the project files
2. **Navigate** to the `src` directory
3. **Compile** the Java files:
   ```bash
   javac *.java
   ```
4. **Run** the test application:
   ```bash
   java VendingMachineTest
   ```

## 💻 Code Examples

### Basic Usage

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

## 🏗️ UML Class Diagram

![UML Class Diagram](UML%20Class%20Diagram.png)

The diagram shows the relationship between the `VendingMachine` class and its state implementations, demonstrating the State Pattern structure.

## 🎯 Benefits of State Pattern

### ✅ Advantages
- **Clean Separation of Concerns**: Each state handles its own logic
- **Easy to Extend**: Adding new states doesn't require modifying existing code
- **Improved Maintainability**: State-specific behavior is isolated
- **Better Testability**: Each state can be tested independently
- **Eliminates Complex Conditionals**: No more nested if-else statements

### 🔄 State-Specific Benefits
- **IdleState**: Handles item selection logic
- **ItemSelectedState**: Manages coin insertion and dispensing preparation
- **DispensingState**: Controls the dispensing process and automatic transitions
- **OutOfOrderState**: Provides system shutdown functionality

## 🤝 Contributing

Contributions are welcome! Here are some ways you can contribute:

1. **Add new states** (e.g., `MaintenanceState`, `PaymentProcessingState`)
2. **Enhance existing functionality** (e.g., multiple item types, change calculation)
3. **Improve error handling** and user feedback
4. **Add comprehensive unit tests**
5. **Update documentation** and examples

### Development Guidelines
- Follow Java naming conventions
- Add comments for complex logic
- Include test cases for new features
- Update the UML diagram when adding new states

## 📄 License

This project is open source and available under the [MIT License](LICENSE).

---

**Note**: This implementation serves as an educational example of the State Design Pattern. For production use, additional features like error handling, logging, and security measures should be considered.


