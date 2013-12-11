import java.io.*;
import java.util.StringTokenizer;

public class stage2
{
	public static void main(String args[])
	{
		try
		{
			File f1 = new File("genic_interaction_linguistic_data.txt");		//creating a instance of class File for input.txt
			FileReader fr1 = new FileReader(f1);	//to read the file input.txt
			File f5 = new File("genic_interaction_linguistic_data.txt");		//creating a instance of class File for input.txt
			FileReader fr5 = new FileReader(f5);	//to read the file input.txt
			File f2 = new File("genic_interaction_linguistic_data_coref.txt");		//creating a instance of class File for input.txt
			FileReader fr2 = new FileReader(f2);
			BufferedReader br1 = new BufferedReader(fr1);	//BufferedReader class for filereader1
			BufferedReader br5 = new BufferedReader(fr5);	//BufferedReader class for filereader1
			
			BufferedReader br2 = new BufferedReader(fr2);	//BufferedReader class for filereader1
			
			PrintWriter output = new PrintWriter(new FileWriter("temp.txt"));
			
			String readlin,readlin1,readlin3;
			String a,b,c,d,e,f;
			d = "";
			e = "";
				
			int count = 0;
			readlin3 = br5.readLine();
			while((readlin = br1.readLine()) != null)
			{
				StringTokenizer st = new StringTokenizer(readlin);
				if(!readlin.equals(""))
				{
						
					a = st.nextToken();
					
					if(a.equals("syntactic_relations"))
					{
						while(st.hasMoreTokens())
						{
							b = st.nextToken();
							int indexOf1stinvertedcomma = b.indexOf("'");
							int indexOf2ndinvertedcomma = b.indexOf("'",b.indexOf("'")+1);
							int indexOf2ndcomma = b.indexOf(",",b.indexOf(',')+2);
							int indexOfclosingbracket = b.indexOf(")");
							String subS1 = b.substring(indexOf1stinvertedcomma+1, indexOf2ndinvertedcomma);
							String subS2 = b.substring(indexOf2ndinvertedcomma+2, indexOf2ndcomma);
							String subS3 = b.substring(indexOf2ndcomma+1, indexOfclosingbracket);
							
							
							
							File f3 = new File("lll_sentences_tagged.txt_standarized.txt");		//creating a instance of class File for input.txt
							FileReader fr3 = new FileReader(f3);
							
							File f4 = new File("lll_sentences_tagged.txt_standarized.txt");		//creating a instance of class File for input.txt
							FileReader fr4 = new FileReader(f4);
							
							
							BufferedReader br3 = new BufferedReader(fr3);
							BufferedReader br4 = new BufferedReader(fr4);
							
							
							while((readlin1 = br3.readLine()) != null)
							{
								StringTokenizer st1 = new StringTokenizer(readlin1);
								c = st1.nextToken();
								if(c.equals(",") || c.equals("(") || c.equals(")") || c.equals("-") || c.equals(";"))
									continue;
								
								while(st1.hasMoreTokens())
									c = st1.nextToken();
								d = makeEncoded(readlin1);
								
								
								if(c.equals(count+"_"+subS2))
								{
									break;
								}

							}
							
							while((readlin1 = br4.readLine()) != null)
							{
								StringTokenizer st2 = new StringTokenizer(readlin1);
								f = st2.nextToken();
								if(f.equals(",") || f.equals("(") || f.equals(")") || f.equals("-") || f.equals(";"))
									continue;
								
								while(st2.hasMoreTokens())
									f = st2.nextToken();
								e = makeEncoded(readlin1);
								
								if(f.equals(count+"_"+subS3))
								{
									break;
								}		
							}
							
							if(Integer.parseInt(subS2) < Integer.parseInt(subS3))
							{
								subS1=subS1.replace(":","_");
								subS1=subS1.replace("-","");
								output.println(subS1+"("+d+","+e+").");
							}
							else
							{
								subS1=subS1.replace(":","_");
								subS1=subS1.replace("-","");
								output.println(subS1+"("+e+","+d+").");
							}	
									
								
						}
						count++;		
					}
				}
				if((readlin3 = br5.readLine()) == null)
				br1 = br2;
			}
			output.close();	
		
		}
		catch(Exception e)	
		{
			e.printStackTrace();
		}
	}
	
	public static String makeEncoded(String readlin)
	{
		int indexOfSent = readlin.indexOf("\tsent");
		indexOfSent = readlin.indexOf("sent", indexOfSent);
		int indexOfLastTab = readlin.indexOf("\t",indexOfSent);
		
		String encoded = readlin.substring(indexOfSent, indexOfLastTab);
		return encoded;
	}
}