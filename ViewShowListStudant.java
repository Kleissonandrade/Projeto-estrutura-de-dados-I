import javax.swing.*;
import java.awt.event.*;
import java.awt.*;
import java.util.ArrayList;
import javax.swing.table.DefaultTableModel;

public class ViewShowListStudant extends JFrame{

  private JTable table;
  private JScrollPane scroll;
  private ArrayList<User> studants;

  Database database = Database.getInstance();

   public ViewShowListStudant() {
     studants = new ArrayList<User>();
     studants = database.listStudants();
     initializeComponents();
  }

  private void initializeComponents(){
    setLayout(new FlowLayout());

    scroll = new JScrollPane(table);

    table.setFillsViewportHeight(true);

    getContentPane().add(scroll);

    String [] columnsnName = {"Matricula", "Nome", "RG", "CPF", "Data de Nascimento", "Email"};

    ArrayList<String[]> data = new ArrayList<String[]>();

    for(int i = 0; i < studants.size(); i++){
      data.add(new String[]{String.valueOf(studants.get(i).getRegistration()), studants.get(i).getName(), studants.get(i).getRg(),  studants.get(i).getCpf(), studants.get(i).getBirthDate(), studants.get(i).getEmail()});
    }
    DefaultTableModel model = new DefaultTableModel(
      data.toArray(new String[data.size()][]), columnsnName);

    table.setModel(model);
  }

  public static void main(String args[]){}

}
