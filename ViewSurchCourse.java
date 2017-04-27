import javax.swing.*;
import java.awt.event.*;
import java.awt.*;
import java.lang.NullPointerException;
import java.lang.IllegalStateException;
import java.lang.NumberFormatException;


public class ViewSurchCourse extends JFrame{

  private JLabel title;
  private JLabel labelSurch;
  private JTextField textSurchCourse;
  private JButton buttonSurch;
  private JButton buttonReturn;
  private JButton buttonCancel;

  public ViewSurchCourse() {
        initializeComponents();
  }

  private void initializeComponents(){
    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    getContentPane().setLayout(null);

    title = new JLabel("Buscar Curso");
    getContentPane().add(title);
    title.setBounds(450, 26, 225, 58);
    title.setFont(new Font("Ubuntu", 0, 36));

    labelSurch = new JLabel("Curso:");
    getContentPane().add(labelSurch);
    labelSurch.setBounds(70, 160, 120, 21);

    textSurchCourse = new JTextField();
    textSurchCourse.setBounds(130, 210, 360, 28);
	getContentPane().add(textSurchCourse);
	
    textSurchCourse.addActionListener(new ActionListener(){
      public void actionPerformed(ActionEvent e){
        textSurchCourseAction();
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

  Database database = Database.getInstance();

  public Course getCourse(){
    Course course = null;
	try{
      course = database.surchCourseName(textSurchCourseAction());
	 }catch(IllegalStateException e){
	  JOptionPane.showMessageDialog(null, "Insira um curso!");
	  }    
    if(course == null){
      throw new NullPointerException();
    }
    return course;
  }

  public void buttonSurchAction(){
    try{
      Course course = new Course(this.getCourse());

      ViewShowCourse ViewShowCourse = new ViewShowCourse(course);
      ViewShowCourse.setVisible(true);
      ViewShowCourse.setSize(1057, 562);
      setVisible(false);
    }catch(NullPointerException e){
      JOptionPane.showMessageDialog(null, "Curso não encontrado!");
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
