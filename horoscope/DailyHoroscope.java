package horoscope;

import horoscopeapi.HoroscopeAPI;
import horoscopeapi.HoroscopeSign;
import horoscopeapi.SQLExcpetion;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.MalformedURLException;
import java.text.ParseException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class DailyHoroscope
 */
@WebServlet("/zsign")
public class DailyHoroscope extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DailyHoroscope() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		MyHoroscope myh = new MyHoroscope();
		String bday = request.getParameter("bday");
		try {
			HoroscopeAPI api = null;
			try {
				api = new HoroscopeAPI(10000);
			} catch (MalformedURLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (SQLExcpetion e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			HoroscopeSign sign = myh.searchSign(bday.split("-")[1], bday.split("-")[2]);
			PrintWriter out = response.getWriter();
			out.print(sign+"\n");
			out.print(myh.getHoroscope(sign,api));
	
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

}
