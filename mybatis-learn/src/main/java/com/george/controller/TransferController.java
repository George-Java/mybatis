package com.george.controller;

import com.george.service.TransferService;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;

@WebServlet(urlPatterns = "/transfer")
public class TransferController extends HttpServlet {
    public static Logger logger = LoggerFactory.getLogger(TransferController.class);

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //request.getSession().setAttribute("fromAccount", request.getParameter("fromAccount"));
        //request.getSession().setAttribute("toAccount", request.getParameter("toAccount"));
        //request.getSession().setAttribute("amount", Double.parseDouble(request.getParameter("amount")));
        //request.getRequestDispatcher("/transferService").forward(request, response);

        int fromAccountId = Integer.parseInt(request.getParameter("fromAccountId"));
        int toAccountId = Integer.parseInt(request.getParameter("toAccountId"));
        double amount = Double.parseDouble(request.getParameter("amount"));

        Cookie[] cookies = {new Cookie("fromAccountId", request.getParameter("fromAccountId")),
                new Cookie("toAccountId", request.getParameter("toAccountId")),
                new Cookie("amount", request.getParameter("amount"))};
        for (Cookie cookie : cookies) {
            cookie.setPath("/");
            cookie.setMaxAge(86400);
            response.addCookie(cookie);
        }

        TransferService transferService = new TransferService(fromAccountId, toAccountId, amount);
        int resultCode = transferService.transfer();
        if (resultCode == 0) {
            logger.info("转账成功!即将跳转到success.jsp");
            response.sendRedirect(request.getContextPath() + "/success.jsp");
        } else if (resultCode == -1) {
            response.sendRedirect(request.getContextPath() + "/error.jsp");
        } else {
            response.sendRedirect(request.getContextPath() + "/failed.jsp");
        }
    }
}
