import javax.swing.*;
import java.awt.event.*;
import java.awt.*;
import java.lang.Integer;
import java.lang.NullPointerException;
import java.lang.IllegalStateException;
import java.lang.NumberFormatException;


public class ViewNewCourse extends JFrame{

  private JLabel title;
  private JLabel labelCourse;
  private JLabel labelCod;
  private JLabel labelWorkload;
  private JLabel labelDuration;
  private JTextField textCourse;
  private JTextField textCod;
  private JTextField textWorkload;
  private JTextField textDuration;

  private JLabel labelSpanHouras;
  private JLabel labelSpanPeriodos;


  private JButton buttonCadastrar;
  private JButton buttonCancelar;

  public ViewNewCourse() {
        initializeComponents();
    }

  private void initializeComponents(){
    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    getContentPane().setLayout(null);

    title = new JLabel("Cadastro de Curso");
    getContentPane().add(title);
    title.setBounds(390, 30, 300, 73);
    title.setFont(new Font("Ubuntu", 0, 36));

    labelCourse = new JLabel("Curso:");
    getContentPane().add(labelCourse);
    labelCourse.setBounds(40, 160, 60, 21);

    labelCod = new JLabel("Código:");
    getContentPane().add(labelCod);
    labelCod.setBounds(420, 160, 70, 21);

    labelWorkload = new JLabel("Carga Horaria:");
    getContentPane().add(labelWorkload);
    labelWorkload.setBounds(600, 160, 120, 21);

    labelDuration = new JLabel("Duração:");
    getContentPane().add(labelDuration);
    labelDuration.setBounds(40, 210, 80, 21);


    textCourse = new JTextField();
    getContentPane().add(textCourse);
    textCourse.setBounds(100, 160, 310, 28);

    textCourse.addActionListener(new ActionListener(){
      public void actionPerformed(ActionEvent e){
        actionTextCourse();
      }
    });

    textCod = new JTextField();
    getContentPane().add(textCod);
    textCod.setBounds(490, 160, 90, 28);

    textCod.addActionListener(new ActionListener(){
      public void actionPerformed(ActionEvent e){
        actionTextCod();
      }
    });

    textWorkload = new JTextField();
    getContentPane().add(textWorkload);
    textWorkload.setBounds(720, 160, 60, 28);

    textWorkload.addActionListener(new ActionListener(){
      public void actionPerformed(ActionEvent e){
        actionTextWorkload();
      }
    });

    textDuration = new JTextField();
    getContentPane().add(textDuration);
    textDuration.setBounds(120, 210, 90, 28);

    textDuration.addActionListener(new ActionListener(){
      public void actionPerformed(ActionEvent e){
        actionTextDuration();
      }
    });

    labelSpanHouras = new JLabel(" horas.");
    getContentPane().add(labelSpanHouras);
    labelSpanHouras.setBounds(780, 160, 57, 30);

    labelSpanPeriodos =  new JLabel(" periodos.");
    getContentPane().add(labelSpanPeriodos);
    labelSpanPeriodos.setBounds(210, 210, 80, 30);

     buttonCadastrar = new JButton("Cadastrar");
     buttonCadastrar.setFont(new Font("Ubuntu", 0, 18));
     getContentPane().add(buttonCadastrar);
     buttonCadastrar.setBounds(640, 430, 190, 50);

     buttonCadastrar.addActionListener(new ActionListener(){
       public void actionPerformed(ActionEvent e){
         actionButtonCadastrar();
       }
     });

     buttonCancelar = new JButton("Cancelar");
     buttonCancelar.setFont(new Font("Ubuntu", 0, 18));
     getContentPane().add(buttonCancelar);
     buttonCancelar.setBounds(440, 430, 190, 50);

     buttonCancelar.addActionListener(new ActionListener(){
       public void actionPerformed(ActionEvent e){
         actionButtonCancelar();
       }
     });
    pack();

    }

  public static void main(String [] args){

  }

  public void actionButtonCancelar(){
    ViewHome home = new ViewHome();
    home.setSize(1057, 562);
    home.setVisible(true);
  }



  public void actionButtonCadastrar(){
    Database database = Database.getInstance();
    boolean flag = false;
    int temps = 0;
    do{
      try{
        flag = true;

        database.addCourse(new Course(actionTextCourse(), actionTextCod(), actionTextWorkload(), actionTextDuration()));
        Course course = new Course(database.surchCourseName(actionTextCourse()));

        ViewShowCourse viewShowCourse = new ViewShowCourse(course);
        viewShowCourse.setVisible(true);
        viewShowCourse.setSize(1057, 562);

      }catch(NullPointerException e){}

      catch(IllegalStateException e){
        if(textCourse.getText().trim().length() == 0){
          JOptionPane.showMessageDialog(null, "Campo Curso vazio!");
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
        if(textDuration.getText().trim().length() == 0){
          JOptionPane.showMessageDialog(null, "Campo Duração vazio!");
          temps ++;
        }
    }
    }while(!flag && temps < 1);
  }

  public String actionTextCourse(){
    if(textCourse.getText() == null){
      throw new NullPointerException();

    }if(textCourse.getText().trim().length() == 0){
      throw new  IllegalStateException();
    }
    return textCourse.getText();
  }

  public int actionTextCod(){
    int codigo = Integer.parseInt(textCod.getText());
    if(textCod.getText() == null){
      throw new NullPointerException();

    }if(textCod.getText().trim().length() == 0){
      throw new NumberFormatException();
    }
    return codigo;
  }

  public int actionTextWorkload(){
    int workload = Integer.parseInt(textWorkload.getText());
    if(textWorkload.getText() == null){
      throw new NullPointerException();

    }if(textWorkload.getText().trim().length() == 0){
      throw new NumberFormatException();
    }
    return workload;
  }

  public int actionTextDuration(){
    int duration = Integer.parseInt(textDuration.getText());
    if(textDuration.getText() == null){
      throw new NullPointerException();

    }if(textDuration.getText().trim().length() == 0){
      throw new NumberFormatException();
    }
    return duration;
  }
}
