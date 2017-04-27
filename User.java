public class User{
  private String name;
  private int registration;
  private String birthDate;
  private String email;
  private String rg;
  private String cpf;

  public User(){}

  public User(User user){
    this.name = user.getName();
    this.rg = user.getRg();
    this.cpf = user.getCpf();
    this.registration = user.getRegistration();
    this.birthDate = user.getBirthDate();
    this.email = user.getEmail();
  }

  public User(String name, String rg, String cpf, int registration, String birthDate, String email){
    this.name = name;
    this.rg = rg;
    this.cpf = cpf;
    this.registration = registration;
    this.birthDate = birthDate;
    this.email = email;
  }

  public User(String name, String birthDate, int registration, String rg, String cpf, String email){
    this.name = name;
    this.birthDate = birthDate;
    this.rg = rg;
    this.cpf = cpf;
    this.registration = registration;
    this.email = email;
  }

  public User(String name, int registration, String birthDate, String rg, String cpf, String email){
    this.name = name;
    this.registration = registration;
    this.birthDate = birthDate;
    this.rg = rg;
    this.cpf = cpf;
    this.email = email;
  }

  public void setName(String name){
    this.name = name;
  }

  public String getName(){
	  return name;
  }

  public void setRegistration(int registration){
    this.registration = registration;
  }

  public int getRegistration(){
	  return registration;
  }

  public void setBirthDate(String birthDate){
    this.birthDate = birthDate;
  }

  public String getBirthDate(){
	  return birthDate;
  }

  public void setEmail(String email){
    this.email = email;
  }

  public String getEmail(){
	  return email;
  }

  public void setRg(String rg){
    this.rg = rg;
  }

  public String getRg(){
    return rg;
  }

  public void setCpf(String cpf){
    this.cpf = cpf;
  }

  public String getCpf(){
    return cpf;
  }
}
