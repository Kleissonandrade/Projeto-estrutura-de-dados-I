import javax.swing.*;
import java.awt.event.*;
import java.awt.*;
import java.lang.NullPointerException;
import java.lang.IllegalStateException;
import java.lang.NumberFormatException;


public class ViewNewAluno extends JFrame{
  private JLabel labelTel;
  private JLabel labelRegister;
  private JLabel labelBirthDate;
  private JLabel labelCpf;
  private JLabel labelEmail;
  private JLabel labelRg;
  private JLabel labelName;
  private JLabel title;
  private JLabel labelEndereco;
  private JTextField textCpf;
  private JTextField textEndereco;
  private JTextField textTel;
  private JTextField textRegister;
  private JTextField textRg;
  private JTextField textName;
  private JTextField textBirthDate;
  private JTextField textEmail;

  private JButton buttonCadastrar;
  private JButton buttonCancelar;

  public ViewNewAluno() {
        initializeComponents();
    }

  private void initializeComponents(){
    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    getContentPane().setLayout(null);

    title = new JLabel("Cadastro de Aluno");
    getContentPane().add(title);
    title.setBounds(370, 30, 300, 73);
    title.setFont(new Font("Ubuntu", 0, 36));

    labelTel = new JLabel("Telefone:");
    getContentPane().add(labelTel);
    labelTel.setBounds(570, 260, 80, 18);

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

    labelEndereco = new JLabel("Endereço:");
    getContentPane().add(labelEndereco);
    labelEndereco.setBounds(40, 310, 90, 21);


    textCpf = new JTextField();
    getContentPane().add(textCpf);
    textCpf.setBounds(670, 160, 160, 28);

    textCpf.addActionListener(new ActionListener(){
      public void actionPerformed(ActionEvent e){
        actionTextCpf();
      }
    });

    textEndereco = new JTextField();
    getContentPane().add(textEndereco);
    textEndereco.setBounds(130, 310, 550, 28);

    textEndereco.addActionListener(new ActionListener(){
      public void actionPerformed(ActionEvent e){
        actionTextEndereco();
      }
    });

    textTel = new JTextField();
    getContentPane().add(textTel);
    textTel.setBounds(650, 260, 180, 28);

    textTel.addActionListener(new ActionListener(){
      public void actionPerformed(ActionEvent e){
        actionTextTel();
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
    ViewNewAluno newAluno = new ViewNewAluno();
    newAluno.setVisible(true);
    newAluno.setSize(1057, 562);
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
		Studant studant = new Studant(actionTextName(), actionTextRg(), actionTextCpf(),
        actionTextRegister(), actionTextBirthDate(), actionTextEmail(), actionTextTel(), actionTextEndereco());	
        
        database.addStudant(studant.getRegistration(), studant);
        JOptionPane.showMessageDialog(null, "OK!");
        
      }catch(NullPointerException x){
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
        if(textEndereco.getText().trim().length() == 0){
          JOptionPane.showMessageDialog(null, "Campo Endereço vazio!");
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
        if(textTel.getText().trim().length() == 0){
          JOptionPane.showMessageDialog(null, "Campo Telefone vazio!");
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

  public int actionTextTel(){
    int tel = Integer.parseInt(textTel.getText());
    if(textTel.getText() == null){
      throw new NullPointerException(
                      "Null Email in NewStudant");
    }if(textTel.getText().trim().length() == 0){
      throw new NumberFormatException();
    }
    return tel;
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
    int register = Integer.parseInt(textRegister.getText());
    if(textRegister.getText() == null){
      throw new NullPointerException(
                      "Null Email in NewStudant");
    }if(textRegister.getText().trim().length() == 0){
      throw new NumberFormatException();
    }
    return register;
  }

  public String actionTextEndereco(){
    if(textEndereco.getText() == null){
      throw new NullPointerException(
                      "Null Email in NewStudant");
    }if(textEndereco.getText().trim().length() == 0){
      throw new  IllegalStateException();
    }
    return textEndereco.getText();
  }

}
