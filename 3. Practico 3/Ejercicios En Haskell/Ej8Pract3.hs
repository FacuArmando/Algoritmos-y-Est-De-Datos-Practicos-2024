module Ej8Pract3 where
import Prelude hiding (take, drop)

-- Funcion Take
take :: (Num i, Ord i) => i -> [a] -> [a]
take n _
    | n <= 0 = []
take _ [] = []
take n (x:xs) = x : take (n-1) xs

-- Funcion Drop
drop :: Int -> [a] -> [a]
drop 0 s = s
drop _ [] = []
drop n (_:s) = drop (n-1) s

-- Funcion Cortar
cortar :: Int -> Int -> [Char] -> [Char]
cortar i j w = take (j-i) (drop i w)
