package servlets;

import org.hibernate.Session;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;

@WebServlet("/s")
public class MyServlet extends HttpServlet {



    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {


        String filtr = (String) request.getParameter("name_do1");
        try {
            if(filtr == null || filtr.equals("all")) {
                String queryName = toDoList.selectName();
                request.setAttribute("textA", queryName);
                String queryNameDo = toDoList.selectNameDo();
                request.setAttribute("textB", queryNameDo);
                String queryRequest = toDoList.selectRequest();
                request.setAttribute("textD", queryRequest);
            }
            else if(filtr.equals("yes"))
            {
                String queryName = toDoList.selectNameYes();
                request.setAttribute("textA", queryName);
                String queryNameDo = toDoList.selectNameDoYes();
                request.setAttribute("textB", queryNameDo);
                String queryRequest = toDoList.selectRequestYes();
                request.setAttribute("textD", queryRequest);
            }
            else if(filtr.equals("no"))
            {
                String queryName = toDoList.selectNameNo();
                request.setAttribute("textA", queryName);
                String queryNameDo = toDoList.selectNameDoNo();
                request.setAttribute("textB", queryNameDo);
                String queryRequest = toDoList.selectRequestNo();
                request.setAttribute("textD", queryRequest);
            }
            String query1 = toDoList.updateName();
            request.setAttribute("textC", query1);
        } catch (SQLException e) {

        }
        catch (NullPointerException e){

        }
        //String MyValue = new String(request.getParameter("MyParam");
        try{
        String name = new String (request.getParameter("name").getBytes("ISO-8859-1"),"utf-8");
        String name_do = new String (request.getParameter("name_do").getBytes("ISO-8859-1"),"utf-8");
        String request1 = new String (request.getParameter("request").getBytes("ISO-8859-1"),"utf-8");
            if(name!=null && name_do!=null && request1!=null) {
                toDoList.insertName(name, name_do, request1);
                String queryName = toDoList.selectName();
                request.setAttribute("textA", queryName);
                String queryNameDo = toDoList.selectNameDo();
                request.setAttribute("textB", queryNameDo);
                String queryRequest = toDoList.selectRequest();
                request.setAttribute("textD", queryRequest);
            }
        }
        catch (NullPointerException e){

        }
     catch (SQLException e) {

    }
        try{
            String name = new String (request.getParameter("name_update").getBytes("ISO-8859-1"),"utf-8");
            String name_do = new String (request.getParameter("name_do_update").getBytes("ISO-8859-1"),"utf-8");
            String request1 = new String (request.getParameter("request_update").getBytes("ISO-8859-1"),"utf-8");
            if(name!=null && name_do!=null && request1!=null) {
                toDoList.updateName(name, name_do, request1);
                String queryName = toDoList.selectName();
                request.setAttribute("textA", queryName);
                String queryNameDo = toDoList.selectNameDo();
                request.setAttribute("textB", queryNameDo);
                String queryRequest = toDoList.selectRequest();
                request.setAttribute("textD", queryRequest);
            }
        }
        catch (SQLException e){

        }
        catch(NullPointerException e)
        {

        }


        RequestDispatcher dispatcher = request.getRequestDispatcher("/index.jsp");
        dispatcher.forward(request, response);


    }


}
