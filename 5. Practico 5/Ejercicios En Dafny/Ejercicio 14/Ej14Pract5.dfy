method Main(n: int) 
    requires n > 0
{
    var a := new int[n];
    var s := 0;
    var i := 0;
    
    // Invariante que asegura que 's' es la suma de los primeros 'i' elementos de 'a'
    while i < n
        invariant 0 <= i <= n
        invariant s == sum(a, i)  // La suma parcial es correcta
    {
        s := s + a[i];
        i := i + 1;
    }
    
    // Aseguramos que al final de la función, la suma sea correcta
    assert s == sum(a, n);
}

// Función que calcula la suma de los primeros 'j' elementos de 'a'
function sum(a: array<int>, j: int): int
    requires 0 <= j <= a.Length
{
    var s := 0;
    var k := 0;
    
    // Invariante que asegura que 's' es la suma de los primeros 'k' elementos de 'a'
    while k < j
        invariant 0 <= k <= j
        invariant s == (if k == 0 then 0 else s + a[k-1])  // La suma de los primeros 'k' elementos de 'a'
    {
        s := s + a[k];
        k := k + 1;
    }
    
    return s;
}