{-# OPTIONS_GHC -Wno-unrecognised-pragmas #-}
{-# HLINT ignore "Use splitAt" #-}
split2 :: [a] -> [([a],[a])]
split2 xs = [(take n xs, drop n xs) | n <- [0..length xs]]
