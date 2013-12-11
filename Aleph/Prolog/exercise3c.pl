last(Item,[]).

last(Item,[X|Y]):-
	last(Item,Y).
