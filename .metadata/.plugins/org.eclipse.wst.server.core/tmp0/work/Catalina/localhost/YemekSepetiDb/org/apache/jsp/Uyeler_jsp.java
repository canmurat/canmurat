/*
 * Generated by the Jasper component of Apache Tomcat
 * Version: Apache Tomcat/7.0.50
 * Generated at: 2014-01-17 20:26:03 UTC
 * Note: The last modified time of this file was set to
 *       the last modified time of the source file after
 *       generation to assist with modification tracking.
 */
package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import com.sepetim.UyeClass;

public final class Uyeler_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent {

private static final long serialVersionUID = 1L;
	public String newuser;
	public String newusertekrar;
	public String passwd;
	public String passwdtekrar;
	public static String username = "";
	public String textarea;
	public String err = "alert(\"haydar\")";
	public Boolean uyeOlabilir = true;
	public String[] illegalKarakter;
	public String sonNot = ""; 
public boolean yasadisiKaraktervarmi(String toExamine) {
		String[] arr = toExamine.split("[~#@*+%{}<>\\[\\]|\"\\_^]", 2);
		return arr.length > 1;
	}
  private static final javax.servlet.jsp.JspFactory _jspxFactory =
          javax.servlet.jsp.JspFactory.getDefaultFactory();

  private static java.util.Map<java.lang.String,java.lang.Long> _jspx_dependants;

  private javax.el.ExpressionFactory _el_expressionfactory;
  private org.apache.tomcat.InstanceManager _jsp_instancemanager;

  public java.util.Map<java.lang.String,java.lang.Long> getDependants() {
    return _jspx_dependants;
  }

  public void _jspInit() {
    _el_expressionfactory = _jspxFactory.getJspApplicationContext(getServletConfig().getServletContext()).getExpressionFactory();
    _jsp_instancemanager = org.apache.jasper.runtime.InstanceManagerFactory.getInstanceManager(getServletConfig());
  }

  public void _jspDestroy() {
  }

  public void _jspService(final javax.servlet.http.HttpServletRequest request, final javax.servlet.http.HttpServletResponse response)
        throws java.io.IOException, javax.servlet.ServletException {

    final javax.servlet.jsp.PageContext pageContext;
    javax.servlet.http.HttpSession session = null;
    final javax.servlet.ServletContext application;
    final javax.servlet.ServletConfig config;
    javax.servlet.jsp.JspWriter out = null;
    final java.lang.Object page = this;
    javax.servlet.jsp.JspWriter _jspx_out = null;
    javax.servlet.jsp.PageContext _jspx_page_context = null;


    try {
      response.setContentType("text/html; charset=ISO-8859-1");
      pageContext = _jspxFactory.getPageContext(this, request, response,
      			null, true, 8192, true);
      _jspx_page_context = pageContext;
      application = pageContext.getServletContext();
      config = pageContext.getServletConfig();
      session = pageContext.getSession();
      out = pageContext.getOut();
      _jspx_out = out;

      out.write("\r\n");
      out.write("<!DOCTYPE html PUBLIC \"-//W3C//DTD HTML 4.01 Transitional//EN\" \"http://www.w3.org/TR/html4/loose.dtd\">\r\n");
      out.write("<html>\r\n");
      out.write("<head>\r\n");
      out.write("<meta http-equiv=\"Content-Type\" content=\"text/html; charset=ISO-8859-1\">\r\n");
      out.write("<title>Insert title here</title>\r\n");
      out.write("</head>\r\n");
      out.write("<body>\r\n");
      out.write("\r\n");
      out.write("</body>\r\n");
      out.write("</html>\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\t\r\n");
      out.write("\r\n");

	UyeClass uye = new UyeClass();

      out.write("\r\n");
      out.write("\r\n");
      out.write('\r');
      out.write('\n');

	newusertekrar = request.getParameter("usernametekrar");
	newuser = request.getParameter("username");
	passwd = request.getParameter("password");
	passwdtekrar = request.getParameter("passwordtekrar");
	
	
	RequestDispatcher r = getServletContext().getRequestDispatcher(
			"/GirisServlet");
	
	/*
	 * Uye Ol servlet'inden alinan bilgiler'in uyumlulugu ve dogruluklari
	 * test edilir.
	 */

	if (newusertekrar == null || newuser == null || passwd == null
			|| passwdtekrar == null) {
		sonNot += "<h2> Hic bir alan bos bÄ±rakÄ±lmamalÄ±dÄ±r ! </h2>\n";
		uyeOlabilir = false;
	}
	/*girilen kullanici isimlerinin eslesip eslesmeme sorgusu*/
	if (!newusertekrar.trim().equals(newuser.trim())) {

		sonNot +="<h3 id='h3'>Kullanici isimleri eslesmiyor.<h3>";
		uyeOlabilir = false;
	}
	/* Girilen kullanici isminde bir kullanici mevcut ise uyarÄ±lÄ±r. */
	if (uye.IsÄ±mBul(newuser)) {

		sonNot +="<h3>Girilen Kullanici adi kullanilmaktadir. !</h3>";
		uyeOlabilir = false;
	}
	/* Karakter sorgulamasÄ± */
	if (yasadisiKaraktervarmi(username)) {
		sonNot +="Kullanici ismi icin yanlis karakterler girdiniz ! \n"
				+ "[~#@*+%{}<>\\[\\]|\"\\_^] karakterlerinden herhangi birisi kullanÄ±lamaz !";
		uyeOlabilir = false;
	}
	/* Sifrelerin eslesip eslememe sorgusu */
	if (!passwdtekrar.equals(passwd)) {

		sonNot +="<h3 id='h3'>Sifreler eslesmiyor !</h3>";
		uyeOlabilir = false;

	}

	/* Sorun yok ise , girilen isimler kullanicilar.txt'e yazilir. */
	if (uyeOlabilir == true) {
		uye.UyeYaz(newuser, passwd);
		sonNot +="<h3 id='h3'>Uye oldun hadi hayirli olsun !</h3>";

	}

	r.include(request, response);

      out.write("\r\n");
      out.write("\r\n");
    } catch (java.lang.Throwable t) {
      if (!(t instanceof javax.servlet.jsp.SkipPageException)){
        out = _jspx_out;
        if (out != null && out.getBufferSize() != 0)
          try { out.clearBuffer(); } catch (java.io.IOException e) {}
        if (_jspx_page_context != null) _jspx_page_context.handlePageException(t);
        else throw new ServletException(t);
      }
    } finally {
      _jspxFactory.releasePageContext(_jspx_page_context);
    }
  }
}
