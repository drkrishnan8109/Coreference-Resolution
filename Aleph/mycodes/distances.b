:- modeh(*,distance(+word1,+word2,+sentence)).

:- modeb(*,subset([+word1,-,-,-,+word2],+sentence)).

:- determination(distance/3,subset/2).
:- determination(distance/3,member/2).

list([man,woman,grandfather,grandmother]).

member(X,[X|L]).

member(X,[Head|Tail]):-
	member(X,Tail).

subset(S,L):-
	conc(L1,L2,L),
	conc(S,L3,L2).

conc([],L,L).

conc([X|L1],L2,[X|L3]):-
	conc(L1,L2,L3).
