import java.io.*;
import java.util.StringTokenizer;


public class testing
{
	public static void main(String args[])
	{
			
		try
		{
	
			File f = new File("lll_linguistic_all_sentences_tagged_complete.txt");		//creating a instance of class File for input.txt
			FileReader fr = new FileReader(f);	//to read the file input.txt
			BufferedReader br1 = new BufferedReader(fr);	//BufferedReader class for filereader1
			//PrintWriter output = new PrintWriter(new FileWriter("test.txt"));
			//int count = 0;
			String g = "",readlin1;
			String[] res = "abc 12 dsf".split("[0-9]");
		    //for (int x=0; x<res.length; x++)
            //System.out.println(res[x]);
            //System.out.println(res.length);
            
            File f_dict = new File("dictionary_data.txt");		//creating a instance of class File for input.txt
			FileReader fr_dict = new FileReader(f_dict);	//to read the file input.txt
			BufferedReader br_dict = new BufferedReader(fr_dict);	//BufferedReader class for filereader1
			String dict_data="";
			
			
			
			
			String word[] = new String[100];
			int count[] = new int[100];
			
			for(int x = 0; x < word.length; x++)
			{
				word[x] = "";
				count[x] = 0;
			}	
			
			int i = 0;
			int count2 = 0, count3 = 0, count3g = 0;
			
			while((readlin1 = br1.readLine()) != null)
			{
				if(!readlin1.equals(""))
				{
					readlin1 = readlin1.toLowerCase();
					
					
					StringTokenizer st = new StringTokenizer(readlin1);
					
					
					int noOfTokens = st.countTokens();
					int compInWords = (noOfTokens-3)/2;
					
					//m = st.nextToken();
					
					String m = "";
					
					for(int k=0;k<=((noOfTokens-4)/2); k++)
					{
						if(compInWords>1 && !m.equals(""))
						    m = m +" "+ st.nextToken();
						else if(compInWords>1 && m.equals(""))
							m = st.nextToken();
						else
							m = m + st.nextToken();
					}
					
					//System.out.println(m);
					
					if(m.equals("(") || m.equals(")") || m.equals("-") || m.equals(",") || m.equals(";"))
					{
						continue;
					}
					
					else if(m.equals("."))
					{
						i = 0;
						
						for(int x = 0; !word[x].equals("");x++)
						{
							if(count[x]==2)
								count2++;
							else if(count[x]==3)
								count3++;
							else if(count[x] > 3)
							{
								System.out.println(word[x]);
								count3g++;
							}				
						}
						
						for(int x = 0; !word[x].equals("");x++)
						{
							word[x] = "";
							count[x] = 0;
						}
						continue;
					
					}		
					
					else
					{
						//System.out.println(m);
						if(i == 0)
						{
							word[i] = m;
							count[i] = 1;
							i++;
						}
						else
						{
							int j = 0;
							for(j = 0;!word[j].equals("");j++)
							{
								if(word[j].equals(m))
								{
									count[j]++;
									break;
								}
								
							}
							if(word[j].equals(""))
							{
								word[j] = m;
								count[j] = 1;
							}		
						}	
						
					}	
					
					
				}
			}
			
			
			System.out.println(""+count2+" "+count3+" "+count3g);		
			
			
			
			/*
			for(int j = 0; (readlin1= br1.readLine()) != null; j++)
			{
				StringTokenizer st4 = new StringTokenizer(readlin1);
				int thirdnoOfTokens = st4.countTokens();
				if(thirdnoOfTokens==5)
					continue;
				String m = "";	
				for(int x=0;  x<=thirdnoOfTokens-4; x++)
				if(x == 0)
				{
					StringTokenizer st = new StringTokenizer(readlin1);
				    int noOfTokens = st.countTokens();
					int compInWords = (noOfTokens-5)/2;
					
					if(noOfTokens >= 7)
					for(int k=0;k<=((noOfTokens-6)/2); k++)
					{
						if(compInWords>1 && !m.equals(""))
						    m = m +" "+ st.nextToken();
						else if(compInWords>1 && m.equals(""))
							m = st.nextToken();
						else
							m = m + st.nextToken();
					}
					
					else
						m = st.nextToken();
						}
							
						else
							g = st4.nextToken();
							
					String[] result = m.split("[0-9]");
			    	for (int x=0; x<result.length; x++)
			    	{
			    		int flag = 0;
			    		//System.out.println(result[x]);
			    		if(result.length == 1 && result[x].equals(m))
			    			break;
			    		for (int i=0; i < result[x].length(); i++)
	            			if((result[x].charAt(i) >= 65 && result[x].charAt(i) <= 90) || (result[x].charAt(i) >= 97 && result[x].charAt(i) <= 122)) 
	            			{
		            			System.out.println(m);
		            			count++;
	            				flag = 1;
	            				break;
	            			}
	            		if (flag == 1)
	            			break;
			    	}		   	
						
				//if(((g.charAt(0) == 'B' && g.charAt(1) == '-') || g.equals("O")) && (m.charAt(0) >= 65 && m.charAt(0) <= 90))
				//	count++;	
				//if((g.charAt(0) == 'B' && g.charAt(1) == '-') || (g.equals("O")))
				//	count++;
				//if((g.equals("B-PP")) || (g.equals("I-PP")))
				//	count++;
				//System.out.println(test.length());
						
			}
			*/
			//System.out.println(count);
		}
		
		catch(Exception e)	
		{
			e.printStackTrace();
		}
	}			
}