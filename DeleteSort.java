package taskreminder;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.util.Comparator;

public class DeleteSort {
    public static void deleteTask(JTable taskTable, DefaultTableModel tableModel) {
        int selected = taskTable.getSelectedRow();
        if (selected >= 0) {
            TaskReminderApp.taskList.remove(selected);
            tableModel.removeRow(selected);
        } else {
            JOptionPane.showMessageDialog(null, "Select a task to delete.");
        }
    }

    public static void sortTasks(DefaultTableModel tableModel) {
        TaskReminderApp.taskList.sort(Comparator.comparing(Task::getDueDate));
        tableModel.setRowCount(0);
        for (Task task : TaskReminderApp.taskList) {
            tableModel.addRow(new Object[]{task.getTitle(), task.getDueDate(), task.isCompleted()});
        }
    }
}
