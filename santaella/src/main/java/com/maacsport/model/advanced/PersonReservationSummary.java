package com.maacsport.model.advanced;


	import javax.persistence.Entity;
	import javax.persistence.Id;

	@Entity
	@org.hibernate.annotations.Immutable
	@org.hibernate.annotations.Subselect(
	    value = "select i.PERSON_ID as PERSONID, i.PERSON_NAME as NAME, " +
	            "count(b.reservation_id) as NUMBEROFRESERVATIONS " +
	            "from PERSON i left outer join Reservation b on i.PERSON_ID = b.person_person_id " +
	            "group by i.PERSON_ID, i.PERSON_NAME"
	)

	// TODO Table names are case sensitive, Hibernate bug HHH-8430
	@org.hibernate.annotations.Synchronize({"Person", "Reservation"})
	public class PersonReservationSummary { 

	    @Id
	    protected String personId;

	    protected String name;

	    protected long numberOfReservations;

	    public PersonReservationSummary() {
	    }

	    // Getter methods...
	    public String getPersonId() {
	        return personId;
	    }

	    public String getName() {
	        return name;
	    }

	    public long getNumberOfReservations() {
	        return numberOfReservations;
	    }

	    // ...
	
}
