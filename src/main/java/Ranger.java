public class Ranger {

    private int rangerBadgeNo;
    private  String rangerName;
    private String rangerEmail;

    public Ranger(String rangerName,int rangerBadgeNo,String rangerEmail){
        this.rangerName = rangerName;
        this.rangerBadgeNo = rangerBadgeNo;
        this.rangerEmail = rangerEmail;
    }

    public String getRangerName(){
        return rangerName;
    }
    public int getRangerBadgeNo(){
        return rangerBadgeNo;
    }
    public String getRangerEmail(){
        return rangerEmail;
    }

}
