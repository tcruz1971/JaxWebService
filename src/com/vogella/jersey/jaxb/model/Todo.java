package com.vogella.jersey.jaxb.model;

import java.util.List;

import javax.xml.bind.annotation.*;

@XmlRootElement
// JAX-RS supports an automatic mapping from JAXB annotated class to XML and JSON
// Isn't that cool?
public class Todo {

  private String summary;
  private String description;
  private List<String> mMappings;  
  
  @XmlAttribute
  public String getSummary() {
    return summary;
  }

  public void setSummary(String summary) {
    this.summary = summary;
  }
  
  @XmlAttribute
  public String getDescription() {
    return description;
  }

  public void setDescription(String description) {
    this.description = description;
  }

  @XmlElement(name = "file")
  public List<String> getFile() {
	return mMappings;
  }

  public void setFile(List<String> aMappings) {
    this.mMappings = aMappings;
  }
  
} 