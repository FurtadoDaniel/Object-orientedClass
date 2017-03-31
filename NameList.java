  
/* Alunos: Barbara Drummond
           Daniel Furtado
*/

import java.io.*; //FileReader and FileWriter
import java.util.Scanner; // keyboard input
import java.util.regex.*; // Pattern and matcher


public class NameList {


    public static String[] addName(String[] Array, String NewName) {

        //verify if array is empty and check the length for the next array
        int len = (Array != null) ? Array.length : 0;
        String[] NewArray = new String[len + 1];

        //copy arrays, garbage collector delete the older array
        for (int Counter = 0; Counter < len; Counter++) NewArray[Counter] = Array[Counter];
        NewArray[len] = NewName;

        return NewArray;
    }


    public static String[] loadList(String[] Names, String Archive) {
        
        String Line = null;
        
        try {

            //transfor the binary file into String
            BufferedReader Lines = new BufferedReader(new FileReader(Archive));

            //run the Archive copyng to an Array
            while((Line = Lines.readLine()) != null) Names = addName(Names, Line);

            Lines.close();  
        }

        //Error menssages
        catch(FileNotFoundException ex){ System.out.println("Unable to open file '" + Archive + "'"); }
        catch(IOException ex) { System.out.println("Error reading file '"+ Archive + "'"); }
        
        return Names; 
    }


    //Return true if Name is Invalid and false if is Valid 
    public static boolean verifyName(String Name) {
        
        //Create a A to Z and space sequences and check if there R a miss match
        Pattern p = Pattern.compile("[^a-z ]", Pattern.CASE_INSENSITIVE);
        boolean HasInvalidCharacter = p.matcher(Name).find();
        
        //Check if there is only spaces in the String
        boolean HasValidCharacter = false;
        for (int Counter =0; Counter < Name.length(); Counter++) if (Name.charAt(Counter) != ' ') HasValidCharacter = true;

        return (!HasValidCharacter || HasInvalidCharacter);
    }


    public static String readName() {

        Scanner Name_enter = new Scanner(System.in);
        String Name;

        do {
            System.out.print("Name:");
            Name = Name_enter.nextLine();
        } while (verifyName(Name));

        return Name;
    }


    public static void printList(String[] List) {

        if (List == null) return;

        System.out.println("\nList:\n");
        for (int Counter = 0 ; Counter < List.length; Counter++) System.out.println( Integer.toString(Counter) + " - " + List[Counter]);
        
        new Scanner(System.in).nextLine(); //wait enter be pressed
    }


    public static void writeList(String[] List, String Archive){

        try {

            if (List == null) return;
            
            BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(Archive));
            
            for (int Counter = 0 ; Counter < List.length; Counter++) {
                bufferedWriter.write(List[Counter]);
                bufferedWriter.newLine();
            }

            bufferedWriter.close();
        }

        catch(IOException ex) { System.out.println("Error writing to file '" + Archive + "'");  }
    }

    public static boolean contains (int[] Array, int Value) {

        for (int Counter = 0; Counter < Array.length; Counter++) if (Value == Array[Counter]) return true;

        return false;
    }

    public static void main(String[] Args) {

		String [] Names = null;
		int Choose = -1;
		final int[] Valid_options = {0,1,2,3,9}; //valid option on menu
		Scanner Option_enter = new Scanner(System.in);

        //Clean console
        System.out.print("\033[H\033[2J");  
        System.out.flush();

		do {

			System.out.println("---NameList---\n\n0-Load\n1-Add a name\n2-Show\n3-Write\n9-EXIT");
			
            		//Repeat until the user choose a valid option
            		do {
				System.out.print("Choose:");
				Choose = Option_enter.nextInt();
			} while (! (contains(Valid_options, Choose))); 
			
            		switch (Choose) {
				case 0:Names = loadList(Names, "people.txt");break;
				case 1:Names = addName(Names, readName());break;
				case 2:printList(Names);break;
				case 3:writeList(Names,"people.txt");break;
				case 9:System.out.println("End");
			}

			System.out.print("\033[H\033[2J");  
            		System.out.flush(); 

		} while (Choose != 9);
	}
	
}

