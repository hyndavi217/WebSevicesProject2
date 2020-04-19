package com.umd.webservicesProject.project2.utility;

import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.springframework.stereotype.Component;

import com.umd.webservicesProject.project2.TO.CHServiceUtilTO;
import com.umd.webservicesProject.project2.TO.CHUtilSeviceTO;

@Component
public class FileReadingUtility {

	public CHUtilSeviceTO fIleReadingUtilityMethod(CHServiceUtilTO pUser) {
		System.out.println("@@@@@inside util class");
		System.out.println("pUser.getResponseChar()" + pUser.getResponseChar());
		System.out.println(pUser.getSelectedService());
		System.out.println("pUser.getSelectedService()" + pUser.getFilePath());

		String userName = pUser.getUserName();
		String intialSelectedService = pUser.getSelectedService();
		String intialResponse = pUser.getResponseChar();
		String intialTwoByteChar = intialSelectedService + intialResponse;
		List<String> finalServices = new ArrayList<String>();
		String finalChar = null;

		List<List<String>> listObject = new ArrayList<>();
		try {
			// reading lines in a file
			List<String> lines = Files.readAllLines(Paths.get(pUser.getFilePath()));
			// reading no of lines in afile
			// int linesCount = lines.size();
			for (String line : lines) {
				// Storing each line as a object in list
				List<String> twoByteStringArray = new ArrayList<String>();
				for (int i = 0; i <= line.length() - 1; i = i + 2) {
					String ByteChars = String.valueOf((line.charAt(i))) + String.valueOf((line.charAt(i + 1)));
					twoByteStringArray.add(ByteChars);
				}
				listObject.add(twoByteStringArray);
			}
			for (List<String> x : listObject)
				System.out.println(x);

			System.out.println("****");

			// getting each list
			// creating string array
			for (int i = 0; i < listObject.size(); i++) {
				System.out.println("listObject" + listObject);
				System.out.println("size:" + listObject.size());
				System.out.println("size:" + listObject.get(i).size());
				Iterator<String> iter = listObject.get(i).iterator();
				while (iter.hasNext()) {
					String elem = iter.next();
					System.out.println(elem);
					System.out.println("intialTwoByteChar" + intialTwoByteChar);
					if (intialTwoByteChar.equals(elem)) {
						System.out.println("matching element");
						while (iter.hasNext()) {
							String s = iter.next();
							if (intialResponse.equals(s.substring(1))) {
								finalServices.add(s);
							}
						}
					}
				}
				System.out.println("finalservices" + finalServices);

			}
			if (finalServices.isEmpty()) {
				System.out.println("end service");
				finalChar = "end";
			} else {
				finalChar = finalServices.get(0);
			}
			System.out.println("final service:" + finalChar);
		}

		catch (Exception e) {
			e.printStackTrace();
		}
		CHUtilSeviceTO ProcessedOutput = new CHUtilSeviceTO();
		ProcessedOutput.setPossibleServicesToSelect(finalServices);
		ProcessedOutput.setFinalChar(finalChar);

		ProcessedOutput.setUserName(userName);

		return ProcessedOutput;
	}

}
