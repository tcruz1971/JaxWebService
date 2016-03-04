package com.vogella.jersey.jaxb.model;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import java.io.File;
import java.util.ArrayList;
import java.util.List;

@Path("/todo")
public class TodoResource {
  // This method is called if XMLis request
  private static String OS = System.getProperty("os.name").toLowerCase();
  @GET
  @Produces({ MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON })
  public Todo getXML() {
    Todo todo = new Todo();
    todo.setSummary("This is my first todo");
    todo.setDescription("This is my first todo");
	File[] paths = null;
	if ( OS.indexOf("nux") >= 0 || OS.indexOf("nix") >= 0 || OS.indexOf("aix") > 0 ) {
		File f = new File("/tmp");
		paths = f.listFiles();
	} else if ( OS.indexOf("win") >= 0 ) {
		File f = new File("d:\\Downloads");
		paths = f.listFiles();		
	}
	List <String> item = new ArrayList<String> ();
	for (File path:paths) {
		item.add(path.getName());
	}
	todo.setFile(item);
    return todo;
  }
  
  // This can be used to test the integration with the browser
  @GET
  @Produces({ MediaType.TEXT_XML })
  public Todo getHTML() {
    Todo todo = new Todo();
    todo.setSummary("This is my first todo");
    todo.setDescription("This is my first todo");
    return todo;
  }

} 