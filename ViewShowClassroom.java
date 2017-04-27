import javax.swing.*;
import java.awt.event.*;
import java.awt.*;
import java.util.ArrayList;

public class ViewShowClassroom extends JFrame{
  private JLabel labelDiscipline;
  private JLabel labelGetDiscipline;
  private JLabel labelCod;
  private JLabel labelGetCod;
  private JLabel title;

  private JButton buttonNewStudant;
  private JButton buttonRemoveStudant;
  private JButton buttonList;
  private JButton buttonReturn;
  private JButton buttonCancelar;

  private Classroom classroom;
  private DatabaseStudants studants;

  public ViewShowClassroom(Classroom classroom){
    this.classroom = classroom;
    this.studants = classroom.getStudants();
    initializeComponents();
  }

  private void initializeComponents(){
    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    getContentPane().setLayout(null);

    title = new JLabel("Turma");
    getContentPane().add(title);
    title.setBounds(490, 30, 300, 73);
    title.setFont(new Font("Ubuntu", 0, 36));

    labelDiscipline = new JLabel("Disciplina:");
    getContentPane().add(labelDiscipline);
    labelDiscipline.setBounds(90, 180, 80, 20);

    labelGetDiscipline = new JLabel();
    labelGetDiscipline.setText(classroom.getDiscipline());
    getContentPane().add(labelGetDiscipline);
    labelGetDiscipline.setBounds(150, 150, 290, 18);

    labelCod = new JLabel("Código:");
    getContentPane().add(labelCod);
    labelCod.setBounds(90, 150, 60, 18);

    labelGetCod = new JLabel();
    labelGetCod.setText(String.valueOf(classroom.getNumber()));
    getContentPane().add(labelGetCod);
    labelGetCod.setBounds(170, 180, 120, 18);

     buttonNewStudant = new JButton("Adicionar Aluno");
     buttonNewStudant.setFont(new Font("Ubuntu", 0, 18));
     getContentPane().add(buttonNewStudant);
     buttonNewStudant.setBounds(90, 290, 160, 50);

     buttonNewStudant.addActionListener(new ActionListener(){
       public void actionPerformed(ActionEvent e){
         buttonNewStudantAction();
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

     buttonList = new JButton("Listar Alunos");
     buttonList.setFont(new Font("Ubuntu", 0, 18));
     getContentPane().add(buttonList);
     buttonList.setBounds(430, 290, 160, 50);

     buttonList.addActionListener(new ActionListener(){
       public void actionPerformed(ActionEvent e){
         buttonListAction();
       }
     });

     buttonRemoveStudant = new JButton("Remover Aluno");
     buttonRemoveStudant.setFont(new Font("Ubuntu", 0, 18));
     getContentPane().add(buttonRemoveStudant);
     buttonRemoveStudant.setBounds(260, 290, 160, 50);

     buttonRemoveStudant.addActionListener(new ActionListener(){
       public void actionPerformed(ActionEvent e){
         buttonRemoveStudantAction();
       }
     });
    pack();
    }

  public static void main(String [] args){}

  public void buttonNewStudantAction(){
    ViewNewStudantClassroom viewNewStudantClassroom = new ViewNewStudantClassroom(classroom);
    viewNewStudantClassroom.setSize(1057, 562);
    viewNewStudantClassroom.setVisible(true);
  }

  public void buttonRemoveStudantAction(){
    ViewRemoveStudantClassroom ViewRemoveStudantClassroom = new ViewRemoveStudantClassroom(classroom);
    ViewRemoveStudantClassroom.setVisible(true);
    ViewRemoveStudantClassroom.setSize(1057, 562);
  }

  public void buttonListAction(){
    ViewShowListStudantClass ViewShowListStudantClass = new ViewShowListStudantClass(classroom);
    ViewShowListStudantClass.setSize(1057, 562);
    ViewShowListStudantClass.setVisible(true);
  }

  public void buttonCancelarAction(){
    ViewHome viewHome = new ViewHome();
    viewHome.setSize(1057, 562);
    viewHome.setVisible(true);
  }

}
