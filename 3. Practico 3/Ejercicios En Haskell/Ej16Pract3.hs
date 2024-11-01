-- | Dados dos enteros X e Y, retorna True si X divide a Y, caso contrario False
divide :: Int -> Int -> Bool
divide x y = mod x y == 0

-- | Dado un número X, retorna la lista de todos los divisores de X.
divisores :: Int -> [Int]
divisores x = filter (divide x) [1..x]
