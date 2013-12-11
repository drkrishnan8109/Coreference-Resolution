%Genealogy Background Knowledge.
:- modeh(*,grandparent(+person,-person)).

:- modeb(*,parent(+person,-person)).

:- determination(grandparent/2,parent/2).
% Male & Female
%person(chester).
%person(mildred).
%person(irvin).
%person(shirley).
%person(clarence).
%person(sharon).
%person(ron).
%person(mary).
%person(ken).
%person(charlie).
% Parent Relationship
parent(chester,irvin).
parent(chester,clarence).
parent(chester,mildred).
parent(irvin,ron).
parent(irvin,ken).
parent(clarence,shirley).
parent(clarence,sharon).
parent(clarence,charlie).
parent(mildred,mary).
