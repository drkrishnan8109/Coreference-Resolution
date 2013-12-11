parent(pam,bob).
parent(tom,bob).
parent(tom,liz).
parent(bob,ann).
parent(bob,pat).
parent(pat,jim).

female(pam).
male(tom).
male(bob).
female(liz).
female(pat).
female(ann).
male(jim).

offspring(X,Y):-
	parent(Y,X).

mother(X,Y):-
	parent(X,Y),
	female(X).

grandparent(X,Z):-
	parent(X,Y),
	parent(Y,Z).

sister(X,Y):-
	parent(Z,X),
	parent(Z,Y),
	female(X).

happy(X):-
	parent(X,Y).

hastwochildren(X):-
	parent(X,Y),
	sister(Y,Z).

predecessor(X,Z):-
	parent(X,Z).

predecessor(X,Z):-
	parent(X,Y),
	predecessor(Y,Z).
