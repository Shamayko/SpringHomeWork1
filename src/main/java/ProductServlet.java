import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;


@WebServlet(name = "ProductServlet", urlPatterns = "/product_servlet")
public class ProductServlet extends HttpServlet {
    private static Logger logger = LoggerFactory.getLogger(ProductServlet.class);

@Override
protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    resp.setContentType("text/html;charset=UTF-8");
    resp.getWriter().printf("<html><body>");
    for (int i = 0; i < 10; i++) {
        Product product = new Product(i, "Product " + i, (100 * i));
        resp.getWriter().printf(product.toString() + "<br>");
    }

    resp.getWriter().printf("</body></html>");
    resp.getWriter().close();
}

@Override
public void init() throws ServletException {
    logger.debug("Init");
}
}
