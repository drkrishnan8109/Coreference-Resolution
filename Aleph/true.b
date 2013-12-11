:- modeh(*,false).

:- modeb(*,male(+person)).
:- modeb(*,not(female(+person))).
:- modeb(*,not(male(+person))).
:- modeb(*,female(+person)).

:- determination(false/0,(not)/1).
:- determination(false/0,male/1).
:- determination(false/0,female/1).

:- set(noise,0).

male(amit).
male(sumit).
male(puneet).
male(nishant).

female(heena).
female(amrita).
female(vartika).
