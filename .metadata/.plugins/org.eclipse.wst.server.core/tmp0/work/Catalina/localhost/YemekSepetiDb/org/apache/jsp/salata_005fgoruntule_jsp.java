/*
 * Generated by the Jasper component of Apache Tomcat
 * Version: Apache Tomcat/7.0.50
 * Generated at: 2014-01-31 13:05:17 UTC
 * Note: The last modified time of this file was set to
 *       the last modified time of the source file after
 *       generation to assist with modification tracking.
 */
package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import java.util.*;
import java.sql.*;;

public final class salata_005fgoruntule_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent {

  private static final javax.servlet.jsp.JspFactory _jspxFactory =
          javax.servlet.jsp.JspFactory.getDefaultFactory();

  private static java.util.Map<java.lang.String,java.lang.Long> _jspx_dependants;

  static {
    _jspx_dependants = new java.util.HashMap<java.lang.String,java.lang.Long>(2);
    _jspx_dependants.put("/include/common.jsp", Long.valueOf(1391171880204L));
    _jspx_dependants.put("/include/./database.jsp", Long.valueOf(1390919848595L));
  }

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
      response.setContentType("text/html");
      pageContext = _jspxFactory.getPageContext(this, request, response,
      			null, true, 8192, true);
      _jspx_page_context = pageContext;
      application = pageContext.getServletContext();
      config = pageContext.getServletConfig();
      session = pageContext.getSession();
      out = pageContext.getOut();
      _jspx_out = out;

      out.write("\r\n");
      out.write("\r\n");

	
	String url = "jdbc:sqlserver://localhost:1433;databaseName=YemekSepeti;user=mehmet;password=1234567";
	Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
	Connection con = DriverManager.getConnection(url);

	Statement stmt = con.createStatement();
	Statement stmt1 = con.createStatement();
	Statement stmt2 = con.createStatement();
	Statement stmt3 = con.createStatement();
	Statement stmt4 = con.createStatement();
	Statement stmt5 = con.createStatement();

	ResultSet rs, rs1, rs2, rs3, rs4, rs5;

	PreparedStatement pstmt, pstmt1, pstmt2, pstmt3, pstmt4, pstmt5;

      out.write("\r\n");
      out.write("\r\n");

	String yemekAd = "", yemekFiyat1 = "", urun1 = "", yemekId1 = "", guncel_yemek = "";
	String icecekAd = "", icecekFiyat1 = "", urun2 = "", icecekId1 = "", guncel_icecek = "";
	String salataAd = "", salataFiyat1 = "", urun3 = "", salataId1 = "", guncel_salata = "";
	String tatliAd = "", tatliFiyat1 = "", urun4 = "", tatliId1 = "", guncel_tatli = "";
	String yemegi_sil = "", icecegi_sil = "", salatayi_sil = "", tatliyi_sil = "", kullanici_sil = "", urunu_sil = "";
	String Ad = "", Soyad = "", DTarih = "", Adres = "", EPosta = "", guncel_kullanici = "";
	String KullaniciId1 = "", Tel1 = "", Sifre1 = "", Para1 = "", KrediKartNo1 = "", Admin1 = "", kullanici = "";

	String sepet_yemek_sil ="", sepet_icecek_sil="", sepet_salata_sil="", sepet_tatli_sil=""; 
	String timeStamp = "";
	int yemekId = 0, yemekFiyat = 0, icecekId = 0, icecekFiyat = 0, salataId = 0, salataFiyat = 0, tatliId = 0, tatliFiyat = 0,geneltoplam=0;
	int KullaniciId = 0, Para = 0, Admin = 0, SiparisId1 = 0;
	long Tel = 0, KrediKartNo = 0, Sifre = 0;

	String alinanyemekler = "", alinanicecekler = "", alinansalatalar = "", alinantatlilar = "";
	String yemekleradet = "", icecekleradet = "",salatalaradet="", tatlilaradet = "";
	int yemeklertoplam = 0, iceceklertoplam = 0, salatalartoplam = 0, tatlilartoplam = 0, toplamtutar = 0;
	
	String yemeklertoplam1="",iceceklertoplam1="",salatalartoplam1="",tatlilartoplam1="";
	
	String SiparisleriAl = "SiparisleriAl";

	String SiparisId = "", Yemekler = "", Icecekler = "", Salatalar = "", Tatlilar = "";

	int x=0;

	

