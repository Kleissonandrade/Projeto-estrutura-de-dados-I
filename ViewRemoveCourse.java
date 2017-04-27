import javax.swing.*;
import java.awt.event.*;
import java.awt.*;
import java.lang.Integer;
import java.lang.NullPointerException;
import java.lang.IllegalStateException;
import java.lang.NumberFormatException;


public class ViewRemoveCourse extends JFrame{

  private JLabel title;
  private JLabel labelSurch;
  private JTextField textSurchCourse;
  
  private JButton buttonRemove;
  private JButton buttonCancel;

  public ViewRemoveCourse() {
        initializeComponents();
  }

  private void initializeComponents(){
    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    getContentPane().setLayout(null);

    title = new JLabel("Excluir Curso");
    getContentPane().add(title);
    title.setBounds(450, 26, 225, 58);
    title.setFont(new Font("Ubuntu", 0, 36));

    labelSurch = new JLabel("Curso:");
    getContentPane().add(labelSurch);
    labelSurch.setBounds(70, 210, 120, 21);

    

    textSurchCourse = new JTextField();
    textSurchCourse.setBounds(130, 210, 300, 28);
	getContentPane().add(textSurchCourse);
	
    textSurchCourse.addActionListener(new ActionListener(){
      public void actionPerformed(ActionEvent e){
        textSurchCourseAction();
      }
    });

    
     buttonRemove = new JButton("Remover");
     buttonRemove.setFont(new Font("Ubuntu", 0, 18));
     getContentPane().add(buttonRemove);
     buttonRemove.setBounds(275, 280, 140, 50);

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
          database.removeCourseName(textSurchCourseAction());
          JOptionPane.showMessageDialog(null, "OK!");

        }catch(NullPointerException e){
          JOptionPane.showMessageDialog(null, "Curso não encontrado");

        }catch(IllegalStateException e){
          JOptionPane.showMessageDialog(null, "Insira o nome do curso");

        }
    
  }

  public String textSurchCourseAction(){
    if(textSurchCourse.getText() == null){
      throw new NullPointerException();

    }if(textSurchCourse.getText().trim().length() == 0){
      throw new  IllegalStateException();
    }
    return textSurchCourse.getText();
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
