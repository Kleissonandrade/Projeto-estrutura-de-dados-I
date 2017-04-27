import javax.swing.*;
import java.awt.event.*;
import java.awt.*;
import java.lang.NullPointerException;
import java.lang.IllegalStateException;
import java.lang.NumberFormatException;


public class ViewSurchClassroom extends JFrame{

  private JLabel title;
  private JLabel labelCod;
  private JTextField textSurchCod;
  private JButton buttonCancel;
  private JButton buttonSurch;

  public ViewSurchClassroom() {
        initializeComponents();
  }

  private void initializeComponents(){
    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    getContentPane().setLayout(null);

    title = new JLabel("Buscar Turma");
    getContentPane().add(title);
    title.setBounds(460, 26, 225, 58);
    title.setFont(new Font("Ubuntu", 0, 36));

    labelCod = new JLabel("Codigo: ");
    getContentPane().add(labelCod);
    labelCod.setBounds(70, 190, 130, 21);

    textSurchCod = new JTextField();
    textSurchCod.setBounds(150, 190, 360, 28);
    getContentPane().add(textSurchCod);

    textSurchCod.addActionListener(new ActionListener(){
      public void actionPerformed(ActionEvent e){
        textSurchCodAction();
      }
    });

     buttonSurch = new JButton("Buscar");
     buttonSurch.setFont(new Font("Ubuntu", 0, 18));
     getContentPane().add(buttonSurch);
     buttonSurch.setBounds(350, 280, 140, 50);

     buttonSurch.addActionListener(new ActionListener(){
       public void actionPerformed(ActionEvent e){
         buttonSurchAction();
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

  public static void main(String [] args){

  }


  public void buttonSurchAction(){
    Database database = Database.getInstance();
    try{
      Classroom classroom = database.surchClassCod(textSurchCodAction());

      ViewShowClassroom viewShowClassroom = new ViewShowClassroom(classroom);
      viewShowClassroom.setVisible(true);
      viewShowClassroom.setSize(1057, 562);

    }catch(NullPointerException e){
          JOptionPane.showMessageDialog(null, "Turma não encontrada!");
    }catch(NumberFormatException e){
      JOptionPane.showMessageDialog(null, "Informe o código da turma");
    }

  }

  public int textSurchCodAction(){
    int cod = Integer.parseInt(textSurchCod.getText());
    if(textSurchCod.getText() == null){
      throw new NullPointerException();

    }if(textSurchCod.getText().trim().length() == 0){
      throw new NumberFormatException();
    }
    return cod;
  }


  public void buttonCancelAction(){
    ViewHome home = new ViewHome();
    home.setSize(1057, 562);
    home.setVisible(true);
  }

}
