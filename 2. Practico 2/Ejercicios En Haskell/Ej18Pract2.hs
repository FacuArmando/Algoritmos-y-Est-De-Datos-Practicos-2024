cuadrado :: Int -> Int
cuadrado x = x * x

hd :: [ a ] -> a
hd ( x : xs ) = x

--2 * cuadrado (hd [2,4,5,6,7,8])--