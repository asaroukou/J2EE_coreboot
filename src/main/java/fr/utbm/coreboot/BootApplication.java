package fr.utbm.coreboot;

import fr.utbm.coreboot.Entity.*;
import fr.utbm.coreboot.Repository.CourseRepository;
import fr.utbm.coreboot.Service.ClientService;
import fr.utbm.coreboot.Service.SessionService;
import fr.utbm.coreboot.Service.LocationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

import javax.persistence.EntityManager;
import java.text.SimpleDateFormat;
import java.util.List;

@SpringBootApplication(scanBasePackages={"fr.utbm.coreboot"})
@EnableJpaAuditing
public class BootApplication
extends SpringBootServletInitializer implements CommandLineRunner {

	@Autowired(required = true)
	private ClientService clientService;
	@Autowired(required = true)
	private LocationService locationService;
	@Autowired(required = true)
	private SessionService sessionService;
	@Autowired(required = true)
	private CourseRepository courseRepository;

	@Autowired
	private EntityManager em;

	@Override
	protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
		return application.sources(BootApplication.class);
	}

	public static void main(String[] args) {
		SpringApplication.run(BootApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {

		List<Course> cs = courseRepository
				.findCourseByLocation(locationService.findLocationById(4).getId());
		for (Course c : cs) {
			System.out.println(c);
		}
//		CriteriaBuilder cb = em.getCriteriaBuilder();
//		CriteriaQuery<Course> cq = cb.createQuery(Course.class);
//
//		Root<Course> book = cq.from(Course.class);
//		Predicate authorNamePredicate = cb.equal(book.get("author"), authorName);
//		Predicate titlePredicate = cb.like(book.get("title"), "%" + title + "%");
//		cq.where(authorNamePredicate, titlePredicate);
//
//		TypedQuery<Course> query = em.createQuery(cq);
//		List<Course> courses = query.getResultList();
//
//		for(int i = 1; i <= 10; i++){
//			Client client = new Client();
//			client.setFirstname("firstname" + i);
//			client.setLastname("lastname"  + i);
//			client.setEmail("myemail@domail.com");
//			client.setAddress("My awesome address");
//			client.setPhone("0987655789");
//			client = clientService.addClient(client);
//
//			Location location = new Location();
//			location.setCity("Belfort");
//			location = locationService.addLocation(location);
//
//			Course course = new Course();
//			course.setCode("MI4" + i);
//			course.setTitle("Architecture des ordinateurs");
//			course = courseService.addCourse(course);
//
//			Session session = new Session();
//			session.setMax(20);
//			session.setEndDate(Date.from(Instant.now()));
//			session.setStartDate(Date.from(Instant.now()));
//			session.setLocation(location);
//			session.setCourse(course);
//			session = sessionService.addSession(session);
//			session.addClient(client);
//			session = sessionService.updateSession(session);
//			System.out.println(session);
//		}

//		Session session = sessionService.findSessionById(1);
//		System.out.println(session.getClients());
//		session.removeClient(clientService.findClient(1));
//		System.out.println(session.getClients());
//		session = sessionService.updateSession(session);
//		System.out.println(session.getClients());
//		Client c = clientService.findClient(1);
//		System.out.println(c.getSessions());
	}
}
