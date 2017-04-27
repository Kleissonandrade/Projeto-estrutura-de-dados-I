import java.util.ArrayList;

public class DatabaseStudants{
  private ArrayList<User> studants;

  public DatabaseStudants(){
    studants = new ArrayList<User>();
  }

  public void addStudant(User studant){
    studants.add(studant);
    System.out.println("salvou");
  }

  public ArrayList<User> getStudants(){
    return this.studants;
  }

  public ArrayList<User> listStudants(){
    ArrayList<User> studantsList = new ArrayList<User>();
    for(int i=0; i < studants.size(); i++ ){
      studantsList.add(studants.get(i));
    }
    return studantsList;
  }

  public User surchStudantName(String studantName){
    User studant = null;
    for(int i=0; i < studants.size(); i++){

      if(studants.get(i).getName().equals(studantName)){
       studant = studants.get(i);
      }
    }
    return studant;
  }

  public User surchStudantRegistration(int registration){
    User studant = null;
    for(int i=0; i < studants.size(); i++){
      if(studants.get(i) instanceof User){
        if(studants.get(i).getRegistration() == registration){
          studant = studants.get(i);
          System.out.println(studant.getName() + "foi removido");
        }
      }
    }
    return studant;
  }

  public void removeStudantClass(int registration){
    for(int i=0; i < studants.size(); i++){
      if(this.studants.get(i).getRegistration() == registration){

        this.studants.remove(i);
      }else{
        throw new NullPointerException();
      }
    }
  }

}
