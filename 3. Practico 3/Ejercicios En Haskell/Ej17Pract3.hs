import Ej7Pract3 (factores, esPrimo)

listaNat :: Int -> [Int]
listaNat n = filter esPrimo [1..n]