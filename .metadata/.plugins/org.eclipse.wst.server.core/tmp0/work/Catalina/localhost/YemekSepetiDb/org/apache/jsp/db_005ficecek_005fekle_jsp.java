/*
 * Generated by the Jasper component of Apache Tomcat
 * Version: Apache Tomcat/7.0.50
 * Generated at: 2014-01-31 12:56:25 UTC
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

public final class db_005ficecek_005fekle_jsp extends org.apache.jasper.runtime.HttpJspBase
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

	// getParameter ile alacagÄ±mÄ±z degeri int'e atamadÄ±gÄ±mÄ±z icin String degiskene atÄ±p int olana cast ediyoruz 
	icecekFiyat1 = request.getParameter("icecekFiyati");
	if (icecekFiyat1 != null || !"".equals(icecekFiyat1))
		icecekFiyat = Integer.parseInt(icecekFiyat1);

	icecekAd = request.getParameter("icecekAdi");

	pstmt = con
			.prepareStatement("Insert into icecekler(Ad,Fiyat) values(?,?)");
	pstmt.setString(1, icecekAd);
	pstmt.setInt(2, icecekFiyat);
	
	pstmt.executeUpdate();

	con.close();
	session.setAttribute("icecek", "icecek  (" + icecekAd
			+ ") basari ile eklenmistir.");
	response.sendRedirect("icecek_ekle.jsp");

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
