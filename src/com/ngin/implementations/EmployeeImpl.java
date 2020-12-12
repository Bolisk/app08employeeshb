package com.ngin.implementations;

import java.util.List;
import java.util.logging.Logger;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;
import com.ngin.entities.Employee;
import com.ngin.services.EmployeeService;

// implementation of javax persistence via Entity Manager class
public class EmployeeImpl implements EmployeeService {
	
	Logger logger = Logger.getLogger("Employee Log");
	
	private EntityManagerFactory emf = Persistence
			.createEntityManagerFactory("MASTERUNIT");
	
	// insert employee via parameter
	public void insertEmployee(Employee e) {
		// create manager
		EntityManager em = emf.createEntityManager();
		try {
			em.getTransaction().begin();
			em.persist(e);
			em.getTransaction().commit();
		} finally {
			em.close();	
			emf.close();
		}
	}
	
	// get all employees - via TypedQuery
	public List<Employee> getAllEmployees() {
		// create manager
		EntityManager em = emf.createEntityManager();
		
		// create TypedQuery instance
		TypedQuery<Employee> query = 
		em.createNamedQuery("Employee.findAll", Employee.class);
		em.close();
		emf.close();
		return query.getResultList();
	}
	
	// get employee by their id
    public Employee getEmployeeById(int id) {
    	
        EntityManager em = emf.createEntityManager();
        
        // via JPQL query
        em.createQuery("SELECT e FROM Employee e WHERE e.id = :id")
          .setParameter("id", id)
          .getSingleResult();

		em.close();
		emf.close();
        return em.find(Employee.class, id);
    }
	
    // swap Employee - create a new one in place of an old
    public void swapEmployee(int idToSwap) {
    	
    	EntityManager em = emf.createEntityManager();
    	
    	// employee replacement
    	Employee backUp = new Employee("nginstudios", "Constantions", "Bolis");
    	// employee to be replaced
    	Employee dayOff = em.find(Employee.class, idToSwap);
    	
    	em.getTransaction().begin();
    	
    	em.persist(backUp);
    	em.remove(dayOff);
    	em.merge(backUp);
    	
    	em.getTransaction().commit();
		em.close();
		emf.close();
    }

    // display all Employees to console
    public void showAllEmployees() {
    	
    	List<Employee> workForce = getAllEmployees();
    	// is not replaced by logger - we want print to console
    	workForce.forEach(System.out::println);
    }

    // display Employee to console if company matches
	public void showEmployeeByCompany(String com) {

		EntityManager em = emf.createEntityManager();
		em.getTransaction().begin();
		
		Employee check = em.find(Employee.class, com);
		if (check == null) {
			logger.info("Employee does not Exist!");
		} else { check.toString();}
		
		em.getTransaction().commit();
		em.close();
		emf.close();
	}
	
	// just a property update of an Employee instance/row
	public void correctEmployeeName(int id, String newName) {
		
		EntityManager em = emf.createEntityManager();
    	
		try {    	    	
	    	em.getTransaction().begin();
	    	// employee to be updated
	    	Employee employeeUpdate = em.find(Employee.class, id);
	    	// update via setter
	    	employeeUpdate.setFirstName(newName);
	    	//save to memory
	    	em.merge(employeeUpdate);
	    	// save to DB
	    	em.getTransaction().commit();
		} finally {
			em.close();
			emf.close();
		}
	}
    
}
