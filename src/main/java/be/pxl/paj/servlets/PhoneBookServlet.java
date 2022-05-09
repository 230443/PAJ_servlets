package be.pxl.paj.servlets;

import be.pxl.paj.servlets.domain.PhonebookEntry;
import be.pxl.paj.servlets.repository.PhonebookEntryRepository;
import org.springframework.beans.factory.annotation.Autowired;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(value = "/add-contact")
public class PhoneBookServlet extends HttpServlet {

	private PhonebookEntryRepository phonebookRepository;

	@Autowired
	public PhoneBookServlet(PhonebookEntryRepository phonebookEntryRepository) {
		this.phonebookRepository = phonebookEntryRepository;
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		super.doPost(req, resp);
		PhonebookEntry phonebookEntry = new PhonebookEntry();
		phonebookEntry.setFirstName(req.getParameter("firstName"));
		phonebookEntry.setLastName(req.getParameter("lastName"));
		phonebookEntry.setPhoneNumber(req.getParameter("phoneNumber"));

		phonebookRepository.save(phonebookEntry);


	}
}
