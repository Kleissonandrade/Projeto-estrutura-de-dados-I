import javax.swing.*;
import java.awt.event.*;
import java.awt.*;
import java.util.LinkedList;
import java.util.ArrayList;

public class ViewShowCourse extends JFrame{

  private JLabel labelCourse;
  private JLabel labelGetCourse;
  private JLabel labelCod;
  private JLabel labelGetCod;
  private JLabel labelWorkload;
  private JLabel labelGetWorkload;
  private JLabel title;
  private JLabel labelDuration;
  private JLabel labelGetDuration;

  private JButton buttonNewDiscipline;
  private JButton buttonRemoveDiscipline;
  private JButton buttonReturn;
  private JButton buttonCancelar;
  private Course course;
  private DatabaseDisciplines disciplines;

  public ViewShowCourse(Course course){
    this.course = course;
    this.disciplines = course.getDisciplines();
    initializeComponents();
  }

  private void initializeComponents(){
    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    getContentPane().setLayout(null);

    title = new JLabel("Nome do Curso");
    getContentPane().add(title);
    title.setBounds(430, 30, 300, 73);
    title.setFont(new Font("Ubuntu", 0, 36));

    labelCourse = new JLabel("Curso:");
    getContentPane().add(labelCourse);
    labelCourse.setBounds(90, 150, 60, 18);

    labelGetCourse = new JLabel();
    labelGetCourse.setText(course.getCourseName());
    getContentPane().add(labelGetCourse);
    labelGetCourse.setBounds(150, 150, 290, 18);

    labelCod = new JLabel("Código:");
    getContentPane().add(labelCod);
    labelCod.setBounds(90, 180, 60, 20);

    labelGetCod = new JLabel();
    labelGetCod.setText(String.valueOf(course.getKey()));
    getContentPane().add(labelGetCod);
    labelGetCod.setBounds(150, 180, 120, 18);

    labelWorkload = new JLabel("Carga Horaria:");
    getContentPane().add(labelWorkload);
    labelWorkload.setBounds(90, 210, 110, 20);

    labelGetWorkload = new JLabel();
    labelGetWorkload.setText(String.valueOf(course.getWorkload()));
    getContentPane().add(labelGetWorkload);
    labelGetWorkload.setBounds(200, 210, 120, 20);

    labelDuration = new JLabel("Duração: ");
    getContentPane().add(labelDuration);
    labelDuration.setBounds(90, 240, 70, 20);

    labelGetDuration = new JLabel();
    labelGetDuration.setText(String.valueOf(course.getDuration()));
    getContentPane().add(labelGetDuration);
    labelGetDuration.setBounds(160, 240, 70, 20);

     buttonNewDiscipline = new JButton("Adicionar Disciplina");
     buttonNewDiscipline.setFont(new Font("Ubuntu", 0, 18));
     getContentPane().add(buttonNewDiscipline);
     buttonNewDiscipline.setBounds(90, 290, 160, 50);

     buttonNewDiscipline.addActionListener(new ActionListener(){
       public void actionPerformed(ActionEvent e){
         buttonNewDisciplineAction();
       }
     });

     buttonCancelar = new JButton("Cancelar");
     buttonCancelar.setFont(new Font("Ubuntu", 0, 18));
     getContentPane().add(buttonCancelar);
     buttonCancelar.setBounds(440, 430, 190, 50);

     buttonCancelar.addActionListener(new ActionListener(){
       public void actionPerformed(ActionEvent e){
         buttonCancelarAction();
       }
     });

     buttonReturn = new JButton("Voltar");
     buttonReturn.setFont(new Font("Ubuntu", 0, 18));
     getContentPane().add(buttonReturn);
     buttonReturn.setBounds(600, 290, 160, 50);

     buttonReturn.addActionListener(new ActionListener(){
       public void actionPerformed(ActionEvent e){
         buttonReturnAction();
       }
     });

     buttonRemoveDiscipline = new JButton("Remover Disciplina");
     buttonRemoveDiscipline.setFont(new Font("Ubuntu", 0, 18));
     getContentPane().add(buttonRemoveDiscipline);
     buttonRemoveDiscipline.setBounds(260, 290, 160, 50);

     buttonRemoveDiscipline.addActionListener(new ActionListener(){
       public void actionPerformed(ActionEvent e){
         buttonRemoveDisciplineAction();
       }
     });
    pack();
    }

  public static void main(String [] args){}

  public void buttonNewDisciplineAction(){
    ViewNewDiscipline viewNewDiscipline = new ViewNewDiscipline(course);
    viewNewDiscipline.setSize(1057, 562);
    viewNewDiscipline.setVisible(true);
  }

  public void buttonRemoveDisciplineAction(){
    ViewRemoveDiscipline viewRemoveDiscipline = new ViewRemoveDiscipline(this.course);
    viewRemoveDiscipline.setVisible(true);
    viewRemoveDiscipline.setSize(1057, 562);
  }


  public void buttonReturnAction(){
    ViewSurchCourse viewSurchCourse = new ViewSurchCourse();
    viewSurchCourse.setSize(1057, 562);
    viewSurchCourse.setVisible(true);
  }

  public void buttonCancelarAction(){
    ViewHome viewHome = new ViewHome();
    viewHome.setSize(1057, 562);
    viewHome.setVisible(true);
  }

}
