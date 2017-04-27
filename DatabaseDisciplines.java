//import java.util.ArrayList;
import java.util.Hashtable;

import java.lang.NullPointerException;

public class DatabaseDisciplines{
  //private ArrayList<Discipline> disciplines;
  private Hashtable<Integer, Discipline> disciplines;
  

  public DatabaseDisciplines(){
    //disciplines = new ArrayList<Discipline>();
    disciplines = new Hashtable<Integer, Discipline> ();
  }
  public void addDiscipline(int key, Discipline discipline){
	this.disciplines.put(key, discipline);
  }

  public Hashtable<Integer, Discipline> getDisciplines(){
    return this.disciplines;
  }
  
  public Discipline surchDisciplineKey(int key){
    Discipline discipline = this.disciplines.get(key);
    return discipline;
  }
  
  public void removeDiscipline(int key){
    this.disciplines.remove(key);
    }

  public Hashtable<Integer, Discipline> getDisciplinesCourse(){
	  return this.disciplines;
	  }
  /*public void addDiscipline(Discipline disc){
    disciplines.add(disc);
    System.out.println("salvou");
  }*/

  /*public ArrayList<Discipline> getDisciplines(){
    return disciplines;
  }*/

  /*public ArrayList<Discipline> listDisciplines(){
    ArrayList<Discipline> disciplinesList = new ArrayList<Discipline>();
    for(int i=0; i < disciplines.size(); i++ ){
      disciplinesList.add(disciplines.get(i));
    }
    return disciplinesList;
  }*/

  /*public Discipline surchDisciplineName(String disciplineName){
    for(int i=0; i < disciplines.size(); i++){

      if(disciplines.get(i).getDisciplineName().equals(disciplineName)){
       return disciplines.get(i);
      }
    }

    return null;

  }*/

  /*public Discipline surchDisciplineKey(int key){
    for(int i=0; i < disciplines.size(); i++){
      if(disciplines.get(i).getKey() == key){
        return disciplines.get(i);
      }
    }
    return null;
  }*/

  /*public void removeDiscipline(String disciplineName){
    for(int i=0; i < disciplines.size(); i++){
      if(disciplines.get(i).getDisciplineName().equals(disciplineName)){
        disciplines.remove(i);
      }else{
        throw new NullPointerException();
      }
    }*/
  

}
