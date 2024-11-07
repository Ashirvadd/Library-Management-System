import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.*;
import java.io.*;
import java.util.*;

public class One extends JFrame implements ActionListener {
    private JLabel label1, label2, label3, label4, label5, label6, label7;
    private JTextField textField1, textField2, textField3, textField4, textField5, textField6, textField7;
    private JButton addButton, viewButton, editButton, deleteButton, clearButton, exitButton;
    private JPanel panel;
    private ArrayList<String[]> books = new ArrayList<>();
    private final String dataFile = "library_data.txt";

    public One() {
        setTitle("Library Management System");
        setSize(600, 300);
        setDefaultCloseOperation(EXIT_ON_CLOSE);

        label1 = new JLabel("Book ID");
        label2 = new JLabel("Book Title");
        label3 = new JLabel("Author");
        label4 = new JLabel("Publisher");
        label5 = new JLabel("Year of Publication");
        label6 = new JLabel("ISBN");
        label7 = new JLabel("Number of Copies");

        textField1 = new JTextField(10);
        textField2 = new JTextField(20);
        textField3 = new JTextField(20);
        textField4 = new JTextField(20);
        textField5 = new JTextField(10);
        textField6 = new JTextField(20);
        textField7 = new JTextField(10);

        addButton = new JButton("Add");
        viewButton = new JButton("View");
        editButton = new JButton("Edit");
        deleteButton = new JButton("Delete");
        clearButton = new JButton("Clear");
        exitButton = new JButton("Exit");

        addButton.addActionListener(this);
        viewButton.addActionListener(this);
        editButton.addActionListener(this);
        deleteButton.addActionListener(this);
        clearButton.addActionListener(this);
        exitButton.addActionListener(this);

        panel = new JPanel(new GridLayout(10, 2));
        panel.add(label1);
        panel.add(textField1);
        panel.add(label2);
        panel.add(textField2);
        panel.add(label3);
        panel.add(textField3);
        panel.add(label4);
        panel.add(textField4);
        panel.add(label5);
        panel.add(textField5);
        panel.add(label6);
        panel.add(textField6);
        panel.add(label7);
        panel.add(textField7);
        panel.add(addButton);
        panel.add(viewButton);
        panel.add(editButton);
        panel.add(deleteButton);
        panel.add(clearButton);
        panel.add(exitButton);

        add(panel);
        loadLibraryData(); // Load data from file when the program starts
        setVisible(true);
    }

    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == addButton) {
            String[] book = new String[7];
            book[0] = textField1.getText();
            book[1] = textField2.getText();
            book[2] = textField3.getText();
            book[3] = textField4.getText();
            book[4] = textField5.getText();
            book[5] = textField6.getText();
            book[6] = textField7.getText();
            books.add(book);
            saveLibraryData(); // Save data to file after adding a book
            JOptionPane.showMessageDialog(this, "Book added successfully");
            clearFields();
        } else if (e.getSource() == viewButton) {
            viewBooks();
        } else if (e.getSource() == editButton) {
            editBook();
        } else if (e.getSource() == deleteButton) {
            deleteBook();
        } else if (e.getSource() == clearButton) {
            clearFields();
        } else if (e.getSource() == exitButton) {
            saveLibraryData(); // Save data to file before exiting
            System.exit(0);
        }
    }

    private void clearFields() {
        textField1.setText("");
        textField2.setText("");
        textField3.setText("");
        textField4.setText("");
        textField5.setText("");
        textField6.setText("");
        textField7.setText("");
    }

    private void saveLibraryData() {
        try (PrintWriter writer = new PrintWriter(new FileWriter(dataFile))) {
            for (String[] book : books) {
                writer.println(String.join(",", book));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void loadLibraryData() {
        try (BufferedReader reader = new BufferedReader(new FileReader(dataFile))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] bookData = line.split(",");
                books.add(bookData);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void viewBooks() {
        String[] columns = {"Book ID", "Book Title", "Author", "Publisher", "Year of Publication", "ISBN", "Number of Copies"};
        Object[][] data = new Object[books.size()][7];
        for (int i = 0; i < books.size(); i++) {
            data[i] = books.get(i);
        }
        JTable table = new JTable(new DefaultTableModel(data, columns));
        JScrollPane scrollPane = new JScrollPane(table);
        JFrame frame = new JFrame("View Books");
        frame.add(scrollPane);
        frame.setSize(800, 400);
        frame.setVisible(true);
    }

    private void editBook() {
        String idToEdit = textField1.getText();
        for (int i = 0; i < books.size(); i++) {
            String[] book = books.get(i);
            if (book[0].equals(idToEdit)) {
                book[1] = textField2.getText(); // Update book title
                book[2] = textField3.getText(); // Update author
                book[3] = textField4.getText(); // Update publisher
                book[4] = textField5.getText(); // Update year of publication
                book[5] = textField6.getText(); // Update ISBN
                book[6] = textField7.getText(); // Update number of copies
                books.set(i, book);
                saveLibraryData(); // Save data to file after editing a book
                JOptionPane.showMessageDialog(this, "Book edited successfully");
                clearFields();
                return;
            }
        }
        JOptionPane.showMessageDialog(this, "Book not found for editing");
    }

    private void deleteBook() {
        String idToDelete = textField1.getText();
        for (int i = 0; i < books.size(); i++) {
            String[] book = books.get(i);
            if (book[0].equals(idToDelete)) {
                books.remove(i);
                saveLibraryData(); // Save data to file after deleting a book
                JOptionPane.showMessageDialog(this, "Book deleted successfully");
                clearFields();
                return;
            }
        }
        JOptionPane.showMessageDialog(this, "Book not found for deletion");
    }

    public static void main(String[] args) {
        new One();
}
}
