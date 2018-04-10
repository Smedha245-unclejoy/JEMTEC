package shiv.com.jemtec;

/**
 * Created by SHIVAM on 2/14/2016.
 */
public class Jims {
    private int sno;
    private String notice;
    private String date;
    public Jims(int sno, String notice, String date)
    {
        this.setSno(sno);
        this.setNotice(notice);
        this.setDate(date);
    }
    public int getSno() {
        return sno;
    }

    public void setSno(int sno) {
        this.sno = sno;
    }

    public String getNotice() {
        return notice;
    }

    public void setNotice(String notice) {
        this.notice = notice;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }
}

