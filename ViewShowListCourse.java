import javax.swing.*;
import java.awt.event.*;
import java.awt.*;
import java.util.LinkedList;
import java.util.ArrayList;
import javax.swing.table.DefaultTableModel;

public class ViewShowListCourse extends JFrame{

  private JTable table;
  private JScrollPane scroll;
  private LinkedList<Course> courses;

  Database database = Database.getInstance();

   public ViewShowListCourse() {
     courses = new LinkedList<Course>();
     courses = database.listCourses();
     initializeComponents();
  }

  private void initializeComponents(){
    setLayout(new FlowLayout());
    table = new JTable();

    scroll = new JScrollPane(table);

    table.setFillsViewportHeight(true);

    getContentPane().add(scroll);

    String [] columnsnName = {"Código", "Curso", "Carga Horaria", "Duração", "Total Disciplinas"};

    ArrayList<String[]> data = new ArrayList<String[]>();

    for(int i = 0; i < courses.size(); i++){
      data.add(new String[]{String.valueOf(courses.get(i).getKey()), courses.get(i).getCourseName(), String.valueOf(courses.get(i).getWorkload()) + " horas", String.valueOf(courses.get(i).getDuration()) + " periodos", "x"});
    }
    DefaultTableModel model = new DefaultTableModel(
      data.toArray(new String[data.size()][]), columnsnName);

    table.setModel(model);
  }

  public static void main(String args[]){}

}
