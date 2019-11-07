import java.util.ArrayList;
import java.util.Arrays;

public class Resume {

    private String name;
    private String email;
    ArrayList<Education> educationList;
    ArrayList<WorkExperience> workList;
    ArrayList<Skill> skillList;

    public Resume(){}
    public Resume(String name,
                  String email,
                  ArrayList<Education> educationList,
                  ArrayList<WorkExperience> workList,
                  ArrayList<Skill> skillList) {
        this.name = name;
        this.email = email;
        this.educationList = educationList;
        this.workList = workList;
        this.skillList = skillList;
    }

    public String displayText(){
        String str = "======================================================\n";
        str += name + "\n" + email + "\n";
        str += "\n\n* EDUCATION *\n";
        for (Education education : educationList) {
            str += education.displayText();
        }
        str += "\n\n* WORK EXPERIENCE *\n";
        for (WorkExperience work : workList) {
            str += work.displayText();
        }
        str += "\n\n* SKILLS *\n";
        for (Skill skill : skillList) {
            str += skill.displayText();
        }
        str += "======================================================\n";
        return str;
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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public ArrayList<Education> getEducationList() {
        return educationList;
    }

    public void setEducationList(ArrayList<Education> educationList) {
        this.educationList = educationList;
    }

    public ArrayList<WorkExperience> getWorkList() {
        return workList;
    }

    public void setWorkList(ArrayList<WorkExperience> workList) {
        this.workList = workList;
    }

    public ArrayList<Skill> getSkillList() {
        return skillList;
    }

    public void setSkillList(ArrayList<Skill> skillList) {
        this.skillList = skillList;
    }
}
