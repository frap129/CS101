import java.util.*;
import java.io.*;
import java.nio.file.Files;

public class CopyFile {
    public static void main(String [] args) throws Exception
    {
       File inFile = new File(args[0]);       
       File outFile = new File(args[1]);
       Files.copy(inFile.toPath(), outFile.toPath());
    }
}