package com.shagie.dbtest.servlet;

import com.shagie.dbtest.db.DataAccess;
import org.apache.commons.lang3.StringUtils;
import org.apache.log4j.Logger;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Map;

@WebServlet(name = "Add", value = "/add")
public class Add extends HttpServlet {
	private final static Logger LOG = Logger.getLogger(Add.class);

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException,
			IOException {
		Map<String, String[]> params;
		params = request.getParameterMap();
		addEntry(params.get("newvalue"));
		request.getRequestDispatcher("/").forward(request, response);
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException,
			IOException {
		Map<String, String[]> params;
		params = request.getParameterMap();
		addEntry(params.get("newvalue"));
		request.getRequestDispatcher("/").forward(request, response);
	}

	private void addEntry(String[] adds) {
		LOG.info("Adding: " + StringUtils.join(adds, ", "));
		DataAccess dao = new DataAccess();
		for (String add : adds) {
			dao.addData(add);
		}
	}

}
