#!/usr/bin/env python

import re

#Global Variable Declaration
Order=[]
string=[]
list=[]
information=[]
Entity=[]
Antecedent=[]
Mention=[]
Noun=[]
article=[]
checklist=[]

def Split():
	"Function to split entity pairs"
	handler=open('antecedentpairs2b.xml','r')
	strings=handler.read()
	handler.close()
	list=re.split('<Entity id="',strings)
	count=0
	str=''
	for i in range(len(list)):
		if i!=0:
			m=re.findall('</Entity>',list[i])
			count=count+1
			if len(m)!=0:
				count=count-len(m)
				str=str+'<Entity id="'+list[i]
			else:
				str=str+'<Entity id="'+list[i]
			if count==0:
				count=0	
				str=str+'\n'
				string.append(str)
				str=''

def Separate():
	str=''
	for i in range(len(string)):
		m=re.search('</Entity>',string[i])
		if m!=None:
			list.append(string[i])

	for i in range(len(list)):
		m=re.findall('<InhibitRelation id="|</InhibitRelation>',list[i])
		if len(m)!=0:
			object=re.split('<InhibitRelation id=[^>]*>|</InhibitRelation>',list[i])
			for k in range(len(object)):
				str=str+object[k]
				list[i]=str
		str=''
	
	for i in range(len(list)):
		object=re.split('<[^E]*>[^<>]*</[^E]*>',list[i])
		for k in range(len(object)):
			str=str+object[k]
		list[i]=str
		str=''

	str=''					
	for i in range(len(list)):
		object=re.split('<Entity id="|"[^>]*>|</Entity>',list[i])
		length=len(object)-1
		count=0
		end=0
		temp=[]
		set=0
		for k in range(length):
			if object[k]!='':
				inc=1	
				if object[k].isdigit()==True:
					set=0
					count=count+1
					temp.append(object[k])
					temp.append(str)	
				else:	
					if set==0:
						set=1
						n=2*count-1
					else:
						end=end+1
						n=2*count-1-2*end
						inc=2
					while n>=1:
						temp[n]=temp[n]+" "+object[k]
						if inc!=2:
							n=n-2*end
							inc=inc+1
						n=n-2
			
		str=''
		p=1
		for i in range(len(temp)):
			str=str+temp[i]
			p=p+1
			if p==2:
				Entity.append(str)
				p=1
				str=''
		

def Relation():
	sample=[]
	for i in range(len(list)):
		m=re.search('Antecedent',list[i])
		if m!=None:
			sample.append(list[i])
	for j in range(len(sample)):
		ant=re.split('<Entity id="|</Entity>',sample[j])
		length=len(ant)-1
		strings=''
		for k in range(length):
			n=re.search('Antecedent',ant[k])
			if n!=None:
				ls=re.split('.*Antecedent="|">|, ',ant[k])
				#print ls
				xy=len(ls)
				for s in range(xy):
					if ls[s].isdigit()==True:
						Antecedent.append(ls[s])
						Antecedent.append(ls[xy-1])


def Positive():
	for i in range(len(Entity)):
		if i%2!=0:
			m=re.split('[" "]*',Entity[i])
			#print m
			length=len(m)
			strings=m[1]
			p=2
			while p<=(length-1): 
				strings=strings+" "+m[p]
				p=p+1
			Entity[i]=strings
	

