module Ej8Pract2 where
sumarDigitos :: Int -> Int
sumarDigitos 0 = 0
sumarDigitos 1 = 1
sumarDigitos 2 = 2
sumarDigitos 3 = 3
sumarDigitos 4 = 4
sumarDigitos 5 = 5
sumarDigitos 6 = 6
sumarDigitos 7 = 7
sumarDigitos 8 = 8
sumarDigitos 9 = 9
sumarDigitos n = n `mod` 10 + sumarDigitos (n `div` 10)

{-sumlist :: Num a => [a] -> a
sumlist xs = case xs of
    [] -> 0
    (x:xs) -> x + sumlist xs-}