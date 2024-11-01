digitos :: Integer -> [Integer]
digitos n = reverse (digitos' n)

digitos' n
     | n < 10 = [n]
     | otherwise = (n `rem` 10) : digitos' (n `div` 10)