nroEsp :: [Int]
nroEsp = [n | n <- [1..5000], all (\k -> n `mod` k == k - 1) [2..10]]