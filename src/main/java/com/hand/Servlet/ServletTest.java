package com.hand.Servlet;

import java.io.IOException;
import java.sql.Date;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.hand.beans.FilmBean;
import com.hand.beans.LanguageBean;
import com.hand.beans.UserBean;
import com.hand.service.ServiceAll;

/**
 * Servlet implementation class ServletTest
 */
public class ServletTest extends HttpServlet {
	private static final long serialVersionUID = 1L;

	ServiceAll service = new ServiceAll();

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public ServletTest() {
		super();
		// TODO Auto-generated constructor stub
	}

	@Override
	protected void service(HttpServletRequest arg0, HttpServletResponse arg1) throws ServletException, IOException {
		String action = arg0.getParameter("action");
		if ("loginCheck".equals(action)) {
			loginCheck(arg0, arg1);

		} else if ("filmList".equals(action)) {
			filmList(arg0, arg1);

		} else if ("filmAdd".equals(action)) {
			filmAdd(arg0, arg1);

		} else if ("filmDel".equals(action)) {
			filmDel(arg0, arg1);

		} else if ("filmUpdate".equals(action)) {
			filmUpdate(arg0, arg1);

		} else if ("add".equals(action)) {
			add(arg0, arg1);

		} else {
			doPost(arg0, arg1);
		}

	}

	private void filmUpdate(HttpServletRequest arg0, HttpServletResponse arg1) {
		int film_id = Integer.parseInt(arg0.getParameter("film_id"));
		FilmBean film = new FilmBean();

		film.setFilm_id(film_id);

		film = service.filmListById(film);
		List<LanguageBean> languagelist = service.languagelist();
		arg0.setAttribute("film", film);

		arg0.setAttribute("languagelist", languagelist);
		try {
			arg0.getRequestDispatcher("/update.jsp").forward(arg0, arg1);
		} catch (ServletException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

	@Override
	protected void doPost(HttpServletRequest arg0, HttpServletResponse arg1) throws ServletException, IOException {
		int film_id = Integer.parseInt(arg0.getParameter("film_id"));
		String title = arg0.getParameter("title");
		String language = arg0.getParameter("language");
		String description = arg0.getParameter("description");
		int language_id = Integer.parseInt(arg0.getParameter("language_id"));
		Date last_update = new Date(System.currentTimeMillis());
		FilmBean film = new FilmBean(film_id, title, description, language_id, last_update);
		service.filmUpdate(film);
		filmList(arg0, arg1);

	}

	private void filmDel(HttpServletRequest arg0, HttpServletResponse arg1) {
		int film_id = Integer.parseInt(arg0.getParameter("film_id"));
		FilmBean film = new FilmBean();
		film.setFilm_id(film_id);
		;
		service.filmDel(film);
		filmList(arg0, arg1);

	}

	private void filmAdd(HttpServletRequest arg0, HttpServletResponse arg1) {
		List<LanguageBean> languagelist = service.languagelist();
		arg0.setAttribute("languagelist", languagelist);
		try {
			arg0.getRequestDispatcher("/add.jsp").forward(arg0, arg1);
		} catch (ServletException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

	private void filmList(HttpServletRequest arg0, HttpServletResponse arg1) {
		List<FilmBean> filmList = service.filmList();
		arg0.setAttribute("filmList", filmList);
		// try {
		// arg0.getRequestDispatcher("/filmlist.jsp").forward(arg0, arg1);
		// } catch (ServletException e) {
		// e.printStackTrace();
		// } catch (IOException e) {
		// e.printStackTrace();
		// }
		try {
			arg1.sendRedirect(arg0.getContextPath() + "/filmlist.jsp");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	private void loginCheck(HttpServletRequest arg0, HttpServletResponse arg1) {
		String name = arg0.getParameter("name");
		UserBean user = new UserBean();
		user.setName(name);
		if (service.loginCheck(user)) {
			arg0.getSession().setAttribute("name", name);
		} else {
			arg0.setAttribute("msg", "ÓÃ»§Ãû´íÎó£¡µÇÂ½Ê§°Ü");
		}
		try {
			arg0.getRequestDispatcher("index.jsp").forward(arg0, arg1);
		} catch (ServletException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	private void add(HttpServletRequest arg0, HttpServletResponse arg1) {
		String title = arg0.getParameter("title");
		String description = arg0.getParameter("description");
		int language_id = Integer.parseInt(arg0.getParameter("language_id"));
		FilmBean film = new FilmBean();

		film.setTitle(title);
		film.setDescription(description);
		film.setLanguage_id(language_id);
		service.filmAdd(film);
		filmList(arg0, arg1);
	}

}
