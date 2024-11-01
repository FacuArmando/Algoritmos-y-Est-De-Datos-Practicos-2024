listNat :: [Int] -> [Int]
listNat xs = [x^2 | x <- xs, x>= 0]