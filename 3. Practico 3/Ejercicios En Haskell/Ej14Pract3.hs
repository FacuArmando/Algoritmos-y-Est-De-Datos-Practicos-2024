module Ej14Pract3 where
import Prelude hiding (take)
import qualified GHC.Types

-- Funcion Take
take :: (Num i, Ord i) => i -> [a] -> [a]
take n _
    | n <= 0 = []
take _ [] = []
take n (x:xs) = x : take (n-1) xs

--- Retorne la lista de los 1eros 5 numeros naturales de una lista infinita de numeros naturales
primeros5Nros :: Int -> [Int]
primeros5Nros n = take 5 [1..]
