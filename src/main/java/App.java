import static spark.Spark.*;
import java.util.HashMap;
import java.util.Map;
import spark.ModelAndView;
import spark.template.handlebars.HandlebarsTemplateEngine;


public class App {
    public static void main(String[] args) {
        staticFileLocation("/public");

        get("/",(request, response) ->{
            Map<String,Object>model = new HashMap<String, Object>();
            model.put("rangers",Ranger.all());
            model.put("animals","")
            return new ModelAndView(model,"index.hbs");
        },new HandlebarsTemplateEngine());
    }
}
