package horoscope;

import horoscopeapi.HoroscopeAPI;
import horoscopeapi.HoroscopeReading;
import horoscopeapi.HoroscopeSign;
import horoscopeapi.SQLExcpetion;

import java.io.IOException;
import java.net.MalformedURLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class MyHoroscope {
	
	public HoroscopeSign searchSign(String month ,String day) throws ParseException{
		SimpleDateFormat sdf = new SimpleDateFormat("MM/dd");
		Date signDate = sdf.parse(month+"/"+day);
		String[] parts;
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
		for (HoroscopeSign zsign : HoroscopeSign.values()){
			parts = api.getSignInfo(zsign).split("-");
			Date beginDate = sdf.parse(parts[0]);
			Date endDate = sdf.parse(parts[1]);
			if (signDate.after(beginDate) && signDate.before(endDate) || signDate.equals(beginDate) || signDate.equals(endDate)) {
				return zsign;
			}
		}
		return null;
	}
	
	public String getSignSymbol(HoroscopeSign zsign,HoroscopeAPI api){
		return api.getSignSymbol(zsign);		
	}
	
	public String getHoroscope(HoroscopeSign zsign,HoroscopeAPI api){
		return api.getHoroscopeReading(zsign, HoroscopeReading.Daily_Horoscope);	
	}
}