def Link():
	meta=[]
	for i in range(len(list)):
		temp=re.split('[^<>]*\n$',list[i])
		list[i]=temp[0]

	for i in range(len(list)):
		temp=re.split('<Entity id="|</Entity>',list[i])
		for j in range(len(temp)-1):
			if j!=0: 
				meta.append(temp[j])
	
	temp=[]
	for i in range(len(meta)):
		m=re.search('=',meta[i])
		if m!=None:
			temp.append(meta[i])
	meta=temp

	temp=[]
	for i in range(len(meta)):
		temp=re.split('">[^>]*',meta[i])
		meta[i]=temp[0]
		##List Entire Relation Available Here, can use for finding.
		m=re.search("Antecedent",meta[i])
		if m==None:
			p=re.split('"*',meta[i])
			meta[i]=p[0]
	
	temp=[]
	count=0
	for i in range(len(meta)):
		m=re.search("Antecedent",meta[i])
		if m==None:
			temp.append(meta[i])
			temp.append('E')
			count=count+1
		if m!=None:
			p=re.split('".*"',meta[i])
			temp.append(p[0])
			temp.append('E')
			count=count+1
			if p[1]!=None:
				n=re.search(", ",p[1])
				if n!=None:
					s=re.split(', ',p[1])
					for k in range(len(s)):
						temp.append(s[k])
						temp.append('A')
						count=count+1
				else:
					temp.append(p[1])
					temp.append('A')
					count=count+1
	meta=temp
	for i in range(len(meta)):
		information.append(meta[i])
	

def Text_Information():
	writer=open("Text_Information.txt",'w+')
	number=1
	number_entity=0
	number_antecedent=0
	string="Mention no."+"\t"+"E/A"+"\t"+"Entity No."+"\t"+"Antecedent No."+"\t"+"Text"+"\n"
	writer.writelines(string)
	string=''
	for i in range(len(information)):
		if i%2!=0 and information[i]=='E' and Entity[number_entity]==information[i-1]:
			string="Mention "+str(number)+"\t"+information[i]+"\t"+information[i-1]+"\t"+"-"+"\t"+Entity[number_entity+1]+"_m"+str(number)+"\n"
			Mention.append(number)
			Mention.append(information[i])
			Mention.append(information[i-1])
			Mention.append("-")
			Mention.append(Entity[number_entity+1]+"_m"+str(number))
			number_entity=number_entity+2
			number=number+1 
			writer.writelines(string)
		elif i%2!=0 and information[i]=='A' and Antecedent[number_antecedent]==information[i-1]:
			string="Mention "+str(number-1)+"\t"+information[i]+"\t"+Entity[number_entity-2]+"\t"+information[i-1]+"\t"+Antecedent[number_antecedent+1]+"_m"+str(number-1)+"\n"
			Mention.append(number-1)
                        Mention.append(information[i])
                        Mention.append(Entity[number_entity-2])
                        Mention.append(information[i-1])
                        Mention.append(Antecedent[number_antecedent+1]+"_m"+str(number-1))
			number_antecedent=number_antecedent+2
			writer.writelines(string)
		string=''
	writer.close()	


def Examples_File():
	reader=open("Modified_Text_Information.txt",'r')
	strings=reader.readlines()
	reader.close()
	Mylist=[]
	i=1
	while i<len(strings):
		m=re.split('\t|\n',strings[i])
		if len(m)>2:
			for j in range(len(m)-1):
				Mylist.append(m[j])
		i=i+1

	writer=open("coreference.f",'w+')
	count=3
	while count<len(Mylist):
		i=2
		if Mylist[count]!="-":
			while i<count:
				if Mylist[count]==Mylist[i] and Mylist[i-1]=='E':
					writer.writelines("corefers(\""+Mylist[i+2]+"\",\""+Mylist[count+1]+"\").\n")
				i=i+5
		count=count+5						
	writer.close()

	writer=open("Background.txt",'w+')
	i=4
	while i<=len(Mylist):
		if Mylist[i-3]!='A':
			str=Mylist[i]
			e=str[0]
#			if e.isupper()==True:
#				writer.writelines("starts_with_capital(\""+Mylist[i]+"\").\n")
#			else:
#				writer.writelines("starts_with_capital(\""+Mylist[i]+"\").\n")
		i=i+5
#	writer.writelines("\n")
	writer.close()


