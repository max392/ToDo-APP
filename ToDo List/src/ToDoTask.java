import javax.swing.*;
import java.awt.*;

public class ToDoTask extends JFrame {

        ToDoTask(){


            JTextField taskfield = new JTextField(25);
            JButton addbutton = new JButton("ADD Task");
            JButton deletebutton = new JButton("Delete Task");
            DefaultListModel<String> tasklistmodel = new DefaultListModel<>();
            JList<String> tasklist = new JList<>(tasklistmodel);
            addbutton.setFocusable(false);
            deletebutton.setFocusable(false);
            taskfield.setText("Enter Task Here");

            //panel
            JPanel  panel = new JPanel();
            panel.add(taskfield);
            panel.add(addbutton);
            JPanel bottompanel = new JPanel();
            bottompanel.add(deletebutton);



            //frame
            this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            this.setSize(400,600);
            this.setTitle("ToDo APP ");
            this.setIconImage(null);
            this.setLayout(new BorderLayout());
            this.add(panel,BorderLayout.NORTH);
            this.add(bottompanel,BorderLayout.SOUTH);
            this.add(new JScrollPane(tasklist),BorderLayout.CENTER);
            this.setVisible(true);



            addbutton.addActionListener(e -> {
                String task =   taskfield.getText();
                if(!task.isEmpty()){
                    tasklistmodel.addElement(task);
                    taskfield.setText("");
                }
            });

            deletebutton.addActionListener(e -> {
                int selectIndex= tasklist.getSelectedIndex();
                if(selectIndex !=-1){
                    tasklistmodel.remove(selectIndex);

                }
            });
        }
}
