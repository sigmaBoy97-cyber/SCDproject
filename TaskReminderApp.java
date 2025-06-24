package taskreminder;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;
import java.util.List;

public class TaskReminderApp extends JFrame {
    private JTextField titleField;
    private JTextField dueDateField;
    private DefaultTableModel tableModel;
    private JTable taskTable;
    public static List<Task> taskList = new ArrayList<>();

    public TaskReminderApp() {
        setTitle("Task Reminder App");
        setSize(600, 400);
        setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
        setLocationRelativeTo(null);
        setLayout(new BorderLayout());

        // UI Components
        titleField = new JTextField(10);
        dueDateField = new JTextField(10);
        JButton addButton = new JButton("Add Task");
        JButton completeButton = new JButton("Mark Completed");
        JButton deleteButton = new JButton("Delete Task");
        JButton sortButton = new JButton("Sort by Due Date");
        JPanel inputPanel = new JPanel();
        inputPanel.add(new JLabel("Title:"));
        inputPanel.add(titleField);
        inputPanel.add(new JLabel("Due Date (DD/MM/YYYY):"));
        inputPanel.add(dueDateField);
        inputPanel.add(addButton);
        inputPanel.add(completeButton);
        inputPanel.add(deleteButton);
        inputPanel.add(sortButton);

        tableModel = new DefaultTableModel(new String[]{"Title", "Due Date", "Completed"}, 0);
        taskTable = new JTable(tableModel);
        JScrollPane scrollPane = new JScrollPane(taskTable);

        add(inputPanel, BorderLayout.NORTH);
        add(scrollPane, BorderLayout.CENTER);

        // Action Listeners (linked to other classes)
        addButton.addActionListener(e -> AddTask.addTask(titleField, dueDateField, tableModel));
        completeButton.addActionListener(e -> MarkasCompleted.completeTask(taskTable, tableModel));
        deleteButton.addActionListener(e -> DeleteSort.deleteTask(taskTable, tableModel));
        sortButton.addActionListener(e -> DeleteSort.sortTasks(tableModel));

        addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent e) {
                int choice = JOptionPane.showConfirmDialog(null, "Do you want to exit?", "Exit", JOptionPane.YES_NO_OPTION);
                if (choice == JOptionPane.YES_OPTION) System.exit(0);
            }
        });

        setVisible(true);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(TaskReminderApp::new);
    }
}
