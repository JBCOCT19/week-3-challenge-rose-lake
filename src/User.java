import java.util.ArrayList;

public class User {

    int id;                         // up to 2+ billion possible, should be plenty!
    String name;
    ArrayList<Resume> resumes;

    public User() {}

    public User(int id, String name, ArrayList<Resume> resumes) {
        this.id = id;
        this.name = name;
        this.resumes = resumes;
    }

    //*************************
    // default getters/setters
    //*************************
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public ArrayList<Resume> getResumes() {
        return resumes;
    }

    public void setResumes(ArrayList<Resume> resumes) {
        this.resumes = resumes;
    }
}
