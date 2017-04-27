import javax.swing.*;
import java.awt.event.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.Hashtable;
import javax.swing.table.DefaultTableModel;

public class ViewShowListTeacher extends JFrame{

  private JTable table;
  private JScrollPane scroll;
  private ArrayList<User> teachers;



  Database database = Database.getInstance();

   public ViewShowListTeacher() {
    teachers = new ArrayList<User>();
    teachers = database.listTeacher();
    initializeComponents();
  }

  private void initializeComponents(){
    setLayout(new FlowLayout());

    table = new JTable();

    scroll = new JScrollPane(table);

    table.setFillsViewportHeight(true);

    getContentPane().add(scroll);

    String [] columnsnName = {"Matricula", "Nome", "RG", "CPF", "Data de Nascimento", "Email"};

    ArrayList<String[]> data = new ArrayList<String[]>();

    for(int i = 0; i < teachers.size(); i++){
      data.add(new String[]{String.valueOf(teachers.get(i).getRegistration()), teachers.get(i).getName(), teachers.get(i).getRg(),  teachers.get(i).getCpf(), teachers.get(i).getBirthDate(), teachers.get(i).getEmail()});
    }

    DefaultTableModel model = new DefaultTableModel(
      data.toArray(new String[data.size()][]), columnsnName);


    table.setModel(model);

  }

  public static void main(String args[]){}

}
