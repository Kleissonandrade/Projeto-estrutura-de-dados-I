import javax.swing.*;
import java.awt.event.*;
import java.awt.*;
import java.lang.NullPointerException;
import java.lang.IllegalStateException;
import java.lang.NumberFormatException;

public class ViewNewClassroom extends JFrame{

  private JLabel title;
  private JLabel labelCod;
  private JLabel labelDiscipline;
  private JTextField textDiscipline;
  private JTextField textCod;

  private JButton buttonCadastrar;
  private JButton buttonCancelar;

  public ViewNewClassroom() {
        initializeComponents();
    }

  private void initializeComponents(){
    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    getContentPane().setLayout(null);

    title = new JLabel("Cadastro de Turma");
    getContentPane().add(title);
    title.setBounds(370, 30, 330, 73);
    title.setFont(new Font("Ubuntu", 0, 36));

    labelCod = new JLabel("Código:");
    getContentPane().add(labelCod);
    labelCod.setBounds(40, 160, 66, 21);

    labelDiscipline = new JLabel("Disciplina:");
    getContentPane().add(labelDiscipline);
    labelDiscipline.setBounds(250, 160, 90, 21);

    textCod = new JTextField();
    getContentPane().add(textCod);
    textCod.setBounds(110, 160, 90, 28);

    textCod.addActionListener(new ActionListener(){
      public void actionPerformed(ActionEvent e){
        actionTextCod();
      }
    });

    textDiscipline = new JTextField();
    getContentPane().add(textDiscipline);
    textDiscipline.setBounds(330, 160, 220, 28);

    textDiscipline.addActionListener(new ActionListener(){
      public void actionPerformed(ActionEvent e){
        actionTextDiscipline();
      }
    });

     buttonCadastrar = new JButton("Cadastrar");
     buttonCadastrar.setFont(new Font("Ubuntu", 0, 18));
     getContentPane().add(buttonCadastrar);
     buttonCadastrar.setBounds(640, 430, 190, 50);

     buttonCadastrar.addActionListener(new ActionListener(){
       public void actionPerformed(ActionEvent e){
         actionButtonCadastrar();
       }
     });

     buttonCancelar = new JButton("Cancelar");
     buttonCancelar.setFont(new Font("Ubuntu", 0, 18));
     getContentPane().add(buttonCancelar);
     buttonCancelar.setBounds(440, 430, 190, 50);

     buttonCancelar.addActionListener(new ActionListener(){
       public void actionPerformed(ActionEvent e){
         actionButtonCancelar();
       }
     });
    pack();

    }

  public static void main(String [] args){

  }

  public void actionButtonCancelar(){
    ViewHome home = new ViewHome();
    home.setSize(1057, 562);
    home.setVisible(true);
  }

  public void actionButtonCadastrar(){
    Database database = Database.getInstance();
    boolean flag = false;
    int temps = 0;
    do{
      try{
        flag = true;
        Classroom classroom = new Classroom(actionTextCod(), actionTextDiscipline());
        database.addClass(classroom.getNumber(), classroom);

        Classroom classroom1 = database.surchClassCod(classroom.getNumber());

        ViewShowClassroom viewShowClassroom = new ViewShowClassroom(classroom);
        viewShowClassroom.setVisible(true);
        viewShowClassroom.setSize(1057, 562);

      }catch(NullPointerException e){
      }
      catch(IllegalStateException e){
        if(textDiscipline.getText().trim().length() == 0){
          JOptionPane.showMessageDialog(null, "Campo Disciplina vazio!");
          temps ++;
        }
      }
      catch(NumberFormatException e){
        if(textCod.getText().trim().length() == 0){
          JOptionPane.showMessageDialog(null, "Campo Código vazio!");
          temps ++;
        }
    }
    }while(!flag && temps < 1);
  }


  public String actionTextDiscipline(){
    if(textDiscipline.getText() == null){
      throw new NullPointerException();

    }if(textDiscipline.getText().trim().length() == 0){
      throw new  IllegalStateException();
    }
    return textDiscipline.getText();
  }

  public int actionTextCod(){
    int codigo = Integer.parseInt(textCod.getText());
    if(textCod.getText() == null){
      throw new NullPointerException();

    }if(textCod.getText().trim().length() == 0){
      throw new NumberFormatException();
    }
    return codigo;
  }
}
