list1(man).
list1(woman).
list1(child).
list1(grandfather).
list1(grandmother).

list2('Albert').
list2('Einstein').
list2('Maxwell').
list2('Newton').

member1([Head|Tail]):-
	list2(Head).

member2([Head|Tail]):-
	list1(Head).

conc([],L,L).

%conc([],[],[]).

%conc([],[X|L1],[X|L2]):-
%	conc([],L1,L2).

conc([X|L1],L2,[X|L3]):-
	conc(L1,L2,L3).
	

distance3(X,Y,[Z|L]):-
	conc([X,_,_,_],[_|Y],[Z|L]),
	relation(X,Y).
%	X=\=Y.

relation(X,Y):-
	list1(X),
	member1([Y]);
	list2(X),
	member2([Y]).
