import java.io.*;

public class NameList {
    public static void main() {
		ArrayList Names = new ArrayList();
		int choose = -1;
		final int[] valid_options = {0,1,2,3,9};
		
		Scanner key_enter = new Scanner(System.in);
		do {
			System.out.println("---NameList---\n\n0-Load\n1-Add a name\n2-Show\n3-Write\n9-EXIT");
			do {
				System.out.println("Choose:");
				choose = key_enter.nextInt();
			} while (! valid_options.contains(choose));
			switch (choose) {
				case 0:Names = LoadList("people");break;
				case 1:Names.add(ReadName());break;
				case 2:PrintList(Names);break;
				case 4:WriteList(Names);break;
				case 9:System.out.println("End");
			}
			System.out.println("\f");
		} while (choose != 9);
	}
	/*
	public static String ()	{
	String fileName = "temp.txt";
        String line = null;
        try {
            // FileReader reads text files in the default encoding.
            FileReader fileReader = 
                new FileReader(fileName);

            // Always wrap FileReader in BufferedReader.
            BufferedReader bufferedReader = 
                new BufferedReader(fileReader);

            while((line = bufferedReader.readLine()) != null) {
                System.out.println(line);
            }   

            // Always close files.
            bufferedReader.close();         
        }
        catch(FileNotFoundException ex) {
            System.out.println(
                "Unable to open file '" + 
                fileName + "'");                
        }
        catch(IOException ex) {
            System.out.println(
                "Error reading file '" 
                + fileName + "'");                  
            // Or we could just do this: 
            // ex.printStackTrace();
        }
    }*/
}

