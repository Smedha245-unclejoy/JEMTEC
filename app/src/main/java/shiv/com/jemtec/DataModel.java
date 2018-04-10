package shiv.com.jemtec;

/**
 * Created by medha singh on 4/11/2016.
 */
public class DataModel {
    String name;
    String email;
    String title;
    String surname;
    int id_;
    int image;

    public DataModel(String name, String email, int id_, String title,String surname) {
        this.name = name;
        this.title=title;
        this.id_ = id_;
        this.surname=surname;
        this.email=email;

    }

    public String getName() {
        return name;
    }


    public String getEmail(){
        return email;
    }

    public int getId() {
        return id_;
    }

    public String getTitle(){
        return title;
    }
    public String getSurname(){
        return surname;
    }
}
