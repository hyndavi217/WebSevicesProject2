package com.umd.webservicesProject.project2.controller;

import java.io.StringWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.converter.xml.Jaxb2RootElementHttpMessageConverter;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.umd.webservicesProject.project2.TO.CHControlerTOHome;
import com.umd.webservicesProject.project2.TO.CHUtilSeviceTO;
import com.umd.webservicesProject.project2.TO.CHandlerWebServiceClassTO;
import com.umd.webservicesProject.project2.constants.ConstantsClass;
import com.umd.webservicesProject.project2.model.UserAcceptRequestObject;
import com.umd.webservicesProject.project2.service.ConversationHandlerService;

@RestController
public class ConversationHandlerController {

	@Autowired
	private RestTemplate restTemplate;

	@Bean
	public RestTemplate restTemplate(RestTemplateBuilder builder) {
		List<HttpMessageConverter<?>> convertor = new ArrayList<HttpMessageConverter<?>>();
		convertor.add(new Jaxb2RootElementHttpMessageConverter());
		builder.messageConverters(convertor);
		return builder.build();
	}

	@PostMapping(path = "/conver")
	@ResponseBody
	public CHControlerTOHome acceptData(@RequestBody UserAcceptRequestObject user) throws JAXBException {
		System.out.println("inside ch controller");
		System.out.println(user.getUserName());
		// Invoking reading file method in util class from service
		ConversationHandlerService ch = new ConversationHandlerService(user);
		CHUtilSeviceTO cHUtilSeviceTO = ch.readProtocol();

		System.out.println("**** inside Conversation Handler COntroller");
		System.out.println(cHUtilSeviceTO.getFinalChar());
		System.out.println(cHUtilSeviceTO.getUserName());
		System.out.println(cHUtilSeviceTO.getPossibleServicesToSelect());
		// output 6j
		// hyndavi
		// [6j, 9j]
		// make a rest call to resultant web service and get the response based on the
		// resulted char
		CHandlerWebServiceClassTO cHandlerWebServiceClassTO = new CHandlerWebServiceClassTO();
		cHandlerWebServiceClassTO.setUserName(cHUtilSeviceTO.getUserName());
		cHandlerWebServiceClassTO.setResponseChar(cHUtilSeviceTO.getTwoByteService());

		// possible services with excluding intial string
		List<String> possibleServiceWithExcludingIntialString = new ArrayList<String>();
		possibleServiceWithExcludingIntialString = cHUtilSeviceTO.getPossibleServicesToSelect();
		System.out.println("before excluding" + possibleServiceWithExcludingIntialString);
		// possibleServiceWithExcludingIntialString.remove(0);
		System.out.println("******possibleServiceWithExcludingIntialString" + possibleServiceWithExcludingIntialString);

		// end point ex:/6
		System.out.println(Character.toString(cHUtilSeviceTO.getTwoByteService().charAt(0)));

		String requestedURL = "/" + Character.toString(cHUtilSeviceTO.getTwoByteService().charAt(0));
		System.out.println("***requestedURL" + requestedURL);
		//
		String uri = ConstantsClass.url + requestedURL;
		// RestTemplate restTemplate = new RestTemplate();
		HttpEntity<?> entity;
		String CharFindsTypeOFResponse = Character.toString(cHUtilSeviceTO.getTwoByteService().charAt(1));

		HttpHeaders headers = new HttpHeaders();
		if (CharFindsTypeOFResponse.equals("j")) {
			headers.setContentType(MediaType.APPLICATION_XML);
			headers.setAccept(Collections.singletonList(MediaType.APPLICATION_JSON));
		} else {
			headers.setContentType(MediaType.APPLICATION_XML);
			headers.setAccept(Collections.singletonList(MediaType.APPLICATION_XML));
		}

		JAXBContext jaxbContext = JAXBContext.newInstance(CHandlerWebServiceClassTO.class);
		Marshaller marsheller = jaxbContext.createMarshaller();
		marsheller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
		StringWriter sw = new StringWriter();
		marsheller.marshal(cHandlerWebServiceClassTO, sw);
		entity = new HttpEntity<>(sw.toString(), headers);
		ResponseEntity<String> result1 = restTemplate.exchange(uri, HttpMethod.POST, entity, String.class);
		System.out.println("&&&&&");
		System.out.println(result1.getBody());
		// adding the response object as string with filename and possible services list
		// to TO object to pass to home controller
		CHControlerTOHome cHControlerTOHome = new CHControlerTOHome();
		cHControlerTOHome.setLastProcessedCharacter(cHUtilSeviceTO.getTwoByteService());
		cHControlerTOHome.setFinalResponseObject(result1.getBody());
		System.out.println("^^^^^^^^");

		String filePath = user.getFileName();
		System.out.println(filePath);
		// we want only filename not the path so extracting file name from path
		String fileName = filePath.substring(30);
		System.out.println(fileName);
		cHControlerTOHome.setFileName(fileName);
		// get the possible services list object ex:[6j,6j,7x,4x]
		// remove the repetition and remove the first string
		System.out.println("@@@@@posible services list");
		// possibleServiceWithExcludingIntialString and including repetition
		// avoid repetition
		System.out.println(cHUtilSeviceTO.getPossibleServicesToSelect());
		// [4x, 6x, 4x, 4x]
		List<String> possibleServiceWithoutRepetitionWithExcludingIntialString = new ArrayList<String>();

		for (String s : possibleServiceWithExcludingIntialString) {
			if (!possibleServiceWithoutRepetitionWithExcludingIntialString.contains(s)) {
				possibleServiceWithoutRepetitionWithExcludingIntialString.add(s);
			}
		}
		System.out.println("!!!!!!possibleServiceWithoutRepetitionWithExcludingIntialString"
				+ possibleServiceWithoutRepetitionWithExcludingIntialString);
		// ******possible service with single letter ex:4,6
		List<String> possibleServiceNumbers = new ArrayList<String>();
		for (int i = 0; i < possibleServiceWithoutRepetitionWithExcludingIntialString.size(); i++) {
			String number = Character
					.toString(possibleServiceWithoutRepetitionWithExcludingIntialString.get(i).charAt(0));
			String fNumber = "Service" + " " + number;
			possibleServiceNumbers.add(fNumber);
		}
		System.out.println("%%%%% possible services list with numbers" + possibleServiceNumbers);
		// cHControlerTOHome - possible service number
		cHControlerTOHome.setPossibleServicesList(possibleServiceNumbers);
		String r = result1.getBody();
		System.out.println(r);
		// adding response from webservices as string to pojo
		cHControlerTOHome.setFinalResponseObject(r);
		cHControlerTOHome.setUserName(user.getUserName());
		return cHControlerTOHome;
	}
}
