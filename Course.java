import java.util.ArrayList;

public class Course{
  private String courseName;
  private int duration;
  private int workload;
  private int key;
  private DatabaseDisciplines disciplines;

  public Course(){}

  public Course(Course course){
    this.courseName = course.getCourseName();
    this.duration = course.getDuration();
    this.workload = course.getWorkload();
    this.key = course.getKey();
    this.disciplines = course.getDisciplines();
  }

  public Course(String courseName, int key, int workload, int duration){
    this.courseName = courseName;
    this.key = key;
    this.workload = workload;
    this.duration = duration;
    this.disciplines = new DatabaseDisciplines();
  }

  public void setCourseName(String courseName){
    this.courseName = courseName;
  }

  public String getCourseName(){
    return courseName;
  }

  public void setKey(int key){
    this.key = key;
  }

  public int getKey(){
    return key;
  }

  public void setDuration(int duration){
    this.duration = duration;
  }

  public int getDuration(){
    return duration;
  }

  public void setWorkload(int workload){
    this.workload = workload;
  }

  public int getWorkload(){
    return workload;
  }

  public void addDiscipline(int key, Discipline discipline){
    disciplines.addDiscipline(key, discipline);
  }

  /*public ArrayList<Discipline> listDisciplines(){
    return disciplines.listDisciplines();
  }*/

  /*public void surchDisciplineName(String name){
    disciplines.surchDisciplineName(name);
  }*/

  public void surchDisciplineKey(int key){
    disciplines.surchDisciplineKey(key);
  }

  /*public void removeDiscipline(String name){
    disciplines.removeDiscipline(name);
  }*/
	
  
  public void removeDiscipline(int key){
    disciplines.removeDiscipline(key);
  }
  
  public DatabaseDisciplines getDisciplines(){
    return this.disciplines;
  }

/*
  public void totalCredits(){}
  public void totalDisciplina(){}
  public void totalWorkload(){}
*/
}
