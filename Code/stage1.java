import java.io.*;
import java.util.StringTokenizer;


public class stage1
{
	public static void main(String args[])
	{
			
		try
		{
			PrintWriter output = new PrintWriter(new FileWriter("lll_sentences_tagged.txt_standarized.txt"));
				
			int absno = 1;
				
			{
				File f = new File("lll_linguistic_all_sentences_tagged_complete.txt");		//creating a instance of class File for input.txt
				FileReader fr = new FileReader(f);	//to read the file input.txt
				BufferedReader br1 = new BufferedReader(fr);	//BufferedReader class for filereader1
				
					
				String readlin;
				String prevreadlin = "";
				int sentno = -1, phno = -1, wno = -1;
				String curr = "";
				String prev = "";
				int count = 1;
				for(int i=0; (readlin= br1.readLine()) != null; i++)
				{
					
					if(!readlin.equals(""))
					{
							
						StringTokenizer st = new StringTokenizer(readlin);
						StringTokenizer st2 = new StringTokenizer(readlin);
						StringTokenizer st3 = new StringTokenizer(prevreadlin);
						StringTokenizer st4 = new StringTokenizer(prevreadlin);
						curr = "";
						
						String a,b,c,d;
						
						int countToken = st.countTokens();
						if(readlin.equals(""))
						{
							prev = curr;
							prevreadlin = readlin;
							continue;
						}
						a = st2.nextToken();
						b = st2.nextToken();
						c = st2.nextToken();
						d = st2.nextToken();
						
						if(a.equals("(") || a.equals(")") || a.equals("-") || a.equals(",") || a.equals(";") )
						{
							output.println(readlin);
							continue;
						}
						
						for(int m=0; m<=countToken-2; m++)
							curr = st.nextToken();
						
						int currstringlength = curr.length();
						int prevstringlength = prev.length();
						String currsubstring="";
						String prevsubstring="";
						if(i == 0)
						{
							prev = curr;
							prevreadlin = readlin;
							wno++;
							phno++;
							sentno++;
							count = 0;
								output.println(readlin+"\tsent"+sentno+"_ph"+phno+"_w"+wno+"\t"+sentno+"_"+count);
						}
						else
						{
							if(curr.charAt(0) == 'O')
							{
								if(a.equals("."))
								{
									sentno++;
									count = 0;
									phno=0;
									wno =0;
								}
								else if(a.equals(",") || a.equals("(") || a.equals(")"))
								{
									wno++;
								}
								else
								{
									String ntok=st3.nextToken();
									if(!(ntok.charAt(0)=='.'))
									{
									     phno++;
									     wno=0;	
									}
									
								}
							}
						
						else	
							{
								
								if(!prev.equals("") && prev.charAt(0) == 'O')    // removed here 
								{
									StringTokenizer st_prevline = new StringTokenizer(prevreadlin);
									if(!st_prevline.nextToken().equals("."))
										phno++; //commented just now
									wno=0;
									prev = curr;
									prevreadlin = readlin;
									output.println(readlin+"\tsent"+sentno+"_ph"+phno+"_w"+wno+"\t"+sentno+"_"+count);
									count++;
									continue;
								}
								
								if(!prev.equals("") && st3.nextToken().charAt(0) =='.')
								{
									System.out.println("HI!");
									phno=0;
									wno=0; 
									prev = curr;
									prevreadlin = readlin;
									output.println(readlin+"\tsent"+sentno+"_ph"+phno+"_w"+wno+"\t"+sentno+"_"+count);
									continue;
								}
								
								if(curr.length() > 1 && prev.length() > 1)
								{
									currsubstring = curr.substring(2,currstringlength);
									prevsubstring = prev.substring(2,prevstringlength);
								}
							
								if(!currsubstring.equals(prevsubstring))
								{
									phno++;
									wno=0;
								}
									
								else if(prevsubstring.equals(currsubstring))
								{
									if(curr.charAt(0) == 'I' && prev.charAt(0) == 'B')
									{
										wno++;
									}
									else if(curr.charAt(0) == 'I' && prev.charAt(0) == 'I')
									{
										wno++;
									}
									else if(prevsubstring.equals("") && currsubstring.equals(""))
									{
									}
									else 
									{
										wno=0;
										phno++; ///changed here
									}
								}
							}
							
							if(!(a.equals("(") || a.equals(")") || a.equals("-") || a.equals(",") || a.equals(";") ))
							{
								prev = curr;
								prevreadlin = readlin;
							}
							
							if(!a.equals("."))
							{
								if(!(a.equals("(") || a.equals(")") || a.equals("-") || a.equals(",") || a.equals(";") ))
									output.println(readlin+"\tsent"+sentno+"_ph"+phno+"_w"+wno+"\t"+sentno+"_"+count);
								else
								{
									output.println(readlin);
									count--;
								}
							}
						}
						if(!a.equals("."))
							count++;
						
					}
				
				}
			}
			output.close();
		}
		catch(Exception e)	
		{
			e.printStackTrace();
		}
		
	}
}
