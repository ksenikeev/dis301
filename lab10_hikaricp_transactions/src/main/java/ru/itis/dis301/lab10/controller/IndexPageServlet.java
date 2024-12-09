package ru.itis.dis301.lab10.controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import ru.itis.dis301.lab10.model.Client;
import ru.itis.dis301.lab10.model.ClientInfo;
import ru.itis.dis301.lab10.service.ClientService;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@WebServlet("/index")
public class IndexPageServlet extends HttpServlet {

    final static Logger logger = LogManager.getLogger(IndexPageServlet.class);

    private ClientService service = new ClientService();

    public void doGet(HttpServletRequest request, HttpServletResponse response) {
        try{

            ClientInfo clientInfo = new ClientInfo();
            clientInfo.setAddress("Казань");
            clientInfo.setPassport("9202 2342342");
            clientInfo.setPhone("+791028723");

            Client client = new Client();
            client.setClientInfo(clientInfo);
            client.setName("User");
            client.setEmail("user@masd.ru");

            service.save(client);

            List<Client> clients = new ArrayList<>();
            request.setAttribute("clients", clients);

            request.getRequestDispatcher("index.ftl").forward(request, response);

        } catch (IOException e) {
            logger.error(e);
        } catch (ServletException e) {
            logger.error(e);
        }


    }

}
