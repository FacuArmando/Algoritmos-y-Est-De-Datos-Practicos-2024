cuadrado :: Int -> Int
cuadrado x = x * x

f :: Int -> Int -> Int
f x 0 = x
f x n = cuadrado (f x (n-1))

