package com.anju.lockedme;

import java.io.File;
import java.util.InputMismatchException;
import java.util.Scanner;

public class LockedMeMain {
	public static String rootPath  = System.getProperty("user.home");
	public static String destnPath = rootPath+"\\toanju\\";
	public void greetUser() {
		System.out.println("**************************************");
		System.out.println("*     Hello! Welcome to LockedMe     *");
		System.out.println("*     File Management Application    *");
		System.out.println("*                                    *");
		System.out.println("*     Created by: Anju Prema         *");
		System.out.println("**************************************");
	}
	
	public Integer showMainMenu() throws InvalidOptionException {
		Scanner sc = new Scanner(System.in);
		Integer opt;
		System.out.println("1. List Files");
		System.out.println("2. Manage Files");
		System.out.println("3. Exit");
		System.out.println("Enter the option: ");
		opt = sc.nextInt();
		if(opt > 0 && opt <=3) {
			return opt;
		}else throw new InvalidOptionException("Sorry.. Cannot process.You entered an Invalid option..");
	}
	
	public void processMainMenuOption(Integer mainOpt) throws InvalidOptionException {
		switch(mainOpt) {
		case 1:
			/*List Files in system*/
			break;
		case 2:
			/*Manage files in the system*/
			Integer manageOpt = showManageFilesMenu();
			processManageFilesOption(manageOpt);
			break;
		case 3:
			/*Exit*/
			sayGoodBye();
			break;
		}
	}
	
	public Integer showManageFilesMenu() throws InvalidOptionException{
		Integer opt;
		Scanner sc = new Scanner(System.in);
		System.out.println("");
		System.out.println("---------    Manage Files   ----------");
		System.out.println("1. Add New File");
		System.out.println("2. Delete File");
		System.out.println("3. Search File");
		System.out.println("4. Go Back");
		System.out.println("Enter the option: ");
		opt = sc.nextInt();
		if(opt > 0 && opt <=4) {
			return opt;
		}else throw new InvalidOptionException("Sorry.. Cannot process.You entered an Invalid option..");
		
	}
	
	public void processManageFilesOption(Integer opt) throws InvalidOptionException {
		Integer manageOpt;
		switch(opt) {
		case 1:
			/*Add new file*/
			AddNewFile addNew = new AddNewFile(rootPath,destnPath);
			addNew.addNewFileMain();
			manageOpt = showManageFilesMenu();
			processManageFilesOption(manageOpt);
			break;
		case 2:
			/*Delete file*/
			DeleteFile delFile = new DeleteFile(destnPath);
			delFile.deleteFileMain();
			manageOpt = showManageFilesMenu();
			processManageFilesOption(manageOpt);
			break;
		case 3:
			/*Search file*/
			break;
		case 4:
			/*Exit and go to main menu*/
			try {
				Integer mainOpt = showMainMenu();
				processMainMenuOption(mainOpt);
			} catch (InvalidOptionException e) {
				e.getMessage();
			}
			break;
		}
	}
	
	public void sayGoodBye() {
		System.out.println("------- Exiting Successfully ---------");
		System.out.println("-----------   Thank you  -------------");
	}
	
	public LockedMeMain() {
		/*make my destination folder ready*/
		File f = new File(destnPath);
		if(! f.exists()) {
			f.mkdir();
		}
	}
	
	public static void main(String[] args) {
		try {
			LockedMeMain lm = new LockedMeMain();
			lm.greetUser();
			Integer mainOpt = lm.showMainMenu();
			lm.processMainMenuOption(mainOpt);
		}catch(InvalidOptionException e) {
			System.out.println(e.getMessage());
		}catch(InputMismatchException e) {
			System.out.println("Sorry.. Cannot process.You entered an Invalid option..");
		}
	}

}