def Fullstop_and_Article_end():
	for i in range(len(string)):
		m=re.split('<[^E/A][^<]*>|</[^EA][^<]*>|\n|<A.*>',string[i])
		str=''
		for j in range(len(m)-1):
			str=str+m[j]
		string[i]=str

	Var=[]
	for i in range(len(string)):
		m=re.split('\.[^0-9]',string[i])
		if m>1:
			for j  in range(len(m)-1):
				Var.append(m[j])
				Var.append("F")
			Var.append(m[len(m)-1])
		else:
			Var.append(m[0])
		n=re.search('</Article>',string[i])
		if n!=None:
			Var.append("Aend")


	temp=[]
	for i in range(len(Var)):
		m=re.split('<Entity id="',Var[i])
		j=1
		while j<=(len(m)-1):
			temp.append(m[j])
			j=j+1
		if Var[i]=="F" or Var[i]=="Aend":
			temp.append(Var[i])

	for i in range(len(temp)):
		m=re.split('".*',temp[i])
		if m[0]!="F":
			Order.append(m[0])
			last=m[0]
		else:
			if last!="F":
				Order.append("F")
				last="F"


def Modified_Text_Information():
	print len(Order)
	print len(Entity)
	print len(Antecedent)
	reader=open("Text_Information.txt",'r')
	strings=reader.readlines()
	reader.close()
	writer=open("Modified_Text_Information.txt",'w+')
	write="Mention no."+"\t"+"E/A"+"\t"+"Entity No."+"\t"+"Antecedent No."+"\t"+"Text"+"\n"
	writer.writelines(write)
	i=0
	j=1
	count=0
	article_count=1
	while i<len(Order) and j<len(strings):
		m=re.split("\t|\n",strings[j])
		if Order[i]==m[2] and m[3]=="-" and m[1]!="A":
			write=m[0]+"\t"+m[1]+"\t"+m[2]+"_A"+str(article_count)+"\t"+m[3]+"\t"+m[4]+"\n"
			writer.writelines(write)
			j=j+1
			i=i+1
		elif Order[i]==m[2] and m[3]!="-" and m[1]!="A":
			write=m[0]+"\t"+m[1]+"\t"+m[2]+"_A"+str(article_count)+"\t"+m[3]+"_A"+str(article_count)+"\t"+m[4]+"\n"
			writer.writelines(write)
			j=j+1
			i=i+1

		if Order[i]=="Aend":
			article_count=article_count+1
			i=i+1

		if j<len(strings):
			n=re.split("\t|\n",strings[j])
			while n[1]=="A":
				write=n[0]+"\t"+n[1]+"\t"+n[2]+"_A"+str(article_count)+"\t"+n[3]+"_A"+str(article_count)+"\t"+n[4]+"\n"
	                	writer.writelines(write)
				j=j+1
				n=re.split("\t|\n",strings[j])

		if Order[i]=="F":
			write="Fullstop\n"
			writer.writelines(write)
			i=i+1
		count=count+1	
	writer.close()	


def Predicates():
        reader=open("Modified_Text_Information.txt",'r')
        capture=reader.readlines()
        reader.close()
        Mylist=[]
        i=1
        while i<len(capture):
                m=re.split('\t|\n',capture[i])
                if len(m)>=2:
                        for j in range(len(m)-1):
                                Mylist.append(m[j])
                i=i+1

	reader=open("coreference.f",'r')
	strings=reader.readlines()	
	reader.close()
	
	verify=[]
	writer=open("coreference.f",'w+')
	for i in range(len(strings)):
		m=re.split('corefers\(\"|\"\).\n',strings[i])
		n=m[1]
		m=re.split('\",\"',n)
		verify.append(m[0])
		verify.append(m[1])
		j=4
		k=0
		checks=verify[0]
		while j<=(len(Mylist)-1):
			if Mylist[j]==checks:
				k=k+1
				checks=verify[1]
				if k==2:
					writer.writelines("corefers(\""+verify[0]+"\",\""+verify[1]+"\").\n")
					break
			if Mylist[j+1]!="Fullstop":
				j=j+5
			elif Mylist[j+1]=="Fullstop" and k==0:
				j=j+6
			else:
				break	
				
		verify=[]
	writer.close()


	reader=open("coreference.f",'r')
	strings=reader.readlines()
	reader.close()
	print len(strings)
	
	writer=open("coreference.n",'w+')
	i=4
	count=0
	while i<=(len(Mylist)-1):
		if Mylist[i-4]!="Fullstop":
			if Mylist[i-3]!="A":
				if Mylist[i+1]!="Fullstop":
					j=i+5
					while Mylist[j-4]!="Fullstop":
						if Mylist[j-3]!="A":
							str="corefers(\""+Mylist[i]+"\",\""+Mylist[j]+"\").\n"
							temp=0
							for k in range(len(strings)):
								if (strings[k]==str):
									break
								else:
									temp=len(strings)
							if temp==len(strings):
								writer.writelines(str)
								temp=0
								count=count+1
						j=j+5
					i=i+5	
				else:
					i=i+6
			else:
				i=i+5
		else:
			i=i+1
	# Total no. of combinations= 431
	print count
	writer.close()

