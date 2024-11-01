belongs :: Eq a => a -> [a] -> Bool
belongs e [] = False
belongs e ( a : as ) = belongs e as || ( a == e )

{-
Ejemplos Belongs:
  ghci> belongs 'o' "hello"
  True

  ghci> belongs 4 []
  False

  ghci> belongs ['w', 'o'] ["hello", "wo"]
  True
-}