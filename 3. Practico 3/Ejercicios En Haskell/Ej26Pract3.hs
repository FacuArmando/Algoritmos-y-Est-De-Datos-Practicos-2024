listEntParMay10 :: [Int] -> [Int]
listEntParMay10 xs = [x | x<-xs, x>10, even x]