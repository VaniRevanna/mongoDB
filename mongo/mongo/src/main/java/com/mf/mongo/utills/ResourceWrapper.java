package com.mf.mongo.utills;


import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.data.domain.Page;

public class ResourceWrapper<T> {

	 private List<T> content;
	 @SuppressWarnings("rawtypes")
	private final Map metadata;
	  
	  @SuppressWarnings("rawtypes")
	public ResourceWrapper(Page<T> page) {
	    super();
	    
		    this.setContent(page.getContent());
		    this.metadata = new HashMap();		    
	    populateMetadata(page);
	    
	  }
	  
	  
	  @SuppressWarnings("unchecked")
	private void populateMetadata(Page<T> page) {
	    
	    metadata.put("NumberOfElementsInCurrentPage", page.getNumberOfElements());
	    metadata.put("PageSize", page.getSize());
	    metadata.put("TotalNumberOfPages", page.getTotalPages());
	  }
	  
	  
	  public List<T> getContent() {
	    return content;
	  }
	  
	  
	  public void setContent(List<T> content) {
	    this.content = content;
	  }
	  
	  
	  @SuppressWarnings("rawtypes")
	public Map getMetadata() {
	    return metadata;
	  }
}
