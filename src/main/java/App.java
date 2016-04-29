import java.util.ArrayList;  //Delete this if there are no ArrayList objects.
import java.util.Map;
import java.util.HashMap;
import spark.ModelAndView;
import spark.template.velocity.VelocityTemplateEngine;
import static spark.Spark.*;

public class App {
  public static void main(String[] args) {
    String layout = "templates/layout.vtl";
//This is first path to homepage, or "index".
    get("/", (request, response) -> {
      Map<String, Object> model = new HashMap<String, Object>();
      model.put("template", "templates/index.vtl");
      return new ModelAndView(model, layout);
    }, new VelocityTemplateEngine());

    get("/entries/new", (request, response) -> {
      HashMap<String, Object> model = new HashMap<String, Object>();
      model.put("template", "templates/entry-form.vtl");
      return new ModelAndView(model,layout);
    }, new VelocityTemplateEngine());

    post("/entries", (request,response) -> {
      HashMap<String, Object> model = new HashMap<String, Object>();
      String word = request.queryParams("word");
      Entry newEntry = new Entry(word);
      model.put("template", "templates/entry-success.vtl");
      return new ModelAndView(model, layout);
    }, new VelocityTemplateEngine());

    get("/entries", (request, response) -> {
      HashMap<String, Object> model = new HashMap<String, Object>();
      model.put("entries", Entry.all());
      model.put("template", "templates/entries.vtl");
      return new ModelAndView(model, layout);
    }, new VelocityTemplateEngine());

    get("/entries/:id", (request, response) -> {
      HashMap<String, Object> model = new HashMap<String, Object>();
      Entry entry = Entry.find(Integer.parseInt(request.params(":id")));
      model.put("entry", entry);
      model.put("template", "templates/entry.vtl");
      return new ModelAndView(model, layout);
    }, new VelocityTemplateEngine());

    get("/entries/:id/definitions/new", (request, response) -> {
      HashMap<String, Object> model = new HashMap<String, Object>();
      Entry entry = Entry.find(Integer.parseInt(request.params(":id")));
      model.put("entry", entry);
      model.put("template", "templates/entry-definitions-form.vtl");
      return new ModelAndView(model, layout);
    }, new VelocityTemplateEngine());


  }
}
