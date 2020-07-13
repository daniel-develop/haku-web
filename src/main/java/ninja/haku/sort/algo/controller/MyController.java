package ninja.haku.sort.algo.controller;


import ninja.haku.sort.algo.alpha.AlphaVantage;
import ninja.haku.sort.algo.pojo.DailyPrice;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;


import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.Map;

@Controller
public class MyController {

    @GetMapping("/")
    public String home(Model model){

        return "index";

    }

    @GetMapping("/search")
    //@ResponseBody
    public String process(HttpServletRequest request, Model model){

        AlphaVantage vantage = new AlphaVantage();
        Map<String, DailyPrice> list = vantage.getEquityInfo(request.getParameter("equityName"));
        model.addAttribute("allDays", list);

        if(list == null){

            return "error";

        }

        //  Map to hold the daily change in percentage
        Map<String, Double> change = new HashMap<>();
        //  Map to hold the daily change in dollar
        Map<String, Double> changeInDollar = new HashMap<>();



        for(Map.Entry<String, DailyPrice> i : list.entrySet()){

            // Calculate the difference in percentage
            double priceChange = (Double.parseDouble(i.getValue().getClose()) - Double.parseDouble(i.getValue().getOpen()))/Double.parseDouble(i.getValue().getOpen());
            priceChange = priceChange * 100;
            // Calculate the difference in dollars
            double priceChangeDollar = (Double.parseDouble(i.getValue().getClose()) - Double.parseDouble(i.getValue().getOpen()));

            changeInDollar.put(i.getKey(), priceChangeDollar);
            change.put(i.getKey(), priceChange);
        }

        // Add the data to the model
        model.addAttribute("changesInDollar", changeInDollar);
        model.addAttribute("changes", change);

        return "search";
    }


}
