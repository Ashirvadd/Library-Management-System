# Library Management System

This project is a Java-based Library Management System with a simple Graphical User Interface (GUI) created using `Swing`. The program enables users to perform basic library management tasks such as adding, viewing, editing, and deleting book records. The application also saves and loads book data from a file to maintain persistence.

## Features

- **Add Book**: Allows users to add new books by providing details such as Book ID, Title, Author, Publisher, Year of Publication, ISBN, and Number of Copies.
- **View Books**: Displays all books in a table format.
- **Edit Book**: Enables editing of an existing book's information by entering the Book ID and updating other details.
- **Delete Book**: Removes a book entry based on its Book ID.
- **Clear Fields**: Clears all input fields.
- **Exit**: Exits the application and saves the current state of book records to a file.

## Project Structure

- **Main Class (`One`)**: This class contains the GUI components and action listeners for the Library Management System.
- **Data Persistence**: Book data is stored in a text file (`library_data.txt`) to retain information across sessions. When the application starts, it loads data from this file, and upon exit or data changes, it saves the data back to the file.

## Requirements

- Java 8 or higher
- `javax.swing` and `java.awt` libraries (included in standard Java distributions)

## How to Run the Project

1. **Compile** the code using `javac One.java`.
2. **Run** the application using `java One`.
3. **Interacting with the GUI**:
   - Enter book details and use the `Add` button to save new entries.
   - Click `View` to open a new window displaying all books.
   - To edit or delete a book, enter its Book ID, update fields as needed, and click the corresponding button.

## File Information

- **library_data.txt**: This file stores book records in CSV format. Each line represents a book entry with fields separated by commas.

## Project Workflow

1. **Initialize**: Loads existing book data from `library_data.txt` when the application starts.
2. **Add/Edit/Delete/View Operations**: Modifies the in-memory data and updates the file upon changes.
3. **Exit**: Ensures all data is saved to `library_data.txt` before the program closes.

## Key Components

- `JTextField`: Used for user input fields (e.g., Book ID, Title).
- `JButton`: Triggers actions such as adding or viewing books.
- `JTable`: Displays a list of all books in the View Books feature.
- `ArrayList<String[]>`: Stores book data temporarily within the application.

## Example Usage

1. **Adding a Book**:
   - Enter details in the respective fields.
   - Click `Add` to save the entry. The program will confirm the addition.

2. **Editing a Book**:
   - Enter the `Book ID` of the book to edit.
   - Update any fields and click `Edit`. The program will confirm if the update is successful.

3. **Viewing All Books**:
   - Click `View` to see a list of all books in a new table window.

4. **Deleting a Book**:
   - Enter the `Book ID` of the book to delete and click `Delete`. A confirmation message will appear.

## License

This project is licensed under the MIT License.
