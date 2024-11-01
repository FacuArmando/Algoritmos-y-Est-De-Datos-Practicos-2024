listaSuc :: [Int] -> [Int]
listaSuc xs = map (+1) (filter (>= 0) xs)