module Ej13Pract3 where
import Prelude hiding (take)

-- Funcion Take
take :: (Num i, Ord i) => i -> [a] -> [a]
take n _
    | n <= 0 = []
take _ [] = []
take n (x:xs) = x : take (n-1) xs