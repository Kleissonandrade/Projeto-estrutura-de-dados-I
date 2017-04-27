import javax.swing.*;
import java.awt.event.*;
import java.awt.*;

public class ViewList extends JFrame{

  private JLabel title;
 
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
    
     buttonCourse = new JButton("Curso");
     buttonCourse.setFont(new Font("Ubuntu", 0, 18));
     getContentPane().add(buttonCourse);
     buttonCourse.setBounds(50, 140, 170, 50);

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
