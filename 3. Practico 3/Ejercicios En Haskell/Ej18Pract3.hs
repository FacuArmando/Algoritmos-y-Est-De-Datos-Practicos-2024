{-# OPTIONS_GHC -Wno-unrecognised-pragmas #-}
{-# HLINT ignore "Use sum" #-}
potencia :: Int -> Int
potencia n = if n == 0 then 1 else 2 * potencia (n-1)

sumaCuad :: [Int] -> Int
sumaCuad xs = foldl (+) 0 (map potencia xs)