############################################# Rest Predicates code here.	
	
	writer=open("Nouns.txt",'w+')
	for i in range(32):
		handle=open('a'+`i`+'_tagged','r')
		strings=handle.readlines()
		handle.close()
		str=''
		string='--$'
		k=0
		for j in range(len(strings)):
			m=re.split("\t|\n",strings[j])
			#print m
			if len(m)==6 and m[3]=='B-NP':
				str=m[0]
			elif len(m)==6 and m[3]=='I-NP':
                                str=str+' '+m[0]
			else:
				if str!='':
					Noun.append(str)
					str=str+"_A"+`i`+"\t"+string[2:]+"\n"
					writer.writelines(str)
					k=0
					Noun.append(string[2:])
				string='--$'
				str=''
			if len(m)==6 and m[4]!='O' and k==0 and str!='':
				k=k+1
				string=m[4]
	writer.close()
		
########################################### Noun Phrase Extracted.
########################################### Classification of Nouns.
########################################### Tagged files added.	
	reader=open("antecedentpairs2b.xml",'r')
	strings=reader.readlines()	
	reader.close()
	str=''	
	for i in range(len(strings)):
		m=re.split('\n',strings[i])
		for j in range(len(m)-1):
			str=str+m[j]		

	m=re.split("<A>[^<>]*</A>|<J>[^<>]*</J>|<V>[^<>]*</V>|<P>[^<>]*</P>|<Y>[^<>]*</Y>",str)
	str=''
	for i in range(len(m)):
		str=str+m[i]
		
	m=re.split("<Article>|</Article>",str)
	i=1
	while i<=(len(m)-2):
		if m[i]!='':
			article.append(m[i])
			count=count+1
		i=i+1
	
########################## Articles in article[] list
#	for i in range(len(article)):
#		print article[i]
#		print "\n"
########################## To print articles.
	writer=open("Article_Header.txt",'w+')
	mention=1
	
	for i in range(32):
		writer1=open('a'+`i`+'_tagged'+'_added','w+')
		reader=open('a'+`i`+'_tagged','r')
		strings=reader.readlines()
		reader.close()
		
		m=re.split("</T>",article[i])
		
		n=re.split("<Entity id=",m[0])
		if len(n)>1:
			j=1
			while j<=(len(n)-1):
				writer.writelines("Mention "+`mention`+"\n")
				mention=mention+1
				j=j+1	
		
		p=re.split("<Ab>|</Ab>",m[1])
		m[1]=p[1]+p[2]
		p=re.split("<InhibitRelation[^>]*>|</InhibitRelation>|</Entity>|<Complex[^>]*>|</Complex[^>]*>",m[1])
		m[1]=''
		for i in range(len(p)):
			m[1]=m[1]+p[i]

		p=re.split("<E[^>]*>",m[1])
		
		m[1]=''
		for i in range(len(p)-1):
			m[1]=m[1]+p[i]+"$#"
		m[1]=m[1]+p[len(p)-1]
		
		p=re.split(" ",m[1])
		check=[]

		for i in range(len(p)):
			f=re.split(",|\.|\(|\)|\%|\[|\]|:|;|>|--|\^",p[i])
			if f!=None:
				for j in range(len(f)):
					if f[j]=="":
						check.append("sp.")
						if j+1<=(len(f)-1) and j-1>0:
							if f[j]=="" and f[j-1]!="" and f[j+1]!="":
								check.append("sp.")
					else:
						if f[j]!="$#":
							check.append(f[j])
							if j+1 <= (len(f)-1):
								if f[j+1]!="":
									check.append("sp.")
						else:
							check.append(f[j]+"sp.")
								
					
			else:
				check.append(p[i])

		checklist=check
	
		j=1
		str=''
		k=0
		for i in range(len(strings)):
			x=re.split("\t|\n",strings[i])
			if x[0]!="":
				str=x[0]+"\t"+x[1]+"\t"+x[2]+"\t"+x[3]+"\t"+x[4]+"\t"
				temp=checklist[k]
