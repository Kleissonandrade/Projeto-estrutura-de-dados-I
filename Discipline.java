public class Discipline{
  private String disciplineName;
  private int credits;
  private int workload;
  private int key;
  private int require;

  public Discipline(String discipline, int key, int credits, int workload){
    this.disciplineName = discipline;
    this.key = key;
    this.credits = credits;
    this.workload = workload;
  }

  public Discipline(int key, String discipline, int credits, int workload){
    this.key = key;
    this.disciplineName = discipline;
    this.credits = credits;
    this.workload = workload;
  }

  public void setDisciplineName(String disciplineName){
    this.disciplineName = disciplineName;
  }

  public String getDisciplineName(){
    return disciplineName;
  }

  public void setCredits(int credits){
    this.credits = credits;
  }
  public int getCredits(){
    return credits;
  }

  public void setWorkload(int workload){
    this.workload = workload;
  }
  public int getWorkload(){
    return workload;
  }

  public void setKey(int key){
    this.key =key;
  }

  public int getKey(){
    return key;
  }
}
