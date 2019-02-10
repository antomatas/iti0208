package hello;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.Map;

@Controller
public class MyController {

    private Map<Integer, String> valuesMap = new HashMap();
    private int id = 1;

    @GetMapping("/")
    public String index() {
        valuesMap.put(id++, "firstTask");
        valuesMap.put(id++, "secondTask");
        return "index";
    }
    @ResponseBody
    @GetMapping("/tasks")
    public Map<Integer, String> tasks() {
        return valuesMap;
    }

    @PostMapping("/")
    public String greeting(@RequestParam("task") String taskName) {
        if(!taskName.equals("")) {
            valuesMap.put(id++, taskName);
        }
        return "index";
    }

}
