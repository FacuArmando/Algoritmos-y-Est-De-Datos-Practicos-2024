zeroes :: (Eq a, Num a) => [a] -> Bool
zeroes [] = True
zeroes ( a : as ) = zeroes as && ( a == 0)