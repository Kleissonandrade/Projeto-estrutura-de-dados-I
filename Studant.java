public class Studant extends User{
  private String address;
  private int tel;

  public Studant(){}

  public Studant(String name, String rg, String cpf, int registration, String birthDate, String email, int tel, String address){
    super(name, rg, cpf, registration, birthDate, email);
    this.tel = tel;
    this.address = address;
  }

  public Studant(String name, String birthDate, int registration, String rg, String cpf, String email, String address, int tel){
    super(name, birthDate, registration, rg, cpf, email);
    this.address = address;
    this.tel = tel;
  }

  public Studant(String name, int registration, String birthDate, String rg, String cpf, String email, int tel, String address){
    super(name, registration, birthDate, rg, cpf, email);
    this.tel = tel;
    this.address = address;
  }

  public void setAddress(String address){
    this.address = address;
  }

  public String getAddress(){
    return address;
  }

  public void setTel(int tel){
    this.tel = tel;
  }

  public int getTel(){
    return tel;
  }
}
