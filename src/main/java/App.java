import dao.Sql2oHeroDao;
import org.sql2o.Sql2o;
import spark.ModelAndView;
import spark.template.handlebars.HandlebarsTemplateEngine;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


import static spark.Spark.*;
import modules.*;


public class App {
    static int getHerokuAssignedPort() {
        ProcessBuilder processBuilder = new ProcessBuilder();
        if (processBuilder.environment().get("PORT") != null) {
            return Integer.parseInt(processBuilder.environment().get("PORT"));
        }
        return 4567; //return default port if heroku-port isn't set (i.e. on localhost)
    }
    public static void main(String[] args) {

        String connectionString = "jdbc:postgresql://ec2-23-21-76-49.compute-1.amazonaws.com:5432/df2ubtmuhc32s7"; //!
        Sql2o sql2o = new Sql2o(connectionString, "perryobara@gmail.com", "postgres://qgepephuvuocmt:6165f51b634f71bbd9503e365c3cf6144dcb89115283457c73995dcc1131f31c@ec2-174-129-242-183.compute-1.amazonaws.com:5432/dem963r96fekce"); //!

        Sql2oHeroDao heroDao = new Sql2oHeroDao(sql2o);
        port(getHerokuAssignedPort());
        staticFileLocation("/public");

     get("/",(request,response)->{
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

        Hero newHero=new Hero(strength,weakness,age,hero_name,cause_value,squad_name);
        heroDao.addHero(newHero);
        response.redirect("/heroes");

        return new ModelAndView(model,"heroes.hbs");
    }, new HandlebarsTemplateEngine());


        get("/heroes",(request,response)->{
            Map<String, Object> model = new HashMap<String, Object>();
            request.session().attribute("hero_name");
            request.session().attribute("strength");
            request.session().attribute("weakness");
            request.session().attribute("cause_value");
            request.session().attribute("age");
            List<Hero> heroes=heroDao.getAllHeroes();

            return new ModelAndView(model,"heroes.hbs");
        },new HandlebarsTemplateEngine());






    }
}