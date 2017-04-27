import javax.swing.*;
import java.awt.event.*;
import java.awt.*;
import java.util.ArrayList;
import java.lang.NullPointerException;
import java.lang.IllegalStateException;
import java.lang.NumberFormatException;

public class ViewNewDiscipline extends JFrame{

  private JLabel labelDiscipline;
  private JLabel labelCod;
  private JLabel labelCredits;
  private JLabel labelWorkload;
  private JLabel title;
  private JTextField textDiscipline;
  private JTextField textCod;
  private JTextField textCredits;
  private JTextField textWorkload;

  private JLabel labelSpanHoras;

  private JButton buttonAdd;
  private JButton buttonVoltar;
  private Course course;
  private DatabaseDisciplines disciplines;


  public ViewNewDiscipline(Course course) {
        this.course = course;
        this.disciplines = course.getDisciplines();
        initializeComponents();
    }

  private void initializeComponents(){
    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    getContentPane().setLayout(null);

    title = new JLabel("Adicionar Disciplina");
    getContentPane().add(title);
    title.setBounds(380, 30, 400, 73);
    title.setFont(new Font("Ubuntu", 0, 36));

    labelDiscipline = new JLabel("Disciplina:");
    getContentPane().add(labelDiscipline);
    labelDiscipline.setBounds(40, 160, 80, 21);

    labelCod = new JLabel("Código:");
    getContentPane().add(labelCod);
    labelCod.setBounds(420, 160, 70, 21);

    labelCredits = new JLabel("Qnt. Creditos:");
    getContentPane().add(labelCredits);
    labelCredits.setBounds(40, 210, 110, 21);

    labelWorkload = new JLabel("Carga Horaria:");
    getContentPane().add(labelWorkload);
    labelWorkload.setBounds(250, 210, 120, 21);

    labelSpanHoras = new JLabel(" horas.");
    getContentPane().add(labelSpanHoras);
    labelSpanHoras.setBounds(540, 210, 50, 30);


    textDiscipline = new JTextField();
    getContentPane().add(textDiscipline);
    textDiscipline.setBounds(120, 160, 280, 28);

    textDiscipline.addActionListener(new ActionListener(){
      public void actionPerformed(ActionEvent e){
        textDisciplineAction();
      }
    });

    textCod = new JTextField();
    getContentPane().add(textCod);
    textCod.setBounds(490, 160, 170, 28);

    textCod.addActionListener(new ActionListener(){
      public void actionPerformed(ActionEvent e){
        textCodAction();
      }
    });

    textCredits = new JTextField();
    getContentPane().add(textCredits);
    textCredits.setBounds(150, 210, 80, 28);

    textCredits.addActionListener(new ActionListener(){
      public void actionPerformed(ActionEvent e){
        textCreditsAction();
      }
    });

    textWorkload = new JTextField();
    getContentPane().add(textWorkload);
    textWorkload.setBounds(370, 210, 170, 28);

    textWorkload.addActionListener(new ActionListener(){
      public void actionPerformed(ActionEvent e){
        textWorkloadAction();
      }
    });

     buttonAdd = new JButton("Adicionar");
     buttonAdd.setFont(new Font("Ubuntu", 0, 18));
     getContentPane().add(buttonAdd);
     buttonAdd.setBounds(640, 430, 190, 50);

     buttonAdd.addActionListener(new ActionListener(){
       public void actionPerformed(ActionEvent e){
         buttonAddAction();
       }
     });

     buttonVoltar = new JButton("Voltar");
     buttonVoltar.setFont(new Font("Ubuntu", 0, 18));
     getContentPane().add(buttonVoltar);
     buttonVoltar.setBounds(440, 430, 190, 50);

     buttonVoltar.addActionListener(new ActionListener(){
       public void actionPerformed(ActionEvent e){
         buttonVoltarAction();
       }
     });
    pack();
    }

  public static void main(String [] args){}

  public void buttonVoltarAction(){
    ViewShowCourse viewShowCourse = new ViewShowCourse(course);
    viewShowCourse.setSize(1057, 562);
    viewShowCourse.setVisible(true);
  }

  public void buttonAddAction(){
    boolean flag = false;
    int temps = 0;
    do{
      try{
        flag = true;
        Discipline discipline = new Discipline(textDisciplineAction(), textCodAction(), textCreditsAction(), textWorkloadAction());
        disciplines.addDiscipline(discipline.getKey(), discipline);
        JOptionPane.showMessageDialog(null, "OK!");
        
      }catch(NullPointerException e){}

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
        if(textWorkload.getText().trim().length() == 0){
          JOptionPane.showMessageDialog(null, "Campo Carga Horaria vazio!");
          temps ++;
        }
        if(textCredits.getText().trim().length() == 0){
          JOptionPane.showMessageDialog(null, "Campo Créditos vazio!");
          temps ++;
        }
    }
    }while(!flag && temps < 1);
  }

  public String textDisciplineAction(){
    if(textDiscipline.getText() == null){
      throw new NullPointerException();

    }if(textDiscipline.getText().trim().length() == 0){
      throw new  IllegalStateException();
    }
    return textDiscipline.getText();
  }

  public int textCodAction(){
    int cod = Integer.parseInt(textCod.getText());
    if(textCod.getText() == null){
      throw new NullPointerException();

    }if(textCod.getText().trim().length() == 0){
      throw new NumberFormatException();
    }
    return cod;
  }

  public int textCreditsAction(){
    int credits = Integer.parseInt(textCredits.getText());
    if(textCredits.getText() == null){
      throw new NullPointerException();

    }if(textCredits.getText().trim().length() == 0){
      throw new NumberFormatException();
    }
    return credits;
  }

  public int textWorkloadAction(){
    int workload = Integer.parseInt(textWorkload.getText());
    if(textWorkload.getText() == null){
      throw new NullPointerException();

    }if(textWorkload.getText().trim().length() == 0){
      throw new NumberFormatException();
    }
    return workload;
  }
}
