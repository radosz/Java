package horoscope;
import com.google.gson.*;

public class HoroscopeJson {
	public static String json(String month,String day){
		Gson gson  = new GsonBuilder()
	    .setPrettyPrinting()
	    .disableHtmlEscaping()
	    .create();
		return gson.toJson(new PrepareJson(month, day));
	}

}
