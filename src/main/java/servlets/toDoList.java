package servlets;

import org.hibernate.Query;
import org.hibernate.Session;

import javax.persistence.Entity;
import javax.persistence.EntityManager;
import javax.persistence.Id;
import javax.persistence.TypedQuery;
import java.sql.SQLException;


/**
 * Created by imaka_000 on 24.08.2016.
 */
@Entity
public class toDoList {
    @Id
    private Integer id;
    private String name;
    private String name_do;
    private String request;
    private static Session session;
public static void startSession(){
    session = HibernateClass.getSessionFactory().openSession();

    session.beginTransaction();

}
    public static String selectName() throws SQLException {
        startSession();
        //String hql100 = "SELECT name " + "FROM test";

        Query queryName = session.createQuery( "select name FROM toDoList ");

        String result ="";
        for(int i =0; i<queryName.list().size(); i++) {
            String number = i+1+". ";
            result = result  + number + queryName.list().get(i).toString() + "<br>";

        }

        return result;
    }
    public static String selectNameDo() throws SQLException {

        Query queryNameDo = session.createQuery( "select name_do FROM toDoList ");
        String result ="";
        for(int i =0; i<queryNameDo.list().size(); i++) {
            result = result + queryNameDo.list().get(i).toString() + "<br>";
        }
        return result;
        }

    public static String selectRequest() throws SQLException {

        Query queryRequest = session.createQuery( "select request FROM toDoList ");
        String result ="";
        for(int i =0; i<queryRequest.list().size(); i++) {
            result = result  + queryRequest.list().get(i).toString() + "<br>";

        }

        return result;
    }

    public static String selectNameYes() throws SQLException {
        startSession();
        //String hql100 = "SELECT name " + "FROM test";

        Query queryName = session.createQuery( "select name FROM toDoList where name_do='Выполнено'");

        String result ="";
        for(int i =0; i<queryName.list().size(); i++) {
            String number = i+1+". ";
            result = result  + number+ queryName.list().get(i).toString() + "<br>";

        }

        return result;
    }
    public static String selectNameDoYes() throws SQLException {

        Query queryNameDo = session.createQuery( "select name_do FROM toDoList where name_do='Выполнено'");
        String result ="";
        for(int i =0; i<queryNameDo.list().size(); i++) {
            result = result + queryNameDo.list().get(i).toString() + "<br>";
        }
        return result;
    }

    public static String selectRequestYes() throws SQLException {

        Query queryRequest = session.createQuery( "select request FROM toDoList where name_do='Выполнено'");
        String result ="";
        for(int i =0; i<queryRequest.list().size(); i++) {
            result = result  + queryRequest.list().get(i).toString() + "<br>";

        }

        return result;
    }

    public static String selectNameNo() throws SQLException {
        startSession();
        //String hql100 = "SELECT name " + "FROM test";

        Query queryName = session.createQuery( "select name FROM toDoList where name_do='Невыполнено'");

        String result ="";
        for(int i =0; i<queryName.list().size(); i++) {
            String number = i+1+". ";
            result = result  + number+ queryName.list().get(i).toString() + "<br>";

        }

        return result;
    }
    public static String selectNameDoNo() throws SQLException {

        Query queryNameDo = session.createQuery( "select name_do FROM toDoList where name_do='Невыполнено'");
        String result ="";
        for(int i =0; i<queryNameDo.list().size(); i++) {
            result = result + queryNameDo.list().get(i).toString() + "<br>";
        }
        return result;
    }

    public static String selectRequestNo() throws SQLException {

        Query queryRequest = session.createQuery( "select request FROM toDoList where name_do='Невыполнено'");
        String result ="";
        for(int i =0; i<queryRequest.list().size(); i++) {
            result = result  + queryRequest.list().get(i).toString() + "<br>";

        }

        return result;
    }

    public static String updateName() throws SQLException {
        startSession();
         Query queryRequest = session.createQuery( "select name FROM toDoList ");
        String result ="<option value='"+ queryRequest.list().get(0)+"'>" + queryRequest.list().get(0) + "</option>";
        for(int i =1; i<queryRequest.list().size(); i++) {
            result = result  + "<option value='"+ queryRequest.list().get(i)+"'>" + queryRequest.list().get(i) + "</option>";

        }
        return result;
    }

    public static void insertName(String name, String name_do, String request)  {


        Query queryName = session.createQuery( "select name FROM toDoList ");
        int k=0;
        for(int i =0; i<queryName.list().size(); i++) {
            if(queryName.list().get(i).toString().equals(name))
                k=1;
        }
        if(k==0) {
            toDoList sevl = new toDoList();
            sevl.setName(name);
            sevl.setName_do(name_do);
            sevl.setRequest(request);
            session.save(sevl);
            session.getTransaction().commit();
        }
    }
    public static void updateName(String name1, String name_do1, String request1)  {
        //startSession();
        Query queryId = session.createQuery( "select id FROM toDoList where name='"+name1+"'");
        toDoList updateStr = (toDoList) session.load(toDoList.class, Integer.parseInt(queryId.list().get(0).toString()));
        //System.out.println(number);
        updateStr.setName_do(name_do1);
        updateStr.setRequest(request1);

        session.update(updateStr);

        session.getTransaction().commit();
    }

    public toDoList() {

    }
    public Integer getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getName_do() {
        return name_do;
    }

    public String getRequest() {
        return request;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setName_do(String name_do) {
        this.name_do = name_do;
    }

    public void setRequest(String request) {
        this.request = request;
    }
}
