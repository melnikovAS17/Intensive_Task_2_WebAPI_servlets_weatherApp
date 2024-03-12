package ru.melnikov.Intensive.task.webAPI.servlets;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import java.io.IOException;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class GetCurrentWeatherByCityNameServletTest { //TODO !ServletConfig has not been initialized!
    String path = "/viewJsp/formForSelectionCity.jsp";
    GetCurrentWeatherByCityNameServlet servlet;

    @BeforeEach
    public void init(){
        servlet = new GetCurrentWeatherByCityNameServlet();
    }

    @Test
    public void doGet_whenCalledMethod_TheRequestShouldBeForwardedToJsp() throws ServletException, IOException {
        HttpServletRequest request = mock(HttpServletRequest.class);
        HttpServletResponse response = mock(HttpServletResponse.class);
        RequestDispatcher dispatcher = mock(RequestDispatcher.class);

        servlet.doGet(request,response);

        when(request.getRequestDispatcher(path)).thenReturn(dispatcher);

        verify(request, times(1)).getRequestDispatcher(path);
        verify(dispatcher).forward(request, response);
    }

}