--Comprobar si las listas son iguales o no
listIguales :: Eq a => [a] -> [a] -> Bool
listIguales lista1 lista2 = lista1 == lista2