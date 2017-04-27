import javax.swing.*;
import java.awt.event.*;
import java.awt.*;
import java.lang.NullPointerException;
import java.lang.IllegalStateException;
import java.lang.NumberFormatException;


public class ViewSurchStudant extends JFrame{

  private JLabel title;
  private JLabel labelSurch;
  private JTextField textSurchRegister;
  private JButton buttonSurch;
  private JButton buttonReturn;
  private JButton buttonCancel;

  public ViewSurchStudant() {
        initializeComponents();
  }

  private void initializeComponents(){
    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    getContentPane().setLayout(null);

    title = new JLabel("Buscar Aluno");
    getContentPane().add(title);
    title.setBounds(450, 26, 225, 58);
    title.setFont(new Font("Ubuntu", 0, 36));

    labelSurch = new JLabel("Matricula:");
    getContentPane().add(labelSurch);
    labelSurch.setBounds(70, 210, 120, 21);

    textSurchRegister = new JTextField();
    textSurchRegister.setBounds(160, 210, 360, 28);
	getContentPane().add(textSurchRegister);
    textSurchRegister.addActionListener(new ActionListener(){
      public void actionPerformed(ActionEvent e){
        surchRegisterAction();
      }
    });

     buttonSurch = new JButton("Buscar");
     buttonSurch.setFont(new Font("Ubuntu", 0, 18));
     getContentPane().add(buttonSurch);
     buttonSurch.setBounds(200, 280, 140, 50);

     buttonSurch.addActionListener(new ActionListener(){
       public void actionPerformed(ActionEvent e){
         buttonSurchAction();
       }
     });

     buttonReturn = new JButton("Voltar");
     buttonReturn.setFont(new Font("Ubuntu", 0, 18));
     getContentPane().add(buttonReturn);
     buttonReturn.setBounds(350, 280, 140, 50);

     buttonReturn.addActionListener(new ActionListener(){
       public void actionPerformed(ActionEvent e){
         buttonReturnAction();
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

  public void buttonSurchAction(){
    Database database = Database.getInstance();
    User user = null;
      try{
        user = database.surchUserRegister(surchRegisterAction());

        ViewShowSurchStudant viewShowSurchStudant = new ViewShowSurchStudant(user);
        viewShowSurchStudant.setSize(1057, 562);
        viewShowSurchStudant.setVisible(true);

      }catch(NumberFormatException e){
        JOptionPane.showMessageDialog(null, "Informe a matricula!");
      }
      catch(NullPointerException e){
        JOptionPane.showMessageDialog(null, "Usuário não Encontrado!");
      }
    }
  
  
  public int surchRegisterAction(){
    int register = Integer.parseInt(textSurchRegister.getText());
    if(textSurchRegister.getText() == null){
      throw new NullPointerException();

    }if(textSurchRegister.getText().trim().length() == 0){
      throw new NumberFormatException();
    }
    return register;
  }

  public void buttonReturnAction(){
    ViewSurch viewSurch = new ViewSurch();
    viewSurch.setVisible(true);
    viewSurch.setSize(1057, 562);
  }

  public void buttonCancelAction(){
    ViewHome home = new ViewHome();
    home.setSize(1057, 562);
    home.setVisible(true);
  }
}
