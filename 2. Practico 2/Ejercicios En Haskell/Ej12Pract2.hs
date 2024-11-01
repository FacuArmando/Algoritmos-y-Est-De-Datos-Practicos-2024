import Ej11Pract2 (sumCurry)

addFour :: (Num a) => a -> a -> a
addFour = sumCurry 4


{-Versión de un compañero:
suma4 :: Int -> Int ->Int
suma4 = sumaTres 4
-}
