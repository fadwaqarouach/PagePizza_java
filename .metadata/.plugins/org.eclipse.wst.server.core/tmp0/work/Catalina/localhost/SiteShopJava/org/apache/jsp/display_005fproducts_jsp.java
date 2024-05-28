/*
 * Generated by the Jasper component of Apache Tomcat
 * Version: Apache Tomcat/10.1.20
 * Generated at: 2024-05-28 20:27:38 UTC
 * Note: The last modified time of this file was set to
 *       the last modified time of the source file after
 *       generation to assist with modification tracking.
 */
package org.apache.jsp;

import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.jsp.*;
import com.PIZZA.entities.Message;
import com.PIZZA.dao.UserDao;
import com.PIZZA.entities.Product;
import com.PIZZA.dao.ProductDao;
import com.PIZZA.entities.Admin;
import com.PIZZA.entities.Cart;
import com.PIZZA.dao.CartDao;
import com.PIZZA.entities.User;
import java.util.List;
import com.PIZZA.entities.Category;
import com.PIZZA.helper.ConnectionProvider;
import com.PIZZA.dao.CategoryDao;
import com.PIZZA.entities.Message;

public final class display_005fproducts_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent,
                 org.apache.jasper.runtime.JspSourceImports,
                 org.apache.jasper.runtime.JspSourceDirectives {

  private static final jakarta.servlet.jsp.JspFactory _jspxFactory =
          jakarta.servlet.jsp.JspFactory.getDefaultFactory();

  private static java.util.Map<java.lang.String,java.lang.Long> _jspx_dependants;

  static {
    _jspx_dependants = new java.util.HashMap<java.lang.String,java.lang.Long>(3);
    _jspx_dependants.put("/Components/alert_message.jsp", Long.valueOf(1716923181531L));
    _jspx_dependants.put("/Components/navbar.jsp", Long.valueOf(1716923141763L));
    _jspx_dependants.put("/Components/common_css_js.jsp", Long.valueOf(1714252115538L));
  }

  private static final java.util.Set<java.lang.String> _jspx_imports_packages;

  private static final java.util.Set<java.lang.String> _jspx_imports_classes;

  static {
    _jspx_imports_packages = new java.util.LinkedHashSet<>(3);
    _jspx_imports_packages.add("jakarta.servlet");
    _jspx_imports_packages.add("jakarta.servlet.http");
    _jspx_imports_packages.add("jakarta.servlet.jsp");
    _jspx_imports_classes = new java.util.LinkedHashSet<>(12);
    _jspx_imports_classes.add("com.PIZZA.entities.Product");
    _jspx_imports_classes.add("java.util.List");
    _jspx_imports_classes.add("com.PIZZA.dao.CategoryDao");
    _jspx_imports_classes.add("com.PIZZA.entities.Admin");
    _jspx_imports_classes.add("com.PIZZA.dao.UserDao");
    _jspx_imports_classes.add("com.PIZZA.entities.User");
    _jspx_imports_classes.add("com.PIZZA.dao.ProductDao");
    _jspx_imports_classes.add("com.PIZZA.dao.CartDao");
    _jspx_imports_classes.add("com.PIZZA.entities.Cart");
    _jspx_imports_classes.add("com.PIZZA.entities.Message");
    _jspx_imports_classes.add("com.PIZZA.entities.Category");
    _jspx_imports_classes.add("com.PIZZA.helper.ConnectionProvider");
  }

  private volatile jakarta.el.ExpressionFactory _el_expressionfactory;
  private volatile org.apache.tomcat.InstanceManager _jsp_instancemanager;

  public java.util.Map<java.lang.String,java.lang.Long> getDependants() {
    return _jspx_dependants;
  }

  public java.util.Set<java.lang.String> getPackageImports() {
    return _jspx_imports_packages;
  }

  public java.util.Set<java.lang.String> getClassImports() {
    return _jspx_imports_classes;
  }

  public boolean getErrorOnELNotFound() {
    return false;
  }

  public jakarta.el.ExpressionFactory _jsp_getExpressionFactory() {
    if (_el_expressionfactory == null) {
      synchronized (this) {
        if (_el_expressionfactory == null) {
          _el_expressionfactory = _jspxFactory.getJspApplicationContext(getServletConfig().getServletContext()).getExpressionFactory();
        }
      }
    }
    return _el_expressionfactory;
  }

  public org.apache.tomcat.InstanceManager _jsp_getInstanceManager() {
    if (_jsp_instancemanager == null) {
      synchronized (this) {
        if (_jsp_instancemanager == null) {
          _jsp_instancemanager = org.apache.jasper.runtime.InstanceManagerFactory.getInstanceManager(getServletConfig());
        }
      }
    }
    return _jsp_instancemanager;
  }

  public void _jspInit() {
  }

  public void _jspDestroy() {
  }

  public void _jspService(final jakarta.servlet.http.HttpServletRequest request, final jakarta.servlet.http.HttpServletResponse response)
      throws java.io.IOException, jakarta.servlet.ServletException {

    if (!jakarta.servlet.DispatcherType.ERROR.equals(request.getDispatcherType())) {
      final java.lang.String _jspx_method = request.getMethod();
      if ("OPTIONS".equals(_jspx_method)) {
        response.setHeader("Allow","GET, HEAD, POST, OPTIONS");
        return;
      }
      if (!"GET".equals(_jspx_method) && !"POST".equals(_jspx_method) && !"HEAD".equals(_jspx_method)) {
        response.setHeader("Allow","GET, HEAD, POST, OPTIONS");
        response.sendError(HttpServletResponse.SC_METHOD_NOT_ALLOWED, "Les JSPs ne permettent que GET, POST ou HEAD. Jasper permet aussi OPTIONS");
        return;
      }
    }

    final jakarta.servlet.jsp.PageContext pageContext;
    jakarta.servlet.http.HttpSession session = null;
    final jakarta.servlet.ServletContext application;
    final jakarta.servlet.ServletConfig config;
    jakarta.servlet.jsp.JspWriter out = null;
    final java.lang.Object page = this;
    jakarta.servlet.jsp.JspWriter _jspx_out = null;
    jakarta.servlet.jsp.PageContext _jspx_page_context = null;


    try {
      response.setContentType("text/html; charset=ISO-8859-1");
      pageContext = _jspxFactory.getPageContext(this, request, response,
      			"error_exception.jsp", true, 8192, true);
      _jspx_page_context = pageContext;
      application = pageContext.getServletContext();
      config = pageContext.getServletConfig();
      session = pageContext.getSession();
      out = pageContext.getOut();
      _jspx_out = out;

      out.write("\n");
      out.write("\n");
      out.write("	\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");

Admin activeAdmin = (Admin) session.getAttribute("activeAdmin");
if (activeAdmin == null) {
	Message message = new Message("You are not logged in! Login first!!", "error", "alert-danger");
	session.setAttribute("message", message);
	response.sendRedirect("adminlogin.jsp");
	return;
}
UserDao userDao = new UserDao(ConnectionProvider.getConnection());
ProductDao productDao = new ProductDao(ConnectionProvider.getConnection());

      out.write("\n");
      out.write("<!DOCTYPE html>\n");
      out.write("<html>\n");
      out.write("<head>\n");
      out.write("<meta charset=\"ISO-8859-1\">\n");
      out.write("<title>View Product's</title>\n");
      out.write("<!--CSS-->\n");
      out.write("<link href=\"https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css\" rel=\"stylesheet\" integrity=\"sha384-9ndCyUaIbzAi2FUVXJi0CjmCapSmO7SnpJef0486qhLnuZ2cdeRhO02iuK6FUUVM\" crossorigin=\"anonymous\">\n");
      out.write("<!--font awesome-->\n");
      out.write("<!--<link rel=\"stylesheet\" href=\"https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css\">\n");
      out.write("-->\n");
      out.write("<link rel=\"stylesheet\" href=\"https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.4.0/css/all.min.css\">\n");
      out.write("<link rel=\"stylesheet\" href=\"CSS/style.css\"/>\n");
      out.write("\n");
      out.write("\n");
      out.write("<!--JavaScript-->\n");
      out.write("<script src=\"https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/js/bootstrap.bundle.min.js\" integrity=\"sha384-geWF76RCwLtnZ8qwWowPQNguL3RmwHVBC9FhGdlKrxdiJJigb/j/68SIy3Te4Bkz\" crossorigin=\"anonymous\"></script>\n");
      out.write("<script src=\"JS/script.js\"></script>\n");
      out.write("\n");
      out.write("<!--jQuery-->\n");
      out.write("<script src=\"https://code.jquery.com/jquery-3.7.0.min.js\" integrity=\"sha256-2Pmvv0kuTBOenSvLm6bvfBSSHrUJ+3A7x6P5Ebd07/g=\" crossorigin=\"anonymous\"></script>\n");
      out.write("<!--sweet alert-->\n");
      out.write("<script src=\"https://unpkg.com/sweetalert/dist/sweetalert.min.js\"></script>\n");
      out.write("<script src=\"https://cdn.jsdelivr.net/npm/sweetalert2@11\"></script>");
      out.write("\n");
      out.write("</head>\n");
      out.write("<body>\n");
      out.write("	<!--navbar -->\n");
      out.write("	");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");

User user = (User) session.getAttribute("activeUser");
Admin admin = (Admin) session.getAttribute("activeAdmin");

CategoryDao catDao = new CategoryDao(ConnectionProvider.getConnection());
List<Category> categoryList = catDao.getAllCategories();

      out.write("\n");
      out.write("<style>\n");
      out.write(".navbar {\n");
      out.write("	font-weight: 500;\n");
      out.write("}\n");
      out.write("\n");
      out.write(".nav-link {\n");
      out.write("	color: rgb(255 255 255/ 100%) !important;\n");
      out.write("}\n");
      out.write("\n");
      out.write(".dropdown-menu {\n");
      out.write("	background-color: #ffffff !important;\n");
      out.write("	border-color: #949494;\n");
      out.write("}\n");
      out.write("\n");
      out.write(".dropdown-menu li a:hover {\n");
      out.write("	background-color: #808080 !important;\n");
      out.write("	color: white;\n");
      out.write("}\n");
      out.write("</style>\n");
      out.write("<nav class=\"navbar navbar-expand-lg custom-color\" data-bs-theme=\"dark\">\n");
      out.write("\n");
      out.write("	<!-- admin nav bar -->\n");
      out.write("	");

	if (admin != null) {
	
      out.write("\n");
      out.write("	<div class=\"container\">\n");
      out.write("		<a class=\"navbar-brand\" href=\"admin.jsp\"><i\n");
      out.write("			class=\"fa-sharp fa-solid fa-house\" style=\"color: #ffffff;\"></i>&ensp;QrShop</a>\n");
      out.write("		<button class=\"navbar-toggler\" type=\"button\" data-bs-toggle=\"collapse\"\n");
      out.write("			data-bs-target=\"#navbarSupportedContent\"\n");
      out.write("			aria-controls=\"navbarSupportedContent\" aria-expanded=\"false\"\n");
      out.write("			aria-label=\"Toggle navigation\">\n");
      out.write("			<span class=\"navbar-toggler-icon\"></span>\n");
      out.write("		</button>\n");
      out.write("		<div class=\"collapse navbar-collapse\" id=\"navbarSupportedContent\">\n");
      out.write("\n");
      out.write("			<div class=\"container text-end\">\n");
      out.write("				<ul class=\"navbar-nav justify-content-end\">\n");
      out.write("					<li class=\"nav-item\"><button type=\"button\"\n");
      out.write("							class=\"btn nav-link\" data-bs-toggle=\"modal\"\n");
      out.write("							data-bs-target=\"#add-category\"><i class=\"fa-solid fa-plus fa-xs\"></i>Add Category</button></li>\n");
      out.write("					<li class=\"nav-item\"><button type=\"button\"\n");
      out.write("							class=\"btn nav-link\" data-bs-toggle=\"modal\"\n");
      out.write("							data-bs-target=\"#add-product\"><i class=\"fa-solid fa-plus fa-xs\"></i>Add Product</button></li>\n");
      out.write("					<li class=\"nav-item\"><a class=\"nav-link\" aria-current=\"page\"\n");
      out.write("						href=\"admin.jsp\">");
      out.print(admin.getName());
      out.write("</a></li>\n");
      out.write("					<li class=\"nav-item\"><a class=\"nav-link\" aria-current=\"page\"\n");
      out.write("						href=\"LogoutServlet?user=admin\"><i\n");
      out.write("							class=\"fa-solid fa-user-slash fa-sm\" style=\"color: #fafafa;\"></i>&nbsp;Logout</a></li>\n");
      out.write("				</ul>\n");
      out.write("			</div>\n");
      out.write("		</div>\n");
      out.write("	</div>\n");
      out.write("	");

	} else {
	
      out.write("\n");
      out.write("\n");
      out.write("	<!-- end -->\n");
      out.write("\n");
      out.write("	<!-- for all -->\n");
      out.write("	<div class=\"container\">\n");
      out.write("		<a class=\"navbar-brand\" href=\"index.jsp\"><i\n");
      out.write("			class=\"fa-sharp fa-solid fa-house\" style=\"color: #ffffff;\"></i>&ensp;QrShop</a>\n");
      out.write("		<button class=\"navbar-toggler\" type=\"button\" data-bs-toggle=\"collapse\"\n");
      out.write("			data-bs-target=\"#navbarSupportedContent\"\n");
      out.write("			aria-controls=\"navbarSupportedContent\" aria-expanded=\"false\"\n");
      out.write("			aria-label=\"Toggle navigation\">\n");
      out.write("			<span class=\"navbar-toggler-icon\"></span>\n");
      out.write("		</button>\n");
      out.write("		<div class=\"collapse navbar-collapse\" id=\"navbarSupportedContent\">\n");
      out.write("			<ul class=\"navbar-nav me-auto mb-2 mb-lg-0\">\n");
      out.write("				<li class=\"nav-item\"><a class=\"nav-link\" href=\"products.jsp\"\n");
      out.write("					role=\"button\" aria-expanded=\"false\"> Products </a>\n");
      out.write("				<li class=\"nav-item dropdown\"><a\n");
      out.write("					class=\"nav-link dropdown-toggle\" href=\"#\" role=\"button\"\n");
      out.write("					data-bs-toggle=\"dropdown\" aria-expanded=\"false\"> Category </a>\n");
      out.write("					<ul class=\"dropdown-menu\">\n");
      out.write("						<li><a class=\"dropdown-item\" href=\"products.jsp?category=0\">All\n");
      out.write("								Products</a></li>\n");
      out.write("						");

						for (Category c : categoryList) {
						
      out.write("\n");
      out.write("						<li><a class=\"dropdown-item\"\n");
      out.write("							href=\"products.jsp?category=");
      out.print(c.getCategoryId());
      out.write('"');
      out.write('>');
      out.print(c.getCategoryName());
      out.write("</a></li>\n");
      out.write("						");

						}
						
      out.write("\n");
      out.write("					</ul></li>\n");
      out.write("			</ul>\n");
      out.write("			<form class=\"d-flex pe-5\" role=\"search\" action=\"products.jsp\"\n");
      out.write("				method=\"get\">\n");
      out.write("				<input name=\"search\" class=\"form-control me-2\" size=\"50\"\n");
      out.write("					type=\"search\" placeholder=\"Search for products\" aria-label=\"Search\"\n");
      out.write("					style=\"background-color: white !important;\">\n");
      out.write("				<button class=\"btn btn-outline-light\" type=\"submit\">Search</button>\n");
      out.write("			</form>\n");
      out.write("\n");
      out.write("			<!-- when user is logged in -->\n");
      out.write("			");

			if (user != null) {
				CartDao cartDao = new CartDao(ConnectionProvider.getConnection());
				int cartCount = cartDao.getCartCountByUserId(user.getUserId());
			
      out.write("\n");
      out.write("			<ul class=\"navbar-nav ml-auto\">\n");
      out.write("				<li class=\"nav-item active pe-3\"><a\n");
      out.write("					class=\"nav-link position-relative\" aria-current=\"page\"\n");
      out.write("					href=\"cart.jsp\"><i class=\"fa-solid fa-cart-shopping\"\n");
      out.write("						style=\"color: #ffffff;\"></i> &nbsp;Cart<span\n");
      out.write("						class=\"position-absolute top-1 start-0 translate-middle badge rounded-pill bg-danger\">");
      out.print(cartCount);
      out.write("</span></a></li>\n");
      out.write("				<li class=\"nav-item active pe-3\"><a class=\"nav-link\"\n");
      out.write("					aria-current=\"page\" href=\"profile.jsp\">");
      out.print(user.getUserName());
      out.write("</a></li>\n");
      out.write("				<li class=\"nav-item pe-3\"><a class=\"nav-link\"\n");
      out.write("					aria-current=\"page\" href=\"LogoutServlet?user=user\"><i\n");
      out.write("						class=\"fa-solid fa-user-slash\" style=\"color: #fafafa;\"></i>&nbsp;Logout</a></li>\n");
      out.write("			</ul>\n");
      out.write("			");

			} else {
			
      out.write("\n");
      out.write("			<ul class=\"navbar-nav ml-auto\">\n");
      out.write("				<li class=\"nav-item active pe-2\"><a class=\"nav-link\"\n");
      out.write("					aria-current=\"page\" href=\"register.jsp\"> <i\n");
      out.write("						class=\"fa-solid fa-user-plus\" style=\"color: #ffffff;\"></i>&nbsp;Register\n");
      out.write("				</a></li>\n");
      out.write("				<li class=\"nav-item pe-2\"><a class=\"nav-link\"\n");
      out.write("					aria-current=\"page\" href=\"login.jsp\"><i\n");
      out.write("						class=\"fa-solid fa-user-lock\" style=\"color: #fafafa;\"></i>&nbsp;Login</a></li>\n");
      out.write("				<li class=\"nav-item pe-2\"><a class=\"nav-link\"\n");
      out.write("					aria-current=\"page\" href=\"adminlogin.jsp\">&nbsp;Admin</a></li>\n");
      out.write("			</ul>\n");
      out.write("\n");
      out.write("		</div>\n");
      out.write("	</div>\n");
      out.write("	");

	}
	}
	
      out.write("\n");
      out.write("	<!-- end  -->\n");
      out.write("</nav>\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("	<!-- update product -->\n");
      out.write("	<div class=\"container mt-3\">\n");
      out.write("		");
      out.write('\n');

Message messg = (Message) session.getAttribute("message");
if (messg != null) {

      out.write("\n");
      out.write("<div class=\"alert ");
      out.print(messg.getCssClass());
      out.write("\" role=\"alert\" id=\"alert\">\n");
      out.write("	");
      out.print(messg.getMessage());
      out.write("\n");
      out.write("</div>\n");

session.removeAttribute("message");
}

      out.write("\n");
      out.write("<script type=\"text/javascript\">\n");
      out.write("	setTimeout(function() {\n");
      out.write("		$('#alert').alert('close');\n");
      out.write("	}, 3000);\n");
      out.write("</script>");
      out.write("\n");
      out.write("		<table class=\"table table-hover\">\n");
      out.write("			<tr class=\"table-primary text-center\" style=\"font-size: 20px;\">\n");
      out.write("				<th>Image</th>\n");
      out.write("				<th>Name</th>\n");
      out.write("				<th class=\"text-start\">Category</th>\n");
      out.write("				<th>Price</th>\n");
      out.write("				<th class=\"text-start\">Quantity</th>\n");
      out.write("				<th class=\"text-start\">Discount</th>\n");
      out.write("				<th>Action</th>\n");
      out.write("			</tr>\n");
      out.write("			");

			List<Product> productList = productDao.getAllProducts();
			for (Product prod : productList) {
				String category = catDao.getCategoryName(prod.getCategoryId());
			
      out.write("\n");
      out.write("			<tr class=\"text-center\">\n");
      out.write("				<td><img src=\"Product_imgs\\");
      out.print(prod.getProductImages());
      out.write("\"\n");
      out.write("					style=\"width: 60px; height: 60px; width: auto;\"></td>\n");
      out.write("				<td class=\"text-start\">");
      out.print(prod.getProductName());
      out.write("</td>\n");
      out.write("				<td>");
      out.print(category);
      out.write("</td>\n");
      out.write("				<td>&#8364;");
      out.print(prod.getProductPriceAfterDiscount());
      out.write("</td>\n");
      out.write("				<td>");
      out.print(prod.getProductQunatity());
      out.write("</td>\n");
      out.write("				<td>");
      out.print(prod.getProductDiscount());
      out.write("%</td>\n");
      out.write("				<td><a href=\"update_product.jsp?pid=");
      out.print(prod.getProductId());
      out.write("\" role=\"button\" class=\"btn btn-secondary\">Update</a>&emsp;<a\n");
      out.write("					href=\"AddOperationServlet?pid=");
      out.print(prod.getProductId());
      out.write("&operation=deleteProduct\"\n");
      out.write("					class=\"btn btn-danger\" role=\"button\">Delete</a></td>\n");
      out.write("			</tr>\n");
      out.write("			");

			}
			
      out.write("\n");
      out.write("		</table>\n");
      out.write("	</div>\n");
      out.write("</body>\n");
      out.write("</html>\n");
      out.write("\n");
    } catch (java.lang.Throwable t) {
      if (!(t instanceof jakarta.servlet.jsp.SkipPageException)){
        out = _jspx_out;
        if (out != null && out.getBufferSize() != 0)
          try {
            if (response.isCommitted()) {
              out.flush();
            } else {
              out.clearBuffer();
            }
          } catch (java.io.IOException e) {}
        if (_jspx_page_context != null) _jspx_page_context.handlePageException(t);
        else throw new ServletException(t);
      }
    } finally {
      _jspxFactory.releasePageContext(_jspx_page_context);
    }
  }
}