:- modeh(*,conc(+list1,+list2,+list3)).

:- modeb(*,+list1=[-number1|-list1]).
:- modeb(*,+list3=[-number2|-list3]).
%:- modeb(*,matchlist(+list2,+list3)).
:- modeb(*,conc(+list1,+list2,+list3)).
:- modeb(*,match(+number1,+number2)).

:- determination(conc/3,match/2).
:- determination(conc/3,'='/2).
:- determination(conc/3,conc/3).
%:- determination(conc/3,matchlist/2).

match([],[]).

match(X,Y):-
	X=:=Y.

%matchlist([],[]).

%matchlist([X|List2],[Y|List3]):-
%	X=:=Y,
%	matchlist(List2,List3).
