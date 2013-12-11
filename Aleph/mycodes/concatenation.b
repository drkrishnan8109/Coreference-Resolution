:- modeh(*,concat(+list1,+list2,+list3)).

:- modeb(*,+list1=[-number1|-list1]).
:- modeb(*,+list3=[-number2|-list3]).
:- modeb(*,match(+number1,+number2)).
:- modeb(*,not(complete(+list1))).
:- modeb(*,concat(-list1,+list2,-list3)).

:- determination(concat/3,'='/2).
:- determination(concat/3,match/2).
:- determination(concat/3,'not'/1).
:- determination(concat/3,concat/3).

match(X,Y):-
	X=:=Y,
	write(X),
	write(Y).

complete([]).
