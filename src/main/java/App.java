import java.util.HashMap;
import java.util.ArrayList;

import spark.ModelAndView;
import spark.template.velocity.VelocityTemplateEngine;
import static spark.Spark.*;

public class App {
    public static void main(String[] args) {
        staticFileLocation("/public");
        String layout = "templates/layout.vtl";

        get("/", (request, response) -> {
          HashMap<String,Object>model = new HashMap<String, Object>();
          model.put("definitions", request.session().attribute("definitions"));
          model.put("template", "templates/index.vtl");
          return new ModelAndView(model, layout);
        }, new VelocityTemplateEngine());

        get("/definitions", (request, response) -> {
          HashMap<String, Object> model = new HashMap<String, Object>();
          model.put("definitions", Definition.all());
          model.put("template", "templates/definitions.vtl");
          return new ModelAndView(model, layout);
          }, new VelocityTemplateEngine());

        get("definitions/new", (request, response) -> {
          HashMap<String, Object> model = new HashMap<String, Object>();
          model.put("template", "templates/definition-form.vtl");
          return new ModelAndView(model, layout);
          }, new VelocityTemplateEngine());

        post("/definitions", (request,response) -> {
          HashMap<String, Object>model = new HashMap<String, Object>();
          Word word = Word.find(Integer.parseInt(request.queryParams("wordId")));
          String description = request.queryParams("description");
          Definition newDefinition = new Definition(description);
          word.addDefinition(newDefinition);
          model.put("word", word);
          model.put("template", "templates/word.vtl");
          return new ModelAndView(model, layout);
        }, new VelocityTemplateEngine());

        //RESTful ARCHITECTURE
        //Use POST to create something on the server
        //Use GET to retrieve something from the server
        //Use PUT to change or update something on the server
        //Use DELETE to remove or delete something on the server
        //Keep URLs intuitive
        //Each request from client contains all info necessary for that request

        //ROUTES: Home Page

        // get("/", (request, response) -> {
        //     HashMap<String, Object> model = new HashMap<String, Object>();

        //     model.put("template", "templates/index.vtl");
        //     return new ModelAndView(model, layout);
        // }, new VelocityTemplateEngine());

        //ROUTES: Identification of Resources

        //ROUTES: Changing Resources

    }
}
