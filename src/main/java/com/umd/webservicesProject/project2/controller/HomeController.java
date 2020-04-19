package com.umd.webservicesProject.project2.controller;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.multipart.MultipartFile;

import com.umd.webservicesProject.project2.TO.CHControlerTOHome;
import com.umd.webservicesProject.project2.model.User;
import com.umd.webservicesProject.project2.model.UserAcceptRequestObject;

@Controller
public class HomeController {

	// TODO show it in the fron end(display user name and selected service in upload
	// screen and create object everywhere we r using

	private final static String DirectoryPath = "D:\\\\CoordinationProtocolFiles\\";

	@GetMapping("/home")
	public String showHomePage(Model model) {
		User user = new User();
		// TODO move logic to util class
		// TODO read it from property file(holds the data)
		List<String> arrayList = Arrays.asList("service 0", "service 1", "service 2", "service 3", "service 4",
				"service 5", "service 6", "service 7", "service 8", "service 9");
		List<String> servicesList = new ArrayList();
		servicesList.addAll(arrayList);

		model.addAttribute("user", user);
		model.addAttribute("servicesList", servicesList);

		return "form";
	}

	@PostMapping("/intialRequest")
	public String processingIntialRequest(@ModelAttribute("user") User User, ModelMap model) {
		// TODO change the class naming convention to transferObject
		UserAcceptRequestObject userAcceptRequestObject = new UserAcceptRequestObject();
		userAcceptRequestObject.setUserName(User.getUserName());
		System.out.println(userAcceptRequestObject.getUserName());
		StringBuilder sb = new StringBuilder();
		sb.append(User.getService().get(0));
		System.out.println(sb.toString());
		String service = sb.toString();
		userAcceptRequestObject.setService(service);
		System.out.println(userAcceptRequestObject.getService());
		model.addAttribute(userAcceptRequestObject);
		return "fileUpload";

	}

	@PostMapping("/fileUpload")
	// TODO bring the username and service from frnot end
	public String uploadingCoordinationProtocolFile(
			@ModelAttribute("userAcceptRequestObject") UserAcceptRequestObject userAcceptRequestObject,
			@RequestParam("FileWithProtocol") MultipartFile File, ModelMap model) throws IOException {
		if (File.isEmpty()) {
			System.out.println("file is empty");
			return "error";
		} else {
			// TODO convert mutlipartfile to file to pass it to utility class
			// TODO move below file copy code to some utility class
			DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyyMMddHHmmss");
			LocalDateTime now = LocalDateTime.now();
			String FileName = DirectoryPath + dtf.format(now);
			System.out.println(FileName);
			Files.copy(File.getInputStream(), Paths.get(FileName));
			// TODO create homeService class and move the restcall logic to that class
			// TODO move all urls to constants
			final String uri = "http://localhost:8080/conver";
			// UserAcceptRequestObject userAcceptRequestObject =new UserAcceptRequestObject
			// ();

			userAcceptRequestObject.setFileName(FileName);
			userAcceptRequestObject.setFirstTimeRequest(true);
			RestTemplate restTemplate = new RestTemplate();
			CHControlerTOHome result = restTemplate.postForObject(uri, userAcceptRequestObject,
					CHControlerTOHome.class);
			System.out.println("####");
			System.out.println(result.getFinalResponseObject());
			System.out.println(result.getPossibleServicesList());
			// rendering response data to jsp page
			// things needed to be rendered
			// username,possible services list
			model.addAttribute("result", result);
			model.addAttribute("possibleServices", result.getPossibleServicesList());
			model.addAttribute("userName", result.getUserName());
			model.addAttribute("fileName", result.getFileName());

			return "output";
		}

	}

	@PostMapping("/nextRequest")
	public String nextTimeInvocation(@ModelAttribute("result") CHControlerTOHome presult, ModelMap model) {
		System.out.println("****** next time invocation method" + presult);
		System.out.println(presult.getUserName());
		System.out.println(presult.getFileName());
		System.out.println(presult.getPossibleServicesList().get(0));

		String FileName = DirectoryPath + presult.getFileName();
		System.out.println(FileName);
		// Files.copy(File.getInputStream(), Paths.get(FileName));
		// TODO create homeService class and move the restcall logic to that class
		// TODO move all urls to constants
		final String uri = "http://localhost:8080/conver";
		UserAcceptRequestObject userAcceptRequestObject = new UserAcceptRequestObject();
		userAcceptRequestObject.setFileName(FileName);
		userAcceptRequestObject.setService(presult.getPossibleServicesList().get(0));
		userAcceptRequestObject.setUserName(presult.getUserName());
		userAcceptRequestObject.setLastProcessedCharacter(presult.getLastProcessedCharacter());
		RestTemplate restTemplate = new RestTemplate();
		CHControlerTOHome result = restTemplate.postForObject(uri, userAcceptRequestObject, CHControlerTOHome.class);
		System.out.println("####");
		System.out.println(result.getFinalResponseObject());
		System.out.println(result.getPossibleServicesList());
		// rendering response data to jsp page
		// things needed to be rendered
		// username,possible services list
		model.addAttribute("result", result);
		model.addAttribute("possibleServices", result.getPossibleServicesList());
		model.addAttribute("userName", result.getUserName());
		model.addAttribute("fileName", result.getFileName());

		return "output";
	}

}