#				print temp+"\t"+x[0]
				while temp[0]=="$":
					temp=temp[2:]
					str=str+"Mention "+`mention`+"\t"
					mention=mention+1
				str=str+"\n"
				writer1.writelines(str)
				k=k+1	



		writer1.close()
	writer.close()

	reader=open("Tagging.txt",'r')
	strings=reader.readlines()
	reader.close()	
	
	writer=open("Background.txt",'a+')
	

	for i in range(len(strings)):
		str=re.split("\t|\n",strings[i])
		if len(str)>6:
			b=5
			while((len(str)-b)>0):
				read=str[b]
				if read!="":
					r=re.split(" ",read)
					val=2*int(r[1])-1
					l=re.split('\s|\[|\]|,|\(|\)',Entity[val])
#					print l
					if l[len(l)-1]=="":
						length=len(l)-1
					else:	
						length=len(l)
					k=0
					np=0
					bnp=0
					while(k<length):
						s=re.split("\t|\n",strings[i+k])
						if ((s[0]==l[k]) or (s[0]==',') or (s[0]=='\[') or (s[0]=='\]') or (s[0]=='\)') or (s[0]=='\(')):
							p=1
							st=s[4]	
#							print s[0]
							if st[0:1]=='B':
								np=1
							s_np=s[3]
						k=k+1

					if np==1 and p==1:
						writer.writelines("nameNP(\""+Entity[val]+"_m"+r[1]+"\").\n")
#					if np==0 and p==1:
#						writer.writelines("nameNP(\""+Entity[val]+"_m"+r[1]+"\",0).\n")
				b=b+1
	writer.writelines("\n")
	writer.close()

	def_NP=['the','its','their','The','Its','Their','These','these']
        indef_NP=['a','an','one','neither','either','each','every','A','An','One','Neither','Either','Each','Every','both','Both']
        pronoun=['we','this','some','who','We','This','Some','Who','We','those','Those','it','It','them','Them','they','They']
	
	writer1=open("Noun_Phrases.txt",'w+')	
	writer2=open("DefiniteNP.txt",'w+')
	writer3=open("IndefiniteNP.txt",'w+')
	writer4=open("PronounNP.txt","w+")

	writex=open("Entity.txt","w+")
	i=0
	while((i+1)<len(Entity)):
		writex.writelines(Entity[i]+"\t"+Entity[i+1]+"\n")
		i=i+2
	writex.close()
	
	writex=open("Antecedent.txt","w+")
	i=0
	while((i+1)<len(Antecedent)):
		writex.writelines(Antecedent[i]+"\t"+Antecedent[i+1]+"\n")
		i=i+2
	writex.close()

	reader=open("Background.txt",'r')
	nNP=reader.readlines()
	reader.close()

	count=0
	match=''
	i=1
	write=1
	wr=1
	match_count=0

	while (i<len(Entity)):
		match=Entity[i]
		count=count+1
		j=0
		while (j<len(Noun)):
			if (Noun[j]==match):			
				match_count=match_count+1
				str=re.split(" ",Noun[j])

				for k in range(len(def_NP)):
					if str[0]==def_NP[k]:
						writer2.writelines("definiteNP(\""+Entity[i]+"_m"+`count`+"\").\n")
						write=2
				
				for k in range(len(indef_NP)):
					if str[0]==indef_NP[k]:
						writer3.writelines("indefiniteNP(\""+Entity[i]+"_m"+`count`+"\").\n")
						write=2					
				if write!=2:
					for ts in range(len(pronoun)):
						if pronoun[ts]==str[0] and len(str)==1:
							writer4.writelines("pronounNP(\""+Entity[i]+"_m"+`count`+"\").\n")
							wr=3
							break
				if write!=2 and wr!=3:
					bNP="nameNP(\""+Entity[i]+"_m"+`count`+"\").\n"
					set=0
					for pw in range(len(nNP)):
						if nNP[pw]==bNP:
							set=1
							break
					if set==0:
						writer1.writelines("bareNP(\""+Entity[i]+"_m"+`count`+"\").\n")
				break	
			j=j+2
		write=1
		wr=1
		i=i+2


	writer1.writelines("\n")
	writer1.close()
	writer2.writelines("\n")
	writer2.close()
	writer3.writelines("\n")
	writer3.close()
	writer4.writelines("\n")
	writer4.close()

