package com.maacsport.model.advanced;



import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.transaction.annotation.Transactional;

import com.maacsport.model.Person;
import com.maacsport.dao.PersonDao;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.PersistenceUnit;
import javax.persistence.Query;
import javax.transaction.TransactionManager;

import static org.junit.Assert.assertEquals;




public class MappedSubselectTests {

	private ApplicationContext context;
    private PersonDao itemDao;
    private EntityManagerFactory emf=null;
    private TransactionManager tx;
    
    @PersistenceUnit(unitName = "maacsportPU")
    private EntityManagerFactory e;
    
    @Before
    public void setUp() throws Exception {
        context = new ClassPathXmlApplicationContext("classpath:test-context.xml");
        itemDao = (PersonDao) context.getBean("personDao");
        emf = (EntityManagerFactory) context.getBean("entityManagerFactory");
       // tx = (TransactionManager) context.getBean("transactionManager");
    }

    @Test
    @Transactional
    public void loadSubselectEntity() throws Exception {
       
       String ITEM_ID="11111H";
    		   
        try {
           // ((Transaction) tx).begin();
            EntityManager em = emf.createEntityManager();
            

            {
                PersonReservationSummary itemBidSummary = em.find(PersonReservationSummary.class, ITEM_ID);
                // select * from (
                //      select i.ID as ITEMID, i.ITEM_NAME as NAME, ...
                // ) where ITEMID = ?

                assertEquals(itemBidSummary.getName(), "Miguel  Aguilera Caballero");
            }
            em.clear();

            { // Hibernate will synchronize the right tables before querying
                Person item = em.find(Person.class, ITEM_ID);
                item.setName("New name");

                // No flush before retrieval by identifier!
                // ItemBidSummary itemBidSummary = em.find(ItemBidSummary.class, ITEM_ID);

                // Automatic flush before queries if synchronized tables are affected!
                Query query = em.createQuery(
                    "select ibs from PersonReservationSummary ibs where ibs.personId = :personId"
                );
                PersonReservationSummary personResercationSummary =
                    (PersonReservationSummary)query.setParameter("personId", ITEM_ID).getSingleResult();

                assertEquals(personResercationSummary.getName(), "AUCTION: New name");
            }

           // tx.commit();
            em.close();
        } finally {
            //tx.rollback();
        }
    }

  

}
