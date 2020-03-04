package Global;

import org.apache.log4j.Logger;

public class Global {

    public static Logger logger;

    public static void initializeLogger(String className){
        logger = Logger.getLogger(className);
    }

    public static int[] generateRandomArray(int size){

        int[] a = new int[size];

        for (int i = 0; i < size; i++) {
            a[i] = (int) (Math.random()*100);
        }

        return a;
    }

}
