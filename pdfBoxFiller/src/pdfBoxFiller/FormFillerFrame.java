package pdfBoxFiller;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JTextField;
import java.awt.BorderLayout;
import javax.swing.JButton;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JLabel;

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


public class FormFillerFrame {
	private JTextField textField;
    
	
	public static void main(String[] args) {    
	    new FormFillerFrame();    
	}
    
	FormFillerFrame(){    
		JFrame f=new JFrame("SEP Account App Filler"); 
					//submit button
		JButton b=new JButton("Submit");    
		b.setBounds(83,222,140, 40);    
					//enter name label
		JLabel label = new JLabel();		
		label.setText("Enrollment Snapshot Data");
		label.setBounds(70, 23, 187, 78);
					//text field to enter name
		JTextField textfield= new JTextField();
		textfield.setBounds(28, 91, 242, 30);
		f.getContentPane().add(textfield);
		f.getContentPane().add(label);
		f.getContentPane().add(b);    
		f.setSize(300,300);    
		f.getContentPane().setLayout(null);    
		
		JTextField zeroAccountNumbertextField = new JTextField();
		zeroAccountNumbertextField.setBounds(83, 156, 130, 26);
		f.getContentPane().add(zeroAccountNumbertextField);
		zeroAccountNumbertextField.setColumns(10);
		
		JLabel lblZeroAccountNumber = new JLabel("Zero Account Number");
		lblZeroAccountNumber.setBounds(80, 128, 143, 16);
		f.getContentPane().add(lblZeroAccountNumber);
		f.setVisible(true);    
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);  
		

		
		
							//action listener
		b.addActionListener(new ActionListener() {
	        
			@Override
		
			public void actionPerformed(ActionEvent arg0) {
					
				String data = textfield.getText();
				
				String zeroAccountNumber = zeroAccountNumbertextField.getText();
				
					try {
					
					pdfBox.autoFillSepIRA(data, zeroAccountNumber);
					
					}
					
					catch (Exception e) {
					   
					}
					
					
					System.out.println(data);
					
			}  
			
		
			
	      });
		}         
}
