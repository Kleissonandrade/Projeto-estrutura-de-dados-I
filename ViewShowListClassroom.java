import javax.swing.*;
import java.awt.event.*;
import java.awt.*;
import java.util.ArrayList;
import javax.swing.table.DefaultTableModel;

public class ViewShowListClassroom extends JFrame{

  private JTable table;
  private JScrollPane scroll;
  private ArrayList<Classroom> classes;

  Database database = Database.getInstance();

   public ViewShowListClassroom() {
     classes = new ArrayList<Classroom>();
     classes = database.listClass();
     initializeComponents();
  }

  private void initializeComponents(){
    setLayout(new FlowLayout());
    table = new JTable();

    scroll = new JScrollPane(table);

    table.setFillsViewportHeight(true);

    getContentPane().add(scroll);

    String [] columnsnName = {"Código", "Disciplina", "Quant. Alunos"};

    ArrayList<String[]> data = new ArrayList<String[]>();

    for(int i = 0; i < classes.size(); i++){
      data.add(new String[]{String.valueOf(classes.get(i).getNumber()), classes.get(i).getDiscipline(), "x"});
    }
    DefaultTableModel model = new DefaultTableModel(
      data.toArray(new String[data.size()][]), columnsnName);

    table.setModel(model);
  }

  public static void main(String args[]){}

}
