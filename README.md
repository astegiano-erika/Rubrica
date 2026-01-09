# Rubrica – Java Swing Address Book

**Rubrica** is a desktop application developed in **Java** using the **Swing** library.  
It provides basic address book functionalities, allowing the user to create, edit, and delete contacts through a graphical interface.

The main window displays a table (`JTable`) listing all contacts, showing **name, surname, and phone number**.  
Contact creation and editing are handled through a **modal form dialog**, ensuring a consistent and controlled user interaction.

## Data Persistence
Contacts are stored in a text file (`informazioni.txt`) using a semicolon-separated format.  
At application startup, existing data are automatically loaded if the file is present; otherwise, the address book starts empty.  
After each save operation, the full contact list is written back to the file.

## Additional Features
Beyond the required functionality, the following improvements were implemented:

- **Basic input validation** in the form, with error feedback shown via dialog messages.
- **Alphabetical ordering by name** (case-sensitive), based on the first column of the table, to improve readability and usability.

## Execution
The application is exported as a **runnable JAR (`Rubrica.jar`)** and can be launched via double-click on any system with a properly configured **Java Virtual Machine (JVM)**.
