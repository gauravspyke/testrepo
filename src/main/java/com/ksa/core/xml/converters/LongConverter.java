package com.ksa.core.xml.converters;


public class LongConverter extends com.thoughtworks.xstream.converters.basic.LongConverter {

	 public boolean canConvert(Class type) {
	        return type.equals(long.class) || type.equals(Long.class);
	    }

	    public Object fromString(String str) {
	    	System.out.println("here the value is "+str);
	        return Long.parseLong(str);
	    }
  
}