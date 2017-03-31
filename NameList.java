import java.io.*;
import java.util.Scanner;
import java.util.regex.*;

public class NameList {

    public static String[] addName(String[] Array, String NewName) {

        int len = (Array != null) ? Array.length : 0;

        String[] NewArray = new String[len + 1];

        for (int Counter = 0; Counter < len; Counter++) NewArray[Counter] = Array[Counter];
        NewArray[len] = NewName;

        return NewArray;
    }

    public static String[] loadList(String[] Names, String Archive) {
        
        String Line = null;
        
        try {

            BufferedReader Lines = new BufferedReader(new FileReader(Archive));

            while((Line = Lines.readLine()) != null) Names = addName(Names, Line);

            Lines.close();  

                 
        }

        catch(FileNotFoundException ex){ System.out.println("Unable to open file '" + Archive + "'"); }
        catch(IOException ex) {
            System.out.println("Error reading file '"+ Archive + "'");
        }
        return Names; 
    }

    public static boolean verifyName(String Name) {
        
        Pattern p = Pattern.compile("[^a-z ]", Pattern.CASE_INSENSITIVE);
        boolean HasInvalidCharacter = p.matcher(Name).find();
        
        boolean HasValidCharacter = false;
        for (int Counter =0; Counter < Name.length(); Counter++) if (Name.charAt(Counter) != ' ') HasValidCharacter = true;

        return (!HasValidCharacter || HasInvalidCharacter);
    }

    public static String readName() {

        Scanner Name_enter = new Scanner(System.in);
        String Name;
        do {
            System.out.println("Informe o nome que deseja Adicionar:");
            Name = Name_enter.nextLine();
        } while (verifyName(Name));
        return Name;
    }


    public static void printList(String[] List) {
        if (List == null) return;
        for (int Counter = 0 ; Counter < List.length; Counter++) System.out.println(List[Counter]);
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
        catch(IOException ex) {
            System.out.println("Error writing to file '" + Archive + "'");
        }
    }

    public static boolean contains (int[] Array, int Value) {
        for (int Counter = 0; Counter < Array.length; Counter++) if (Value == Array[Counter]) return true;
        return false;
    }

    public static void main(String[] Args) {
		String [] Names = null;
		int Choose = -1;
		final int[] Valid_options = {0,1,2,3,9};
		
		Scanner Option_enter = new Scanner(System.in);
		do {
			System.out.println("---NameList---\n\n0-Load\n1-Add a name\n2-Show\n3-Write\n9-EXIT");
			do {
				System.out.print("Choose:");
				Choose = Option_enter.nextInt();
			} while (! (contains(Valid_options, Choose)));
			switch (Choose) {
				case 0:Names = loadList(Names, "people.txt");break;
				case 1:Names = addName(Names, readName());break;
				case 2:printList(Names);break;
				case 4:writeList(Names,"people.txt");break;
				case 9:System.out.println("End");
			}
			System.out.print("\f");
		} while (Choose != 9);
	}
	
}

