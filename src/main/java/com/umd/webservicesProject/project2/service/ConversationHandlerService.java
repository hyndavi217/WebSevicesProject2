package com.umd.webservicesProject.project2.service;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.springframework.stereotype.Service;

import com.umd.webservicesProject.project2.TO.CHServiceUtilTO;
import com.umd.webservicesProject.project2.TO.CHUtilSeviceTO;
import com.umd.webservicesProject.project2.model.UserAcceptRequestObject;
import com.umd.webservicesProject.project2.utility.FileReadingUtility;

/**
 * @author hyndavi
 *
 */
@Service
public class ConversationHandlerService {

	private UserAcceptRequestObject user;

	public ConversationHandlerService(UserAcceptRequestObject puser) {
		user = puser;
	}

	public CHUtilSeviceTO readProtocol() {

		System.out.println("inside ch service");
		System.out.println(user.getUserName());
		System.out.println(user.getService());
		System.out.println(user.getFileName());

		// extraxting number from selected service string as ex: 5j
		String service = user.getService();
		String userSelectedService = null;
		Pattern servicepatteren = Pattern.compile("[0-9]");
		Matcher m = servicepatteren.matcher(service);
		while (m.find()) {
			System.out.println(m.group());
			userSelectedService = m.group();

		}
		String intialCharFromUserName = null;
		if (user.isFirstTimeRequest()) {
			intialCharFromUserName = getInitialCharFromName();
		} else {
			intialCharFromUserName = user.getLastProcessedCharacter().substring(1);
		}
		// assigning three values to to object to pass to fileReadUtility class
		CHServiceUtilTO chto = new CHServiceUtilTO();
		chto.setFilePath(user.getFileName());
		chto.setResponseChar(intialCharFromUserName);
		chto.setSelectedService(userSelectedService);
		chto.setUserName(user.getUserName());
		// supplying TO object
		// calling utility for file read
		FileReadingUtility fileReadingUtility = new FileReadingUtility();
		CHUtilSeviceTO cHUtilSeviceTO = fileReadingUtility.fIleReadingUtilityMethod(chto);
		cHUtilSeviceTO.setTwoByteService(userSelectedService + intialCharFromUserName);
		System.out.println("******CHService output ");
		System.out.println(cHUtilSeviceTO.getFinalChar());
		System.out.println(cHUtilSeviceTO.getUserName());
		System.out.println(cHUtilSeviceTO.getPossibleServicesToSelect());

		return cHUtilSeviceTO;

	}

	public String getInitialCharFromName() {
		// evaluating the intial char based on starting user name as string
		String userName = user.getUserName();
		String intialchar = Character.toString((userName.charAt(0)));
		// using regex to patteren match
		String intialCharFromUserName;
		Pattern charpatteren = Pattern.compile("[a-m A-M]");
		Matcher matching = charpatteren.matcher(intialchar);
		if (matching.find()) {
			intialCharFromUserName = "j";
		} else {
			intialCharFromUserName = "x";
		}
		System.out.println("****regex*****");
		System.out.println(intialCharFromUserName);
		return intialCharFromUserName;
	}

}
