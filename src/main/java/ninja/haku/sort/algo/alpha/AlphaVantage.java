package ninja.haku.sort.algo.alpha;


import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import ninja.haku.sort.algo.pojo.DailyPrice;
import ninja.haku.sort.algo.pojo.TimeSeries;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;


import javax.print.attribute.standard.JobKOctets;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.time.LocalDate;
import java.util.Map;

public class AlphaVantage {

    private OkHttpClient client;
    private String url;
    private String date;

    public AlphaVantage(){

        client = new OkHttpClient();
        url = "https://www.alphavantage.co/query?function=TIME_SERIES_DAILY&apikey=63I53QLANDZX4HAN&symbol=";
        date = java.time.LocalDate.now().toString();

    }

    public String getEntityName(String symbol){

//        url = url + symbol;
//
//        Request request = new Request.Builder().url(url).build();
//        try {
//            Response response = client.newCall(request).execute();
//            return response.body().string();
//
//        } catch (IOException e) {
//            System.out.println("****************************************************************************************");
//            System.out.println("There was an error executing the request. Client may have entered an invalid symbol.");
//            System.out.println("****************************************************************************************");
//            e.printStackTrace();
//
//        }
//        return "An error has occurred";

        return date;

    }

//    public void getDailyPrice(){
//
//        ObjectMapper mapper = new ObjectMapper();
//
//        try {
//            URL myAPI = new URL("https://www.alphavantage.co/query?function=TIME_SERIES_DAILY&apikey=63I53QLANDZX4HAN&symbol=IBM");
//            TimeSeries price =  mapper.readValue(myAPI, TimeSeries.class);
//            Map<String, DailyPrice> prices = price.getValues();
//            System.out.println(prices.get("2020-07-10").getOpen());
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//    }


    public  Map<String, DailyPrice> getEquityInfo(String symbol){

        ObjectMapper mapper = new ObjectMapper();
        try {
            URL myAPI = new URL("https://www.alphavantage.co/query?function=TIME_SERIES_DAILY&apikey=63I53QLANDZX4HAN&symbol=" + symbol);
            TimeSeries price =  mapper.readValue(myAPI, TimeSeries.class);
            Map<String, DailyPrice> myList = price.getValues();
            return myList;
        } catch (Exception e) {

            e.printStackTrace();
            System.out.println("*******************************************************");
            System.out.println("ERROR WHILE REQUESTING TO ALPHA VANTAGE API");
            System.out.println("*******************************************************");

        }

        return null;

    }
}
