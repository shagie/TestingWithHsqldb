package com.shagie.dbtest.servlet;

import com.shagie.dbtest.db.DataAccess;
import com.shagie.dbtest.db.objects.Data;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@javax.servlet.annotation.WebServlet("/")
public class Main extends HttpServlet {
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		DataAccess dao = new DataAccess();
		List<Data> datas = dao.getData();

		request.setAttribute("datas", datas);

		request.getRequestDispatcher("main.jsp").forward(request,response);
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		DataAccess dao = new DataAccess();
		List<Data> datas = dao.getData();

		request.setAttribute("datas", datas);

		request.getRequestDispatcher("main.jsp").forward(request,response);
	}
}
