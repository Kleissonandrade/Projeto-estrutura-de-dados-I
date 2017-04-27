public class Teacher extends User{
  private String formation;

  public Teacher(String name, String rg, String cpf, int registration, String birthDate, String email, String formation){
    super(name, rg, cpf, registration, birthDate, email);
    this.formation = formation;
  }

  public void setFormation(String formation){
    this.formation = formation;
  }

  public String getFormation(){
    return formation;
  }
}
