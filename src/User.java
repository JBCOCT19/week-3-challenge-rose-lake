import java.util.ArrayList;

public class User {

    private String name;
    private ArrayList<Resume> resumes;

    public User() {}

    public User(String name, ArrayList<Resume> resumes) {
        this.name = name;
        this.resumes = resumes;
    }

    //**************************************************************************
    // this method adds a new Resume to this User's ArrayList<Resume> resumes
    //**************************************************************************
    public void addResume(Resume newResume) {
        resumes.add(newResume);
    }

    //*************************
    // default getters/setters
    //*************************
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
