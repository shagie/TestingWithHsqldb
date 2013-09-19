package com.shagie.dbtest.servlet;

import com.shagie.dbtest.db.DataAccess;
import org.apache.log4j.Logger;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Map;

@WebServlet(name = "Delete", value = "/delete")
public class Delete extends HttpServlet {
	private final static Logger LOG = Logger.getLogger(Delete.class);

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException,
			IOException {
		Map<String, String[]> params;
		params = request.getParameterMap();
		deleteEntry(params.get("id"));
		request.getRequestDispatcher("/").forward(request, response);
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException,
			IOException {
		Map<String, String[]> params;
		params = request.getParameterMap();
		deleteEntry(params.get("id"));
		request.getRequestDispatcher("/").forward(request, response);
	}

	private void deleteEntry(String[] deletes) {
		DataAccess dao = new DataAccess();
		for (String del : deletes) {
			LOG.info("Deleting id=" + del);
			dao.markInactive(Integer.parseInt(del));
		}
	}

}
