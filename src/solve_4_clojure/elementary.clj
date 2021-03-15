(ns solve-4-clojure.elementary)

;; Regular Expressions
(= "ABC" (apply str (re-seq #"[A-Z]+" "bA1B3Ce ")))

;; Rearranging Code
(= (count (sort (rest (reverse [2 5 4 1 3 6]))))
   (-> [2 5 4 1 3 6]
       (reverse)
       (rest)
       (sort)
       (count))
   5)
