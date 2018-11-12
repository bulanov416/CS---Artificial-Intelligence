package DominoProblem;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class DataParser {

    public static void main(String[] args) throws IOException {

        String string = "";

        Scanner fileReader = new Scanner(new File("C:\\Users\\Alex Bulanov\\Documents\\School\\2018-2019\\CS - Artificial Intelligence\\src\\misc\\data.txt")).useDelimiter(",\\s*");

        List<String> temps = new ArrayList<String>();

        while (fileReader.hasNext()) {
            string = fileReader.next();
            temps.add(string);
        }
        fileReader.close();

        String[] tempsArray = temps.toArray(new String[0]);

        for (String s : tempsArray) {
            System.out.println(s);
        }
    }
}