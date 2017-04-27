import javax.swing.*;
import java.awt.event.*;
import java.awt.*;

public class ViewHome extends JFrame{
  private JButton newStudant;
  private JButton newTeacher;
  //private JButton newAdmin;
  private JButton newClass;
  private JButton list;
  private JButton removeStudant;
  private JButton removeTeacher;
  private JButton removeAdmin;
  private JButton removeClass;
  private JButton removeCourse;
  private JButton close;
  private JButton newCourse;
  private JButton surch;
  private JLabel labelTitle;

  public ViewHome() {
        initializeComponents();
    }

  private void initializeComponents(){
    labelTitle = new JLabel("Sistema Acadêmico");
    newStudant = new JButton("Novo Aluno");
    newTeacher = new JButton("Novo Prof.");
    //newAdmin = new JButton("Novo Admin");
    newClass = new JButton("Nova Turma");
    list = new JButton("Listar");
    removeStudant = new JButton("Excluir Aluno");
    removeTeacher = new JButton("Excluir Prof.");
    removeAdmin = new JButton("Excluir Admin");
    removeClass = new JButton("Excluir Turma");
    removeCourse = new JButton("Excluir Curso");
    close = new JButton("Sair");
    newCourse = new JButton("Novo Curso");
    surch = new JButton("Buscar");

    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    getContentPane().setLayout(null);


    labelTitle.setFont(new Font("Ubuntu", 0, 36));
    labelTitle.setHorizontalAlignment(javax.swing.SwingConstants.CENTER); // obs TESTEAR SEM ESSA PORRA
    getContentPane().add(labelTitle);
    labelTitle.setBounds(360, 20, 315, 54);

    //newStudant.setBackground(Color.blue);
    newStudant.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
    newStudant.setOpaque(true);

    newStudant.addActionListener(new ActionListener() {
        public void actionPerformed(ActionEvent e) {
            newStudantAction();
        }
    });

    getContentPane().add(newStudant);
    newStudant.setBounds(100, 150, 120, 83);

    //newTeacher.setBackground(Color.blue);
    newTeacher.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
    newTeacher.setOpaque(true);

    newTeacher.addActionListener(new ActionListener(){
      public void actionPerformed(ActionEvent e){
        newTeacherAction(e);
      }
    });

    getContentPane().add(newTeacher);
    newTeacher.setBounds(230, 150, 120, 83);

   
    newClass.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
    newClass.setOpaque(true);

    newClass.addActionListener(new ActionListener(){
      public void actionPerformed(ActionEvent e){
        newClassAction(e);
      }
    });

    getContentPane().add(newClass);
    newClass.setBounds(368, 150, 120, 83);

   
    newCourse.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
    newCourse.setOpaque(true);

    newCourse.addActionListener(new ActionListener(){
      public void actionPerformed(ActionEvent e){
        newCourseAction(e);
      }
    });

    getContentPane().add(newCourse);
    newCourse.setBounds(620, 150, 120, 83);

    surch.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
    surch.setOpaque(true);

    surch.addActionListener(new ActionListener(){
      public void actionPerformed(ActionEvent e){
        surchAction(e);
      }
    });

    getContentPane().add(surch);
    surch.setBounds(750, 150, 120, 83);

    list.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
    list.setOpaque(true);

    list.addActionListener(new ActionListener(){
      public void actionPerformed(ActionEvent e){
        listAction(e);
      }
    });

    getContentPane().add(list);
    list.setBounds(880, 150, 120, 83);

    //removeStudant.setBackground(Color.red);
    removeStudant.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
    removeStudant.setOpaque(true);

    removeStudant.addActionListener(new ActionListener(){
      public void actionPerformed(ActionEvent e){
        removeStudantAction(e);
      }
    });

    getContentPane().add(removeStudant);
    removeStudant.setBounds(100, 250, 120, 83);

    //removeTeacher.setBackground(Color.red);
    removeTeacher.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
    removeTeacher.setOpaque(true);

    removeTeacher.addActionListener(new ActionListener(){
      public void actionPerformed(ActionEvent e){
        removeTeacherAction(e);
      }
    });

    getContentPane().add(removeTeacher);
    removeTeacher.setBounds(230, 250, 120, 83);

    //removeAdmin.setBackground(Color.red);
    /*removeAdmin.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
    removeAdmin.setOpaque(true);

    removeAdmin.addActionListener(new ActionListener(){
      public void actionPerformed(ActionEvent e){
        removeAdminAction(e);
      }
    });

    getContentPane().add(removeAdmin);
    removeAdmin.setBounds(360, 250, 120, 83);*/

    //removeClass.setBackground(Color.red);
    removeClass.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
    removeClass.setOpaque(true);

    removeClass.addActionListener(new ActionListener(){
      public void actionPerformed(ActionEvent e){
        removeClassAction(e);
      }
    });

    getContentPane().add(removeClass);
    removeClass.setBounds(490, 250, 120, 83);

    //removeCourse.setBackground(Color.red);
    removeCourse.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
    removeCourse.setOpaque(true);

    removeCourse.addActionListener(new ActionListener(){
      public void actionPerformed(ActionEvent e){
        removeCourseAction(e);
      }
    });

    getContentPane().add(removeCourse);
    removeCourse.setBounds(620, 250, 120, 83);

    close.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
    close.setOpaque(true);

    close.addActionListener(new ActionListener(){
      public void actionPerformed(ActionEvent e){
        closeAction(e);
      }
    });

    getContentPane().add(close);
    close.setBounds(750, 250, 120, 83);

    pack();
  }

