package ninja.haku.sort.algo.pojo;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties({"2. high", "3. low", "5. volume"})
public class DailyPrice {
    @JsonProperty("1. open")
    private String open;
    @JsonProperty("4. close")
    private String close;

    public DailyPrice(String open, String close) {
        this.open = open;
        this.close = close;
    }

    public DailyPrice(){}

    public String getOpen() {
        return open;
    }

    public void setOpen(String open) {
        this.open = open;
    }

    public String getClose() {
        return close;
    }

    public void setClose(String close) {
        this.close = close;
    }
}
