package ru.ncedu.lab;

/**
 * Created by Саша on 04.11.2016.
 */

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Collection;
import java.util.Enumeration;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class SimpleServlet extends HttpServlet {

           private int number=0;
           public void numberSet(int number) {

               this.number=number;
           }
           public int numberGet(){

               return this.number;
           }
           private Classificator p;


    @Override
    public void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {

        this.process(req, resp);
    }

    @Override
    public void init() throws ServletException {
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("spring-classificator_20.xml");
        p = (Classificator) applicationContext.getBean("AllClassify");
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
        this.process(request, response);
    }

    private void process(HttpServletRequest request, HttpServletResponse response) throws IOException {
        response.setStatus(200);//Status code (200) indicating the request succeeded normally

        PrintWriter out = response.getWriter();
        //response.setContentType("text/plain");

        // Get the values of all request parameters
        Enumeration en = request.getParameterNames();
        while(en.hasMoreElements()) {
            // Get the name of the request parameter
            String name = (String)en.nextElement();
            out.println(name);

            // Get the value of the request parameter
            String value = request.getParameter(name);

            // If the request parameter can appear more than once in the query string, get all values
            String[] values = request.getParameterValues(name);

            for (int i=0; i<values.length; i++) {
                out.println(" " + values[i]+"(name="+name+")");
            }

            ///number=values[0]
            number=Integer.parseInt(values[0]);
            out.println("NUMBER="+p.classify(number));

        }
        out.close();
    }
}
