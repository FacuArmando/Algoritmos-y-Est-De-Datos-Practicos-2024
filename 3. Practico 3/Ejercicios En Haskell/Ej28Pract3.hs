todosOcurrenEn :: Eq a => [a] -> [a] -> Bool
todosOcurrenEn xs ys = null [x | x <- xs, x `notElem` ys]