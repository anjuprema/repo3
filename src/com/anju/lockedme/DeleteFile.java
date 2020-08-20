package com.anju.lockedme;

import java.io.File;
import java.util.Scanner;

public class DeleteFile {
	public static String destnPath;
	public DeleteFile(String destn) {
		this.destnPath = destn;
	}
	
	public void deleteFileMain() {
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter File Name: ");
		String deleteFile = sc.nextLine();
		String deleteFilePath = destnPath+deleteFile;
		File f = new File(deleteFilePath);
		if(f.exists()) {
			boolean status = f.delete();
			if(status) System.out.println("File Deleted Succesfully..");
		}else {
			System.out.println("Sorry! Cannot delete. File doesnot exist..");
		}
	}

}
