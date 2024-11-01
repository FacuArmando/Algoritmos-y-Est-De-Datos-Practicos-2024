contOcurrencias :: Eq a => a -> [a] -> Int
contOcurrencias x ys = length [y | y <- ys, y == x]