package awesome.utils;

import com.alibaba.fastjson.JSONPath;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;

@Service
public class Stock {
    private String url="http://hq.youlikj.com/stock/price";
    private String code;
    private double price;
    private double up_limit;
    private double down_limit;
    private double bprice;
    private double sprice;
    private Integer count;


    public Integer getCount() {
        return count;
    }

    public void setCount(Integer count) {
        this.count = count;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public double getPrice() {
        String result=getStockInfor(code);
        BigDecimal price =(BigDecimal) JSONPath.read(result,"data.price");
        return price.doubleValue();
    }

    public double getStockPrice(String ccode) {
        String result=getStockInfor(ccode);
        BigDecimal price =(BigDecimal) JSONPath.read(result,"data.price");
        return price.doubleValue();
    }




    //涨停价
    public double getUp_limit() {
        String result=getStockInfor(code);
        BigDecimal price =(BigDecimal) JSONPath.read(result,"data.up_limit");
        return price.doubleValue();
    }

    public void setUp_limit(double up_limit) {
        this.up_limit = up_limit;
    }
    //跌停价
    public double getDown_limit() {
        String result=getStockInfor(code);
        BigDecimal price =(BigDecimal) JSONPath.read(result,"data.down_limit");
        return price.doubleValue();
    }
    //买5价
    public double getStockBprice(String ccode) {
        String result=getStockInfor(ccode);
        BigDecimal price =(BigDecimal) JSONPath.read(result,"data.bid_p[4]");
        return price.doubleValue();
    }
    //买5价
    public double getStockSprice(String ccode) {
        String result=getStockInfor(ccode);
        BigDecimal price =(BigDecimal) JSONPath.read(result,"data.ask_p[4]");
        return price.doubleValue();
    }





    public void setDown_limit(double down_limit) {
        this.down_limit = down_limit;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    private String getStockInfor(String code){
        Map<String,Object> par=new HashMap<>();
        par.put("code",code);
        String url ="http://10.0.1.155:9035/stock/price";
        String result=HttpRequest.doGet(url,par);
        return result;

    }

}
