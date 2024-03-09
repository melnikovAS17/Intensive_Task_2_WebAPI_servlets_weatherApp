package ru.melnikov.Intensive.task.webAPI.servlets;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Сервлет - точка входа в приложение, создан для удобства пользования.
 */

@WebServlet("/start")
public class MainServlet extends HttpServlet {

    /**
     * При переходе по адресу '/start' пернаправляет клиента на Jsp страницу с кнопкаи - ссылками,
     * которые представляют функционал приложения (получние текущих показателей погоды/получение прогноза на 5 дней)
     */
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        getServletContext().getRequestDispatcher("/viewJsp/mainPage.jsp").forward(req, resp);
    }
}
