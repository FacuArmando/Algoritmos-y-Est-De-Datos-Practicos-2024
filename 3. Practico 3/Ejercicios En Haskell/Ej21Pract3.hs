{-# OPTIONS_GHC -Wno-unrecognised-pragmas #-}
{-# HLINT ignore "Use product" #-}
factorial :: Int -> Int
factorial n = foldr (*) 1 [1..n]