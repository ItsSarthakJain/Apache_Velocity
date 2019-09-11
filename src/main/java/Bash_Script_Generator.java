import java.io.*;
import java.util.*;

import org.apache.velocity.Template;
import org.apache.velocity.VelocityContext;
import org.apache.velocity.app.VelocityEngine;
import org.apache.velocity.runtime.RuntimeConstants;
import org.apache.velocity.runtime.resource.loader.ClasspathResourceLoader;


public class Bash_Script_Generator {

    public static void main(String[] args) throws Exception{


        VelocityEngine velocity=new VelocityEngine();

        velocity.setProperty(RuntimeConstants.RESOURCE_LOADER, "classpath");
        velocity.setProperty("classpath.resource.loader.class", ClasspathResourceLoader.class.getName());

        velocity.init();

        Template item_template=velocity.getTemplate("run_modular_scripts.vm");

        VelocityContext velocityContext=new VelocityContext();

        BufferedReader br = new BufferedReader(new FileReader("/home/exa00104/Desktop/Apache_Velocity/src/main/resources/table_list2.txt"));
        String line =  null;
        HashMap<String,String> map = new HashMap<String, String>();

        while((line=br.readLine())!=null) {
            String str[] = line.split(",");
            map.put(str[0], str[1]);
        }

        Iterator hmIterator = map.entrySet().iterator();

        while (hmIterator.hasNext()) {

            Map.Entry mapElement = (Map.Entry)hmIterator.next();

            String script_name=mapElement.getKey().toString();

            String script_type=mapElement.getValue().toString();

            velocityContext.put("SCRIPT_NAME", script_name);

            velocityContext.put("SCRIPT_TYPE",script_type);

            item_template.initDocument();

            StringWriter outputstream = new StringWriter();

            item_template.merge(velocityContext, outputstream);

            System.out.println(outputstream);

//            String Script_Output_Path = "/home/exa00104/Desktop/Apache_Velocity/Output2/"+script_name+".sh";
//
//            Writer writer = new FileWriter(new File(Script_Output_Path));
//
//            velocity.mergeTemplate("run_modular_scripts.vm", "UTF-8", velocityContext, writer);
//            writer.flush();
//            writer.close();

        }
    }
}

