import javax.swing.*;
import java.awt.event.*;
import java.awt.*;

public class ViewList extends JFrame{

  private JLabel title;

  private JButton buttonStudant;
  private JButton buttonTeacher;
  //private JButton buttonAdmin;
  private JButton buttonClass;
  private JButton buttonCourse;
  private JButton buttonCancelar;

  Database database = Database.getInstance();

  public ViewList() {
        initializeComponents();
  }

  private void initializeComponents(){
    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    getContentPane().setLayout(null);

    title = new JLabel("Listar");
    title.setFont(new Font("Ubuntu", 0, 36));
    getContentPane().add(title);
    title.setBounds(470, 30, 170, 54);

     buttonStudant = new JButton("Aluno");
     buttonStudant.setFont(new Font("Ubuntu", 0, 18));
     getContentPane().add(buttonStudant);
     buttonStudant.setBounds(50, 140, 170, 50);

     buttonStudant.addActionListener(new ActionListener(){
       public void actionPerformed(ActionEvent e){
         buttonStudantAction();
       }
     });

     buttonTeacher = new JButton("Professor");
     buttonTeacher.setFont(new Font("Ubuntu", 0, 18));
     getContentPane().add(buttonTeacher);
     buttonTeacher.setBounds(230, 140, 170, 50);

     buttonTeacher.addActionListener(new ActionListener(){
       public void actionPerformed(ActionEvent e){
         buttonTeacherAction();
       }
     });

     /*buttonAdmin = new JButton("Administrador");
     buttonAdmin.setFont(new Font("Ubuntu", 0, 18));
     getContentPane().add(buttonAdmin);
     buttonAdmin.setBounds(410, 140, 170, 50);

     buttonAdmin.addActionListener(new ActionListener(){
       public void actionPerformed(ActionEvent e){
         buttonAdminAction();
       }
     });*/

     buttonClass = new JButton("Turma");
     buttonClass.setFont(new Font("Ubuntu", 0, 18));
     getContentPane().add(buttonClass);
     buttonClass.setBounds(590, 140, 170, 50);

     buttonClass.addActionListener(new ActionListener(){
       public void actionPerformed(ActionEvent e){
         buttonClassAction();
       }
     });

     buttonCourse = new JButton("Curso");
     buttonCourse.setFont(new Font("Ubuntu", 0, 18));
     getContentPane().add(buttonCourse);
     buttonCourse.setBounds(770, 140, 170, 50);

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

  public static void main(String [] args){}

  public void buttonStudantAction(){
    ViewShowListStudant view = new ViewShowListStudant();
    view.setSize(800, 600);
    view.setVisible(true);
  }
  public void buttonTeacherAction(){
    ViewShowListTeacher viewShowListTeacher = new ViewShowListTeacher();
    viewShowListTeacher.setSize(800, 600);
    viewShowListTeacher.setVisible(true);

  }
  
  /*public void buttonAdminAction(){
    ViewShowListAdmin viewShowListAdmin = new ViewShowListAdmin();
    viewShowListAdmin.setSize(800, 600);
    viewShowListAdmin.setVisible(true);
  }*/

  public void buttonClassAction(){
    ViewShowListClassroom viewShowListClassroom = new ViewShowListClassroom();
    viewShowListClassroom.setSize(800, 600);
    viewShowListClassroom.setVisible(true);
  }

  public void buttonCourseAction(){
    ViewShowListCourse viewShowListCourse = new ViewShowListCourse();
    viewShowListCourse.setSize(800, 600);
    viewShowListCourse.setVisible(true);
  }

  public void buttonCancelarAction(){
    ViewHome home = new ViewHome();
    home.setSize(1057, 562);
    home.setVisible(true);
  }




}
