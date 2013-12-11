distance(man,woman,[man,grandfather,grandmother,son,woman]).
distance(woman,man,[grandfather,woman,son,grandmother,aunt,man,child]).
distance(grandfather,man,[grandfather,woman,son,mother,man,child]).
distance(grandmother,man,[grandfather,grandmother,son,woman,child,man,aunt]).
