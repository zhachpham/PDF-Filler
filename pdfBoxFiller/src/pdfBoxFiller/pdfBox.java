

package pdfBoxFiller;


import java.io.File;
import java.io.IOException;
import java.util.*;

import java.awt.Desktop;

import java.util.Scanner;




//import org.apache.pdfbox.exceptions.COSVitorException;
import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.pdmodel.PDDocumentCatalog;
import org.apache.pdfbox.pdmodel.PDPage;
import org.apache.pdfbox.pdmodel.interactive.form.PDAcroForm;
import org.apache.pdfbox.pdmodel.interactive.form.PDField;
import org.apache.pdfbox.pdmodel.font.PDFont;
import org.apache.pdfbox.pdmodel.font.PDType1Font;
import org.apache.pdfbox.pdmodel.font.PDFontDescriptor;
import org.apache.pdfbox.pdmodel.font.PDSimpleFont;
import org.apache.pdfbox.pdmodel.PDResources;
import org.apache.pdfbox.cos.COSName;
import org.apache.pdfbox.pdmodel.interactive.form.PDCheckBox;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;



import org.apache.pdfbox.pdmodel.common.PDRectangle;
import org.apache.pdfbox.pdmodel.interactive.annotation.PDAnnotationWidget;

import java.util.Iterator;

public class pdfBox{

