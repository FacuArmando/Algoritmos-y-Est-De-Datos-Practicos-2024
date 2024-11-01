divisores :: Int -> [Int]
divisores n = [x | x<-[1..n], n `mod` x == 0]

esPrimo :: Int -> Bool
esPrimo n = divisores n == [1,n]

nrosPrimos :: Int -> [Int]
nrosPrimos n = [x | x <- [2..n], esPrimo x]