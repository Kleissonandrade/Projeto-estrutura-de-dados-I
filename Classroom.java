import java.util.ArrayList;

public class Classroom{
  private int number;
  private String discipline;
  private DatabaseStudants studants;

  public Classroom(int number, String discipline){
    this.number = number;
    this.discipline = discipline;
    this.studants = new DatabaseStudants();
  }

  public Classroom(Classroom classroom){
    this.number = classroom.getNumber();
    this.discipline = classroom.getDiscipline();
    this.studants = classroom.getStudants();
  }

  public void setNumber(int number){
    this.number = number;
  }

  public int getNumber(){
    return number;
  }

  public void setDiscipline(String discipline){
    this.discipline = discipline;
  }

  public String getDiscipline(){
    return discipline;
  }

  public void addStudant(User studant){
    this.studants.addStudant(studant);
  }

  public User surchStudant(int cod){
    return studants.surchStudantRegistration(cod);
  }

  public ArrayList<User> listStudants(){
    return studants.listStudants();
  }

  public void removeStudantClass(int registration){
    studants.removeStudantClass(registration);
  }

  public DatabaseStudants getStudants(){
    return this.studants;
  }

}
