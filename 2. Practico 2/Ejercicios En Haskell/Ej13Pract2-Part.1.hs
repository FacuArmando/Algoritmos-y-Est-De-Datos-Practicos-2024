zeros :: (Eq a, Num a) => [a] -> Int -> Bool
zeros a 0 = True
zeros a n = zeros a (n -1) && ( a !!( n -1) == 0)