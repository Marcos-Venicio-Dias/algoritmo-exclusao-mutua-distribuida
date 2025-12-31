import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

public class CriticalResource {

    public CriticalResource()
    {
        this.generate();
    }


    public void generate()
    {
        File file = new File("recurso_critico.txt");
        try
        {

        if(file.createNewFile())
            {
                System.out.println("Critical resource generated successfully!");
            }else
                {
                    System.out.println("Critical resource already exists!");
                }
        }catch(IOException error)
        {
            System.out.println("Error to generate critical resource!");
        }
    }


    public void writeFile(Payload payload, File file)
    {
        try
        {
            FileWriter fileToWrite = new FileWriter(file,true);
            PrintWriter writeInFile = new PrintWriter(fileToWrite);

            writeInFile.println(payload);
            writeInFile.close();
            

        }catch(IOException error)
           {
                System.out.println("Error to write in file.");
           }
    }
}
