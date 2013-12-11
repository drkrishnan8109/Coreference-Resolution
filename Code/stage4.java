import java.io.*;
import java.util.StringTokenizer;



public class stage4
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
			
			PrintWriter output = new PrintWriter(new FileWriter("lll_sentences_tagged.txt_standarized.txt_f.txt"));
			
			String readlin,readlin1,readlin3;
			String a,b,c="",d="",e,f="";
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
					if(a.equals("genic_interactions"))
					{
						while(st.hasMoreTokens())
						{
							b = st.nextToken();
							int indexOfopeningbracket = b.indexOf("(");
							int indexOfcomma = b.indexOf(",");
							int indexOfclosingbracket = b.indexOf(")");
							String subS1 = b.substring(indexOfopeningbracket+1, indexOfcomma);
							String subS2 = b.substring(indexOfcomma+1, indexOfclosingbracket);
							
							File f3 = new File("lll_sentences_tagged.txt_standarized.txt");		//creating a instance of class File for input.txt
							FileReader fr3 = new FileReader(f3);
							
							File f4 = new File("lll_sentences_tagged.txt_standarized.txt");		//creating a instance of class File for input.txt
							FileReader fr4 = new FileReader(f4);
							
							
							BufferedReader br3 = new BufferedReader(fr3);
							BufferedReader br4 = new BufferedReader(fr4);
							
							
							while((readlin1 = br3.readLine()) != null)
							{
								StringTokenizer st1 = new StringTokenizer(readlin1);
								
								while(st1.hasMoreTokens())
									c = st1.nextToken();
								
								if(readlin1.contains("(\t(\t(\t(\t(") || readlin1.contains(")\t)\t)\t)\t)") || readlin1.contains(",\t,\t,\t,\t,") || readlin1.contains("-\t-\t-\t-\t-") || readlin1.contains(";\t;\t;\t;\t;"))
									{
										continue;
									}
								
								d = makeEncoded(readlin1);	
								   
										
								
								if(c.equals(count+"_"+subS1))
								{
									break;
								}

							}
							
							while((readlin1 = br4.readLine()) != null)
							{
								StringTokenizer st2 = new StringTokenizer(readlin1);
								while(st2.hasMoreTokens())
									f = st2.nextToken();
							
								if(readlin1.contains("(\t(\t(\t(\t(") || readlin1.contains(")\t)\t)\t)\t)") || readlin1.contains(",\t,\t,\t,\t,") || readlin1.contains("-\t-\t-\t-\t-") || readlin1.contains(";\t;\t;\t;\t;"))
									{
										continue;
									}
								
								e = makeEncoded(readlin1);	
								
									
								
								
								if(f.equals(count+"_"+subS2))
								{
									break;
								}		
							}
							
							if(Integer.parseInt(subS1) < Integer.parseInt(subS2))
							{
								output.println("genic_interaction("+d+","+e+").");
							}
							else
							{
								output.println("genic_interaction("+e+","+d+").");
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