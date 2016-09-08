package cn.wglgg.spring.cloud.web;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
@Controller
@RequestMapping("/")
public class HelloController {

    //@RequestMapping("/")
    @GetMapping("/")
    public String index(ModelMap map) {
        // 加入一个属性，用来在模板中读取
        map.addAttribute("host", "http://wglgg.cnn");
        // return模板文件的名称，对应src/main/resources/templates/index.html
        return "index";  
    }

}