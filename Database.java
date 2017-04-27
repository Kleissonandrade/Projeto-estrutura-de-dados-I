import java.util.ArrayList;
import java.util.Hashtable;
import java.util.LinkedList;


public class Database{
  private static LinkedList<Course> courses;
  private static ArrayList<Studant> studants;
  private static Hashtable<Integer, User> users;
  private static Hashtable<Integer, Classroom> classes;

  private static Database INSTANCE = new Database();


  public Database(){
     courses = new LinkedList<Course>();
     users = new Hashtable<Integer, User>();
     studants = new ArrayList<Studant>();
     classes = new Hashtable<Integer, Classroom>();
  }

  public static Database getInstance(){
    return INSTANCE;
  }

  // ----------------------------------------------------- Courses ---------------------------------------------------------
  
  public void addCourse(Course course){
    courses.add(course);
  }

  public LinkedList<Course> listCourses(){
    LinkedList<Course> coursesList = new LinkedList<Course>();
    for(int i=0; i < courses.size(); i++ ){
      coursesList.add(courses.get(i));
    }
    return coursesList;
  }


  public Course surchCourseName(String courseName){
    Course x = null;
    for(int i=0; i < courses.size(); i++){
      if(courses.get(i).getCourseName().equals(courseName)){
        x = courses.get(i);
        if(x == null){
          throw new NullPointerException();
        }
     }
    }
    return x;
  }  

  public void removeCourseName(String courseName){
    for(int i=0; i < courses.size(); i++){
      if(courses.get(i).getCourseName().equals(courseName)){
        courses.remove(i);
      }else{
        throw new NullPointerException();
      }
    }
  }

  // -------------------------------------------------- users -------------------------------------------------------

  public void addStudant(int key, Studant studant){
    users.put(key, studant);
  }

  public void addTeacher(int key, Teacher teacher){
    users.put(key, teacher);
  }

  public Hashtable<Integer, User> getUsers(){
    return this.users;
  }
  
  public User surchUserRegister(int register){
    User user = this.users.get(register);     
    return user;
  }
    
   public void removeUser(int register){
	this.users.remove(register);
   } 

  //-------------------------------------------------------------  Class --------------------------------------------------------

   public void addClass(int key, Classroom classroom){
    this.classes.put(key, classroom);
  }
 

  public Hashtable<Integer, Classroom> getClasses(){
    return this.classes;
  }
  
  public Classroom surchClassCod(int code){
    Classroom classroom = this.classes.get(code);     
    return classroom;
  }
    
   public void removeClass(int register){
	this.classes.remove(register);
   } 
 
  

}
