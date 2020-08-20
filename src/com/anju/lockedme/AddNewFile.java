package com.anju.lockedme;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Scanner;

public class AddNewFile {
	public static String rootPath;
	public static String destnPath;
	
	public AddNewFile(String root, String destn){
		this.rootPath = root;
		this.destnPath = destn;
	}
	
	public void addNewFileMain() {
		Scanner sc = new Scanner(System.in);
		String newFilePath;
		
		System.out.println("Enter path of the file that you need to save");
		System.out.println(rootPath+": ");
		newFilePath = sc.nextLine();
		File source = new File(rootPath+newFilePath);
		if(source.exists()) {
			try {
				Path fileName = Paths.get(rootPath+newFilePath).getFileName();
				File destn = new File(destnPath+fileName);
				if(!destn.exists()) {
					Files.copy(Paths.get(rootPath+newFilePath), Paths.get(destnPath+fileName));
					System.out.println("Saved File Successfully..");
				}else throw new InvalidOptionException("Sorry! Cannot copy, file already exists..");
				
			} catch (IOException e) {
				e.getStackTrace();
				System.out.println("Error Occured wile moving file");
			} catch (InvalidOptionException e) {
				System.out.println(e.getMessage());
			}
		}else {
			System.out.println("File doesnot exit: "+rootPath+newFilePath);
		}
	}
}
