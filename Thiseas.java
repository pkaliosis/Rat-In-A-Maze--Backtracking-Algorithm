import java.io.*;
import java.util.*;

public class Thiseas {

    private static char[][] ThiseasArray;
    private static int lines, columns;
    private static int rowEntryPoint, columnEntryPoint;
	private static int c=0,c2=0,a=0,b=0,cols=0;
	private static char[] charArray;
	private static boolean flag = false;

    public static char[][] readFile(String link) {
        File file = null;
        BufferedReader reader = null;
        BufferedReader reader2 = null;
        try {
            file = new File(link);
        }
        catch (NullPointerException exc1) {
            System.err.println("Sorry, file not found...");
        }
        try {
            reader = new BufferedReader(new FileReader(file));
            reader2 = new BufferedReader(new FileReader(file));
        }
        catch (FileNotFoundException exc2) {
            System.err.println("Sorry, there is an error in opening the file...");
        }
        try {
            String line = reader.readLine();
            String line2 = reader2.readLine();
            String[] splitVar = line.split(" ");
            lines = Integer.parseInt(splitVar[0]);//dosmena lines
            columns = Integer.parseInt(splitVar[1]);//dosmena columnes
            c++;
            c2++;
            line = reader.readLine();
            line2 = reader2.readLine();
            splitVar = line.split(" ");
            rowEntryPoint = Integer.parseInt(splitVar[0]);
            columnEntryPoint = Integer.parseInt(splitVar[1]);
            c++;
            c2++;
            while ((line = reader.readLine()) != null) {
                if (flag==false){
                     charArray = line.toCharArray();
                     cols = charArray.length /2 +1;
                     flag = true;
                }
                c++;
            }
            ThiseasArray = new char[c-2][cols];
            while ((line2 = reader2.readLine()) != null) {
                charArray = line2.toCharArray();
                for (int i=0; i < 2 * cols-1; i+=2) {
                    ThiseasArray [c2-2][i/2] = charArray[i];
                }
                c2++;
            }
            return ThiseasArray;
        }
        catch (IOException exc3) {
            System.out.println("There is an error on reading line " + c + ".");
        }
        char[][] exitArray = new char[1][1];
        for (int i=0; i < 2; i++) {
            for (int j=0; j<2; j++) {
                exitArray [i][j] = '2' ;
            }
        }
        System.out.println("Invalid txt file");
        return exitArray;
    }

    public static int findPath(int i, int j,int n,int m, char[][]array, StringStackImpl obj1,StringStackImpl obj2){
		String s1 =String.valueOf(i); String l;
		String s2 =String.valueOf(j);
		if (array[i][j]=='0'){
			if (obj2.search(s1+","+s2)) {
				l = obj2.pop();
				String [] stringar = l.split(","); 
				int k = Integer.parseInt(stringar[0]);
				int b= Integer.parseInt(stringar[1]);
				array[k][b]=1;
			}
			else {
				obj2.push(s1+","+s2);
			} 
			if (( i == n-1) || (j == m-1 ) || ( i == 0) || (j == 0 ) ){
				obj1.push("("+s1+","+s2+")");
				
				return 0;
			}
			obj1.push("("+s1+","+s2+")");


			if (findPath(i,j+1,n,m,array, obj1,obj2)==0) return 0;
			if (findPath(i+1,j,n,m,array, obj1,obj2)==0) return 0;
			if (findPath(i-1,j,n,m,array, obj1,obj2)==0) return 0;
			if (findPath(i,j-1,n,m,array, obj1,obj2)==0) return 0;

			
			obj1.pop();
		}
		if (array[i][j]=='E' ){
			array[i][j]=1;
			obj2.push(s1+","+s2);
			obj1.push("("+s1+","+s2+")");
			
			
			if ( j+1<m ) {
				if (findPath(i,j+1,n,m,array, obj1,obj2)==0) return 0;
			}
			if ( i+1<n ){
				if (findPath(i+1,j,n,m,array, obj1,obj2)==0) return 0;
			}
			if ( i-1 >=0 ) {
				if (findPath(i-1,j,n,m,array, obj1,obj2)==0) return 0;
			}
			if ( j-1>=0 ){
				if (findPath(i,j-1,n,m,array, obj1,obj2)==0) return 0;
			}
			
		}
		return 1; 
	}

    public static void main(String[] args) {
        char[][] array = readFile(args[0]);
        if (array.length == lines && array[0].length == columns) {
            if (array[rowEntryPoint][columnEntryPoint] == 'E') {
		        StringStackImpl obj = new StringStackImpl();
		        StringStackImpl object = new StringStackImpl();
		        if (findPath(rowEntryPoint,columnEntryPoint,lines,columns,array,obj,object)== 0){
			        System.out.println(obj.peek()); 
		        }
		        else {
			        System.out.println("No exit on the maze!");
		        }
            }
            else {
                System.out.println("Invalid input in file!");
            }
        }
        else {
            System.out.println("Invalid input in file!");
        }
    }
}