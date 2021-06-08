package smbms.pojo;

public class Good_List {
    private int Lid;//对应goods中的Glist_id
    private String Lname;

    public Good_List() {
    }

    public Good_List(int lid, String lname) {
        Lid = lid;
        Lname = lname;
    }

    public int getLid() {
        return Lid;
    }

    public void setLid(int lid) {
        Lid = lid;
    }

    public String getLname() {
        return Lname;
    }

    public void setLname(String lname) {
        Lname = lname;
    }

    @Override
    public String toString() {
        return "Good_List{" +
                "Lid=" + Lid +
                ", Lname='" + Lname + '\'' +
                '}';
    }

}
