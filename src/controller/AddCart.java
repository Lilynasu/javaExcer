package controller;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.AddCartLogic;
import model.Cart;

@WebServlet("/AddCart")
public class AddCart extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		request.setCharacterEncoding("UTF-8");
		String isbn = request.getParameter("isbn");

		//セッションスコープからカートを取得（取得できない場合はカードを作成）
		HttpSession session = request.getSession();
		Cart cart = (Cart) session.getAttribute("cart");
		if (cart == null) {
			cart = new Cart();
		}

		try {
			//カートに本を追加する処理を依頼
			AddCartLogic logic = new AddCartLogic();
			cart = logic.process(isbn, cart);

			//セッションスコープにカートを格納
			session.setAttribute("cart", cart);
			//HTMLを出力
			request.getRequestDispatcher("WEB-INF/AddCart.jsp").forward(request, response);
		} catch (SQLException e) {
			request.getRequestDispatcher("WEB-INF/SystemError.jsp").forward(request, response);
		}
	}

}
