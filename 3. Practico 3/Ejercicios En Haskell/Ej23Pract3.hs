--Versión con Foldr:
tam :: [a]->Int
tam [] = 0
tam xs = foldr (\_ acc -> 1 + acc) 0 xs

--Versión con Foldl:
tam2 :: [a]->Int
tam2 [] = 0
tam2 xs = foldl (\acc _-> 1 + acc) 0 xs