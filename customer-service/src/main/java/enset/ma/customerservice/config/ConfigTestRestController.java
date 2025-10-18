package enset.ma.customerservice.config;


import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
public class ConfigTestRestController {
    @Value("${global.params.p1}")
    private  String a;
    @Value("${global.params.p2}")
    private  String b;


    @GetMapping("/TestConfig1")
    public  Map<String,String> confgTest1(){
        return Map.of("p1:",a,"p2:",b);
    }


    @GetMapping("/TestConfig2")
    public  Map<String,String> confgTest2(){
        return Map.of("p1:",a,"p2:",b);
    }
}
