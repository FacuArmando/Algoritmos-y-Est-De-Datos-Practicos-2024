module Ej7Pract2 where
abs :: Int -> Int
abs (-1) = 1
abs 0 = 0
abs 1 = 1
abs n = if n >= 0 then n else -n