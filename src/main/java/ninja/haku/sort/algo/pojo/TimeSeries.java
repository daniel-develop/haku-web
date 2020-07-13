package ninja.haku.sort.algo.pojo;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.time.LocalDate;
import java.util.Map;


@JsonIgnoreProperties({"Meta Data", "Note"})
public class TimeSeries {

    @JsonProperty("Time Series (Daily)")
    private Map<String, DailyPrice> values;

    public TimeSeries(Map<String, DailyPrice> values) {
        this.values = values;
    }
    public TimeSeries(){ }

    public Map<String, DailyPrice> getValues() {
        return values;
    }

    public void setValues(Map<String, DailyPrice> values) {
        this.values = values;
    }
}
