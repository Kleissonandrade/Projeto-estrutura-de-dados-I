import javax.swing.*;
import java.awt.event.*;
import java.awt.*;
import java.lang.NullPointerException;
import java.lang.IllegalStateException;
import java.lang.NumberFormatException;


public class ViewRemoveDiscipline extends JFrame{

  private JLabel title;
  private JLabel labelDiscipline;
  private JTextField textDiscipline;
  private JButton buttonCancel;
  private JButton buttonRemove;
  private Course course;

  public ViewRemoveDiscipline(Course course) {
        this.course = course;
        initializeComponents();
  }

  private void initializeComponents(){
    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    getContentPane().setLayout(null);

    title = new JLabel("Remover Disciplina");
    getContentPane().add(title);
    title.setBounds(401, 26, 325, 58);
    title.setFont(new Font("Ubuntu", 0, 36));

    labelDiscipline = new JLabel("Disciplina:");
    getContentPane().add(labelDiscipline);
    labelDiscipline.setBounds(70, 190, 130, 21);

    textDiscipline = new JTextField();
    textDiscipline.setBounds(150, 190, 360, 28);
    getContentPane().add(textDiscipline);

    textDiscipline.addActionListener(new ActionListener(){
      public void actionPerformed(ActionEvent e){
        textDisciplineAction();
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

  public static void main(String [] args){}

  public void buttonRemoveAction(){
    try{
      course.removeDiscipline(textDisciplineAction());
      JOptionPane.showMessageDialog(null, "OK!");
    }catch(NullPointerException e){
      JOptionPane.showMessageDialog(null, "Disciplina não encontrado!");
    }catch(IllegalStateException e){
      JOptionPane.showMessageDialog(null, "Insira o nme da disciplina!");
    }
  }
  
  public int textDisciplineAction(){
    int cod = Integer.parseInt(textDiscipline.getText());
    
    if(textDiscipline.getText() == null){
      throw new NullPointerException();
    }
    if(textDiscipline.getText().trim().length() == 0){
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
