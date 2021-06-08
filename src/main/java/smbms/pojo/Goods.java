package smbms.pojo;


public class Goods {
    private int gid;//商品id
    private String gprice;//商品价格
    private String gname;//商品名称
    private String gurl;//商品url
    private int glist_id;//商品分类id
    private String gdesc;

    public Goods() {
    }

    public String getGdesc() {
        return gdesc;
    }

    public void setGdesc(String gdesc) {
        this.gdesc = gdesc;
    }

    @Override
    public String toString() {
        return "Goods{" +
                "gid=" + gid +
                ", gprice='" + gprice + '\'' +
                ", gname='" + gname + '\'' +
                ", gurl='" + gurl + '\'' +
                ", glist_id=" + glist_id +
                ", gdesc='" + gdesc + '\'' +
                '}';
    }

    public int getGid() {
        return gid;
    }

    public void setGid(int gid) {
        this.gid = gid;
    }

    public String getGprice() {
        return gprice;
    }

    public void setGprice(String gprice) {
        this.gprice = gprice;
    }

    public String getGname() {
        return gname;
    }

    public void setGname(String gname) {
        this.gname = gname;
    }

    public String getGurl() {
        return gurl;
    }

    public void setGurl(String gurl) {
        this.gurl = gurl;
    }

    public int getGlist_id() {
        return glist_id;
    }

    public void setGlist_id(int glist_id) {
        this.glist_id = glist_id;
    }

    public Goods(int gid, String gprice, String gname, String gurl, int glist_id, String gdesc) {
        this.gid = gid;
        this.gprice = gprice;
        this.gname = gname;
        this.gurl = gurl;
        this.glist_id = glist_id;
        this.gdesc = gdesc;
    }
}
