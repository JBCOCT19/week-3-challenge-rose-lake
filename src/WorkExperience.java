import java.util.ArrayList;

public class WorkExperience {

    private String title;
    private String company;
    private String startDate;
    private String endDate;
    private ArrayList<String> details;

    public WorkExperience(){}
    public WorkExperience(String title, String company, String startDate, String endDate, ArrayList<String> details) {
        this.title = title;
        this.company = company;
        this.startDate = startDate;
        this.endDate = endDate;
        this.details = details;
    }

    public String displayText(){
        String str = "";
        str += title + "\n" + company + ", " + startDate + " - " + endDate + "\n";
        for (String detail : details) {
            str += "- " + detail + "\n";
        }
        str += "\n";
        return str;
    }

    //*************************
    // default getters/setters
    //*************************
    public String getCompany() {
        return company;
    }

    public void setCompany(String company) {
        this.company = company;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getStartDate() {
        return startDate;
    }

    public void setStartDate(String startDate) {
        this.startDate = startDate;
    }

    public String getEndDate() {
        return endDate;
    }

    public void setEndDate(String endDate) {
        this.endDate = endDate;
    }

    public ArrayList<String> getDetails() {
        return details;
    }

    public void setDetails(ArrayList<String> details) {
        this.details = details;
    }
}
