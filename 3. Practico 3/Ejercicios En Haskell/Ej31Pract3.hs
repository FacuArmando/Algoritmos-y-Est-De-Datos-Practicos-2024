prodCart :: [Int]-> [Int] -> [(Int, Int)]
prodCart xs ys = [(x,y) | x <- xs, y <- ys]