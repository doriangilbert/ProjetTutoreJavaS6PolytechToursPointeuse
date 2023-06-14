package application;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;

import static application.CentralApplication.Enterprise1;
import static java.lang.Thread.sleep;

public class CentralApplicationSerialization implements Runnable {

    @Override
    public void run() {
               try{
                    FileOutputStream fos = new FileOutputStream("Enterprise1.dat");
                    ObjectOutputStream oos = new ObjectOutputStream(fos);
                    oos.writeObject(CentralApplication.Enterprise1);
                    System.out.println("Save Finished");
                    oos.close();
                    fos.close();
                }
                catch (IOException e){

                }
            }

    }
