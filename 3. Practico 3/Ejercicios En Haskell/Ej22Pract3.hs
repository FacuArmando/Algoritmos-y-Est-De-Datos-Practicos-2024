{-# OPTIONS_GHC -Wno-unrecognised-pragmas #-}
{-# HLINT ignore "Eta reduce" #-}
{-# HLINT ignore "Use and" #-}
and1 :: [Bool] -> Bool
and1 xs = foldr (&&) True xs 