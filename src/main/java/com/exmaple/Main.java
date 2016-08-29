package com.exmaple;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.ServletException;
import java.io.IOException;
import org.eclipse.jetty.server.Server;
import org.eclipse.jetty.server.Request;
import org.eclipse.jetty.server.handler.AbstractHandler;
import org.eclipse.jetty.server.handler.HandlerCollection;

public class Main{

    public static void main(String[] args) throws Exception
    {
        Server server = new Server(8080);

        MultipartConfigInjectionHandler multipartConfigInjectionHandler =
                new MultipartConfigInjectionHandler();

        HandlerCollection collection = new HandlerCollection();
        collection.addHandler(new ExampleHandler());

        multipartConfigInjectionHandler.setHandler(collection);

        server.setHandler(multipartConfigInjectionHandler);

        server.start();
        server.join();
    }
}