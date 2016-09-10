package com.maacsport.model.querying;

@org.hibernate.annotations.NamedQueries({
	
		@org.hibernate.annotations.NamedQuery(name = "findPersonsOrderByName", query = "select i from Person i order by i.name asc"),
		@org.hibernate.annotations.NamedQuery(name = "findPersonWithStatusTrue", query = "select i from Item i where i.status > :theStatus", timeout = 60, comment = "Custom SQL comment") 
})

public class PackageInfo {

}
