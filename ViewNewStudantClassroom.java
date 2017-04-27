import javax.swing.*;
import java.awt.event.*;
import java.awt.*;
import java.lang.NullPointerException;
import java.lang.IllegalStateException;
import java.lang.NumberFormatException;


public class ViewNewStudantClassroom extends JFrame{

  private JLabel title;
  private JLabel labelRegister;
  private JTextField textSurchRegister;
  private JButton buttonCancel;
  private JButton buttonAdd;
  private Classroom classroom;
  
  public ViewNewStudantClassroom(Classroom classroom) {
        this.classroom = classroom;
        initializeComponents();
  }

  private void initializeComponents(){
    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    getContentPane().setLayout(null);

    title = new JLabel("Adicionar Aluno");
    getContentPane().add(title);
    title.setBounds(420, 26, 325, 58);
    title.setFont(new Font("Ubuntu", 0, 36));

    labelRegister = new JLabel("Matricula: ");
    getContentPane().add(labelRegister);
    labelRegister.setBounds(70, 190, 130, 21);

    textSurchRegister = new JTextField();
    textSurchRegister.setBounds(150, 190, 360, 28);
    getContentPane().add(textSurchRegister);

    textSurchRegister.addActionListener(new ActionListener(){
      public void actionPerformed(ActionEvent e){
        textSurchRegisterAction();
      }
    });

     buttonAdd = new JButton("Adicionar");
     buttonAdd.setFont(new Font("Ubuntu", 0, 18));
     getContentPane().add(buttonAdd);
     buttonAdd.setBounds(350, 280, 140, 50);

     buttonAdd.addActionListener(new ActionListener(){
       public void actionPerformed(ActionEvent e){
         buttonAddAction();
       }
     });

     buttonCancel = new JButton("Cancelar");
     buttonCancel.setFont(new Font("Ubuntu", 0, 18));
     getContentPane().add(buttonCancel);
     buttonCancel.setBounds(730, 440, 210, 50);

     buttonCancel.addActionListener(new ActionListener(){
       public void actionPerformed(ActionEvent e){
         buttonCancelAction();
       }
     });
    pack();
  }

  public static void main(String [] args){}

  public void buttonAddAction(){
    Database database = Database.getInstance();
    boolean flag = false;
    int temps = 0;
    do{
      try{
		flag = true;
        User studant = database.surchUserRegister(textSurchRegisterAction());
        classroom.addStudant(new User(studant));
        JOptionPane.showMessageDialog(null, "OK!");
       
        
      }catch(NullPointerException e){
        JOptionPane.showMessageDialog(null, "Matricula não encontrada!");
        temps++;
      }

        catch(NumberFormatException e){
          JOptionPane.showMessageDialog(null, "Insira uma matricula!");
          temps ++;
        }

    }while(!flag && temps < 1);

  }

  public int textSurchRegisterAction(){
    int register = Integer.parseInt(textSurchRegister.getText());
    if(textSurchRegister.getText() == null){
      throw new NullPointerException();
    }
    if(textSurchRegister.getText().trim().length() == 0){
      throw new NumberFormatException();
    }
    return register;
  }

  public void buttonCancelAction(){
    ViewShowClassroom viewShowClassroom = new ViewShowClassroom(classroom);
    viewShowClassroom.setVisible(true);
    viewShowClassroom.setSize(1057, 562);

  }

}
