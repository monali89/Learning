package ltcd;

import org.junit.Assert;
import java.util.ArrayList;

public class ZigzagConversion {

    public static void main(String[] args) {
        Assert.assertEquals(convert("PAYPALISHIRING", 4), "PAHNAPLSIIGYIR");
    }

    public static String convert(String s, int numRows) {

        ArrayList<Character[]> final_list = new ArrayList<Character[]>();
        Character[] ai = new Character[numRows];
        boolean is_diagonal = false;
        int before_spaces = 0, after_spaces = 0;
        char[] a = s.toCharArray();

        int i = 0;

        while(i<a.length){
            if(is_diagonal){
                int j = 0;
                for(int x=0; x<before_spaces; x++) ai[j++] = ' ';
                before_spaces--;
                ai[j++] = a[i++];
                for(int x=0; x<after_spaces; x++) ai[j++] = ' ';
                after_spaces++;
                if(before_spaces == 0) is_diagonal = false;
            }else{
                int j=0;
                while(j<numRows && i<a.length){
                    ai[j] = a[i];
                    j++;
                    i++;
                }
                is_diagonal = true;
                after_spaces = 1;
                before_spaces = numRows - after_spaces - 1;
            }
            /*for(int m=0; m<ai.length; m++){
                System.out.print(ai[m] + " ");
            }
            System.out.println("");
            System.out.println("Adding - " + ai.toString());*/
            final_list.add(ai);
        }

        //System.out.println();
        String ans = "";

        /*for(int m=0; m<final_list.size(); m++){
            System.out.println(final_list.get(m));
        	*//*Character[] temp_a = final_list.get(m);
        	for(int n=0; n<temp_a.length; n++){
        		System.out.print(temp_a[n] + " ");
        	}
        	System.out.println();*//*
        }*/

        int rowCtr = 0;
        int mapCtr = 0;
        while(rowCtr<numRows){
        	while(mapCtr<final_list.size()){
        		Character[] temp_a = final_list.get(mapCtr);
        		if(temp_a[rowCtr] != ' '){
            		ans = ans + temp_a[rowCtr];
            	}
            	mapCtr++;
        	}
        	mapCtr = 0;
        	rowCtr++;
        }


        return ans;
    }

}

/*
* The string "PAYPALISHIRING" is written in a zigzag pattern on a given number of rows like this:
* (you may want to display this pattern in a fixed font for better legibility)
*
*   P   A   H   N
*   A P L S I I G
*   Y   I   R
*
* And then read line by line: "PAHNAPLSIIGYIR"
* Write the code that will take a string and make this conversion given a number of rows:
*
* */