      out.write('\r');
      out.write('\n');
      out.write("\r\n");
      out.write("\r\n");
      out.write("<!DOCTYPE html PUBLIC \"-//W3C//DTD XHTML 1.0 Strict//EN\" \"http://www.w3.org/TR/xhtml1/DTD/xhtml1-strict.dtd\">\r\n");
      out.write("<html xmlns=\"http://www.w3.org/1999/xhtml\" xml:lang=\"en\" lang=\"en\">\r\n");
      out.write("<head>\r\n");
      out.write("<script type=\"text/javascript\">\r\n");
      out.write("\tfunction del() {\r\n");
      out.write("\t\tif (confirm(\"SalatayÄ± silmek istediginizden emin misiniz ?\")) {\r\n");
      out.write("\t\t} else {\r\n");
      out.write("\t\t\treturn false;\r\n");
      out.write("\t\t}\r\n");
      out.write("\t}\r\n");
      out.write("</script>\r\n");
      out.write("<meta http-equiv=\"Content-Type\" content=\"text/html; charset=utf-8\" />\r\n");
      out.write("<title></title>\r\n");
      out.write("<link href=\"bootstrap/css/bootstrap.css\" rel=\"stylesheet\"\r\n");
      out.write("\ttype=\"text/css\" />\r\n");
      out.write("<link href=\"bootstrap/css/bootstrap.min.css\" rel=\"stylesheet\"\r\n");
      out.write("\ttype=\"text/css\" />\r\n");
      out.write("<link href=\"bootstrap/css/bootstrap-responsive.css\" rel=\"stylesheet\"\r\n");
      out.write("\ttype=\"text/css\" />\r\n");
      out.write("<link href=\"bootstrap/css/bootstrap-responsive.min.css\" rel=\"stylesheet\"\r\n");
      out.write("\ttype=\"text/css\" />\r\n");
      out.write("<link href=\"css/styles.css\" rel=\"stylesheet\" type=\"text/css\" />\r\n");
      out.write("</head>\r\n");
      out.write("<body>\r\n");
      out.write("\t");

		salataId1 = request.getParameter("salataId");
		if (salataId1 != null)
			salataId = Integer.parseInt(salataId1);
		salatayi_sil = request.getParameter("salatayi_sil");

		if ("yes".equals(salatayi_sil)) {
			salataAd = request.getParameter("salataAd");
			x = stmt1
					.executeUpdate("Delete from salatalar where Id="
							+ salataId);
		}
	
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\t<h2>SALATALAR</h2>\r\n");
      out.write("\r\n");
      out.write("\t<table width=\"736\" height=\"97\" border=\"1\" class=\"table table-bordered\">\r\n");
      out.write("\t\t");

			if (x == 1) {
		
      out.write("\r\n");
      out.write("\t\t<tr bgcolor=\"#000000\">\r\n");
      out.write("\t\t\t<th height=\"35\" colspan=\"9\"><div align=\"center\">\r\n");
      out.write("\t\t\t\t\tSalata (");
      out.print(salataAd);
      out.write(") basari ile silindi.\r\n");
      out.write("\t\t\t\t</div></th>\r\n");
      out.write("\t\t</tr>\r\n");
      out.write("\t\t");

			}
		
      out.write("\r\n");
      out.write("\t\t<tr bgcolor=\"Yellow\">\r\n");
      out.write("\t\t\t<td><div align=\"center\">\r\n");
      out.write("\t\t\t\t\t<strong>SALATA ID</strong>\r\n");
      out.write("\t\t\t\t</div></td>\r\n");
      out.write("\t\t\t<td><div align=\"center\">\r\n");
      out.write("\t\t\t\t\t<strong>SALATA ADI</strong>\r\n");
      out.write("\t\t\t\t</div></td>\r\n");
      out.write("\t\t\t<td><div align=\"center\">\r\n");
      out.write("\t\t\t\t\t<strong>SALATA FIYATI (TL)</strong>\r\n");
      out.write("\t\t\t\t</div></td>\r\n");
      out.write("\t\t\t\r\n");
      out.write("\t\t</tr>\r\n");
      out.write("\t\t");

			int icount = 0;
			rs = stmt.executeQuery("select * from salatalar");
			while (rs.next()) {
				salataAd = rs.getString("Ad");
				salataFiyat = rs.getInt("Fiyat");
				salataId = rs.getInt("Id");
				
		
      out.write("\r\n");
      out.write("\t\t<tr>\r\n");
      out.write("\t\t\t<td><div align=\"center\">\r\n");
      out.write("\t\t\t");
      out.print(salataId);
      out.write("</div></td>\r\n");
      out.write("\t\t\t<td>");
      out.print(salataAd);
      out.write("</td>\r\n");
      out.write("\t\t\t<td>");
      out.print(salataFiyat);
      out.write("</td>\r\n");
      out.write("\t\t\t\r\n");
      out.write("\t\t\t<td><div align=\"center\">\r\n");
      out.write("\t\t\t\t\t<a href=\"salata_duzenle.jsp?salataId=");
      out.print(salataId);
      out.write("\">Edit</a>\r\n");
      out.write("\t\t\t\t</div></td>\r\n");
      out.write("\t\t\t<td><div align=\"center\">\r\n");
      out.write("\t\t\t\t\t<a\r\n");
      out.write("\t\t\t\t\t\thref=\"salata_goruntule.jsp?salatayi_sil=yes&salataId=");
      out.print(salataId);
      out.write("&salataAd=");
      out.print(salataAd);
      out.write("\"\r\n");
      out.write("\t\t\t\t\t\tonclick=\"return del()\">Delete</a>\r\n");
      out.write("\t\t\t\t</div></td>\r\n");
      out.write("\t\t</tr>\r\n");
      out.write("\t\t");

			}
		
      out.write("\r\n");
      out.write("\t</table>\r\n");
      out.write("\t<a href=\"salata_ekle.jsp\">SALATA EKLE</a>\r\n");
      out.write("\t<a href=\"SiparisSayfa.jsp\">ANA SAYFA</a>\r\n");
      out.write("\t");
 session.setAttribute("stilladmin", true); 
      out.write("\r\n");
      out.write("</body>\r\n");
      out.write("</html>\r\n");
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
