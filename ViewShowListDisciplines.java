import javax.swing.*;
import java.awt.event.*;
import java.awt.*;
import java.util.ArrayList;
import javax.swing.table.DefaultTableModel;

public class ViewShowListDisciplines extends JFrame{

  private JTable table;
  private JScrollPane scroll;
  private ArrayList<Discipline> disciplines;

   public ViewShowListDisciplines(Course course) {
      disciplines = new ArrayList<Discipline>();
      disciplines = course.listDisciplines();
     initializeComponents();
  }

  private void initializeComponents(){
    setLayout(new FlowLayout());
    table = new JTable();

    scroll = new JScrollPane(table);

    table.setFillsViewportHeight(true);

    getContentPane().add(scroll);

    String [] columnsnName = {"Código", "Disciplina", "Creditos", "Carga Horaria"};

    ArrayList<String[]> data = new ArrayList<String[]>();

    for(int i = 0; i < disciplines.size(); i++){
      data.add(new String[]{String.valueOf(disciplines.get(i).getKey()), disciplines.get(i).getDisciplineName(), String.valueOf(disciplines.get(i).getCredits()), String.valueOf(disciplines.get(i).getWorkload())});
    }

    DefaultTableModel model = new DefaultTableModel(
      data.toArray(new String[data.size()][]), columnsnName);

    table.setModel(model);
  }

  public static void main(String args[]){}

}
