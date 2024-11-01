module Ej1Pract3 where
import Prelude hiding (Ord, compare, (<), (<=), (>=), (>), max, min, last, init)

--hd :: [a] -> a retorna el primer elemento de una lista
hd :: [a] -> a
hd [] = error "No puedo usar con una lista vacia"
hd (x:_) = x

--tl :: [a] -> [a] retorna toda la lista menos el primer elemento
tl :: [a] -> [a]
tl [] = []
tl (_:xs) = xs

--last :: [a] -> a retorna el ultimo elemento de la lista
last :: [a] -> a
last [] = error "No puedo usar con una lista vacia"
last [x] = x
last (_:xs) = last xs

--init :: [a] -> [a] retorna toda la lista menos el ultimo elemento
init :: [a] -> [a]
init [] = error "No puedo usar con una lista vacia"
init [x] = []
init (x:xs) = x : init xs
