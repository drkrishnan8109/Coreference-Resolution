#!/usr/bin/env python

import re

def Split():
	for i in range(32):
		handle=open('a'+`i`+'_tagged','r')
		string=handle.readlines()
		handle.close()
		count=1
		str=''
		line=0
		writer=open('Negative'+`i`+'.txt','w+')
		writex=open('is_noun_phrase_fact','a+')
		for i in range(len(string)):
			list=re.split("\t",string[i])
			if len(list)==5 and list[3]!='O':
#				print list[0]+"\t"+list[3]
				m=re.search('I-',list[3])
				if m!=None:
					str=str+' '+list[0]			
				else:
					if str!='':
						str=str+'\n'
						writer.writelines(str)
						line=line+1
					str=list[0]
					
				count=count+1
		# print count
		# print line
		writer.close()
		writex.close()

def Permutation():
	for i in range(32):
		handle=open('Negative'+`i`+'.txt','r')
		string=handle.readlines()
		handle.close()
		writer=open('anaphoraresolution.n','a+')
		str=''
		k=0
		count=0;
		while k!=len(string):
			list=re.split('\n',string[k])
			for i in range(len(string)):
				temp=re.split('\n',string[i])
				if i!=k:
					str="is_anaphor_of("+list[0]+","+temp[0]+")\n"
					count=count+1
					writer.writelines(str)
			k=k+1
		print count
		writer.close()


if __name__=='__main__':
	Split()
	Permutation()
