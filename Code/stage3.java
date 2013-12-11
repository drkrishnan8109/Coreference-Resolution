import java.io.*;
import java.util.StringTokenizer;


public class stage3
{
	public static int Count = 0;
	public static int x = 1;
	public static String prev = "";
	public static String prev1 = "";
	public static String prev2 = "";
	public static String prev3 = "";
	public static String prev4 = "";
	public static String prev5 = "";
	public static String prev6 = "";
	
	
	public static int counter = 0;

	public static void main(String args[])
	{	
		try
		{
			
			File f = new File("lll_sentences_tagged.txt_standarized.txt");		//creating a instance of class File for input.txt
			FileReader fr = new FileReader(f);	//to read the file input.txt
			
			BufferedReader br1 = new BufferedReader(fr);	//BufferedReader class for filereader1
			
			File f1 = new File("lll_sentences_tagged.txt_standarized.txt");		//creating a instance of class File for input.txt
			FileReader fr1 = new FileReader(f1);	//to read the file input.txt
			
			BufferedReader br2 = new BufferedReader(fr1);	//BufferedReader class for filereader1
			
			File fn = new File("temp.txt");		//creating a instance of class File for input.txt
			FileReader frn = new FileReader(fn);	//to read the file input.txt
			
			BufferedReader brn = new BufferedReader(frn);	//BufferedReader class for filereader1
						
			PrintWriter output = new PrintWriter(new FileWriter("lll_sentences_tagged.txt_standarized.txt_predicates.txt"));		
			String readlin,readlin1,readlin2;
			String encoded = "";
			
			while((readlin2 = brn.readLine()) != null)
			{
				output.println(readlin2);
			}	
			
			//String aSent = new String[];
			File f_X = new File("lll_sentences_tagged.txt_standarized.txt");		//creating a instance of class File for input.txt
			FileReader fr_X = new FileReader(f_X);	//to read the file input.txt
			BufferedReader br_X = new BufferedReader(fr_X);	//BufferedReader class for filereader1
			String readlin_X;
			String sent[] = new String[200];
			String encodingArray[] = new String[200];
			int sentNoInt = 0;
			int prevSentNoInt = 0;
			String word="";
			int flag1=0;
			
			for(int i=0; i>=0; i++)
			{
				
				if(flag1 == 1)
					break;
				readlin_X = br_X.readLine();
				if(readlin_X != null)
				     readlin_X = readlin_X.toLowerCase();
				//System.out.println(readlin_X);
				
				if(readlin_X!= null)
				{
					//readlin_X = readlin_X.toLowerCase();
					StringTokenizer st_X = new StringTokenizer(readlin_X);
				int noOfTokens = st_X.countTokens();
				if(noOfTokens < 7)
				{
					i--;
					continue;
				}
				
				//sentNoInt = 0;
				String sentNo="";
				//String temp[] = new String[(noOfTokens-5)/2];
				//System.out.println((noOfTokens-6)/2);
				word = "";
				int compInWords = (noOfTokens-5)/2;
				for(int k=0;k<=((noOfTokens-6)/2); k++)
				{
					if(compInWords>1 && !word.equals(""))
					    word = word +" "+ st_X.nextToken();
					else if(compInWords>1 && word.equals(""))
						word = st_X.nextToken();
					else
						word = word + st_X.nextToken();
				}
				
				//System.out.println("word is: "+word);
				/*if(word.equals("(") || word.equals(")") || word.equals("-") || word.equals(",") || word.equals(";") )
				{
					--i;
					continue;
				}*/
				
				while(st_X.hasMoreTokens())
				{
					sentNo = st_X.nextToken();
				}
				sentNoInt = Integer.parseInt(sentNo.substring(0,sentNo.indexOf("_")));
				//System.out.println("sentnoint is: "+sentNoInt);
				}
				
				if(readlin_X != null);
				else
				{
					sentNoInt = prevSentNoInt+1;
					flag1=1;
				}
				
				if(sentNoInt == prevSentNoInt)
				{
					//System.out.println("Copying word: "+word+" into sent");
					sent[i] = word;
					encodingArray[i] = makeEncoded(readlin_X);
				}
				else
				{
					//System.out.println("i is: "+i);
					for(int z=0;z<i;z++)
					{
						//System.out.println("sent["+z+"] is: "+sent[z]);
					}
					String wordsOf2X[] = new String[100];
					String wordsOf3X[] = new String[100];
					String wordsOfG3X[] = new String[100];
					for(int w=0;w<100;w++)
					{
						wordsOf2X[w] = "";
						wordsOf3X[w] = "";
						wordsOfG3X[w] = "";
					}
					int indexOf2=0,indexOf3 =0, indexOfG3=0;
					
					for(int j=0; j<i; j++)
					{
						//System.out.println("in for!");
						//System.out.println("sent["+j+"] is:"+sent[j]);
						int noOfOccurence = findNoOfOccurence(sent, i, sent[j]);
						
						if(noOfOccurence == 2)
						{
							//System.out.print("no OF occurence is: "+noOfOccurence+"   ");
							int flag = 0;
							for(int l=0;l<wordsOf2X.length;l++)
							{
								if(wordsOf2X[l].equals(sent[j]))
								{
									flag = 1;
									break;
								}
							}
							if(flag == 0)
							{
								
								output.println("word2X("+encodingArray[j]+").");
								wordsOf2X[indexOf2] = sent[j];
								indexOf2++;
							}
						}
						if(noOfOccurence == 3)
						{
							//System.out.print("no OF occurence is: "+noOfOccurence+"   ");
							int flag = 0;
							for(int l=0;l<wordsOf3X.length;l++)
							{
								if(wordsOf3X[l].equals(sent[j]))
								{
									flag = 1;
									break;
								}
							}
							if(flag == 0)
							{
								output.println("word3X("+encodingArray[j]+").");
								wordsOf3X[indexOf3] = sent[j];
								indexOf3++;
							}
						}
						if(noOfOccurence > 3)
						{
							//System.out.print("no OF occurence is: "+noOfOccurence+"   ");
							int flag = 0;
							for(int l=0;l<wordsOfG3X.length;l++)
							{
								if(wordsOfG3X[l].equals(sent[j]))
								{
									flag = 1;
									break;
								}
							}
							if(flag == 0)
							{
								output.println("wordG3X("+encodingArray[j]+").");
								wordsOfG3X[indexOfG3] = sent[j];
								indexOfG3++;
							}
						}
					}
					
					for(int j=0;j<200;j++)
					{
						sent[j]="";
						encodingArray[j] = "";
					}
					sent[0] = word;
					encodingArray[0] = makeEncoded(readlin_X);
					i=0;		
				}
				
				//System.out.println(sentNoInt+ "  i is: "+i+ "   word is: "+word);
				//sent[i] = word;
				prevSentNoInt = sentNoInt;
			}
			
			
			
			for(int i=0; (readlin= br1.readLine()) != null; i++)
			{
				StringTokenizer st = new StringTokenizer(readlin);
				String a = "";
				int noOfTokens = st.countTokens();
				int compInWords = (noOfTokens-5)/2;
				
				if(noOfTokens >= 7)
				for(int k=0;k<=((noOfTokens-6)/2); k++)
				{
					if(compInWords>1 && !a.equals(""))
					    a = a +" "+ st.nextToken();
					else if(compInWords>1 && a.equals(""))
						a = st.nextToken();
					else
						a = a + st.nextToken();
				}
				
				else
					a = st.nextToken();	
					
				
			
				int cnt = 1;
				
				if(a.equals("(") || a.equals(")") || a.equals("-") || a.equals(",") || a.equals(";") )
				{
					continue;
				}
				
				
				encoded = makeEncoded(readlin);
				//String b = ""+a.length();
				//if(noOfTokens > 7)
				//	System.out.println(a + b);
				
				
				//if(a.equals("sigma F"))
				//	System.out.println("hiii");
				
				String p;
				
				//GET SENTENCE
				if((p=getSentence(readlin)) == "");
				else
					output.println(p+".");
					
				//GET PHRASE
				if((p=getPhrase(readlin, i)) == "");
				else
					output.println(p+".");
				
				
				//GET WORD
				if((p=getWord(encoded, i)) == "");
				else
					output.println(p+".");
				
				
				//GET PHRASE_CHILD
				 p = getPhraseChild(encoded);
				 output.println(p+".");
				 
				
				//GET NOUN PHRASE
				if((p=getNPSegment(readlin, encoded)) == "");
				else
					output.println(p+".");
			
				
				//GET VERB PHRASE
				if((p=getVSegment(readlin, encoded)) == "");
				else
					output.println(p+".");
						
				
				//GET PREPOSITION PHRASE
				if((p=getPPSegment(readlin, encoded)) == "");
				else
					output.println(p+".");
			
				
				
				//GET NOUN
				if((p=getNoun(readlin, encoded)) == "");
				else
					output.println(p+".");
					
				
				//GET VERB
				if((p=getVerb(readlin, encoded)) == "");
				else
					output.println(p+".");
				
					
				
				//GET PREPOSITION
				if((p=getPrep(readlin, encoded)) == "");
				else
					output.println(p+".");
				
				
				//GET WORD NEXT
				if((p = getWordNext(encoded, i)) == "");
				else
					output.println(p+".");
				
				
				//GET IS_NAMED_ENTITY
				if(isNamedEntity(a))
				{
					output.println("is_named_entity("+encoded+").");
				}
				else;
				
				//GET IS_NUMBER
				if(is_number(a))
					output.println("is_number("+encoded+").");
				else;
				
				
				if((p = getPhraseNext(encoded, i)) == "");
				else
					output.println(p+".");
					
				if((p = getPhraseBefore(encoded, i)) == "");
				else
					output.println(p+".");
					
				//is_in_dict
			/*	if(is_in_dict(a))
				{
					output.println("is_in_dict("+encoded+").");
				}
				else;*/
				
			}
			
			
			for(int i=0; (readlin1= br2.readLine()) != null; i++)
			{
				String p = "";
				//GET WORD_ID_TO_STRING
				StringTokenizer st1 = new StringTokenizer(readlin1);
			
				int countToken = st1.countTokens();
				String a[] = new String [(countToken - 5)/2];
				String b = "";
				
				if(countToken == 5)
					continue;
				
				for(int m = 0; m <= (countToken - 6)/2; m++)
				{
					a[m] = st1.nextToken();
					if(b.equals(""))
					b += a[m];
					else
					b = b+" "+a[m];	
				}

				if(b.equals("(") || b.equals(")") || b.equals("-") || b.equals(",") || b.equals(";") )
				{
					continue;
				}
				encoded = makeEncoded(readlin1);
				String c = encoded;
				
				output.println("word_ID_to_string("+c+", "+"'"+b+"'"+")"+".");
			
				if((p = phrase_contains_originally_leading_cap(b, encoded, i)) != "")
					output.println(p+".");
				
				if((p = phrase_contains_alphanumeric_word(b, encoded, i)) != "")
					output.println(p+".");
			
			}
			
				
		//	output1.close();
			output.close();
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}
	
	
	public static String makeEncoded(String readlin)
	{
		if(readlin!= null){
		StringTokenizer st1 = new StringTokenizer(readlin);
			
		int countToken = st1.countTokens();
				//String a[] = new String [(countToken - 5)/2];
				//String b = "";
				
				//if(countToken == 5)
				//	continue;
		String encoded = "";
		encoded = st1.nextToken();
		if(encoded.equals(",") || encoded.equals("(") || encoded.equals(")") || encoded.equals("-") || encoded.equals(";") || encoded.equals("."))
			return "";
		else			
		{
			for(int m = 1; m <= (countToken - 2); m++)
				{
					encoded = st1.nextToken();
				}	
			
		
		return encoded;
		}	
				
		}
		else return "";
	}
	
	public static int findNoOfOccurence(String sent[], int i, String word)
	{
		int count=0;
		for(int m=0;m<i;m++)
		{
			if(sent[m].equals(word))
				count++;
		}
		return count;
	}
	
	public static boolean isNamedEntity(String a)
	{
		try
		{
			File f_dict = new File("dictionary_data.txt");		//creating a instance of class File for input.txt
			FileReader fr_dict = new FileReader(f_dict);	//to read the file input.txt
			BufferedReader br_dict = new BufferedReader(fr_dict);	//BufferedReader class for filereader1
			String dict_data="";
			
			
			
			for(int i=0; (dict_data = br_dict.readLine())!=null; i++)
			{
				//StringTokenizer st_dict = new StringTokenizer(dict_data);
				
				String[] result = dict_data.split("\\t");
		    	for (int x=0; x<result.length; x++)
		    	{
		    		//System.out.println(result[x]);
		    		if(result[x].equals(a))
					return true;
				}
            
				
				
				
				/*while(st_dict.hasMoreTokens())
				{
					String token = st_dict.nextToken();
					if(token.equals(a))
						return true;
				}*/
			}
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return false;
	}
	
		public static boolean is_in_dict(String a)
	{
		try
		{
			File f_dict2 = new File("words.txt");		//creating a instance of class File for input.txt
			FileReader fr_dict2 = new FileReader(f_dict2);	//to read the file input.txt
			BufferedReader br_dict2 = new BufferedReader(fr_dict2);	//BufferedReader class for filereader1
			String dict_data2="";
			
			for(int i=0; (dict_data2 = br_dict2.readLine())!=null; i++)
			{	
				if(a.equals(dict_data2))
					return true;
			}
			
			return false;
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return false;
	}
	
	
	public static String getSentence(String readlin)
	{
		String s= "";
		try
		{
			
			int indexOfSent = readlin.indexOf("\tsent");
			indexOfSent = readlin.indexOf("sent", indexOfSent);
			int indexOfFirstUnderscore = readlin.indexOf("_",indexOfSent);
			String sentNo = readlin.substring(indexOfSent+4, indexOfFirstUnderscore);
			int sentNoInt = Integer.parseInt(sentNo);
			if(x == 1 && sentNoInt==Count)
			{
				s = "sentence(sent"+Count+")";
				x++;
				return s;
			}
			else
			{
				if(sentNoInt!=Count)
				{
					Count++;
					x=1;
				}
				return s;
			}
		}	
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return s;
	}
	
	public static String getPhrase(String readlin, int i)
	{
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
	
	public static String getWord(String encoded, int i)
	{
		
		String s="";
		
		int indexOfSent = encoded.indexOf("sent");
		int lengthOfString = encoded.length();
		String subS = encoded.substring(indexOfSent+4, lengthOfString);
		
		if(i == 0)
		{
			s = "word("+encoded+")";
			prev1 = subS;
			return s;
		}
		else
		{
			if(prev1.equals(subS))
			{
				prev1 = subS;
				return s;
			}
			else
			{
				s = "word("+encoded+")";
				prev1 = subS;
				return s;
			}
		}
	}
	
	public static String getPhraseChild(String encoded)
	{
		String s="";
		try
		{
			int indexOfSent = encoded.indexOf("sent");
			int indexOfFirstUnderscore = encoded.indexOf("_");
			int indexOfSecondUnderscore = encoded.indexOf("_",indexOfFirstUnderscore+1);
			String subS = encoded.substring(0, indexOfSecondUnderscore);
			
			s = "phrase_child("+subS+", "+encoded+")";
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return s;
	}
	
	public static String getNPSegment(String readlin, String encoded)
	{
		int indexOfSent = readlin.indexOf("sent");
		int indexOfFirstUnderscore = encoded.indexOf("_");
		int indexOfSecondUnderscore = encoded.indexOf("_",indexOfFirstUnderscore+1);
		
		String subS = encoded.substring(0, indexOfSecondUnderscore);
		StringTokenizer st = new StringTokenizer(readlin);
		String s = "";
		String a = "";
		
		int countToken = st.countTokens();
		for(int m = 0; m <= countToken - 4; m++)
		a = st.nextToken();
		
		
		
		
			if(a.equals("B-NP"))
			{
				s = "np_segment("+subS+")";
				return s;
			}
		
		return s;
	}
	
	public static String getVSegment(String readlin, String encoded)
	{
		int indexOfSent = readlin.indexOf("sent");
		int indexOfFirstUnderscore = encoded.indexOf("_");
		int indexOfSecondUnderscore = encoded.indexOf("_",indexOfFirstUnderscore+1);
		
		String subS = encoded.substring(0, indexOfSecondUnderscore);
		StringTokenizer st = new StringTokenizer(readlin);
		String s = "";
		
		String a = "";
		
		int countToken = st.countTokens();
		for(int m = 0; m <= countToken - 4; m++)
		a = st.nextToken();
		
		
		
		
			if(a.equals("B-VP"))
			{
				s = "vp_segment("+subS+")";
				return s;
			}
		return s;
	}
	
	public static String getPPSegment(String readlin, String encoded)
	{
		int indexOfSent = readlin.indexOf("sent");
		int indexOfFirstUnderscore = encoded.indexOf("_");
		int indexOfSecondUnderscore = encoded.indexOf("_",indexOfFirstUnderscore+1);
		
		String subS = encoded.substring(0, indexOfSecondUnderscore);
		StringTokenizer st = new StringTokenizer(readlin);
		String s = "";
		String a = "";
		
		int countToken = st.countTokens();
		for(int m = 0; m <= countToken - 4; m++)
		a = st.nextToken();
		
		
		
		
			if(a.equals("B-PP"))
			{
				s = "pp_segment("+subS+")";
				return s;
			}
		
		return s;
	}
	
	public static String getNoun(String readlin, String encoded)
	{
		StringTokenizer st = new StringTokenizer(readlin);
		String s = "";
		String a = "";
		int countToken = st.countTokens();
		for(int m = 0; m <= countToken - 4; m++)
		a = st.nextToken();
		
		
		
		
		if(a.equals("B-NP") || a.equals("I-NP"))
		{
			s = "noun("+encoded+")";
			return s;
		}
		
		return s;
	}
	
	public static String getVerb(String readlin, String encoded)
	{
		StringTokenizer st = new StringTokenizer(readlin);
		String s = "";
		String a = "";
		int countToken = st.countTokens();
		for(int m = 0; m <= countToken - 4; m++)
		a = st.nextToken();
		
		
		
		
		if(a.equals("B-VP") || a.equals("I-VP"))
		{
			s = "verb("+encoded+")";
			return s;
		}	
		return s;
	}
	
	
	public static String getPrep(String readlin, String encoded)
	{
		StringTokenizer st = new StringTokenizer(readlin);
		String s = "";
		String a = "";
		int countToken = st.countTokens();
		for(int m = 0; m <= countToken - 4; m++)
		a = st.nextToken();
		
		
		
		
		if(a.equals("B-PP") || a.equals("I-PP"))
		{
			s = "prep("+encoded+")";
			return s;
		}
		return s;
	}
	
	public static String phrase_contains_originally_leading_cap(String a, String encoded,int i)
	{
		String s="";
		
		int indexOfSecondUnderscore = encoded.indexOf("_",encoded.indexOf("_")+1);
		String subS = encoded.substring(0, indexOfSecondUnderscore);
		String word = a;
		
		
		
		if(i == 0)
		{
			prev2 = subS;
			if (word.charAt(0)>= 65 && word.charAt(0) <= 90)
				s = "phrase_contains_originally_leading_cap("+subS+")";
			return s;
		}
		else
		{
			if(prev2.equals(subS))
			{
				prev2 = subS;
				return s;
			}
			else
			{
				prev2 = subS;
				if (word.charAt(0)>= 65 && word.charAt(0) <= 90)
					s = "phrase_contains_originally_leading_cap("+subS+")";
				return s;
			}
		}
		
	}
	
	public static boolean is_number(String firstToken)
	{
		int lengthOfFirstToken = firstToken.length();
		
		try 
		{
			Double.parseDouble(firstToken);
            return true;
        }
        catch( Exception e )
      	{
      		return false;
      	}	

	}
	
	public static String phrase_contains_alphanumeric_word(String a, String encoded, int i)
	{
		String s="";
		
		int indexOfSecondUnderscore = encoded.indexOf("_",encoded.indexOf("_")+1);
		String subS = encoded.substring(0, indexOfSecondUnderscore);
		String word = a;
		
		int flag1 = 0;
		int flag2 = 0;
		
		if(i == 0)
		{
			s = "phrase_contains_alphanumeric_word("+subS+")";
			for (int j = 0; j < word.length(); j++)
			{
				if ((word.charAt(j)>= 65 && word.charAt(j) <= 90) || (word.charAt(j)>= 97 && word.charAt(j) <= 122))
					flag1 = 1;
				else if ((word.charAt(j)>= 48 && word.charAt(j) <= 57))
					flag2 = 1;
				if(flag1 == 1 && flag2 == 1)
				{
					prev3 = subS;
					return s;
				}
					 
			}		
					  
			s = "";
			return s;
		}
		else
		{
			if(prev3.equals(subS))
			{
				return s;
			}
			else
			{
				s = "phrase_contains_alphanumeric_word("+subS+")";
				for (int j = 0; j < word.length(); j++)
				{
					if ((word.charAt(j)>= 65 && word.charAt(j) <= 90) || (word.charAt(j)>= 97 && word.charAt(j) <= 122))
						flag1 = 1;
					else if ((word.charAt(j)>= 48 && word.charAt(j) <= 57))
						flag2 = 1;
					if(flag1 == 1 && flag2 == 1)
					{
						prev3 = subS;
						return s;
					}	 
				}		
					  
				s = "";
				return s;
			}
		}
		
	}
	
	public static String getWordNext(String encoded, int i)
	{
		String s = "";
		if(i == 0)
		{
			prev4 = encoded;
			return s;
		}
		else
		{
			s = "word_next("+prev4+", "+encoded+")";
			prev4 = encoded;
			return s;
		}
	}
	
	public static String getPhraseNext(String encoded, int i)
	{
		String s = "";
		int indexOfFirstUnderscore = encoded.indexOf("_", 0);
		int indexOfSecondUnderscore = encoded.indexOf("_",indexOfFirstUnderscore+1);
		int indexOfW = encoded.indexOf("w",0);
		if(i == 0)
		{
			prev5 = encoded.substring(0,indexOfSecondUnderscore);
			return s;
		}
		else if(encoded.substring(indexOfW+1,encoded.length()).equals("0"))
		{
			s = "phrase_next("+prev5+", "+encoded.substring(0,indexOfSecondUnderscore)+")";
			prev5 = encoded.substring(0,indexOfSecondUnderscore);
			return s;
		}
		else
		{
			return s;
		}		
	}
	
	public static String getPhraseBefore(String encoded, int i)
	{
		String s = "";
		int indexOfFirstUnderscore = encoded.indexOf("_", 0);
		int indexOfSecondUnderscore = encoded.indexOf("_",indexOfFirstUnderscore+1);
		int indexOfW = encoded.indexOf("w",0);
		if(i == 0)
		{
			prev6 = encoded.substring(0,indexOfSecondUnderscore);
			return s;
		}
		else if(encoded.substring(indexOfW+1,encoded.length()).equals("0"))
		{
			s = "phrase_before("+encoded.substring(0,indexOfSecondUnderscore)+","+prev6+")";
			prev6 = encoded.substring(0,indexOfSecondUnderscore);
			return s;
		}
		else
		{
			return s;
		}		
	}
}