		public static void autoFillSepIRA(String data, String accountNumber)throws IOException
		{

		    Scanner sc=new Scanner(System.in);
		    
		    // "data" is enrollment snapshot data
		    
		    //remove first and last border
		    data = data.replace("{", "");
		    data = data.replace("}", "");
		    
		    //Creates Key Value Pairs
		    String[] keyValueArray = data.split(", ");
		    System.out.println(Arrays.toString(keyValueArray));
			    
			    HashMap<String, String> keysAndValues = new HashMap<String,String>();
			    for(int i = 0; i < keyValueArray.length; i++) {
			        String[] split = keyValueArray[i].split("=");
			        String key = split[0];
			        String value = "";
			        if (split.length == 2) {
			            value = split[1];    
			        }
			        keysAndValues.put(key, value);
			    }
			    System.out.println(keysAndValues);

	    
	    //Prints All Keys and Values 
	    Set set = keysAndValues.entrySet();
	      Iterator iterator = set.iterator();
	      while(iterator.hasNext()) {
	         Map.Entry mentry = (Map.Entry)iterator.next();
	         System.out.print("key is: "+ mentry.getKey() + " ||||| Value is: ");
	         System.out.println(
	        	 mentry.getValue());
	      }

	      
	      //Calls PDF File to Fill
	      File file = new File("/Users/zhachpham/Desktop/SEP Account App.pdf"); 
		    PDDocument document = PDDocument.load(file); 
		    
	        
		    PDDocumentCatalog docCatalog = document.getDocumentCatalog();
	        PDAcroForm acroForm = docCatalog.getAcroForm();
	        
       

	            //********************************ACCOUNT APPLICATION************************************************

	        	
	        	// account number
	        	PDField accountQFA = acroForm.getField("ACCOUNT NUMBER");
	        	
	        	accountQFA.setValue("QFA");
	        	
	        	PDField accounttNumber = acroForm.getField("ACCOUNT NUMBER 2");
	        	accounttNumber.setValue(accountNumber);
	        	
		        //Investment Professional Number 
		        PDField IPNumber = acroForm.getField("Step1IP#");
		        IPNumber.setValue("ERA");
		        
		        
		        //Account type 
		        String name = keysAndValues.get("person.primary.name");
			    String accountType = keysAndValues.get("accountTitle");
			    System.out.println(name);
		        
		    	PDField AcctTitle = acroForm.getField("Step1AcctTitle");
		    	AcctTitle.setValue(accountType);
		    	


		    	//SSN
		        
		    	String SSN = keysAndValues.get("person.primary.ssn");
		    	System.out.println("\n" + "SSN  = " + SSN);
			    
			PDField PDSSN = acroForm.getField("Step2SSN");
			PDSSN.setValue(SSN);
			      
			    
		        
			//Email
			String email = keysAndValues.get("person.primary.emailAddress");
			System.out.println("\n" + "Email  = " + email);
			    
			PDField PDemail = acroForm.getField("Step2Email");
			PDemail.setValue(email);
		        
			PDField PDemail2 = acroForm.getField("Step8Email");
			PDemail2.setValue(email);
		        
			    
		    	
		    	//Name
		        
			System.out.println("\n" + "Name  = " + name);
			    
			PDField acctFullName = acroForm.getField("Step1ClientName");
			acctFullName.setValue(name);
			   
			//First
		        String firstName = keysAndValues.get("person.primary.firstName");
		        
		        PDField acctFirstName = acroForm.getField("Step2FirstName");
		        acctFirstName.setValue(firstName);
			    
			//Middle
			String middleName = keysAndValues.get("person.primary.middleName");
		        
		        PDField acctMiddleName = acroForm.getField("Step2MI");
		        acctMiddleName.setValue(middleName);
		        
		        //Last
			String lastName = keysAndValues.get("person.primary.lastName");
		        
		        PDField acctLastName = acroForm.getField("Step2LastName");
		        acctLastName.setValue(lastName);
			    
		        PDField acctFullName3 = acroForm.getField("Step11PrintName1");
		        acctFullName3.setValue(name) ;
		        
	        	//Birth Month
		    	
		    	String birthdayMonth = keysAndValues.get("person.primary.birthdayMonth");
			System.out.println("\n" + "Birth Month  = " + birthdayMonth);
			    
			PDField PDbirthdayMonth = acroForm.getField("Step2DOB1");
			PDbirthdayMonth.setValue(birthdayMonth);
			    
			PDField PDbirthdayMonth2 = acroForm.getField("Step8DOB1");
			PDbirthdayMonth2.setValue(birthdayMonth);
			    
	        	//Birth Day
		    	
		    	String birthdayDay = keysAndValues.get("person.primary.birthdayDay");
			System.out.println("\n" + "Birth Day  = " + birthdayDay);
			    
			PDField PDbirthdayDay = acroForm.getField("Step2DOB2");
			PDbirthdayDay.setValue(birthdayDay);
			    
			PDField PDbirthdayDay2 = acroForm.getField("Step8DOB2");
			PDbirthdayDay2.setValue(birthdayDay);
			    
	        	//Birth Year
		    	
		    	String birthdayYear = keysAndValues.get("person.primary.birthdayYear");
			System.out.println("\n" + "Birth Year  = " + birthdayYear);
			    
			PDField PDbirthdayYear = acroForm.getField("Step2DOB3");
			PDbirthdayYear.setValue(birthdayYear);
			    
			PDField PDbirthdayYear2 = acroForm.getField("Step8DOB3");
			PDbirthdayYear2.setValue(birthdayYear);
	        	
	        	//Phone Number
		    	String phoneNumber = keysAndValues.get("person.primary.formattedPhoneNumber");
			System.out.println("\n" + "Phone Number  = " + phoneNumber);
			    
	        	PDField DOB1 = acroForm.getField("Step2HomePhone");
	        	DOB1.setValue(phoneNumber); 
	        	
	        	
		        //Adress
	        	String address = keysAndValues.get("person.primary.address");
			System.out.println("\n" + "Adress  = " + address);
	        	
		         
		        PDField AcctStreetAddress = acroForm.getField("Step2LegalAddress");
		        AcctStreetAddress.setValue(address);
		        
		        //City
		        String city = keysAndValues.get("person.primary.address.city");
			System.out.println("\n" + "City  = " + city);
		         
		        PDField AcctCityAddress = acroForm.getField("Step2LegalCity");
		        AcctCityAddress.setValue(city);
		        
		        //State
		        String state = keysAndValues.get("person.primary.address.state");
			System.out.println("\n" + "State  = " + state);
		        
		        PDField AcctStateAddress = acroForm.getField("Step2LegalState");
		        AcctStateAddress.setValue(state);
		        
		        //ZIP
		        String zip = keysAndValues.get("person.primary.address.postalCode");
			System.out.println("\n" + "ZIP  = " + zip);		    
		        
		        PDField AcctZIPAddress = acroForm.getField("Step2LegalZip");
		        AcctZIPAddress.setValue(zip);
		        
		        //Country
		        String country = keysAndValues.get("person.primary.address.country");
			System.out.println("\n" + "Country  = " + country);		
		        
		        PDField AcctCountryAddress = acroForm.getField("Step2LegalProvince");
		        AcctCountryAddress.setValue(country);

		        
		        //US Citizenship & Tax Residence & Fund Source
		        String citizenship = keysAndValues.get("person.primary.citizenshipStatus");
			System.out.println("\n" + "Citizenship  = " + citizenship);
			    
			PDField PDcitzenship = acroForm.getField("Step2Citizen");
			PDcitzenship.setValue("1") ;
			    
			PDField residence = acroForm.getField("Step2Residence");
			residence.setValue("1") ;
			    
            
		        
		        //possible values are [11, 22, 12, 23, 13, 14, 15, 16, 17, 18, 19, 0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 20, 10, 21] and Off
		        //SEP IRA = 20
		        PDField AcctType = acroForm.getField("Step1Type");
		        AcctType.setValue("20") ;
		        
		        //Funding
		        PDField funding = acroForm.getField("Step5Funding");
		        funding.setValue("8") ;
	        
		        
		        //Employer
		        String employer = keysAndValues.get("person.primary.employerName");
			System.out.println("\n" + "Employer  = " + employer);
		        
		        
		        PDField AcctEmployer = acroForm.getField("Step2EmplName");
		        AcctEmployer.setValue(employer);
		        
		        
		        //Years Employed
		        String yearsEmployed = keysAndValues.get("person.primary.numberOfYearsEmployed");
			System.out.println("\n" + "# years employed : " + yearsEmployed);
		        
		        PDField AcctEmployedYears = acroForm.getField("Step2EmplYears");
		        AcctEmployedYears.setValue(yearsEmployed);
		        

//		        //Occupation
		        String occupation = keysAndValues.get("person.primary.occupation");
			System.out.println("\n" + "Occupation : " + occupation);

		        PDField AcctOccupation = acroForm.getField("Step2EmplOccupation");
		        AcctOccupation.setValue(occupation);
		        
		        
		        //Employer Address
		        String occupationAdress = keysAndValues.get("person.primary.employerAddress.address");
			System.out.println("\n" + "Employer Address : " + occupationAdress);
			    
		        PDField AcctEmployerAddress = acroForm.getField("Step2EmplAddress");
		        AcctEmployerAddress.setValue(occupationAdress);

		        
		        //Employer City
		        String occupationCity = keysAndValues.get("person.primary.employerAddress.city");
			System.out.println("\n" + "Employer City : " + occupationCity);
			    
		        PDField AcctEmployerCity = acroForm.getField("Step2EmplCity");
		        AcctEmployerCity.setValue(occupationCity);
		        
		        
			     //Employer State
		        String occupationState = keysAndValues.get("person.primary.employerAddress.state");
			System.out.println("\n" + "Employer State : " + occupationState);
		        
		        PDField AcctEmployerState = acroForm.getField("Step2EmplState");
		        AcctEmployerState.setValue(occupationState);    
		        

		        //Employer Country
		        String occupationCountry = keysAndValues.get("person.primary.employerAddress.country");
			System.out.println("\n" + "Employer Country : " + occupationCountry);
		        
			    
		        PDField AcctEmployerCountry = acroForm.getField("Step2EmplProvince");
		        AcctEmployerCountry.setValue(occupationCountry);

		        //Employer ZIP
		        String occupationZIP = keysAndValues.get("person.primary.employerAddress.postalCode");
			System.out.println("\n" + "Employer ZIP : " + occupationZIP);
		        
			    
		        PDField AcctEmployerZIP = acroForm.getField("Step2EmplZip");
		        AcctEmployerZIP.setValue(occupationZIP);
		        	        
		        //Mothers Maiden Name
		        String mothersMaidenName = keysAndValues.get("person.primary.encryptedMotherMaidenName");
			System.out.println("\n" + "Mothers Maiden Name : " + mothersMaidenName);
		        
		        
			    
		        PDField AcctMothersMaiden = acroForm.getField("Step8Maiden");
		        AcctMothersMaiden.setValue(mothersMaidenName);
		        System.out.println("New Value:"+  acroForm.getField("Step8Maiden"));
		        System.out.println("TESTING" + AcctMothersMaiden.getValueAsString());
		        

		      
		        
		        //Opens Filled PDF
		        try {
		            document.save("/Users/zhachpham/Desktop/SEP Account App.pdf"); // save changes to another file
			    document.close();
			    Desktop.getDesktop().open(new File("/Users/zhachpham/Desktop/SEP Account App.pdf"));
		        }
		        
		        catch (Exception e)
		        {
		            System.out.println(e);
			}
			}
	}
