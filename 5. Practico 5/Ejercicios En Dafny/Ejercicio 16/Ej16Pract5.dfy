function sum(a: array<int>, i: int, j: int) : int
  requires 0 <= i <= j <= a.Length;
{
  var s := 0;
  for k := i to j - 1 {
    s := s + a[k];
  }
  return s;
}