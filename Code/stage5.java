import java.io.*;
import java.util.StringTokenizer;

public class stage5
{
	
	public static String makeEncoded(String readlin)
	{
		int indexOfSent = readlin.indexOf("\tsent");
		indexOfSent = readlin.indexOf("sent", indexOfSent);
		int indexOfLastTab = readlin.indexOf("\t",indexOfSent);
		
		String encoded = readlin.substring(indexOfSent, indexOfLastTab);
		return encoded;
	}
	
	public static void main(String args[])
	{
		try
		{
		
			File f = new File("lll_sentences_tagged.txt_standarized.txt");		//creating a instance of class File for input.txt
			FileReader fr = new FileReader(f);	//to read the file input.txt
			BufferedReader br1 = new BufferedReader(fr);	//BufferedReader class for filereader1
			
			PrintWriter output = new PrintWriter(new FileWriter("total_comparisons.txt"));
			
			String readlin;
			String readlin1;
			String a,b,c,d,e,f1,g,h,k;
			a="";
			g="";
			String prevreadlin = "";
			int sentno = 0, phno = 0, wno = 0;
			String curr = "";
			String prev = "";
			for(int i=0; (readlin= br1.readLine()) != null; i++)
			{
				StringTokenizer st = new StringTokenizer(readlin);
				int noOfTokens = st.countTokens();
				if(noOfTokens==5)
					continue;
				for(int n=0;n<=noOfTokens-4; n++)
					a = st.nextToken();
					
				b = st.nextToken();
				c = makeEncoded(readlin);
				
				FileReader fr1 = new FileReader(f);	//to read the file input.txt
				BufferedReader br2 = new BufferedReader(fr1);	//BufferedReader class for filereader1
				
				int indexOfSent = c.indexOf("sent");
				int indexOfFirstUnderscore = c.indexOf("_");
				String sentNo = c.substring(indexOfSent+4, indexOfFirstUnderscore);
				String a11 = c;
				
				if(a.equals("B-NP")||a.equals("I-NP"))
				{
					while((readlin1= br2.readLine()) != null)
					{
						StringTokenizer st3 = new StringTokenizer(readlin1);
						int secondnoOfTokens = st3.countTokens();
						if(secondnoOfTokens==5)
							continue;
						for(int x=0; x<=secondnoOfTokens-4; x++)
							d = st3.nextToken();
						e = st3.nextToken();
						f1 = makeEncoded(readlin1);
						if (f1.equals(c))
							break;
					}	
					
					for(int j = i+1; (readlin1= br2.readLine()) != null; i++)
					{
						StringTokenizer st4 = new StringTokenizer(readlin1);
						int thirdnoOfTokens = st4.countTokens();
						if(thirdnoOfTokens==5)
							continue;
						for(int x=0;  x<=thirdnoOfTokens-4; x++)
							g = st4.nextToken();
						h = st4.nextToken();
						k = makeEncoded(readlin1);
						
						
						int indexOfSent1 = k.indexOf("sent");
						indexOfFirstUnderscore = k.indexOf("_");
						String sentNo1 = k.substring(indexOfSent1+4, indexOfFirstUnderscore);
						String a12 = k;
				
						
						if(!sentNo.equals(sentNo1))
							break;
						if(((getPhrase(readlin1,j)).equals((getPhrase(readlin,i)))))	
							continue;
						else
						{
							if(g.equals("B-NP")||g.equals("I-NP"))
								output.println("genic_interaction("+a11+","+a12+").");
							
						}
					}
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
	
	public static String getPhrase(String readlin, int i)
	{
		String prev="";
		String s="";
		
		int indexOfSent = readlin.indexOf("\tsent");
		indexOfSent = readlin.indexOf("sent", indexOfSent);
				
		int indexOfPhrase = readlin.indexOf("_ph", indexOfSent);
		int indexOfFirstUnderscore = readlin.indexOf("_", indexOfSent);
		int indexOfSecondUnderscore = readlin.indexOf("_",indexOfFirstUnderscore+1);
		String subS = readlin.substring(indexOfPhrase+1, indexOfSecondUnderscore);
		String sentNo = readlin.substring(indexOfSent+4, indexOfFirstUnderscore);
		
		
		if(i == 0)
		{
			s = "phrase(sent"+sentNo+"_"+subS+")";
			prev = subS;
			return s;
		}
		else
		{
			if(prev.equals(subS))
			{
				prev = subS;
				return s;
			}
			else
			{
				s = "phrase(sent"+sentNo+"_"+subS+")";
				prev = subS;
				return s;
			}
		}
	}
	
	
}