####### Predicates corresponding to the two mentions.
####### string_match_full, string_match_head, string_match_contain
	Temp_Entity=[]	

        for i in range(len(Entity)):
                m=re.split("[\s]$",Entity[i])
                Temp_Entity.append(m[0])

	writer=open("String_Match.txt","w+")
	i=1
	count=1
	
	while(i<len(Temp_Entity)):
		j=i+2
		temp=count+1
		while(j<len(Temp_Entity)):
			if Temp_Entity[i]==Temp_Entity[j]:
				writer.writelines("string_match_full(\""+Entity[i]+"_m"+`count`+"\",\""+Entity[j]+"_m"+`temp`+"\").\n")
			j=j+2
			temp=temp+1
		i=i+2
		count=count+1
	writer.writelines("\n")
	
	
	strip_pronoun=['the','The','its','Its','their','Their','These','these','a','A','an','An','one','One','neither','Neither','either','Either','each','Each','every','Every','both','Both','we','We','this','This','some','Some','who','Who','those','Those','Them','them','They','they','it','It']

	mode=0
	i=1
	Head_Entity=[]	

	while (i<len(Temp_Entity)):
		m=re.split("\s|,\s",Temp_Entity[i])
		for j in range(len(strip_pronoun)):
			if m[0]==strip_pronoun[j]:
				mode=1
				break		
		if mode==0:
			Head_Entity.append(m[0])
		else:
			Head_Entity.append("$")
			mode=0	
		i=i+2

	for i in range(len(Head_Entity)):	# 2*i-1
		j=i+1
		str_catch=Head_Entity[i]
		m=len(str_catch)
		while (j<len(Head_Entity) and str_catch!="$"):	# 2*j-1	
			str_head=Head_Entity[j]
			if str_catch==str_head[:m]:
				e=(2*i)+1
				a=(2*j)+1
				writer.writelines("string_match_head(\""+Entity[e]+"_m"+`i+1`+"\",\""+Entity[a]+"_m"+`j+1`+"\").\n")
			j=j+1
	
	writer.writelines("\n")

		
	i=1
	count=1
	while(i<len(Entity)):
		j=i+2
		str='.+'+Entity[i]
		temp=count+1
		mode=0
		while(j<len(Entity)):
			m=re.search(str,Entity[j])
			if m!=None:
				for k in range(len(strip_pronoun)):
					if strip_pronoun[k]==Entity[i]:
						mode=1
				if mode==0:
					writer.writelines("string_match_contain(\""+Entity[i]+"_m"+`count`+"\",\""+Entity[j]+"_m"+`temp`+"\").\n")
				else:
					mode=0
			j=j+2
			temp=temp+1
		i=i+2
		count=count+1

	writer.writelines("\n")

	writer.close()				
	print match_count


if __name__=="__main__":
	Split()
	Separate()
	Relation()
	Positive()
	Link()
	Text_Information()
	Fullstop_and_Article_end()
	Modified_Text_Information()
	Examples_File()
	Predicates()
