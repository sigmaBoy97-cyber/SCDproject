package taskreminder;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;

public class MarkasCompleted {
    public static void completeTask(JTable taskTable, DefaultTableModel tableModel) {
        int selected = taskTable.getSelectedRow();
        if (selected >= 0) {
            Task task = TaskReminderApp.taskList.get(selected);
            task.setCompleted(true);
            tableModel.setValueAt(true, selected, 2);
        } else {
            JOptionPane.showMessageDialog(null, "Select a task to mark as completed.");
        }
    }
}
