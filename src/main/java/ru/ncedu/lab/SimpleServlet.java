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
import java.util.Enumeration;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
       // import static org.springframework.util.StringUtils.*;
public class SimpleServlet extends HttpServlet {

           private String responseTemplate =
            "<html>\n" +
                    "<body>\n" +
                    "<h2>Hello from Simple Servlet</h2>\n" +
                    "</body>\n" +
                    "</html>";
           private int number=0;

           public void numberSet(int number) {
               this.number=number;
           }
           public int numberGet(){
               return this.number;
           }
    @Override
    public void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {

        this.process(req, resp);
//        PrintWriter out = resp.getWriter();
//
//        out.println("Hi there!\n");
//
//        //resp.setStatus(222);
//
//        Map<String, String[]> params = req.getParameterMap();
//        if (!params.isEmpty()) {
//            out.println("Params:");
//           // for (String key: params.keySet())
//                //out.println(key + ": " + arrayToDelimitedString(params.get(key), ", "));

  //      }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
        this.process(request, response);
    }

    private void process(HttpServletRequest request, HttpServletResponse response) throws IOException {
//        response.setStatus(200);
//        response.getWriter().write(responseTemplate);
        response.setStatus(200);//Status code (200) indicating the request succeeded normally


        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("spring-classificator_20.xml");
        Classificator p1 = (Classificator) applicationContext.getBean("firsClassificator");
        Classificator p2 = (Classificator) applicationContext.getBean("secondClassificator");
        Classificator p3 = (Classificator) applicationContext.getBean("thirdClassificator");






        PrintWriter out = response.getWriter();
        response.setContentType("text/plain");

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
            out.println("NUMBER="+values[0]+"  "+p1.classify(number)+"  "+p2.classify(number)+"   "+p3.classify(number));

        }
        out.close();
    }
}
