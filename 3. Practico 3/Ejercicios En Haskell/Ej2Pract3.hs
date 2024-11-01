module Ej2Pract3 where
import Prelude hiding (Ord, compare, (<), (<=), (>=), (>), max, min, last, init, reverse)

reverse :: [a] -> [a]
reverse [] = []
reverse (x:xs) = reverse xs ++ [x]
