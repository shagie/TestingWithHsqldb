package com.shagie.dbtest.servlet;

import com.shagie.dbtest.db.DataAccess;
import com.shagie.dbtest.db.objects.Data;
import org.apache.log4j.Logger;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "main", value = "/")
public class Main extends HttpServlet {
	private final static Logger LOG = Logger.getLogger(Main.class);

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException,
			IOException {
		LOG.debug("entered Main doPost");
		DataAccess dao = new DataAccess();
		List<Data> datas = dao.getData();
		LOG.debug("got data");

		request.setAttribute("datas", datas);

		request.getRequestDispatcher("main.jsp").forward(request, response);
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException,
			IOException {
		LOG.debug("entered Main doGet");
		DataAccess dao = new DataAccess();
		List<Data> datas = dao.getData();
		LOG.debug("got data");

		request.setAttribute("datas", datas);

		request.getRequestDispatcher("main.jsp").forward(request, response);
	}
}
