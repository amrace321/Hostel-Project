package com.example.demo.controller;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.example.demo.hostelRepository.HostelRepo;
import com.example.demo.hostelRepository.StudentContactRepo;
import com.example.demo.modal.HostelInfoModel;
import com.example.demo.modal.SearchModel;
import com.example.demo.modal.Signup;
import com.example.demo.modal.Studentcontact;
import com.example.demo.modal.User;
import com.example.demo.securityConfiguration.RoleRepository;
import com.example.demo.securityConfiguration.UserRepository;
import com.example.demo.util.EmailModel;
import com.example.demo.util.EmailService;

@Controller
public class MainController {

	@Autowired
	public StudentContactRepo studentContactRepo;
	@Autowired
	public RoleRepository rolerepository;

	@Autowired
	public UserRepository Userrepository;

	@RequestMapping("/bookHostel")
	public String getStudentcontact(@ModelAttribute Studentcontact studentContact) {
		// List<Studentcontact> findAll = studentContactRepo.findAll();
		// System.out.println(studentContact);
		studentContactRepo.save(studentContact);

		HostelInfoModel hostelInfoModel = hostelrepo.findById(1).get();
		// send email to user after booking
		EmailModel emailModel = new EmailModel();
		// emailModel.setMessage("ThankYou for booking");
		emailModel.setMessage("<h3>Booking Confirmation Mail</h3>" + "<p><b>Booking Details: </b></p>"
				+ "<p> Hostel Name: " + hostelInfoModel.getHostelName() + "</p>" + "<p> Hostel Address: "
				+ hostelInfoModel.getHostelAddress() + "</p>" + "<p> Hostel Contact: " + hostelInfoModel.getContact()
				+ "</p>" + "<p> Hostel Price: " + hostelInfoModel.getPrice() + "</p>" + "<p> Hostel Owner Name: "
				+ hostelInfoModel.getOwnerName() + "</p>"
		/* + "<p> Hostel Image: " + hostelInfoModel.getImagePath() + "</p>" */
		);

		emailModel.setSendTo(studentContact.getEmail());
		emailModel.setSubject("hostel Booking");
		emailService.sendEmail(emailModel);

		// send email to server about the user booking details
		EmailModel emailModel2 = new EmailModel();
		emailModel2.setSendTo("amrace321@gmail.com");
		emailModel2.setMessage("<h3>Booking Confirmation Mail</h3>" + "<p><b>Booking Details: </b></p>"
				+ "<p> Hostel Name: " + hostelInfoModel.getHostelName() + "</p>" + "<p> Hostel Address: "
				+ hostelInfoModel.getHostelAddress() + "</p>" + "<p> Hostel Contact: " + hostelInfoModel.getContact()
				+ "</p>" + "<p> Hostel Price: " + hostelInfoModel.getPrice() + "</p>" + "<p> Hostel Owner Name: "
				+ hostelInfoModel.getOwnerName() + "</p>"
		/* + "<p> Hostel Image: " + hostelInfoModel.getImagePath() + "</p>" */
		);

		emailService.sendEmail(emailModel2);
		return "homeland/property-details";
	}

	@Autowired
	public EmailService emailService;

	@Autowired
	public HostelRepo hostelrepo;

	// Show the multipart files to index page
	@RequestMapping({ "/", "/index" })
	public String getHome(Model model) {
		List<HostelInfoModel> findAll = hostelrepo.findAll();
		model.addAttribute("hostel", findAll);
		System.out.println(findAll);
		return "homeland/index";

	}

	@RequestMapping("/home")
	public String getAdminPage() {
		return "home";
	}

	@RequestMapping("/login")
	public String getLogin() {
		return "login";
	}

	// Images gets stored in D drive
	private String upload = "D:/upload_dir/";

