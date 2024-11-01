sumaSeg :: [Int] -> Int
sumaSeg xs = sum[sum(take n xs) | n <- [1..length xs]]