import javax.swing.*;
import java.awt.event.*;
import java.awt.*;

public class ViewSurch extends JFrame{

  private JLabel title;

  private JButton buttonStudant;
  private JButton buttonTeacher;
 // private JButton buttonAdmin;
  private JButton buttonClass;
  private JButton buttonCourse;
  private JButton buttonCancelar;

  public ViewSurch() {
        initializeComponents();
  }

  private void initializeComponents(){
    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    getContentPane().setLayout(null);

    title = new JLabel("Buscar");
    getContentPane().add(title);
    title.setBounds(490, 30, 170, 54);
    title.setFont(new Font("Ubuntu", 0, 36));

     buttonStudant = new JButton("Aluno");
     buttonStudant.setFont(new Font("Ubuntu", 0, 18));
     getContentPane().add(buttonStudant);
     buttonStudant.setBounds(170, 140, 170, 50);

     buttonStudant.addActionListener(new ActionListener(){
       public void actionPerformed(ActionEvent e){
         buttonStudantAction();
       }
     });

     buttonTeacher = new JButton("Professor");
     buttonTeacher.setFont(new Font("Ubuntu", 0, 18));
     getContentPane().add(buttonTeacher);
     buttonTeacher.setBounds(350, 140, 170, 50);

     buttonTeacher.addActionListener(new ActionListener(){
       public void actionPerformed(ActionEvent e){
         buttonTeacherAction();
       }
     });

     buttonClass = new JButton("Turma");
     buttonClass.setFont(new Font("Ubuntu", 0, 18));
     getContentPane().add(buttonClass);
     buttonClass.setBounds(530, 140, 170, 50);

     buttonClass.addActionListener(new ActionListener(){
       public void actionPerformed(ActionEvent e){
         buttonClassAction();
       }
     });

     buttonCourse = new JButton("Curso");
     buttonCourse.setFont(new Font("Ubuntu", 0, 18));
     getContentPane().add(buttonCourse);
     buttonCourse.setBounds(710, 140, 170, 50);

     buttonCourse.addActionListener(new ActionListener(){
       public void actionPerformed(ActionEvent e){
         buttonCourseAction();
       }
     });

     buttonCancelar = new JButton("Cancelar");
     buttonCancelar.setFont(new Font("Ubuntu", 0, 18));
     getContentPane().add(buttonCancelar);
     buttonCancelar.setBounds(730, 440, 210, 50);

     buttonCancelar.addActionListener(new ActionListener(){
       public void actionPerformed(ActionEvent e){
         buttonCancelarAction();
       }
     });
    pack();

    }

  public static void main(String [] args){

  }

  public void buttonStudantAction(){
    ViewSurchStudant viewSurchStudant = new ViewSurchStudant();
    viewSurchStudant.setVisible(true);
    viewSurchStudant.setSize(1057, 562);
  }

  public void buttonTeacherAction(){
    ViewSurchTeacher ViewSurchTeacher = new ViewSurchTeacher();
    ViewSurchTeacher.setVisible(true);
    ViewSurchTeacher.setSize(1057, 562);
  }
  /*public void buttonAdminAction(){
    ViewSurchAdmin ViewSurchAdmin = new ViewSurchAdmin();
    ViewSurchAdmin.setVisible(true);
    ViewSurchAdmin.setSize(1057, 562);
  }*/
  
  public void buttonClassAction(){
    ViewSurchClassroom ViewSurchClassroom = new ViewSurchClassroom();
    ViewSurchClassroom.setVisible(true);
    ViewSurchClassroom.setSize(1057, 562);

  }

  public void buttonCourseAction(){
    ViewSurchCourse ViewSurchCourse = new ViewSurchCourse();
    ViewSurchCourse.setVisible(true);
    ViewSurchCourse.setSize(1057, 562);
  }

  public void buttonCancelarAction(){
    ViewHome home = new ViewHome();
    home.setSize(1057, 562);
    home.setVisible(true);
  }




}
