import javax.swing.*;
import java.awt.event.*;
import java.awt.*;
import java.util.ArrayList;

public class ViewShowSurchTeacher extends JFrame{

  private JLabel labelName;
  private JLabel labelGetName;
  private JLabel labelRegistration;
  private JLabel labelGetRegistration;
  private JLabel labelRg;
  private JLabel labelGetRg;
  private JLabel title;
  private JLabel labelCpf;
  private JLabel labelGetCpf;
  private JLabel labelBirthDate;
  private JLabel labelGetBirthDate;
  private JLabel labelEmail;
  private JLabel labelGetEmail;


  private JButton buttonCancelar;

  private User studant;

  public ViewShowSurchTeacher(User studant){
    this.studant = studant;
    initializeComponents();
  }

  private void initializeComponents(){
    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    getContentPane().setLayout(null);

    title = new JLabel("Professor");
    getContentPane().add(title);
    title.setBounds(500, 30, 300, 73);
    title.setFont(new Font("Ubuntu", 0, 36));

    labelName = new JLabel("Nome:");
    getContentPane().add(labelName);
    labelName.setBounds(90, 150, 60, 18);

    labelGetName = new JLabel();
    labelGetName.setText(studant.getName());
    getContentPane().add(labelGetName);
    labelGetName.setBounds(150, 150, 420, 18);

    labelRegistration = new JLabel("Matricula:");
    getContentPane().add(labelRegistration);
    labelRegistration.setBounds(90, 180, 72, 20);

    labelGetRegistration = new JLabel();
    labelGetRegistration.setText(String.valueOf(studant.getRegistration()));
    getContentPane().add(labelGetRegistration);
    labelGetRegistration.setBounds(170, 180, 240, 20);

    labelRg = new JLabel("Rg:");
    getContentPane().add(labelRg);
    labelRg.setBounds(90, 210, 30, 20);

    labelGetRg = new JLabel();
    labelGetRg.setText(String.valueOf(studant.getRg()));
    getContentPane().add(labelGetRg);
    labelGetRg.setBounds(120, 210, 120, 20);

    labelCpf = new JLabel("Cpf: ");
    getContentPane().add(labelCpf);
    labelCpf.setBounds(90, 240, 40, 20);

    labelGetCpf = new JLabel();
    labelGetCpf.setText(String.valueOf(studant.getCpf()));
    getContentPane().add(labelGetCpf);
    labelGetCpf.setBounds(130, 240, 230, 20);

    labelBirthDate = new JLabel("Data de Nascimento: ");
    getContentPane().add(labelBirthDate);
    labelBirthDate.setBounds(90, 270, 150, 20);

    labelGetBirthDate = new JLabel();
    labelGetBirthDate.setText(String.valueOf(studant.getBirthDate()));
    getContentPane().add(labelGetBirthDate);
    labelGetBirthDate.setBounds(240, 270, 210, 20);

    labelEmail = new JLabel("Email: ");
    getContentPane().add(labelEmail);
    labelEmail.setBounds(90, 300, 70, 20);

    labelGetEmail = new JLabel();
    labelGetEmail.setText(String.valueOf(studant.getEmail()));
    getContentPane().add(labelGetEmail);
    labelGetEmail.setBounds(160, 300, 450, 20);

     buttonCancelar = new JButton("Cancelar");
     buttonCancelar.setFont(new Font("Ubuntu", 0, 18));
     getContentPane().add(buttonCancelar);
     buttonCancelar.setBounds(440, 430, 190, 50);

     buttonCancelar.addActionListener(new ActionListener(){
       public void actionPerformed(ActionEvent e){
         buttonCancelarAction();
       }
     });

    pack();
    }

  public static void main(String [] args){}

  public void buttonCancelarAction(){
    ViewHome viewHome = new ViewHome();
    viewHome.setSize(1057, 562);
    viewHome.setVisible(true);
  }

}
