Merge Sort

- appartiene alla famiglia delle tecnologie di progettazione
di algoritmi chiamata Divide et Impera.

.divide, cioe prende il problema e lo divide in sottoproblemi,
 risolve i sottoproblemi;
.impera, prendo le sol dei sottoproblemi e le metto insieme in
 modo inteligente da risolvere il probl iniziale.

- si basa sulla tecnica di backtraking, è ricorsivo, e ci permette
 di tornare indiedro su varie istruzioni per cercare vie migliori.

- e simile a heapSort :
   simile : usa un comparator;
            ha tempo di exec O(nlog(n)).
   diverso : non usa una coda di priorità ausiliaria
             ha bisogno di spazio ausiliario O(n)
             heapSort usa spazio ausiliario O(1).

PseudoCodice :
-----------------------
Algorithm mergeSort(S,C)
Input : sequence S with n elements, comparator C
Output : sequence S sorted according to C

if S.size() > 1
   (S1,S2)<---partition(S,n/c)
    mergeSort(S1,C);
    mergeSort(S2,C);
    S<----merge(S1,S2
-----------------------
costo theta nlog(n) // bisogna fare la equazione di repuli sui fogli
in prattica pero hai
T(n) = 2 * T(n/2) + cn
T(n) = 2^2 * T(n/2^2) + 2cn
T(n) = 2^3 * T(n/2^3) + 3cn
....
T(n) = 2^k * T(n/2^k) + kcn
<=> k = log(n)
T(n) = 2^2log(n) *T(1) + c*n*log(n) ===> theta(nlog(n))
i due c gli scrivi con cprimo e csecondo
il cn all-inizio e dato dal contributo di merge che e (n).
***********************
-----------------------
Algorithm merge(A,B)
Input:sequence A and B with n/2 elements each
Output:sorted sequence of A U B
S<------ emptySequence

while !A.isEmpty() and !B.isEmpty()
    if A.first().element() < B.first().element()
    S.insertLast(A.remove(A.first()))
    else
    S.insertLast(B.remove(B.first))

while !A isEmpty()
    S.insertLast(A.remove(A.first()))
while !B isEmpty()
    S.insertLast(B.remove(B.first()))
-------------------------
Costo e tetha di (N) ho 4 cicli niente di che
codice c

mergeSort(int a [], int i, int j){
  if(j>i){
    n=j-i+1;
    k=n/2;
    mergeSort(a,i,i+k-1);
    mergeSort(a,i+k,j);
  }
}

merge(int [] A, int i, int i+k , int j){
  int [] T = new int[0];
  int a=i;int b=i+k; int c=0; int h = i;
  //compare bitch
  while(a<i+k && b<= j){
    if(A[a]<A[b]){
      T[c]=A[a];
      c++;
      a++
    }else{
      T[c] = A[b];
      c++;
      b++;
    }
  }
  //put ordered A>=i+k && A<j
  while (b<=j){
    T[c]=A[b];
    c++;
    b++;
  }
  //put ordered A < i+k into T
  while (a<i+k){
    T[c]=A[a];
    a++;
    c++;
  }
  //put it back together
  while (h<j){
    T[c]=A[a];
    c++;
    a++;
  }
}
