import javax.swing.*;
import java.awt.event.*;
import java.awt.*;
import java.lang.NullPointerException;
import java.lang.NumberFormatException;

public class ViewRemoveClassroom extends JFrame{

  private JLabel title;
  private JLabel labelCod;
  private JTextField textSurchCod;
  private JButton buttonCancel;
  private JButton buttonRemove;

  public ViewRemoveClassroom() {
        initializeComponents();
  }

  private void initializeComponents(){
    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    getContentPane().setLayout(null);

    title = new JLabel("Excluir Turma");
    getContentPane().add(title);
    title.setBounds(440, 26, 225, 58);
    title.setFont(new Font("Ubuntu", 0, 36));

    labelCod = new JLabel("Código: ");
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

     buttonRemove = new JButton("Buscar");
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

  public static void main(String [] args){}

  public void buttonRemoveAction(){
    Database database = Database.getInstance();
    try{
      database.removeClass(textSurchCodAction());
      JOptionPane.showMessageDialog(null, "OK!");

    }catch(NullPointerException e){
          JOptionPane.showMessageDialog(null, "Turma não encontrada!");
    }catch(NumberFormatException e){
      JOptionPane.showMessageDialog(null, "Informe o código da turma");
    }
  }

  public int textSurchCodAction(){
    int cod = Integer.parseInt(textSurchCod.getText());
    if(textSurchCod.getText().trim().length() == 0){
      throw new NumberFormatException();
    }
    if(textSurchCod.getText() == null){
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
