package com.product.details;

import java.io.Serializable;

public class Recommendation implements Serializable {

	public String displayName;
	public String shortDesc;
	public String category;
	public Recommendation(){
		
	}

	@Override
	public String toString() {
		return "Recommendation [displayName=" + displayName + ", shortDesc=" + shortDesc + ", category=" + category
				+ "]";
	}
	
}
