import javax.swing.*;
import java.awt.event.*;
import java.awt.*;
import java.lang.NullPointerException;
import java.lang.NumberFormatException;

public class ViewRemoveStudant extends JFrame{

  private JLabel title;
  private JLabel labelRegister;
  private JTextField textSurchRegister;
  private JButton buttonCancel;
  private JButton buttonRemove;

  public ViewRemoveStudant() {
        initializeComponents();
  }

  private void initializeComponents(){
    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    getContentPane().setLayout(null);

    title = new JLabel("Remover Aluno");
    getContentPane().add(title);
    title.setBounds(420, 26, 275, 58);
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

     buttonRemove = new JButton("Remover");
     buttonRemove.setFont(new Font("Ubuntu", 0, 18));
     getContentPane().add(buttonRemove);
     buttonRemove.setBounds(350, 280, 140, 50);

     buttonRemove.addActionListener(new ActionListener(){
       public void actionPerformed(ActionEvent e){
         buttonRemoveAction();
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


  public void buttonRemoveAction(){
    Database database = Database.getInstance();
    try{
      database.removeStudant(textSurchRegisterAction());
    }catch(NumberFormatException e){
      JOptionPane.showMessageDialog(null, "Insira a matricula!");
    }catch(NullPointerException e){
      JOptionPane.showMessageDialog(null, "Matricula não encontrada!");
    }
  }

  public int textSurchRegisterAction(){
    int register = Integer.parseInt(textSurchRegister.getText());
    if(textSurchRegister.getText().trim().length() == 0){
      throw new NumberFormatException();
    }
    if(textSurchRegister.getText() == null){
      throw new NullPointerException();
    }
    return register;
  }

  public void buttonCancelAction(){
    ViewHome home = new ViewHome();
    home.setSize(1057, 562);
    home.setVisible(true);
  }

}
