/* Program to store directed graph */

edge(a,b).
edge(b,c).
edge(c,d).
edge(e,d).
edge(c,e).
edge(g,c).
edge(a,f).
edge(f,e).
edge(f,g).

path(U,V,W,X,Y,Z):-edge(U,V),edge(V,W),edge(W,X),edge(X,Y),edge(Y,Z).

