import java.io.*;

public class stage6
{
	public static void main(String args[])
	{
		try
		{
			File f1 = new File("total_comparisons.txt");		//creating a instance of class File for input.txt
			FileReader fr1 = new FileReader(f1);	//to read the file input.txt
			BufferedReader br1 = new BufferedReader(fr1);	//BufferedReader class for filereader1
					
			
			PrintWriter output = new PrintWriter(new FileWriter("lll_sentences_tagged.txt_standarized.txt_n.txt"));
			
			String readlin="",readlin1="";
			int count=0;
			while((readlin=br1.readLine())!=null)
			{
				count=0;
				
				File f2 = new File("lll_sentences_tagged.txt_standarized.txt_f.txt");		//creating a instance of class File for input.txt
				FileReader fr2 = new FileReader(f2);	//to read the file input.txt
				BufferedReader br2 = new BufferedReader(fr2);	//BufferedReader class for filereader1
				
				while((readlin1=br2.readLine())!=null)
				{
					if(readlin.equals(readlin1))
					{
						count=1;
						break;
					}
				}
				if(count==0)
				{
					output.println(readlin);
					output.flush();
				}
					
				br2.close();
				
			}
			output.close();
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		
	}
	
}