	// Method for passing the model details and multipart files to database
	@RequestMapping("/registerHostel")
	public String createHostel(@RequestParam("fileName") MultipartFile fileName,
			@ModelAttribute HostelInfoModel hostelInfoModel) throws IOException {
		hostelInfoModel.setImagePath(upload + fileName.getOriginalFilename());
		hostelrepo.save(hostelInfoModel);
		System.out.println(fileName.getOriginalFilename());
		upload(fileName);
		return "home";
	}

	// Method to upload the picture to database
	private void upload(MultipartFile fileName) throws IOException {
		byte[] bytes = fileName.getBytes();
		Path path = Paths.get(upload + fileName.getOriginalFilename());
		Files.write(path, bytes);

	}

	@GetMapping("/getAll")
	@ResponseBody
	public List<HostelInfoModel> createHostelInfoModel() {

		return (List<HostelInfoModel>) hostelrepo.findAll();
	}

	// For editing the hostel details
	@RequestMapping("/update")
	public String update(@ModelAttribute HostelInfoModel hostelInfoModel) {
		hostelrepo.save(hostelInfoModel);
//		System.out.println(studentModel.toString());
		return "home";
	}

	// For deleting the hostel details
	@RequestMapping("/delete/{id}")
	public String delete(@PathVariable int id) {
		hostelrepo.deleteById(id);
		// System.out.println();
		return "home";

	}

	@RequestMapping("/about")
	public String About() {
		return "homeland/about";
	}

	@RequestMapping("/contact")
	public String Contact() {
		return "homeland/contact";
	}

	@RequestMapping("/property-details")
	public String getHostelDetails() {
		return "homeland/property-details";
	}

	@RequestMapping("/property-details1")
	public String getHostelDetails1() {
		return "homeland/property-details1";
	}

	@RequestMapping("/blog")
	public String getBlog() {
		return "homeland/blog";
	}

	@RequestMapping("/buy")
	public String getBuyPage() {
		return "homeland/buy";
	}

	@RequestMapping("/rent")
	public String getRent() {
		return "homeland/rent";
	}

	@RequestMapping("/map")
	public String getMap() {
		return "map";
	}

	@RequestMapping("/bookingForm")
	public String getbookingForm() {
		return "bookingForm";
	}

	@RequestMapping("/search-hostel")
	public String getSearch(@ModelAttribute SearchModel searchModel, Model model) {
		List<HostelInfoModel> list = hostelrepo.findByHostelAddressLike(searchModel.getLocation());
		System.out.println("here" + searchModel.getLocation());
		model.addAttribute("list", list);
		System.out.println(list.size());
		return "/homeland/searchresult";
	}

	@RequestMapping("/register")
	public String getRegister() {
		User findByUsername = Userrepository.findByUsername("admin");
		System.out.println(findByUsername);
		System.out.println(Userrepository.findById(1));
		return "User/signup";
	}

	@RequestMapping(value = "/saveregistered", method = RequestMethod.POST)
	public String getSignUp(@ModelAttribute Signup signup, Model model,RedirectAttributes attributes) {

		if (Userrepository.existsByUsername(signup.getUserName())) {
			attributes.addFlashAttribute("message", "User Name Already exists");
			return "redirect:/register";

		}
		else {
			System.out.println(signup);
			User user = new User();
			user.setPassword(signup.getPassword());
			user.setUsername(signup.getUserName());
			user.setAuthority("USER");
			Userrepository.save(user);

			Studentcontact student = new Studentcontact();
			student.setName(signup.getFirstName());
			student.setEmail(signup.getEmail());
			student.setPhone(signup.getContact());
			studentContactRepo.save(student);
		}
		return "redirect:/";
//
	}
	/*
	 * @PostMapping("/saveregistered") public String checkPersonInfo(@Valid Signup
	 * signup, BindingResult bindingResult) {
	 * 
	 * if (bindingResult.hasErrors()) { return "redirect:/register"; }
	 * 
	 * return "redirect:/"; }
	 */
}
