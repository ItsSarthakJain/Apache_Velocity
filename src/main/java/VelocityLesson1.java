
import java.io.StringWriter;
import java.util.ArrayList;
import java.util.Map;
import java.util.HashMap;
import org.apache.velocity.Template;
import org.apache.velocity.VelocityContext;
import org.apache.velocity.app.VelocityEngine;
import org.apache.velocity.runtime.RuntimeConstants;
import org.apache.velocity.runtime.resource.loader.ClasspathResourceLoader;


public class VelocityLesson1 {

    public static void main(String[] args) {

        VelocityEngine velocity=new VelocityEngine();

        velocity.setProperty(RuntimeConstants.RESOURCE_LOADER, "classpath");
        velocity.setProperty("classpath.resource.loader.class", ClasspathResourceLoader.class.getName());

        velocity.init();

        Template item_template=velocity.getTemplate("stationary_item_template_.vm");

        ArrayList item_list= new ArrayList();

        Map<String,String> item=new HashMap<String,String>();

        item.put("name","Pens");

        item.put("price","$10");

        item_list.add(item);

        item=new HashMap<String, String>();

        item.put("name","Cards");

        item.put("price","$2");

        item_list.add(item);


        item=new HashMap<String, String>();

        item.put("name","Pencils");

        item.put("price","$5");

        item_list.add(item);


        item=new HashMap<String, String>();

        item.put("name","Eraser");

        item.put("price","$1");

        item_list.add(item);


        item=new HashMap<String, String>();

        item.put("name","application_form");

        item.put("price","$0.5");

        item_list.add(item);

        VelocityContext velocityContext=new VelocityContext();

        velocityContext.put("items",item_list);

        item_template.initDocument();

        StringWriter outputstream = new StringWriter();

        item_template.merge(velocityContext,outputstream);

        System.out.println(outputstream);


    }
}
