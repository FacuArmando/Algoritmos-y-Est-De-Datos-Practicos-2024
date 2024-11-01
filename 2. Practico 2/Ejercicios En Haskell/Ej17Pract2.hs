length' :: Num a1 => [a2] -> a1
length' [] = 0
length' ( _ : xs ) = 1 + length' xs

 
