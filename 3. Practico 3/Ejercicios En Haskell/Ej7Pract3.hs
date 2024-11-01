module Ej7Pract3 where
import Prelude hiding (Ord, compare, (<), (<=), (>=), (>), max, min, last, init, reverse, filter)

-- Calcular los factores
factores :: Int -> [Int]
factores n = [x | x <- [1..n], n `mod` x == 0]

-- Ver si el numero ingresado es un nro primo
esPrimo :: Int -> Bool
esPrimo n = factores n == [1,n]

-- Dada una lista de numeros, devuelva la lista solo con los numeros primos
filter :: (Int -> Bool) -> [Int] -> [Int]
filter f [] = []
filter f (x:xs)
              | f x = x: filter f xs
              | otherwise = filter f xs