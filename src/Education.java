public class Education {

    private String degree;
    private String major;
    private String university;
    private int graduationYear;

    public Education(){}
    public Education(String degree, String major, String university, int graduationYear){
        this.degree = degree;
        this.major = major;
        this.university = university;
        this.graduationYear = graduationYear;
    }

    public String displayText(){
        return degree + " in " + major + "\n" + university + ", " + graduationYear + "\n\n";
    }


    //*************************
    // default getters/setters
    //*************************

    public String getDegree() {
        return degree;
    }

    public void setDegree(String degree) {
        this.degree = degree;
    }

    public String getMajor() {
        return major;
    }

    public void setMajor(String major) {
        this.major = major;
    }

    public String getUniversity() {
        return university;
    }

    public void setUniversity(String university) {
        this.university = university;
    }

    public int getGraduationYear() {
        return graduationYear;
    }

    public void setGraduationYear(int graduationYear) {
        this.graduationYear = graduationYear;
    }
}
