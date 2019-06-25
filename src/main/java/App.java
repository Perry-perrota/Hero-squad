import spark.ModelAndView;
import spark.template.handlebars.HandlebarsTemplateEngine;

import java.util.HashMap;
import java.util.Map;

import static spark.Spark.*;


public class App {
    static int getHerokuAssignedPort() {
        ProcessBuilder processBuilder = new ProcessBuilder();
        if (processBuilder.environment().get("PORT") != null) {
            return Integer.parseInt(processBuilder.environment().get("PORT"));
        }
        return 4567; //return default port if heroku-port isn't set (i.e. on localhost)
    }
    public static void main(String[] args) {

        port(getHerokuAssignedPort());
        staticFileLocation("/public");

     get("/homepage",(request,response)->{
         return new ModelAndView(new HashMap(),"index.hbs");
     },new HandlebarsTemplateEngine());

        get("/squads",(request,response)->{
            return new ModelAndView(new HashMap(),"squads.hbs");
        },new HandlebarsTemplateEngine());

    get("/form",(request,response)->{
        Map<String, Object> model = new HashMap<String, Object>();

        return new ModelAndView(model,"form.hbs");
    },new HandlebarsTemplateEngine());

    post("/heroes",(request,response)->{
        Map<String,Object> model=new HashMap<>();
        String hero_name=request.queryParams("hero_name");
        String strength=request.queryParams("strength");
        String weakness=request.queryParams("weakness");
        String cause_value=request.queryParams("cause_value");
        int age=Integer.parseInt(request.queryParams("age"));
        String squad_name=request.queryParams("squad_name");

        request.session().attribute("hero_name",hero_name);
        request.session().attribute("strength",strength) ;
        request.session().attribute("weakness", weakness);
        request.session().attribute("age", age);
        request.session().attribute("squad_name", squad_name);
        request.session().attribute("cause_value", cause_value);


        model.put("hero_name",hero_name);
        model.put("strength",strength);
        model.put("weakness",weakness);
        model.put("cause_value",cause_value);
        model.put("age",age);
        model.put("squad_name",squad_name);

        return new ModelAndView(model,"heroes.hbs");
    }, new HandlebarsTemplateEngine());


        get("/heroes",(request,response)->{
            Map<String, Object> model = new HashMap<String, Object>();
            request.session().attribute("hero_name");
            request.session().attribute("strength");
            request.session().attribute("weakness");
            request.session().attribute("cause_value");
            request.session().attribute("age");


            return new ModelAndView(model,"heroes.hbs");
        },new HandlebarsTemplateEngine());






    }
}