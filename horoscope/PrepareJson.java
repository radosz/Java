package horoscope;
 
import java.io.IOException;
import java.net.MalformedURLException;
import java.text.ParseException;
 
 

import horoscopeapi.HoroscopeAPI;
import horoscopeapi.HoroscopeSign;
import horoscopeapi.SQLExcpetion;
 
public class PrepareJson extends MyHoroscope  {
	private String dailyHoroscope;
	private HoroscopeSign zsign;
	
	public PrepareJson(String month,String day){
		this.setZsign(month, day);
		this.setDailyHoroscope(getZsign());
	}
	public String getDailyHoroscope() {
		return this.dailyHoroscope;
 
	}
	
	public void setDailyHoroscope(HoroscopeSign horoscopeSign) {
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
		this.dailyHoroscope = getHoroscope(getZsign(),api).replace("\u0027","");
	}
	
	public HoroscopeSign getZsign() {
		return this.zsign;
 
	}
	public void setZsign(String month,String day) {
		HoroscopeSign zsign = null;
		try {
			zsign = searchSign(month,day);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		this.zsign = zsign;
	}
}