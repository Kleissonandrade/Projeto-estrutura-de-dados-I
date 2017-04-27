import javax.swing.*;
import java.awt.event.*;
import java.awt.*;
import java.lang.Integer;

public class ViewNewTeacher extends JFrame{

  private JLabel labelRegister;
  private JLabel labelBirthDate;
  private JLabel labelCpf;
  private JLabel labelEmail;
  private JLabel labelRg;
  private JLabel labelName;
  private JLabel title;
  private JLabel labelFormation;
  private JTextField textCpf;
  private JTextField textRegister;
  private JTextField textRg;
  private JTextField textName;
  private JTextField textBirthDate;
  private JTextField textEmail;
  private JTextField textFormation;

  private JButton buttonCadastrar;
  private JButton buttonCancelar;

  public ViewNewTeacher() {
        initializeComponents();
    }

  private void initializeComponents(){
    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    getContentPane().setLayout(null);

    title = new JLabel("Cadastro de Professor");
    getContentPane().add(title);
    title.setBounds(370, 30, 390, 73);
    title.setFont(new Font("Ubuntu", 0, 36));

    labelRegister = new JLabel("Matricula:");
    getContentPane().add(labelRegister);
    labelRegister.setBounds(40, 210, 90, 21);

    labelBirthDate = new JLabel("Data de Nascimento:");
    getContentPane().add(labelBirthDate);
    labelBirthDate.setBounds(370, 210, 180, 21);

    labelCpf = new JLabel("CPF:");
    getContentPane().add(labelCpf);
    labelCpf.setBounds(630, 160, 50, 21);

    labelEmail = new JLabel("Email:");
    getContentPane().add(labelEmail);
    labelEmail.setBounds(40, 260, 49, 18);

    labelRg = new JLabel("RG:");
    getContentPane().add(labelRg);
    labelRg.setBounds(420, 160, 30, 21);

    labelName = new JLabel("Name:");
    getContentPane().add(labelName);
    labelName.setBounds(40, 160, 60, 21);

    labelFormation = new JLabel("Formação:");
    getContentPane().add(labelFormation);
    labelFormation.setBounds(40, 310, 90, 21);


    textCpf = new JTextField();
    getContentPane().add(textCpf);
    textCpf.setBounds(670, 160, 160, 28);

    textCpf.addActionListener(new ActionListener(){
      public void actionPerformed(ActionEvent e){
        actionTextCpf();
      }
    });

    textRegister = new JTextField();
    getContentPane().add(textRegister);
    textRegister.setBounds(120, 210, 230, 28);

    textRegister.addActionListener(new ActionListener(){
      public void actionPerformed(ActionEvent e){
        actionTextRegister();
      }
    });

    textRg = new JTextField();
    getContentPane().add(textRg);
    textRg.setBounds(450, 160, 170, 28);

    textRg.addActionListener(new ActionListener(){
      public void actionPerformed(ActionEvent e){
        actionTextRg();
      }
    });

    textName =  new JTextField();
    getContentPane().add(textName);
    textName.setBounds(100, 160, 310, 28);

    textName.addActionListener(new ActionListener(){
      public void actionPerformed(ActionEvent e){
        actionTextName();
      }
    });

    textBirthDate = new JTextField();
    getContentPane().add(textBirthDate);
    textBirthDate.setBounds(540, 210, 170, 28);

    textBirthDate.addActionListener(new ActionListener(){
      public void actionPerformed(ActionEvent e){
        actionTextBirthDate();
      }
    });

    textEmail = new JTextField();
    getContentPane().add(textEmail);
    textEmail.setBounds(90, 260, 460, 28);

    textEmail.addActionListener(new ActionListener(){
      public void actionPerformed(ActionEvent e){
        actionTextEmail();
      }
    });

    textFormation= new JTextField();
    getContentPane().add(textFormation);
    textFormation.setBounds(140, 310, 410, 92);

    textFormation.addActionListener(new ActionListener(){
      public void actionPerformed(ActionEvent e){
        actionTextFormation();
      }
    });

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
        Teacher teacher = new Teacher(actionTextName(), actionTextRg(), actionTextCpf(), actionTextRegister(),
        actionTextBirthDate(), actionTextEmail(), actionTextFormation());
        database.addTeacher(teacher.getRegistration(), teacher);
        JOptionPane.showMessageDialog(null, "OK!");
      }catch(NullPointerException x){
          JOptionPane.showMessageDialog(null, "Insira um valor inteiro em Matiocula!");
          temps ++;

      }

      catch(IllegalStateException e){
        if(textCpf.getText().trim().length() == 0){
          JOptionPane.showMessageDialog(null, "Campo Cpf vazio!");
          temps ++;
        }
        if(textEmail.getText().trim().length() == 0){
          JOptionPane.showMessageDialog(null, "Campo Email vazio!");
          temps ++;
        }
        if(textRg.getText().trim().length() == 0){
          JOptionPane.showMessageDialog(null, "Campo Rg vazio!");
          temps ++;
        }
        if(textName.getText().trim().length() == 0){
          JOptionPane.showMessageDialog(null, "Campo Nome vazio!");
          temps ++;
        }
        if(textFormation.getText().trim().length() == 0){
          JOptionPane.showMessageDialog(null, "Campo Formação vazio!");
          temps ++;
        }
        if(textBirthDate.getText().trim().length() == 0){
          JOptionPane.showMessageDialog(null, "Campo 'Data de aniversario' vazio!");
          temps ++;
        }
      }
      catch(NumberFormatException e){
        if(textRegister.getText().trim().length() == 0){
          JOptionPane.showMessageDialog(null, "Campo Matricula vazio!");
          temps ++;
      }
    }
    }while(!flag && temps < 1);

  }

  public String actionTextCpf(){
    if(textCpf.getText() == null){
      throw new NullPointerException(
                      "Null Cpf in NewStudant");
    }if(textCpf.getText().trim().length() == 0){
      throw new  IllegalStateException();
    }
    return textCpf.getText();
  }

  public String actionTextEmail(){
    if(textEmail.getText() == null){
      throw new NullPointerException(
                      "Null Email in NewStudant");
    }if(textEmail.getText().trim().length() == 0){
      throw new  IllegalStateException();
    }
    return textEmail.getText();
  }

  public String actionTextFormation(){
    if(textFormation.getText() == null){
      throw new NullPointerException(
                      "Null Email in NewStudant");
    }if(textFormation.getText().trim().length() == 0){
      throw new  IllegalStateException();
    }
    return textFormation.getText();
  }

  public String actionTextRg(){
    if(textRg.getText() == null){
      throw new NullPointerException(
                      "Null Email in NewStudant");
    }if(textRg.getText().trim().length() == 0){
      throw new  IllegalStateException();
    }
    return textRg.getText();
  }
  public String actionTextName(){
    if(textName.getText() == null){
      throw new NullPointerException(
                      "Null Email in NewStudant");
    }if(textName.getText().trim().length() == 0){
      throw new  IllegalStateException();
    }
    return textName.getText();
  }
  public String actionTextBirthDate(){
    if(textBirthDate.getText() == null){
      throw new NullPointerException(
                      "Null Email in NewStudant");
    }if(textBirthDate.getText().trim().length() == 0){
      throw new  IllegalStateException();
    }
    return textBirthDate.getText();
  }
  public int actionTextRegister(){
    int register =  Integer.parseInt(textRegister.getText());
    if(textRegister.getText() == null){
      throw new NullPointerException(
                      "Null Email in NewStudant");
    }if(textRegister.getText().trim().length() == 0){
      throw new NumberFormatException();
    }
    return register;
  }
}
