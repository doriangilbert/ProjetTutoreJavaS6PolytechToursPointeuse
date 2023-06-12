package application;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;

import static application.AppCentrale.Enterprise1;
import static java.lang.Thread.sleep;

public class AppCentraleSerialization implements Runnable {

    @Override
    public void run() {
            while(true){
                try{
                    FileOutputStream fos = new FileOutputStream("Enterprise1.dat");
                    ObjectOutputStream oos = new ObjectOutputStream(fos);
                    oos.writeObject(Enterprise1);
                    oos.close();
                    System.out.println("Save Finished");
                    sleep(5000);
                }
                catch (IOException | InterruptedException e){

                }
            }

    }
}
