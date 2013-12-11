:- modeh(*,distance3(+word,+word,+sentence)).

:- modeb(*,member(+word,+list)).
:- modeb(*,conc(+[_|+word,_,_,_],[+word|_],+sentence)).

:- determination(distance3/3,member/2).
:- determination(distance3/3,conc/3).

list([man,woman,child,grandfather,grandmother]).
word(man).
word(woman).
word(child).
word(grandfather).
word(grandmother).

member(word,[word|_]).

member(word,[Head|Tail]):-
	member(word,Tail).

conc([],L2,L2).

conc([X|L1],L2,[X|L]):-
	conc(L1,L2,L).
