import javax.swing.*;
import java.awt.event.*;
import java.awt.*;
import java.util.ArrayList;
import javax.swing.table.DefaultTableModel;

public class ViewShowListStudantClass extends JFrame{

  private JTable table;
  private JScrollPane scroll;
  private ArrayList<User> studants;

   public ViewShowListStudantClass(Classroom course) {
      studants = new ArrayList<User>();
      studants = course.listStudants();
     initializeComponents();
  }

  private void initializeComponents(){
    setLayout(new FlowLayout());
    table = new JTable();

    scroll = new JScrollPane(table);

    table.setFillsViewportHeight(true);

    getContentPane().add(scroll);

    String [] columnsnName = {"Matricula", "Nome", "Email"};

    ArrayList<String[]> data = new ArrayList<String[]>();

    for(int i = 0; i < studants.size(); i++){
      data.add(new String[]{String.valueOf(studants.get(i).getRegistration()), studants.get(i).getName(), studants.get(i).getEmail()});
    }
    DefaultTableModel model = new DefaultTableModel(
      data.toArray(new String[data.size()][]), columnsnName);

    table.setModel(model);
  }

  public static void main(String args[]){}

}