  public static void main(String [] args){}

  public void newStudantAction(){
    ViewNewAluno viewNewAluno = new ViewNewAluno();
    viewNewAluno.setVisible(true);
    viewNewAluno.setSize(1057, 562);
  }

  public void newTeacherAction(ActionEvent e){
    ViewNewTeacher viewNewTeacher = new ViewNewTeacher();
    viewNewTeacher.setVisible(true);
    viewNewTeacher.setSize(1057, 562);
  }

  /*public void newAdminAction(ActionEvent e){
    ViewNewAdmin viewNewAdmin = new ViewNewAdmin();
    viewNewAdmin.setVisible(true);
    viewNewAdmin.setSize(1057, 562);
  }*/

  public void newClassAction(ActionEvent e){
    ViewNewClassroom viewNewClassroom = new ViewNewClassroom();
    viewNewClassroom.setVisible(true);
    viewNewClassroom.setSize(1057, 562);
  }

  public void newCourseAction(ActionEvent e){
    ViewNewCourse viewNewCourse = new ViewNewCourse();
    viewNewCourse.setVisible(true);
    viewNewCourse.setSize(1057, 562);
  }

  public void surchAction(ActionEvent e){
    ViewSurch viewSurch = new ViewSurch();
    viewSurch.setVisible(true);
    viewSurch.setSize(1057, 562);
  }

  public void listAction(ActionEvent e){
    ViewList viewList = new ViewList();
    viewList.setVisible(true);
    viewList.setSize(1057, 562);
  }

  public void removeStudantAction(ActionEvent e){
    ViewRemoveStudant ViewRemoveStudant = new ViewRemoveStudant();
    ViewRemoveStudant.setVisible(true);
    ViewRemoveStudant.setSize(1057, 562);
  }

  public void removeTeacherAction(ActionEvent e){
    ViewRemoveTeacher ViewRemoveTeacher = new ViewRemoveTeacher();
    ViewRemoveTeacher.setVisible(true);
    ViewRemoveTeacher.setSize(1057, 562);
  }

  /*public void removeAdminAction(ActionEvent e){
    ViewRemoveAdmin ViewRemoveAdmin = new ViewRemoveAdmin();
    ViewRemoveAdmin.setVisible(true);
    ViewRemoveAdmin.setSize(1057, 562);
  }*/

  public void removeClassAction(ActionEvent e){
    ViewRemoveClassroom ViewRemoveClassroom = new ViewRemoveClassroom();
    ViewRemoveClassroom.setVisible(true);
    ViewRemoveClassroom.setSize(1057, 562);
  }

  public void removeCourseAction(ActionEvent e){
    ViewRemoveCourse ViewRemoveCourse = new ViewRemoveCourse();
    ViewRemoveCourse.setVisible(true);
    ViewRemoveCourse.setSize(1057, 562);
  }

  public void closeAction(ActionEvent e){
    System.exit(0);
  }






}
