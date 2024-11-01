-- Calcular los factores
factores :: Int -> [Int]
factores n = [x | x <- [1..n], n `mod` x == 0]

-- Ver si el numero ingresado es un nro primo
esPrimo :: Int -> Bool
esPrimo n = factores n == [1,n]